package com.xeniaandreou.processor;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "sms-service")
@Path("/sms")
public interface SmsCallbackClient {
    @POST
    @Path("/callback")
    @Consumes("application/json")
    @Produces("application/json")
    void sendCallback(SmsCallback payload);
}
