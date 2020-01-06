package pl.beata.springbootaspect.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.beata.springbootaspect.service.EmailService;
import pl.beata.springbootaspect.util.EmailProperties;
import pl.beata.springbootaspect.util.MessageMail;

import javax.mail.MessagingException;

@Aspect
@Component
public class MovieAspect {

    private EmailService emailService;
    private EmailProperties properties;

    @Autowired
    public MovieAspect(EmailService emailService, EmailProperties properties) {
        this.emailService = emailService;
        this.properties = properties;
    }


    @After("@annotation(Movies)")
    private void sendEmail() throws MessagingException {
        emailService.sendEmail(properties.getTo(), MessageMail.TITLE_ADD, MessageMail.TEXT_ADD);
    }

}
