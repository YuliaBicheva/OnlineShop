package edu.bicheva.OnlineShop.exception;

public class DbException extends ApplicationException {

	private static final long serialVersionUID = -2944826428924451242L;

	public DbException(String message, Throwable cause) {
		super(message, cause);
	}

	public DbException(String message) {
		super(message);
	}

	public DbException(Throwable cause) {
		super(cause);
	}

	
}
