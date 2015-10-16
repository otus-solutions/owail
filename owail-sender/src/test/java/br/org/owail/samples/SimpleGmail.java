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
	mailer.addRecipient(Recipient.createTO("DevGroup", "desenvolvimento-elsa@googlegroups.com")); 	// main
	mailer.addRecipient(Recipient.createCC("Diogo Ferreira", "diogo.rosas.ferreira@gmail.com")); 	// carbon copy
	mailer.addRecipient(Recipient.createCC("Fagner Schwalm", "fagnerschwalm@gmail.com")); 		// carbon copy
	mailer.addRecipient(Recipient.createBCC("Diego Santos", "santos.diegoferreira@gmail.com")); 	// blind carbon copy
	
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
