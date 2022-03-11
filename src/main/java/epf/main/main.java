package epf.main;

import epf.exception.DaoException;
import epf.exception.ServiceException;
import epf.service.ClientService;
import epf.service.VehicleService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import epf.configuration.AppConfiguration;
import epf.dao.ClientDao;



public class main {
	public static void main(String[] args) throws DaoException{
		
		try {
			ApplicationContext context = new
					AnnotationConfigApplicationContext(AppConfiguration.class);
					ClientService clientService = context.getBean(ClientService.class);
					VehicleService vehicleService = context.getBean(VehicleService.class);
			System.out.println(vehicleService.findAll());
	       
	       
	       
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
