package br.org.owail.sender.email;

import java.io.UnsupportedEncodingException;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.org.owail.sender.session.EmailSessionFactory;
import br.org.owail.sender.session.SMTPSessionProperties;

public class MessageWrapper {

    private Session session;

    private MessageWrapper(Email email, SMTPSessionProperties properties) {
	session = EmailSessionFactory.newSession(properties.buildProperties(), email.getFrom());
    }

    public static Message wrap(Email email, SMTPSessionProperties properties, String contentType)
	    throws EmailCompositionException {
	MessageWrapper wrapper = new MessageWrapper(email, properties);
	return wrapper.composeMessage(email, contentType);
    }

    private Message composeMessage(Email email, String contentType) throws EmailCompositionException {
	Message message = new MimeMessage(session);
	try {
	    message.setFrom(createInternetAddress(email.getFrom()));
	    setRecipients(email, message);
	    message.setSubject(email.getSubject());
	    message.setContent(email.getMessageText(), contentType);
	} catch (Exception e) {
	    throw new EmailCompositionException(e);
	}
	return message;
    }

    private void setRecipients(Email email, Message message) {
	for (Recipient recipient : email.getRecipients()) {
	    try {
		message.addRecipient(recipient.getType(), createInternetAddress(recipient));
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    private InternetAddress createInternetAddress(EmailUser emailUser) throws UnsupportedEncodingException {
	return new InternetAddress(emailUser.getEmailAddress(), emailUser.getName());
    }

}
