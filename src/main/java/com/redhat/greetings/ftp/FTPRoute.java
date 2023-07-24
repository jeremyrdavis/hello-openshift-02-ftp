package com.redhat.greetings.ftp;

import jakarta.enterprise.context.ApplicationScoped;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class FTPRoute extends RouteBuilder {
    static final Logger LOGGER = LoggerFactory.getLogger(FTPRoute.class);

    @Override
    public void configure() throws Exception {

        from("{{ftp.source}}")
                .to("ftp://{{ftp.user}}@{{ftp.server}}/uploads?password={{ftp.password}}&passiveMode=true");
    }
}
