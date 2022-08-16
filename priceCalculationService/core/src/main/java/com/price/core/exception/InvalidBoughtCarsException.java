package com.price.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Operation is not valid")
public class InvalidBoughtCarsException extends RuntimeException{
}
