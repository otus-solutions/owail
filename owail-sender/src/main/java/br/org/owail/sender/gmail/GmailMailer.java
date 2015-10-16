package br.org.owail.sender.gmail;

import br.org.owail.sender.email.Mailer;
import br.org.owail.sender.session.SMTPSessionProperties;

public class GmailMailer extends Mailer {

    protected GmailMailer(SMTPSessionProperties properties) {
	super(properties);
    }

    public static GmailMailer createTLSMailer() {
	return new GmailMailer(new SMTPTLSProperties());
    }

}