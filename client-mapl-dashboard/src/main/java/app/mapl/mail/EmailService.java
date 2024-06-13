package app.mapl.mail;

public interface EmailService {
     String getEmailMessage(String name, String host, String token);

     void sendEmail(String to, String subject, String content);
     void sendNewAccountEmail(String name, String email, String token);
     void sendPasswordResetEmail(String name, String email, String token);



}
