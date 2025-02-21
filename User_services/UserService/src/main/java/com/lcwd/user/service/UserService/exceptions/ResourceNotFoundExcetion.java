package com.lcwd.user.service.UserService.exceptions;

public class ResourceNotFoundExcetion extends RuntimeException{

    public ResourceNotFoundExcetion(String user_not_found_) {
        super("Resourse not found on the server!!! ");
    }

    public ResourceNotFoundExcetion(String message, Throwable cause) {
        super(message, cause);
    }
}
