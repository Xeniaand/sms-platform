package com.xeniaandreou.processor;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

@QuarkusTest
public class SmsProcessorTest {

    @Mock
    SmsCallbackClient callbackClient;

    @InjectMocks
    SmsProcessor processor;

    @Test
    public void testConsumeWithoutCallingRealService() throws Exception {
        MockitoAnnotations.openMocks(this);

        SmsPayload payload = new SmsPayload();
        payload.id = "000001";
        payload.userId = "Alice";
        payload.phoneNumber = "+357123456";
        payload.content = "Hi there!";

        processor.callbackClient = callbackClient; // override for test

        processor.consume(payload);

        verify(callbackClient, times(1)).sendCallback(any());
    }
}
