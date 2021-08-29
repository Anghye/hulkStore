package com.hulkStore.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HulkStroreExcepcition extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final String code;
	
	private final HttpStatus status;

	private final String message;
}
