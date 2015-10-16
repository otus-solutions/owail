package br.org.owail.sender.email;

import java.io.UnsupportedEncodingException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.org.owail.sender.gmail.EmailCompositionException;
import br.org.owail.sender.session.EmailSessionFactory;
import br.org.owail.sender.session.SMTPSessionProperties;

public class MessageWrapper {

    private Session session;

    private MessageWrapper(Email email, SMTPSessionProperties properties) {
	session = EmailSessionFactory.newSession(properties.buildProperties(), email.getFrom());
    }

    public static Message wrap(Email email, SMTPSessionProperties properties) throws EmailCompositionException {
	MessageWrapper wrapper = new MessageWrapper(email, properties);
	return wrapper.composeMessage(email);
    }

    private Message composeMessage(Email email) throws EmailCompositionException {
	Message message = new MimeMessage(session);
	try {
	    message.setFrom(createInternetAddress(email.getFrom()));
	    setRecipients(email, message);
	    message.setSubject(email.getSubject());
	    message.setText(email.getMessageText());
	} catch (MessagingException | UnsupportedEncodingException e) {
	    throw new EmailCompositionException(e);
	}
	return message;
    }

    private void setRecipients(Email email, Message message) {
	email.getRecipients().stream().forEach(recipient -> {
	    try {
		message.addRecipient(recipient.getType(), createInternetAddress(recipient));
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	});
    }

    private InternetAddress createInternetAddress(EmailUser emailUser) throws UnsupportedEncodingException {
	return new InternetAddress(emailUser.getEmailAddress(), emailUser.getName());
    }

}
