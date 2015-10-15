package br.org.owail.sender.email;

public class Recipient implements EmailUser {

    private String name;
    private String emailAddress;

    public Recipient(String name, String emailAddress) {
	this.name = name;
	this.emailAddress = emailAddress;
    }

    @Override
    public String getName() {
	return name;
    }

    @Override
    public String getEmailAddress() {
	return emailAddress;
    }

}
