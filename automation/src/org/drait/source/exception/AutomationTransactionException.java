/**
 * 
 */
package org.drait.source.exception;

import org.springframework.transaction.TransactionException;

/**
 * @author UC167163
 * 
 */
public class AutomationTransactionException extends TransactionException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1851557973083054240L;

	public AutomationTransactionException(String msg) {
		super(msg);

	}

	public AutomationTransactionException(String msg, final Throwable cause) {
		super(msg, cause);

	}
}
