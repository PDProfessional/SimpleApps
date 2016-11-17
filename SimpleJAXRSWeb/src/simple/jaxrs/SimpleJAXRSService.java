package simple.jaxrs;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/example")
public class SimpleJAXRSService {

        @GET
        @Produces(MediaType.TEXT_PLAIN)
        public Response sayHello(){
        	System.out.println("simple.jaxrs.SimpleJAXRSService.sayHello()");
        	return Response.ok("Hello from JAXRS").build();
        }
        
        @POST
        @Consumes(MediaType.TEXT_PLAIN)
        @Produces(MediaType.TEXT_PLAIN)
        public Response sayHellowithName(String name){
        	System.out.println("simple.jaxrs.SimpleJAXRSService.sayHellowithName() :" + name);
            return Response.ok("Hello "+ name +" from JAXRS").build();
        }
}
