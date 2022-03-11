package epf.configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import epf.service.ClientService;
import epf.service.VehicleService;

@Configuration
@ComponentScan({ "epf.service", "epf.dao",
"epf.persistence" }) // packages dans lesquels chercher les beans

public class AppConfiguration {


}