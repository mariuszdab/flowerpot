package pl.mariuszdab.flowerpot.newsletter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.mariuszdab.flowerpot.user.User;
import pl.mariuszdab.flowerpot.user.UserRepository;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MailService {

    private JavaMailSender javaMailSender;
    private UserRepository userRepositoty;

    public MailService(JavaMailSender javaMailSender, UserRepository userRepositoty) {
        this.javaMailSender = javaMailSender;
        this.userRepositoty = userRepositoty;
    }

    public void sendMail(String to, String subject, String text, boolean isHtmlContent) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(text, isHtmlContent);
        javaMailSender.send(mimeMessage);
    }

    public List<String> findAllUsersWithNewsletter(){

        List<String> emailAddress = userRepositoty.findAllByNewsletter(true)
                .stream()
                .map(u -> u.getEmail())
                .collect(Collectors.toList());

        return emailAddress;
    }

}
