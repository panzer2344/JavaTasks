package com.podval.server;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mailer {
    public static String send(String to,String subject, String msg, String cc){

        final String user="testalexalex9918@gmail.com";//change accordingly
        final String pass="poiuytrewq0987654321";

//1st step) Get the session object
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");//change accordingly
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.port", "465");
        //props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user,pass);
                    }
                });
//2nd step)compose message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.setSubject(subject);
            message.setText(msg);
            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));



            //3rd step)send message
            Transport.send(message);

            return "Done";

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
