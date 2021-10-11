package com.shoes.SportyShoes.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@SuppressWarnings("serial")
@ControllerAdvice
public class SportyShoeBusinessException extends Exception {
	

	public SportyShoeBusinessException() {
		super();
	}

	public SportyShoeBusinessException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public SportyShoeBusinessException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public SportyShoeBusinessException(String arg0) {
		super(arg0);
	}

	public SportyShoeBusinessException(Throwable arg0) {
		super(arg0);
	}
	
	

}
