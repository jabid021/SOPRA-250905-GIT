package restaurant.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import restaurant.context.Singleton;


@WebListener
public class LaunchListener implements ServletContextListener {


    public void contextDestroyed(ServletContextEvent sce)  { 
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
       System.out.println("Tomcat vient de start");
       try {
   		Class.forName("com.mysql.cj.jdbc.Driver");
   		}
   		catch(Exception e) {}
       Singleton.getInstance();
    }
	
}
