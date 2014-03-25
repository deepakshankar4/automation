/**
 * 
 */
package org.drait.source.rest.exception;

/**
 * @author DEEPAK
 * 
 */
public class AutomationBadRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6962114520085522532L;

	public AutomationBadRequestException(String msg) {

		super(msg);
	}

	public AutomationBadRequestException(String msg, final Throwable cause) {
		super(msg, cause);
	}

}
