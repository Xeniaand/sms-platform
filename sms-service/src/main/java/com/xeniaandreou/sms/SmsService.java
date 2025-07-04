package com.xeniaandreou.sms;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import java.util.*;

@ApplicationScoped
public class SmsService {

    private final Map<String, SmsMessage> store = new HashMap<>();

    public Emitter<SmsMessage> emitter;


    public void validateAndQueue(SmsMessage message) {
        if (message.userId == null || message.content == null || message.phoneNumber == null)
            throw new IllegalArgumentException("Missing required fields");

        message.id = UUID.randomUUID().toString();
        message.status = "QUEUED";

        store.put(message.id, message);

        // Send to Kafka/RabbitMQ
        emitter.send(message);
    }

    public List<SmsMessage> getAllMessages() {
        return new ArrayList<>(store.values());
    }

    public void updateMessageStatus(SmsCallback callback) {
        SmsMessage msg = store.get(callback.messageId);
        if (msg != null) {
            msg.status = callback.status;
        }
    }
}

