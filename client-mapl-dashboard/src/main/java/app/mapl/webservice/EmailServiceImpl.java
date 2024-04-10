package app.mapl.webservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {
        private static final String NEW_USER_ACCOUNT_VERIFICATION = "New User Account Verification";
        private static final String PASSWORD_RESET_REQUEST = "Password Reset Request";
        private final JavaMailSender sender;
        @Value("${spring.mail.host}")
        private String host;
        @Value("${spring.mail.username}")
        private String fromEmail;



    @Override
    @Async
    @ConditionalOnProperty(name = "app.mail.enabled",   matchIfMissing = false)
        public void sendNewAccountEmail(String name, String email, String token) {
          try {
              log.info("Sending email to: " + name);
              SimpleMailMessage message = new SimpleMailMessage();
              message.setFrom(fromEmail);
              message.setSubject(NEW_USER_ACCOUNT_VERIFICATION);
              message.setTo(email);
              message.setText(getEmailMessage(name, host, token));
              sender.send(message);
          } catch (MailException e) {
              log.error("Error sending email to: " + name, e);
          }
        }

    /**
     * @param name
     * @param email
     * @param token
     */
    @Override
    public void sendPasswordResetEmail(String name, String email, String token) {

    }
    @Override
    public String getEmailMessage(String name, String host, String token) {
        return "Hello " + name + ",\n\n" +
                "Welcome to your Personal Librarian, MaPL. Please click the link below to verify your account.\n\n" +
                host + "/api/auth/verify-account?token=" + token + "\n\n" +
                "Thank you.";

    }

    /**
     * @param to
     * @param subject
     * @param content
     */
    @Override
    public void sendEmail(String to, String subject, String content) {
        try {
            log.info("Sending email to: " + to);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject(subject);
            message.setTo(to);
            message.setText(content);
            sender.send(message);
            log.info("Email sent to: " + to);
        } catch (MailException e) {
            log.error("Error sending email to: " + to, e);

        }
    }

}
