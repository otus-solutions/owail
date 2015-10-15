package br.org.owail.sender.gmail;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Properties;

import org.junit.Test;

public class SmtpTlsPropertiesTest {

    private static final Boolean SMTP_AUTH = true;
    private static final Boolean SMTP_STARTTLS = true;
    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final String SMTP_PORT = "587";

    @Test
    public void auth_value_should_be_TRUE() {
	SmtpTlsProperties properties = new SmtpTlsProperties();

	assertThat(properties.getAuth(), equalTo(SMTP_AUTH));
    }
    
    @Test
    public void starttls_value_should_be_TRUE() {
	SmtpTlsProperties properties = new SmtpTlsProperties();

	assertThat(properties.getStartTls(), equalTo(SMTP_STARTTLS));
    }
    
    @Test
    public void host_value_should_be_smtp_gmail_com() {
	SmtpTlsProperties properties = new SmtpTlsProperties();

	assertThat(properties.getHost(), equalTo(SMTP_HOST));
    }
    
    @Test
    public void port_value_should_be_587() {
	SmtpTlsProperties properties = new SmtpTlsProperties();

	assertThat(properties.getPort(), equalTo(SMTP_PORT));
    }
    
    @Test
    public void properties_build_should_have_auth_value_equal_to_TRUE() {
	SmtpTlsProperties properties = new SmtpTlsProperties();
	
	Properties build = properties.buildProperties();
	String key = SmtpTlsProperties.MAIL_SMTP_AUTH_KEY;
	
	assertThat(build.getProperty(key), equalTo(SMTP_AUTH.toString()));
    }
    
    @Test
    public void properties_build_should_have_starttls_value_equal_to_TRUE() {
	SmtpTlsProperties properties = new SmtpTlsProperties();
	
	Properties build = properties.buildProperties();
	String key = SmtpTlsProperties.MAIL_SMTP_STARTTLS_ENABLE_KEY;

	assertThat(build.getProperty(key), equalTo(SMTP_STARTTLS.toString()));
    }
    
    @Test
    public void properties_build_should_have_host_value_equal_to_smtp_gmail_com() {
	SmtpTlsProperties properties = new SmtpTlsProperties();
	
	Properties build = properties.buildProperties();
	String key = SmtpTlsProperties.MAIL_SMTP_HOST_KEY;

	assertThat(build.getProperty(key), equalTo(SMTP_HOST));
    }
    
    @Test
    public void properties_build_should_have_port_value_equal_to_587() {
	SmtpTlsProperties properties = new SmtpTlsProperties();
	
	Properties build = properties.buildProperties();
	String key = SmtpTlsProperties.MAIL_SMTP_PORT_KEY;

	assertThat(build.getProperty(key), equalTo(SMTP_PORT));
    }

}
