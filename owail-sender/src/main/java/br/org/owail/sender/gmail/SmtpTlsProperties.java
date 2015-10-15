package br.org.owail.sender.gmail;

import java.util.Properties;

public class SmtpTlsProperties {

    public static final String MAIL_SMTP_AUTH_KEY = "mail.smtp.auth";
    public static final String MAIL_SMTP_STARTTLS_ENABLE_KEY = "mail.smtp.starttls.enable";
    public static final String MAIL_SMTP_HOST_KEY = "mail.smtp.host";
    public static final String MAIL_SMTP_PORT_KEY = "mail.smtp.port";
    
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

    public Properties buildProperties() {
	Properties build = new Properties();
	
	build.setProperty(MAIL_SMTP_AUTH_KEY, getAuth().toString());
	build.setProperty(MAIL_SMTP_STARTTLS_ENABLE_KEY, getStartTls().toString());
	build.setProperty(MAIL_SMTP_HOST_KEY, getHost());
	build.setProperty(MAIL_SMTP_PORT_KEY, getPort());
	
	return build;
    }

}
