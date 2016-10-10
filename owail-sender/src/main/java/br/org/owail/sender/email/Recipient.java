package br.org.owail.sender.email;

import javax.mail.Message.RecipientType;

public class Recipient implements EmailUser {

    private String name;
    private String emailAddress;
    private RecipientType type;

    private Recipient(String name, String emailAddress, RecipientType type) {
	this.name = name;
	this.emailAddress = emailAddress;
	this.type = type;
    }

    public static Recipient createTO(String name, String emailAddress) {
	return new Recipient(name, emailAddress, RecipientType.TO);
    }

    public static Recipient createCC(String name, String emailAddress) {
	return new Recipient(name, emailAddress, RecipientType.CC);
    }

    public static Recipient createBCC(String name, String emailAddress) {
	return new Recipient(name, emailAddress, RecipientType.BCC);
    }

    @Override
    public String getName() {
	return name;
    }

    @Override
    public String getEmailAddress() {
	return emailAddress;
    }

    public RecipientType getType() {
	return type;
    }

}
