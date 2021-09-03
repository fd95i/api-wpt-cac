package com.wps.wpscac.utils;

import com.external.google.gmail.GmailClient;
import com.google.api.services.gmail.model.Message;
import com.wps.wpscac.contact.entity.Contact;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.codec.binary.Base64;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Properties;

@Log4j2
public class SendContactMail implements Runnable {

    private final Contact contact;

    public SendContactMail(final Contact contactInfo) {
        this.contact = contactInfo;
    }

    @Override
    public void run() {
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);
        MimeMessage email = new MimeMessage(session);

        try {
            email.addRecipients(javax.mail.Message.RecipientType.TO,
                    InternetAddress.parse(contact.getEmail()));
            email.setSubject("Bienvenidx!");
            email.setText(String.format("¡Hola %s!\n Gracias por contactarte con Willow Patisserie", contact.getName()));

            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            email.writeTo(buffer);
            byte[] bytes = buffer.toByteArray();
            String encodedEmail = Base64.encodeBase64URLSafeString(bytes);
            Message message = new Message();
            message.setRaw(encodedEmail);

            GmailClient.sendEmail(message);
        } catch ( IOException | MessagingException me) {
            log.error("Couldnt send message due to: " + me.getMessage());
        }
    }

    public static final void dispatch(final Contact info) {
        new Thread(new SendContactMail(info)).start();
    }
}
