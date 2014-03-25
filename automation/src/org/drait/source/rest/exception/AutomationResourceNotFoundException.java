/**
 * 
 */
package org.drait.source.rest.exception;

/**
 * @author DEEPAK
 * 
 */
public class AutomationResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1453540847576799432L;

	public AutomationResourceNotFoundException(String msg) {
		super(msg);
	}

	public AutomationResourceNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
