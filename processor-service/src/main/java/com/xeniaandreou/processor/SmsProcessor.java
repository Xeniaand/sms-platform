package com.xeniaandreou.processor;

import io.smallrye.reactive.messaging.annotations.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.eclipse.microprofile.reactive.messaging.Incoming;


@ApplicationScoped
public class SmsProcessor {

    @Inject
    @RestClient
    SmsCallbackClient callbackClient;

    @Incoming("sms-requests")
    public void consume(SmsPayload sms)  {
        // Simulate delivery
        System.out.println("Processing SMS to: " + sms.phoneNumber);

        // Set status
        SmsCallback callback = new SmsCallback();
        callback.messageId = sms.id;
        callback.status = "DELIVERED";

        // Call back to sms-service
        callbackClient.sendCallback(callback);
    }
}
