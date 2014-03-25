/**
 * 
 */
package org.drait.source.rest.resources;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.drait.source.exception.AutomationBusinessException;
import org.drait.source.exception.AutomationTransactionException;
import org.drait.source.rest.exception.AutomationBadRequestException;
import org.drait.source.rest.exception.AutomationResourceNotFoundException;
import org.springframework.core.NestedRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author DEEPAK
 * 
 */
@ControllerAdvice
public class AutomationControllerAdvice {

	public static final Logger LOGGER = Logger
			.getLogger(AutomationControllerAdvice.class.getName());

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIllegalArgumentException(
			final IllegalArgumentException exception) {

		LOGGER.error("Illegal Argument Exception"
				+ ExceptionUtils.getStackTrace(exception));

		return new ResponseEntity<>(exception.getMessage(),
				HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handleRunTimeException(
			final RuntimeException exception) {

		LOGGER.error("Runtime Exception"
				+ ExceptionUtils.getStackTrace(exception));

		return new ResponseEntity<>(exception.getMessage(),
				HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(NestedRuntimeException.class)
	public ResponseEntity<String> handleNestedRunTimeException(
			final NestedRuntimeException exception) {

		LOGGER.error("Nested Runtime Exception"
				+ ExceptionUtils.getStackTrace(exception));

		return new ResponseEntity<>(exception.getMessage(),
				HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(AutomationTransactionException.class)
	public ResponseEntity<String> handleAutomationTransacationException(
			final AutomationTransactionException exception) {

		LOGGER.error("Automation Transaction Exception"
				+ ExceptionUtils.getStackTrace(exception));

		return new ResponseEntity<>(exception.getMessage(),
				HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(AutomationResourceNotFoundException.class)
	public ResponseEntity<String> handleAutomationResourceNotFoundException(
			final AutomationResourceNotFoundException exception) {

		LOGGER.error("Resource not found Exception"
				+ ExceptionUtils.getStackTrace(exception));

		return new ResponseEntity<>(exception.getMessage(),
				HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(AutomationBadRequestException.class)
	public ResponseEntity<String> handleAutomationBadRequestException(
			final AutomationBadRequestException exception) {

		LOGGER.error("Bad Request Exception"
				+ ExceptionUtils.getStackTrace(exception));

		return new ResponseEntity<>(exception.getMessage(),
				HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(AutomationBusinessException.class)
	public ResponseEntity<String> handleAutomationBusinessException(
			final AutomationBusinessException exception) {

		LOGGER.error("Business Exception"
				+ ExceptionUtils.getStackTrace(exception));

		return new ResponseEntity<>(exception.getMessage(),
				HttpStatus.BAD_REQUEST);

	}

}
