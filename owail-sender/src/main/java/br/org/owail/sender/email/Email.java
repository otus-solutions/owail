package br.org.owail.sender.email;

import java.util.ArrayList;
import java.util.List;

public class Email {

    private Sender from;
    private String subject;
    private String messageText;

    private List<Recipient> recipients;

    public Email() {
	recipients = new ArrayList<Recipient>();
    }

    public Sender getFrom() {
	return from;
    }

    public void setFrom(Sender from) {
	this.from = from;
    }

    public void setFrom(String name, String email, String password) {
	setFrom(new Sender(name, email, password));
    }

    public List<Recipient> getRecipients() {
	return recipients;
    }

    public String getSubject() {
	return subject;
    }

    public void setSubject(String subject) {
	this.subject = subject;
    }

    public String getMessageText() {
	return messageText;
    }

    public void setMessageText(String messageText) {
	this.messageText = messageText;
    }

    public void addRecipient(Recipient recipient) {
	recipients.add(recipient);
    }

    public void addTORecipient(String name, String email) {
	recipients.add(Recipient.createTO(name, email));
    }

    public void addCCRecipient(String name, String email) {
	recipients.add(Recipient.createCC(name, email));
    }

    public void addBCCRecipient(String name, String email) {
	recipients.add(Recipient.createBCC(name, email));
    }

}
