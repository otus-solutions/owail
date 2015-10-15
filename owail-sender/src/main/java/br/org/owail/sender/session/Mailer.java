package br.org.owail.sender.session;

import javax.mail.MessagingException;

import br.org.owail.sender.email.Email;
import br.org.owail.sender.gmail.EmailCompositionException;

public interface Mailer {

    void send(Email email) throws EmailCompositionException, MessagingException;

}
