package epf.ui.servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import epf.model.Client;
import epf.model.Reservation;
import epf.service.ClientService;
import epf.service.ReservationService;
import epf.service.VehicleService;

public class UserupdateServelet {
	
	@WebServlet("/users/update")
	public class ReservationUpdateServlet  extends HttpServlet{
		private static final long serialVersionUID = 1L;

		@Autowired private ReservationService reservationService;
		@Autowired private ClientService clientService;
		@Autowired private VehicleService vehicleService;
		
		@Override
		public void init() throws ServletException {
			super.init();
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		}
		
		protected void doGet(final HttpServletRequest request,final HttpServletResponse
				response) throws ServletException, IOException {
		 try {
			 int resaId = Integer.parseInt(request.getParameter("id"));
			 Client client = new Client();
			 client = clientService.findById(resaId);
			 Reservation reservation = new Reservation();
			 reservation = reservationService.findById(resaId);
			 
			 request.setAttribute("client",  clientService.findById(resaId));
		
			
		 } catch (final Exception e) {
			 request.setAttribute("ErrorMessage",  e.getMessage());
			 e.printStackTrace();
			 System.out.println("Une erreur est survenue:" + e.getMessage());
			 
		 }
		}
		 
		 protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
				try {
					Client client = new Client();
					client =clientService.findById(Integer.parseInt(request.getParameter("id")));
					client.setName(request.getParameter("first_name"));
					client.setLastname(request.getParameter("last_name"));
					client.setBirthDate(Date.valueOf(request.getParameter("birthDate")).toLocalDate());
					client.setEmail(request.getParameter("email"));
					clientService.update(client);
					
				} catch(final Exception e) {
					 System.out.println("Une erreur est survenue:" + e.getMessage());
				}
				response.sendRedirect("http://localhost:8080/rentmanger/rents");
					
					
					
			} 
		 }
			 
}
