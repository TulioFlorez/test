package com.haufe.test.exception;

public class TestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4462778315721581663L;

	public TestException(String name) {

		super(name + " Not Found");
	}
}