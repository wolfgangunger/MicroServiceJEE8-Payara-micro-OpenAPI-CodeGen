package com.unw.ms;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.servers.Server;

@ApplicationPath("/unw")
@ApplicationScoped
@OpenAPIDefinition(info = @Info(
        title = "Unger JEE8 Sample Microservice",
        version = "1.0.0",
        contact = @Contact(
                name = "Wolfgang",
                email = "wolfgang.unger@sccbrasil.com",
                url = "www.sccbrasil.com")
),
        servers = {
          @Server(url = "/", description = "localhost")
        }
)
public class UnwApplication extends Application {
}
