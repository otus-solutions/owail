package br.org.owail.samples;

import javax.mail.MessagingException;

import br.org.owail.sender.email.Recipient;
import br.org.owail.sender.email.Sender;
import br.org.owail.sender.gmail.EmailCompositionException;
import br.org.owail.sender.gmail.GmailMailer;

public class LocalSimpleGmail {

    public static void main(String[] args) {
	GmailMailer mailer = GmailMailer.createTLSMailer();
	
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
	    System.out.println("Oh no...");
	}
    }

}
