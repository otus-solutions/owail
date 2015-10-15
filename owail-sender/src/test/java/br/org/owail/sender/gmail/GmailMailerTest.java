package br.org.owail.sender.gmail;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import br.org.owail.sender.session.EmailSessionFactory;

@Ignore
@RunWith(PowerMockRunner.class)
@PrepareForTest(EmailSessionFactory.class)
public class GmailMailerTest {

    @Test
    public void mailerForTls_method_should_return_a_GmailMailer_instance() {
	GmailMailer mailer = GmailMailer.createMailerForTls();

	MatcherAssert.assertThat(mailer, Matchers.notNullValue());
    }

}
