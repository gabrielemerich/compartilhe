package br.idea.project.resource.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.idea.project.service.exception.AuthException;
import br.idea.project.service.exception.NotAuth;
import br.idea.project.service.exception.ObjectNotFound;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

	public GlobalControllerExceptionHandler() {
		// TODO Auto-generated constructor stub
	}
	

		@ExceptionHandler(ObjectNotFound.class)
		public ResponseEntity<BodyException> conflict(ObjectNotFound ex) {
			BodyException bodyex = new BodyException(ex.getMessage(), HttpStatus.NOT_FOUND.value());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bodyex);
		}
		
		@ExceptionHandler(AuthException.class)
		public ResponseEntity<BodyException> conflict(AuthException ex) {
			BodyException bodyex = new BodyException(ex.getMessage(), HttpStatus.FORBIDDEN.value());
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bodyex);
		}
		
		@ExceptionHandler(NotAuth.class)
		public ResponseEntity<BodyException> conflict(NotAuth ex) {
			BodyException bodyex = new BodyException(ex.getMessage(), HttpStatus.NON_AUTHORITATIVE_INFORMATION.value());
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(bodyex);
		}
		
		

}
