package br.org.owail.sender.email;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;

import br.org.owail.sender.gmail.EmailCompositionException;
import br.org.owail.sender.session.SMTPSessionProperties;

public class Mailer {

    private SMTPSessionProperties properties;
    private Email email;

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

    public void setSubject(String subject) {
	email.setSubject(subject);
    }

    public void setMessageText(String messageText) {
	email.setMessageText(messageText);
    }

    public void send() throws EmailCompositionException, MessagingException {
	Message message = MessageWrapper.wrap(email, properties);
	Transport.send(message);
    }

}
