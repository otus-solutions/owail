package br.org.owail.sender.gmail;

import java.io.UnsupportedEncodingException;

import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.org.owail.sender.email.Email;
import br.org.owail.sender.email.EmailUser;
import br.org.owail.sender.session.EmailSessionFactory;
import br.org.owail.sender.session.Mailer;

public class GmailMailer implements Mailer {

    private GmailProperties properties;

    protected GmailMailer(GmailProperties properties) {
	this.properties = properties;
    }

    @Override
    public void send(Email email) throws EmailCompositionException, MessagingException {
	Session session = EmailSessionFactory.newGmailSession(properties.buildProperties(), email.getFrom());
	Message message = composeMessage(email, session);
	Transport.send(message);
    }

    private Message composeMessage(Email email, Session session) throws EmailCompositionException {
	Message message = new MimeMessage(session);

	try {
	    message.setFrom(createInternetAddress(email.getFrom()));
	    addToRecipients(email, message);
	    message.setSubject(email.getSubject());
	    message.setText(email.getMessageText());
	} catch (MessagingException | UnsupportedEncodingException e) {
	    throw new EmailCompositionException(e);
	}
	return message;
    }

    private void addToRecipients(Email email, Message message) {
	email.getToRecipients().stream().forEach(recipient -> {
	    try {
		message.addRecipient(RecipientType.TO, createInternetAddress(recipient));
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	});
    }

    private InternetAddress createInternetAddress(EmailUser emailUser) throws UnsupportedEncodingException {
	return new InternetAddress(emailUser.getEmailAddress(), emailUser.getName());
    }

    public static GmailMailer createMailerForTls() {
	return new GmailMailer(new SmtpTlsProperties());
    }

}
