package pl.mariuszdab.flowerpot.validation;

import org.springframework.beans.factory.annotation.Autowired;
import pl.mariuszdab.flowerpot.user.User;
import pl.mariuszdab.flowerpot.user.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class EmailCheckInDBValidator implements ConstraintValidator<EmailCheckInDB, String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void initialize(EmailCheckInDB constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        Optional<User> user = userRepository.findByEmail(s);
        if (user.isPresent()){
            return false;
        }
        return true;

    }

}
