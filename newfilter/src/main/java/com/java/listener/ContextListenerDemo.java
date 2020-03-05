package com.java.listener;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ContextListenerDemo implements ServletContextListener
{
    @Override
    public void contextInitialized( ServletContextEvent servletContextEvent )
    {
        System.out.println("\n###################################\n");
        System.out.println("contextInitialized method has been called in "
                + this.getClass().getName());
        ServletContext servletContext = servletContextEvent.getServletContext();
        System.out.println(servletContext + " is Initialized or Created");

        try (InputStream input = new FileInputStream("C:\\Users\\sushilk\\newfilter\\src\\main\\config.properties"))  {
            Properties prop = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            prop.load(input);
            System.out.println(prop.getProperty("db.url"));
            System.out.println(prop.getProperty("db.user"));
            System.out.println(prop.getProperty("db.password"));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("\n#####################################\n");

    }
    @Override
    public void contextDestroyed( ServletContextEvent servletContextEvent )
    {
        System.out.println("\n###################################\n");
        System.out.println("contextDestroyed method has been called in "
                + this.getClass().getName());
        ServletContext servletContext = servletContextEvent.getServletContext();
        System.out.println(servletContext + " is destroyed");
        System.out.println("\n#####################################\n");
        /*
         * If ServletContext is Destroyed, based on that if you want to perform
         * any operation then you can do it here.
         */
    }
}