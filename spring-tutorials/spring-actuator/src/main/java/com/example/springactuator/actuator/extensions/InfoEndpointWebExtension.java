package com.example.springactuator.actuator.extensions;

import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.boot.actuate.endpoint.web.annotation.EndpointWebExtension;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.stereotype.Component;

@Component
@EndpointWebExtension(endpoint = InfoEndpoint.class)
public class InfoEndpointWebExtension {

    public WebEndpointResponse<String> info() {
        return new WebEndpointResponse<>("INFO", 204);
    }
}
