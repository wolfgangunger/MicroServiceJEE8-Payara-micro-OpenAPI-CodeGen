package com.unw.ms;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

/**
 *
 */
@Path("/hello")
@Singleton
@Tag(name = "Hello service", description = "Check the app is online")
public class HelloController {

  @GET
  @Operation(description = "Hello Rest Method")
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Hello World Rest")
  })
  public String sayHello() {
    return "Hello World";
  }
}
