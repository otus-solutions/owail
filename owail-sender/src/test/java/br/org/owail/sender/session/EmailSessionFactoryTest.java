package br.org.owail.sender.session;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.org.owail.sender.email.Sender;
import br.org.owail.sender.gmail.SMTPTLSProperties;
import br.org.owail.sender.session.EmailSessionFactory;

@Ignore
public class EmailSessionFactoryTest {

    private Sender sender;
    private SMTPTLSProperties smtpTlsProperties;

    @Before
    public void setup() {
	sender = new Sender("Sender Name", "sender@domail.com", "password");
	smtpTlsProperties = new SMTPTLSProperties();
    }

    @Test
    public void newGmailTlsSession_method_should_return_a_mail_Session() {
	EmailSessionFactory.newGmailSession(smtpTlsProperties.buildProperties(), sender);
    }

}
