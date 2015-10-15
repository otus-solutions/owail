package br.org.owail.sender;

import java.util.ArrayList;
import java.util.List;

public class Email {

    private Sender from;
    private String subject;
    private String messageText;

    private List<Recipient> toRecipientList;

    public Email() {
	toRecipientList = new ArrayList<Recipient>();
    }

    public Sender getFrom() {
	return from;
    }

    public void setFrom(Sender from) {
	this.from = from;
    }

    public List<Recipient> getToRecipients() {
	return toRecipientList;
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

    public void addToRecipient(Recipient recipient) {
	toRecipientList.add(recipient);
    }

}
