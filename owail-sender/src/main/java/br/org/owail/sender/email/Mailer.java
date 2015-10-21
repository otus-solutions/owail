package br.org.owail.sender.email;

import java.util.List;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;

import br.org.owail.sender.session.SMTPSessionProperties;

public class Mailer {

    public static final String HTML = "text/html; charset=utf-8";

    private SMTPSessionProperties properties;
    private Email email;
    private String emailContentType;

    protected Mailer(SMTPSessionProperties properties) {
	this.properties = properties;
	this.email = new Email();
    }

    public static Mailer createTLSMailer(SMTPSessionProperties smtpProps) {
	return new Mailer(smtpProps);
    }

    public void setFrom(Sender sender) {
	email.setFrom(sender);
    }

    public void addRecipient(Recipient recipient) {
	email.addRecipient(recipient);
    }

    public void addRecipients(List<Recipient> recipients) {
	email.getRecipients().addAll(recipients);
    }

    public void setSubject(String subject) {
	email.setSubject(subject);
    }

    public void setContentType(String type) {
	emailContentType = type;
    }

    public void setContent(String messageText) {
	email.setMessageText(messageText);
    }

    public void send() throws EmailCompositionException, MessagingException {
	Message message = MessageWrapper.wrap(email, properties, emailContentType);
	Transport.send(message);
    }

}
