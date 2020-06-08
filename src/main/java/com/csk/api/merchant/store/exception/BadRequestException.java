package com.csk.api.merchant.store.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.csk.api.merchant.store.model.Error;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@AllArgsConstructor
@NoArgsConstructor
public class BadRequestException extends RuntimeException {
	
	private static final long serialVersionUID = -8672867314241542880L;
	
	private List<Error> errorsList;

	public List<Error> getErrorsList() {
		return errorsList;
	}

	public void setErrorsList(List<Error> errorsList) {
		this.errorsList = errorsList;
	}
	
}
