package edu.bicheva.OnlineShop.exception;

public class ApplicationException extends Exception {

	private static final long serialVersionUID = -1028442449141164173L;

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApplicationException(String message) {
		super(message);
	}

	public ApplicationException(Throwable cause) {
		super(cause);
	}
	
	

}
