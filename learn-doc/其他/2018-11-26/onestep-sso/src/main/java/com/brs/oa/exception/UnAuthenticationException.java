package com.brs.oa.exception;

public class UnAuthenticationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UnAuthenticationException() {
		super();
	}
	public UnAuthenticationException(String msg) {
		super(msg);
	}

}
