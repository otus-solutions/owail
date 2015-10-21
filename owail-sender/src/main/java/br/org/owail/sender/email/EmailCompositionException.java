package br.org.owail.sender.email;

public class EmailCompositionException extends Exception {

    private static final long serialVersionUID = 4572969491869352912L;

    public EmailCompositionException() {
    }

    public EmailCompositionException(String message) {
	super(message);
    }

    public EmailCompositionException(Throwable cause) {
	super(cause);
    }

    public EmailCompositionException(String message, Throwable cause) {
	super(message, cause);
    }

}
