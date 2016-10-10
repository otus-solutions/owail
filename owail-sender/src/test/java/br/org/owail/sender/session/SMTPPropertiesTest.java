package br.org.owail.sender.session;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class SMTPPropertiesTest {

    private static final String AUTH = "mail.smtp.auth";
    private static final String HOST = "mail.smtp.host";
    private static final String PORT = "mail.smtp.port";
    private static final String STARTTLS_ENABLE = "mail.smtp.starttls.enable";
    private static final String SSL_PORT = "mail.smtp.socketFactory.port";
    private static final String SSL_CLASS = "mail.smtp.socketFactory.class";
    
    @Test
    public void AUTH_constant_shoud_hold_the_value_mail_smtp_auth() {
	assertThat(SMTPProperties.AUTH.asString(), equalTo(AUTH));
    }
    
    @Test
    public void STARTTLS_ENABLE_constant_shoud_hold_the_value_mail_smtp_starttls_enable() {
	assertThat(SMTPProperties.STARTTLS_ENABLE.asString(), equalTo(STARTTLS_ENABLE));
    }
    
    @Test
    public void HOST_constant_shoud_hold_the_value_mail_smtp_host() {
	assertThat(SMTPProperties.HOST.asString(), equalTo(HOST));
    }
    
    @Test
    public void PORT_constant_shoud_hold_the_value_mail_smtp_port() {
	assertThat(SMTPProperties.PORT.asString(), equalTo(PORT));
    }
    
    @Test
    public void SSL_PORT_constant_shoud_hold_the_value_mail_smtp_socketFactory_port() {
	assertThat(SMTPProperties.SSL_PORT.asString(), equalTo(SSL_PORT));
    }
    
    @Test
    public void SSL_CLASS_constant_shoud_hold_the_value_mail_smtp_socketFactory_class() {
	assertThat(SMTPProperties.SSL_CLASS.asString(), equalTo(SSL_CLASS));
    }
    
}
