package br.org.owail.sender;

public class Sender implements EmailUser {

    private String name;
    private String emailAddress;
    private String password;

    public Sender(String name, String emailAddress, String password) {
	this.name = name;
	this.emailAddress = emailAddress;
	this.password = password;
    }

    @Override
    public String getName() {
	return name;
    }

    @Override
    public String getEmailAddress() {
	return emailAddress;
    }

    public String getPassword() {
	return password;
    }

}
