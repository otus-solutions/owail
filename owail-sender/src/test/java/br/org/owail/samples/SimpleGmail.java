package br.org.owail.samples;

import javax.mail.MessagingException;

import br.org.owail.sender.email.Recipient;
import br.org.owail.sender.email.Sender;
import br.org.owail.sender.gmail.EmailCompositionException;
import br.org.owail.sender.gmail.GmailMailer;

public class SimpleGmail {

    public static void main(String[] args) {
	GmailMailer mailer = GmailMailer.createTLSMailer();
	
	/* Configure email sender */
	mailer.setFrom(new Sender("Sender Name", "gmail.account@address.com", "the_password"));
	
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
