package pl.mariuszdab.flowerpot.newsletter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import javax.mail.MessagingException;


@Controller
@Slf4j
public class MailController {

    private MailService mailService;

    @Autowired
    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @Scheduled(cron = "0 0 12 * * SUN")
    public void sendMail() throws MessagingException {

        log.info("Newsletter rozesłany !");

        mailService.findAllUsersWithNewsletter().stream()
                .forEach(m -> {
                    try {
                        mailService.sendMail(m,
                                "Flowerpot: Podlej swoje kwiatki!",
                                "<b>Podlałeś swoje kwaiatki? Nie? Nie trać czasu i zrób to teraz :)</b><br> Z nami nie musiz się niczym martwić - przypominamy co niedzielę", true);
                    } catch (MessagingException e) {
                        e.printStackTrace();
                    }
                });

    }
}
