package pl.mariuszdab.flowerpot.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = UserNotFoundException.class)
    public String exe (UserNotFoundException e){
        return "redirect:./errorAdd";
    }

    @ExceptionHandler(value = UserNotFoundExceptionWhenUpdate.class)
    public String exe (UserNotFoundExceptionWhenUpdate e){
        return "redirect:../errorUpdate";
    }

    @ExceptionHandler(value = UserExistException.class)
    public String exe (UserExistException e){
        return "redirect:./errorAdd";
    }

}
