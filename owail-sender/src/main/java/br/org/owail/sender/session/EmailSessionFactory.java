package br.org.owail.sender.session;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import br.org.owail.sender.email.Sender;

public class EmailSessionFactory {

    public static Session newSession(Properties properties, Sender sender) {
	Session session = Session.getInstance(properties, new Authenticator() {
	    @Override
	    protected PasswordAuthentication getPasswordAuthentication() {
	        return new PasswordAuthentication(sender.getEmailAddress(), sender.getPassword());
	    }
	});
	
	return session;
    }

}
