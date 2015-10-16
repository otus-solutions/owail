package br.org.owail.sender.gmail;

import java.io.UnsupportedEncodingException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.org.owail.sender.email.Email;
import br.org.owail.sender.email.EmailUser;
import br.org.owail.sender.email.Recipient;
import br.org.owail.sender.email.Sender;
import br.org.owail.sender.session.EmailSessionFactory;
import br.org.owail.sender.session.Mailer;

public class GmailMailer implements Mailer {

    private GmailProperties properties;
    private Email email;

    protected GmailMailer(GmailProperties properties) {
	this.properties = properties;
	this.email = new Email();
    }

    public static GmailMailer createTLSMailer() {
	return new GmailMailer(new SMTPTLSProperties());
    }

    @Override
    public void setFrom(Sender sender) {
	email.setFrom(sender);
    }

    @Override
    public void addRecipient(Recipient recipient) {
	email.addRecipient(recipient);
    }

    @Override
    public void setSubject(String subject) {
	email.setSubject(subject);
    }

    @Override
    public void setMessageText(String messageText) {
	email.setMessageText(messageText);
    }

    @Override
    public void send() throws EmailCompositionException, MessagingException {
	Message message = MessageWrapper.wrap(email, properties);
	Transport.send(message);
    }

}

class MessageWrapper {

    private Session session;

    private MessageWrapper(Email email, GmailProperties properties) {
	session = EmailSessionFactory.newGmailSession(properties.buildProperties(), email.getFrom());
    }

    public static Message wrap(Email email, GmailProperties properties) throws EmailCompositionException {
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