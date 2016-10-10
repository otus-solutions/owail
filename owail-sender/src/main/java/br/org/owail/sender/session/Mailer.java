package br.org.owail.sender.session;

import javax.mail.MessagingException;

import br.org.owail.sender.email.EmailCompositionException;
import br.org.owail.sender.email.Recipient;
import br.org.owail.sender.email.Sender;

public interface Mailer {

    void setFrom(Sender sender);

    void addRecipient(Recipient recipient);

    void setSubject(String subject);

    void setMessageText(String messageText);

    void send() throws EmailCompositionException, MessagingException;

}
