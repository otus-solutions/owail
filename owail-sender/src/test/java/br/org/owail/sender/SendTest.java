package br.org.owail.sender;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

import org.junit.Test;

public class SendTest {

    private static final String NAME = "Email User";
    private static final String EMAIL_ADDRESS = "user@domail.com";
    private static final String PASSWORD = "password";

    @Test
    public void a_Sender_implements_EmailUser() {
	Sender sender = new Sender(NAME, EMAIL_ADDRESS, PASSWORD);

	assertThat(sender, instanceOf(EmailUser.class));
    }

    @Test
    public void an_Sender_should_have_a_name() {
	Sender sender = new Sender(NAME, EMAIL_ADDRESS, PASSWORD);

	assertThat(sender.getName(), equalTo(NAME));
    }

    @Test
    public void an_Sender_should_have_an_email_address() {
	Sender sender = new Sender(NAME, EMAIL_ADDRESS, PASSWORD);

	assertThat(sender.getEmailAddress(), equalTo(EMAIL_ADDRESS));
    }

    @Test
    public void an_Sender_should_have_an_password() {
	Sender sender = new Sender(NAME, EMAIL_ADDRESS, PASSWORD);

	assertThat(sender.getPassword(), equalTo(PASSWORD));
    }

}
