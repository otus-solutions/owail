package br.org.owail.samples;

import java.util.Properties;

import javax.mail.MessagingException;

import br.org.owail.sender.email.Mailer;
import br.org.owail.sender.email.Recipient;
import br.org.owail.sender.email.Sender;
import br.org.owail.sender.gmail.EmailCompositionException;
import br.org.owail.sender.gmail.SMTPTLSProperties;
import br.org.owail.sender.session.SMTPProperties;
import br.org.owail.sender.session.SMTPSessionProperties;

public class LocalCustomSending {

    public static void main(String[] args) {
	Mailer mailer = Mailer.createTLSMailer(new CustomSMTPSessionProps());

	/* Configure email sender */
	mailer.setFrom(new Sender("Dev", "ccem.projects", "rapadura100200300"));

	/* Configure email recipients */
	mailer.addRecipient(Recipient.createTO("Diego Santos", "santos.diegoferreira@gmail.com"));

	/* Configure the email message */
	mailer.setSubject("Simple Gmail Test!");
	mailer.setMessageText("This is the message body.");

	try {
	    mailer.send();
	} catch (EmailCompositionException | MessagingException e) {
	    System.out.println(e);
	    System.out.println("Oh no...");
	}
    }

}

class CustomSMTPSessionProps implements SMTPSessionProperties {

    @Override
    public Properties buildProperties() {
	SMTPTLSProperties gmailProps = new SMTPTLSProperties();
	
	Properties props = new Properties();
	props.setProperty(SMTPProperties.HOST.asString(), gmailProps.getHost());
	props.setProperty(SMTPProperties.PORT.asString(), gmailProps.getPort());
	props.setProperty(SMTPProperties.STARTTLS_ENABLE.asString(), gmailProps.getStartTls().toString());
	props.setProperty(SMTPProperties.AUTH.asString(), gmailProps.getAuth().toString());

	return props;
    }

}