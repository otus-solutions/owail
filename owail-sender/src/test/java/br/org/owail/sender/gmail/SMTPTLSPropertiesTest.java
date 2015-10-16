package br.org.owail.sender.gmail;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Properties;

import org.junit.Test;

import br.org.owail.sender.session.SMTPProperties;

public class SMTPTLSPropertiesTest {

    private static final Boolean SMTP_AUTH = true;
    private static final Boolean SMTP_STARTTLS = true;
    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final String SMTP_PORT = "587";

    @Test
    public void auth_value_should_be_TRUE() {
	SMTPTLSProperties properties = new SMTPTLSProperties();

	assertThat(properties.getAuth(), equalTo(SMTP_AUTH));
    }

    @Test
    public void starttls_value_should_be_TRUE() {
	SMTPTLSProperties properties = new SMTPTLSProperties();

	assertThat(properties.getStartTls(), equalTo(SMTP_STARTTLS));
    }

    @Test
    public void host_value_should_be_smtp_gmail_com() {
	SMTPTLSProperties properties = new SMTPTLSProperties();

	assertThat(properties.getHost(), equalTo(SMTP_HOST));
    }

    @Test
    public void port_value_should_be_587() {
	SMTPTLSProperties properties = new SMTPTLSProperties();

	assertThat(properties.getPort(), equalTo(SMTP_PORT));
    }

    @Test
    public void properties_build_should_have_auth_value_equal_to_TRUE() {
	SMTPTLSProperties properties = new SMTPTLSProperties();

	Properties build = properties.buildProperties();
	String key = SMTPProperties.AUTH.asString();

	assertThat(build.getProperty(key), equalTo(SMTP_AUTH.toString()));
    }

    @Test
    public void properties_build_should_have_starttls_value_equal_to_TRUE() {
	SMTPTLSProperties properties = new SMTPTLSProperties();

	Properties build = properties.buildProperties();
	String key = SMTPProperties.STARTTLS_ENABLE.asString();

	assertThat(build.getProperty(key), equalTo(SMTP_STARTTLS.toString()));
    }

    @Test
    public void properties_build_should_have_host_value_equal_to_smtp_gmail_com() {
	SMTPTLSProperties properties = new SMTPTLSProperties();

	Properties build = properties.buildProperties();
	String key = SMTPProperties.HOST.asString();

	assertThat(build.getProperty(key), equalTo(SMTP_HOST));
    }

    @Test
    public void properties_build_should_have_port_value_equal_to_587() {
	SMTPTLSProperties properties = new SMTPTLSProperties();

	Properties build = properties.buildProperties();
	String key = SMTPProperties.PORT.asString();

	assertThat(build.getProperty(key), equalTo(SMTP_PORT));
    }

}
