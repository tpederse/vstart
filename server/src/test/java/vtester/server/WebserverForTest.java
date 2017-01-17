package vtester.server;

import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.util.resource.ResourceCollection;

public class WebserverForTest {

	public static void main(String[] args) throws Exception {
		org.eclipse.jetty.server.Server server = new org.eclipse.jetty.server.Server(8081);
		
		ResourceHandler resourceHandler = new ResourceHandler();
		resourceHandler.setDirectoriesListed(true);
		resourceHandler.setResourceBase("src/main/webapp");
		
		server.setHandler(resourceHandler);
		server.start();		
	}
}
