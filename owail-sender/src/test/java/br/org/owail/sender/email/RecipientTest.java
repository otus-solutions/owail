package br.org.owail.sender.email;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

import org.junit.Test;

import br.org.owail.sender.email.EmailUser;
import br.org.owail.sender.email.Recipient;

public class RecipientTest {

    private static final String NAME = "Email User";
    private static final String EMAIL_ADDRESS = "user@domail.com";

    @Test
    public void a_Recipient_implements_EmailUser() {
	Recipient recipient = new Recipient(NAME, EMAIL_ADDRESS);

	assertThat(recipient, instanceOf(EmailUser.class));
    }

    @Test
    public void an_Recipient_should_have_a_name() {
	Recipient recipient = new Recipient(NAME, EMAIL_ADDRESS);

	assertThat(recipient.getName(), equalTo(NAME));
    }

    @Test
    public void an_Recipient_should_have_an_email_address() {
	Recipient recipient = new Recipient(NAME, EMAIL_ADDRESS);

	assertThat(recipient.getEmailAddress(), equalTo(EMAIL_ADDRESS));
    }

}
