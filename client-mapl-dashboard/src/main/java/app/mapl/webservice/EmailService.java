package app.mapl.webservice;

public interface EmailService {
     void sendEmail(String to, String subject, String content);
     void sendNewAccountEmail(String name, String email, String token);

}
