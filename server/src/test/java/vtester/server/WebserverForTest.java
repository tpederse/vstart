package vtester.server;

import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import vtester.server.servlet.ApiServlet;


public class WebserverForTest {

	public static void main(String[] args) throws Exception {
		org.eclipse.jetty.server.Server server = new org.eclipse.jetty.server.Server(8081);


		ResourceHandler resourceHandler = new ResourceHandler();
		resourceHandler.setDirectoriesListed(true);
		resourceHandler.setResourceBase("src/main/webapp");
		server.setHandler(resourceHandler);


        ServletHandler servletHandler = new ServletHandler();
        servletHandler.addServletWithMapping(ApiServlet.class, "/api/*");


		HandlerList handlers = new HandlerList();

		handlers.addHandler(resourceHandler);
		handlers.addHandler(servletHandler);

		server.setHandler(handlers);

		server.start();		
	}
}
