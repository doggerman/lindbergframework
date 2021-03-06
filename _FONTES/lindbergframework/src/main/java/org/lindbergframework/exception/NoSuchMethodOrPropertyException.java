package org.lindbergframework.exception;

import java.util.List;

/**
 * Bean Method or Bean property not found.
 * 
 * @author Victor Lindberg
 * 
 */
public class NoSuchMethodOrPropertyException extends LindbergException {

	private static final long serialVersionUID = 1L;
	
	public static final String DEFAULT_MSG = "Property or Method not found";

	public NoSuchMethodOrPropertyException() {
		super(DEFAULT_MSG);
	}
	
	public NoSuchMethodOrPropertyException(String clazz, String propertyOrMethodName){
		super(DEFAULT_MSG+" : "+propertyOrMethodName+" in "+clazz);
	}

    public NoSuchMethodOrPropertyException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public NoSuchMethodOrPropertyException(List<String> msgs) {
        super(msgs);
    }

    public NoSuchMethodOrPropertyException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public NoSuchMethodOrPropertyException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public NoSuchMethodOrPropertyException(Throwable cause,
        String... causeMessages) {
        super(cause, causeMessages);
    }

	

}
