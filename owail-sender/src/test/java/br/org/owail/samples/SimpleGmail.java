package br.org.owail.samples;

import javax.mail.MessagingException;

import br.org.owail.sender.email.EmailCompositionException;
import br.org.owail.sender.email.Recipient;
import br.org.owail.sender.email.Sender;
import br.org.owail.sender.gmail.GMailer;

/**
 * SimpleGmail sample
 * 
 * This is a example of sending email with the GmailMailer.
 * With this Mailer you do not have to worry about the SMTP Gmail settings. 
 */
public class SimpleGmail {

    public static void main(String[] args) {
	GMailer mailer = GMailer.createTLSMailer();
	
	/* Configure email sender */
	mailer.setFrom(new Sender("Sender Name", "gmail.account.user", "the_password"));
	
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
