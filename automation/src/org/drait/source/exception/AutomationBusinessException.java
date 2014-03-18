/**
 * 
 */
package org.drait.source.exception;

/**
 * @author DEEPAK
 * 
 */
public class AutomationBusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6576184782926828315L;

	public AutomationBusinessException(String msg) {
		super(msg);
	}

	public AutomationBusinessException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
