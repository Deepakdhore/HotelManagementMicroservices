package com.lcwd.user.service.UserService.exceptions;

public class ResourceNotFoundExcetion extends RuntimeException{

    public ResourceNotFoundExcetion() {
        super("Resourse not found on the server!!! ");
    }

    public ResourceNotFoundExcetion(String message) {
        super(message);
    }
}
