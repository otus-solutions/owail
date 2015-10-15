package br.org.owail.sender;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.Test;

public class EmailTest {

    private static final String MESSAGE_TEXT = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
    private static final String EMAIL_SUBJECT = "Email subject!";

    @Test
    public void an_Email_should_have_a_sender_address() {
	Email email = buildEmail();

	assertThat(email.getFrom(), notNullValue());
    }

    @Test
    public void an_Email_should_have_at_least_one_recipient_address() {
	Email email = buildEmail();

	assertThat(email.getToRecipients().size(), greaterThan(0));
    }

    @Test
    public void an_Email_should_have_a_not_empty_subject() {
	Email email = buildEmail();

	assertThat(email.getSubject(), not(isEmptyString()));
    }

    @Test
    public void an_Email_should_have_a_not_empty_message_text() {
	Email email = buildEmail();

	assertThat(email.getMessageText(), not(isEmptyString()));
    }

    private Email buildEmail() {
	Email email = new Email();

	email.setFrom(buildSender());
	email.addToRecipient(buildRecipient());
	email.setSubject(EMAIL_SUBJECT);
	email.setMessageText(MESSAGE_TEXT);

	return email;
    }

    private Sender buildSender() {
	String name = "Sender Name";
	String emailAddress = "sender.address@domail.com";
	String password = "sender.address@domail.com";

	return new Sender(name, emailAddress, password);
    }

    private Recipient buildRecipient() {
	String name = "Recipient Name";
	String emailAddress = "recipient.address@domail.com";

	return new Recipient(name, emailAddress);
    }

}
