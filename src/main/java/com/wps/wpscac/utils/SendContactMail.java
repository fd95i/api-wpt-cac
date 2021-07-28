package com.wps.wpscac.utils;

import com.wps.wpscac.contact.entity.Contact;

public class SendContactMail implements Runnable {

    private final Contact contact;

    public SendContactMail(final Contact contactInfo) {
        this.contact = contactInfo;
    }

    @Override
    public void run() {

    }

    public static final void dispatch(final Contact info) {
        new Thread(new SendContactMail(info)).run();
    }
}
