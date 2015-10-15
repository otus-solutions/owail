package br.org.owail.sender;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class EmailUserTest {

    private static final String NAME = "Email User";
    private static final String EMAIL_ADDRESS = "user@domail.com";

    @Test
    public void an_EmailUser_should_have_a_name() {
	EmailUser emailUser = new Recipient(NAME, EMAIL_ADDRESS);

	assertThat(emailUser.getName(), equalTo(NAME));
    }

    @Test
    public void an_EmailUser_should_have_an_email_address() {
	EmailUser emailUser = new Recipient(NAME, EMAIL_ADDRESS);

	assertThat(emailUser.getEmailAddress(), equalTo(EMAIL_ADDRESS));
    }

}
