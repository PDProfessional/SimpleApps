package simple.jaxrs;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class SimpleJAXRSApplication extends Application{
	public Set<Class<?>> getClasses(){
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(SimpleJAXRSService.class);
        return classes;
}
}
