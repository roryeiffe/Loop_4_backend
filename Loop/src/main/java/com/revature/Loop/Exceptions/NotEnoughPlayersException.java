package com.revature.Loop.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Must havr at least 3 players")
public class NotEnoughPlayersException extends Exception{

}
