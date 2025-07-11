package com.xeniaandreou.sms;

import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class SmsServiceTest {

    private SmsService smsService;
    private Emitter mockEmitter;

    @BeforeEach
    void setUp() {
        mockEmitter = Mockito.mock(Emitter.class);
        smsService = new SmsService();
        smsService.emitter = mockEmitter; // assumes emitter is public or package-private
    }

    @Test
    public void testValidateAndQueue() {
        SmsMessage msg = new SmsMessage();
        msg.userId = "user1";
        msg.phoneNumber = "+357123456";
        msg.content = "Hi there!";

        smsService.validateAndQueue(msg);

        verify(mockEmitter, times(1)).send(eq(msg));
    }
}
