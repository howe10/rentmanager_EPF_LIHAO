package epf.ui.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import epf.exception.ServiceException;
import epf.model.Vehicle;
import epf.service.VehicleService;


@WebServlet(urlPatterns = "/cars/create")
public class VehicleCreateServlet extends HttpServlet{
	private static String Vue_Formulaire="/WEB-INF/views/cars/create.jsp";
	@Autowired VehicleService vehicleService;
	
	private static final long serialVersionUID =1L;
	
	@Override
	public void init() throws ServletException{
		super.init();
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse
			response) throws ServletException, IOException{
		this.getServletContext().getRequestDispatcher(Vue_Formulaire).forward(request,response);
		
			// affichage du formulaire
	
			}
			
	protected void doPost(HttpServletRequest request, HttpServletResponse
			response) throws ServletException, IOException {
		
		try {
		
			String modele = request.getParameter("modele");
		    String seats_string = request.getParameter("seats");
		    int nbPlace = Integer.parseInt(seats_string);
		   
		
			//int cpt = vehicleService.count();
			//cpt++;   
			Vehicle vehicle = new Vehicle(modele,nbPlace);
			
			this.vehicleService.create(vehicle);
			response.sendRedirect(request.getContextPath()+"/cars");
			
			
			
		}catch(ServiceException e) {
			e.printStackTrace();
		}
		
		
			// traitement du formulaire (appel à la méthode de sauvegarde)
			}
	
	
	
	
}
