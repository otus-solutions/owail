package br.org.owail.sender.session;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.org.owail.sender.email.Sender;
import br.org.owail.sender.gmail.GTLSProperties;
import br.org.owail.sender.session.EmailSessionFactory;

@Ignore
public class EmailSessionFactoryTest {

    private Sender sender;
    private GTLSProperties smtpTlsProperties;

    @Before
    public void setup() {
	sender = new Sender("Sender Name", "sender@domail.com", "password");
	smtpTlsProperties = new GTLSProperties();
    }

    @Test
    public void newGmailTlsSession_method_should_return_a_mail_Session() {
	EmailSessionFactory.newSession(smtpTlsProperties.buildProperties(), sender);
    }

}
