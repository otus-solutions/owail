package br.org.owail.sender.session;

public enum SMTPProperties {

    AUTH("mail.smtp.auth"), 
    STARTTLS_ENABLE("mail.smtp.starttls.enable"), 
    HOST("mail.smtp.host"), 
    PORT("mail.smtp.port"),
    SSL_PORT("mail.smtp.socketFactory.port"),
    SSL_CLASS("mail.smtp.socketFactory.class");
    
    private String value;

    private SMTPProperties(String value) {
	this.value = value;
    }
    
    public String asString() {
	return value;
    }
    
}
