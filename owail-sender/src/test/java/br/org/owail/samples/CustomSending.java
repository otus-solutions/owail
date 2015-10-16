package br.org.owail.samples;

import java.util.Properties;

import javax.mail.MessagingException;

import br.org.owail.sender.email.EmailCompositionException;
import br.org.owail.sender.email.Mailer;
import br.org.owail.sender.email.Recipient;
import br.org.owail.sender.email.Sender;
import br.org.owail.sender.session.SMTPProperties;
import br.org.owail.sender.session.SMTPSessionProperties;

/**
 * CustomSending sample
 * 
 * This is a example of sending email with the the default Mailer.
 * With this Mailer you have to tell the your SMTP session properties for your SMTP server. 
 */
public class CustomSending {

    public static void main(String[] args) {
	Mailer mailer = Mailer.createTLSMailer(new MyCustomSMTPSessionProps());

	/* Configure email sender */
	mailer.setFrom(new Sender("Sender Name", "account.user", "the_password"));

	/* Configure email recipients */
	mailer.addRecipient(Recipient.createTO("Recipient TO", "recipient.to@domain.com")); 	// main
	mailer.addRecipient(Recipient.createCC("Recipient CC", "recipient.cc@domain.com")); 	// carbon copy
	mailer.addRecipient(Recipient.createBCC("Recipient BCC", "recipient.bcc@domain.com")); 	// blind carbon copy

	/* Configure the email message */
	mailer.setSubject("Simple Gmail Test!");
	mailer.setMessageText("This is the message body.");

	try {
	    mailer.send();
	} catch (EmailCompositionException | MessagingException e) {
	    System.out.println("Oh no...");
	}
    }

}

/**
 * Here we can see a implementation for SMTPSessionProperties with customized
 * SMTP session properties.
 */
class MyCustomSMTPSessionProps implements SMTPSessionProperties {

    @Override
    public Properties buildProperties() {
	Properties props = new Properties();
	props.setProperty(SMTPProperties.HOST.asString(), "host_here");
	props.setProperty(SMTPProperties.PORT.asString(), "port_here");
	props.setProperty(SMTPProperties.STARTTLS_ENABLE.asString(), "true/false_here");
	props.setProperty(SMTPProperties.AUTH.asString(), "true/false_here");

	return props;
    }

}
