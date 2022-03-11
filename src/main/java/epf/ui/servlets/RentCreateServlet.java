/*
 * package epf.ui.servlets;
 * 
 * import java.io.IOException; import java.time.LocalDate; import
 * java.time.format.DateTimeFormatter;
 * 
 * import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.context.support.SpringBeanAutowiringSupport;
 * 
 * import epf.exception.DaoException; import epf.exception.ServiceException;
 * import epf.model.Reservation; import epf.service.ClientService; import
 * epf.service.ReservationService; import epf.service.VehicleService;
 * 
 * 
 * @WebServlet(urlPatterns = "/rents/create") public class RentCreateServlet
 * extends HttpServlet{ private static String Vue_Formulaire =
 * "/Web-INF/views/rents/create.jsp";
 * 
 * @Autowired ReservationService reservationService;
 * 
 * @Autowired ClientService clientService;
 * 
 * @Autowired VehicleService vehicleService;
 * 
 * 
 * private static final long serialVersionUID =1L;
 * 
 * @Override public void init() throws ServletException { super.init();
 * SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this); }
 * 
 * 
 * @Override protected void doGet(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException,IOException{ try {
 * request.setAttribute("listUsers",this.clientService.findAll());
 * request.setAttribute("listVehicles",this.vehicleService.findAll()); }
 * catch(ServiceException e) { e.printStackTrace();
 * 
 * } catch (DaoException e) { e.printStackTrace(); }
 * this.getServletContext().getRequestDispatcher(Vue_Formulaire).forward(request
 * ,response); } protected void doPost(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException,IOException{
 * 
 * DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
 * 
 * String car_string = request.getParameter("vehicle"); String client_string =
 * request.getParameter("client"); String debut_string =
 * request.getParameter("begin"); String fin_string =
 * request.getParameter("end");
 * 
 * int car = Integer.parseInt(car_string); int client =
 * Integer.parseInt(client_string); LocalDate debut =
 * LocalDate.parse(debut_string,df); LocalDate fin =
 * LocalDate.parse(fin_string,df);
 * 
 * try { int cpt = (int) reservationService.count(); cpt++;
 * 
 * Reservation reservation = new Reservation(cpt,car,client,debut,fin);
 * 
 * reservationService.create(reservation); }catch(ServiceException e) {
 * e.printStackTrace();
 * 
 * } response.sendRedirect("/rentmanager/rents");
 * 
 * 
 * } }
 * 
 * 
 * 
 * 
 * 
 */

package epf.ui.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import epf.exception.DaoException;
import epf.exception.ServiceException;
import epf.model.Client;
import epf.model.Reservation;
import epf.model.Vehicle;
import epf.service.ClientService;
import epf.service.ReservationService;
import epf.service.VehicleService;

@WebServlet(urlPatterns = "/rents/create") public class RentCreateServlet
 extends HttpServlet{ private static String Vue_Formulaire = "/WEB-INF/views/rents/create.jsp";
 
 @Autowired ReservationService reservationService;
 private static final long serialVersionUID = 1L;
 @Override 
 public void init() throws ServletException{
	 super.init();
	 SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
 
 @Override 
 protected void doGet(HttpServletRequest request, HttpServletResponse
			response) throws ServletException, IOException {
	
		 this.getServletContext().getRequestDispatcher(Vue_Formulaire).forward(request,response);
	}


 protected void doPost(HttpServletRequest request, HttpServletResponse
			response) throws ServletException, IOException {
//	    DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/mm/yyyy");
	 
	 
	 try {
	    	
         LocalDate debut = LocalDate.parse(request.getParameter("begin"));
         LocalDate fin = LocalDate.parse(request.getParameter("end"));
         int car = Integer.parseInt(request.getParameter("car"));
         int client = Integer.parseInt(request.getParameter("client"));
         this.reservationService.create(new Reservation (car, client, debut, fin));

         response.sendRedirect(request.getContextPath()+"/rents");
		   
		
 
 
 }catch(ServiceException e) {
		 e.printStackTrace();
   } catch (DaoException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  
    
    
}
}

















