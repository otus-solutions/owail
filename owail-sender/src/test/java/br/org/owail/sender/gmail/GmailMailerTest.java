package br.org.owail.sender.gmail;

import java.util.ArrayList;
import java.util.List;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import br.org.owail.sender.email.Email;
import br.org.owail.sender.email.Recipient;
import br.org.owail.sender.email.Sender;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ GmailMailer.class, EmailCompositionException.class, Transport.class, MessageWrapper.class })
public class GmailMailerTest {

    @Mock
    public Sender senderMock;
    @Mock
    public Email emailMock;
    @Mock
    public SMTPTLSProperties propertiesMock;
    @Mock
    public Message messageMock;
    @Mock
    public String stringMock;
    @Mock
    public Transport transportMock;

    public Recipient recipient;
    public List<Recipient> recipients;

    @Before
    public void setup() throws Exception {
	PowerMockito.whenNew(Email.class).withNoArguments().thenReturn(emailMock);
	PowerMockito.whenNew(SMTPTLSProperties.class).withNoArguments().thenReturn(propertiesMock);

	PowerMockito.mockStatic(EmailCompositionException.class);
	PowerMockito.mockStatic(Transport.class);
	PowerMockito.mockStatic(MessageWrapper.class);

	Mockito.when(emailMock.getFrom()).thenReturn(senderMock);
	Mockito.when(emailMock.getRecipients()).thenReturn(constructRecipientList());
	Mockito.when(emailMock.getMessageText()).thenReturn(stringMock);

	Mockito.when(MessageWrapper.wrap(emailMock, propertiesMock)).thenReturn(messageMock);
    }

    private List<Recipient> constructRecipientList() {
	recipients = new ArrayList<>();

	recipient = Recipient.createTO("Recipient", "email@address.com");

	recipients.add(recipient);
	return recipients;
    }

    @Test
    public void createTLSMailer_method_should_return_a_GmailMailer_instance() {
	GmailMailer mailer = GmailMailer.createTLSMailer();

	MatcherAssert.assertThat(mailer, Matchers.notNullValue());
    }

    @Test
    public void setFrom_method_should_call_setFrom_method_of_Email() {
	GmailMailer mailer = GmailMailer.createTLSMailer();

	mailer.setFrom(senderMock);

	Mockito.verify(emailMock).setFrom(senderMock);
    }

    @Test
    public void addRecipient_method_should_call_addRecipient_method_of_Email() {
	GmailMailer mailer = GmailMailer.createTLSMailer();

	mailer.addRecipient(recipient);

	Mockito.verify(emailMock).addRecipient(recipient);
    }

    @Test
    public void setSubject_method_should_call_setSubject_method_of_Email() {
	GmailMailer mailer = GmailMailer.createTLSMailer();

	mailer.setSubject(stringMock);

	Mockito.verify(emailMock).setSubject(stringMock);
    }

    @Test
    public void setMessageText_method_should_call_setMessage_method_of_Email() {
	GmailMailer mailer = GmailMailer.createTLSMailer();

	mailer.setMessageText(stringMock);

	Mockito.verify(emailMock).setMessageText(stringMock);
    }

    @Test
    public void send_method_should_call_wrap_from_MessageWrapper() throws EmailCompositionException, MessagingException {
	GmailMailer mailer = GmailMailer.createTLSMailer();

	mailer.send();

	PowerMockito.verifyStatic();
	MessageWrapper.wrap(emailMock, propertiesMock);
    }

    @Test
    public void send_method_should_call_send_method_from_Transport() throws EmailCompositionException,
	    MessagingException {
	GmailMailer mailer = GmailMailer.createTLSMailer();

	mailer.send();

	PowerMockito.verifyStatic();
	Transport.send(messageMock);
    }

}