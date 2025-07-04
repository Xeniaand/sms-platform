package com.xeniaandreou.sms;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

@QuarkusTest
public class SmsServiceTest {

    @Inject
    SmsService smsService;

    Emitter<SmsMessage> mockEmitter;

    @BeforeEach
    void setUp() {
        // Create a mock emitter and inject it manually
        mockEmitter = Mockito.mock(Emitter.class);
        smsService.emitter = mockEmitter;
    }

    @Test
    public void testValidateAndQueue() {
        SmsMessage msg = new SmsMessage();
        msg.userId = "user1";
        msg.phoneNumber = "+357123456";
        msg.content = "Hi there!";

        smsService.validateAndQueue(msg);

        // Verify that send() was called on the emitter
        verify(mockEmitter, times(1)).send(any(SmsMessage.class));
    }
}

