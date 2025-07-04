package com.xeniaandreou.sms;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/sms")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SmsController {

    @Inject
    SmsService smsService;

    @POST
    @Path("/send")
    public void sendMessage(SmsMessage message) {
        smsService.validateAndQueue(message);
    }

    @GET
    @Path("/messages")
    public List<SmsMessage> listMessages() {
        return smsService.getAllMessages();
    }

    @POST
    @Path("/callback")
    public void handleCallback(SmsCallback callback) {
        smsService.updateMessageStatus(callback);
    }
}
