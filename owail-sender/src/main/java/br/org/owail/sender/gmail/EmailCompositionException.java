package br.org.owail.sender.gmail;

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

    public EmailCompositionException(String message, Throwable cause, boolean enableSuppression,
	    boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

}
