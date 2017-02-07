package ie.donedeal.beerapp.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
/**
 * Application executable that uses a Tomcat embedded servlet to provide a standalone application 
 * 
 * 		<p>How to execute?</p>
 * 		<p>Option 1. <code>java -jar Application</code></p>
 * 		<p>Option 2. Run as > Java Application</p>
 * 
 * @author Luan Reffatti
 */
@SpringBootApplication
@ComponentScan({"ie.donedeal.beerapp.controller"})
public class BeerApp {
	
    public static void main(String[] args) {
        SpringApplication.run(BeerApp.class, args);
    }
    
}
