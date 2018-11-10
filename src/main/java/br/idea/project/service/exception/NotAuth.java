package br.idea.project.service.exception;

public class NotAuth extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotAuth(String msg) {
		super(msg);
	}
	
	public NotAuth(String msg, Throwable cause) {
		super(msg, cause);
	}

	
}
