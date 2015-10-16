package br.org.owail.sender.gmail;

import java.util.Properties;

import br.org.owail.sender.session.SMTPProperties;
import br.org.owail.sender.session.SMTPSessionProperties;

public class SMTPTLSProperties implements SMTPSessionProperties {

    private static final String MAIL_SMTP_HOST_VALUE = "smtp.gmail.com";
    private static final String MAIL_SMTP_PORT_VALUE = "587";

    public Boolean getAuth() {
	return true;
    }

    public Boolean getStartTls() {
	return true;
    }

    public String getHost() {
	return MAIL_SMTP_HOST_VALUE;
    }

    public String getPort() {
	return MAIL_SMTP_PORT_VALUE;
    }

    @Override
    public Properties buildProperties() {
	Properties build = new Properties();

	build.setProperty(SMTPProperties.HOST.asString(), getHost());
	build.setProperty(SMTPProperties.PORT.asString(), getPort());
	build.setProperty(SMTPProperties.AUTH.asString(), getAuth().toString());
	build.setProperty(SMTPProperties.STARTTLS_ENABLE.asString(), getStartTls().toString());

	return build;
    }

}
