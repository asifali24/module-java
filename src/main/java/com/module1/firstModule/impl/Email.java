package com.module1.firstModule.impl;

import com.module1.firstModule.Notification;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
@Qualifier("email")
public class Email implements Notification {
    @Override
    public void send(Object message) {
        System.out.println("Sending Email "+ message);
    }
}
