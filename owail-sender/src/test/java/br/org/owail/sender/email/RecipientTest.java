package br.org.owail.sender.email;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;

import javax.mail.Message.RecipientType;

import org.junit.Test;

public class RecipientTest {

    private static final String NAME = "Email User";
    private static final String EMAIL_ADDRESS = "user@domail.com";

    @Test
    public void a_Recipient_implements_EmailUser() {
	Recipient recipient = Recipient.createTO(NAME, EMAIL_ADDRESS);

	assertThat(recipient, instanceOf(EmailUser.class));
    }

    @Test
    public void a_Recipient_should_have_a_name() {
	Recipient recipient = Recipient.createTO(NAME, EMAIL_ADDRESS);

	assertThat(recipient.getName(), equalTo(NAME));
    }

    @Test
    public void a_Recipient_should_have_an_email_address() {
	Recipient recipient = Recipient.createTO(NAME, EMAIL_ADDRESS);

	assertThat(recipient.getEmailAddress(), equalTo(EMAIL_ADDRESS));
    }

    @Test
    public void a_Recipient_should_have_a_type() {
	Recipient recipient = Recipient.createTO(NAME, EMAIL_ADDRESS);

	assertThat(recipient.getType(), notNullValue());
    }

    @Test
    public void createTO_method_should_return_a_Recipient_of_type_TO() {
	Recipient recipient = Recipient.createTO(NAME, EMAIL_ADDRESS);

	assertThat(recipient.getType(), equalTo(RecipientType.TO));
    }

    @Test
    public void createCC_method_should_return_a_Recipient_of_type_CC() {
	Recipient recipient = Recipient.createCC(NAME, EMAIL_ADDRESS);

	assertThat(recipient.getType(), equalTo(RecipientType.CC));
    }

    @Test
    public void createBCC_method_should_return_a_Recipient_of_type_BCC() {
	Recipient recipient = Recipient.createBCC(NAME, EMAIL_ADDRESS);

	assertThat(recipient.getType(), equalTo(RecipientType.BCC));
    }

}
