package com.wps.wpscac.contact.exception;

public class ContactNotFoundException extends RuntimeException {
    public ContactNotFoundException() {
        super("Contact ID not found");
    }
}
