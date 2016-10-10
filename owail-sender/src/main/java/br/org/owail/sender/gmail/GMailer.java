package br.org.owail.sender.gmail;

import br.org.owail.sender.email.Mailer;
import br.org.owail.sender.session.SMTPSessionProperties;

public class GMailer extends Mailer {
    
    protected GMailer(SMTPSessionProperties properties) {
	super(properties);
    }

    public static GMailer createTLSMailer() {
	return new GMailer(new GTLSProperties());
    }

}