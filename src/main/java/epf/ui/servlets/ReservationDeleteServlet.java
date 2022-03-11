package epf.ui.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import epf.model.Reservation;
import epf.service.ClientService;
import epf.service.ReservationService;

@WebServlet("/rents/delete")
public class ReservationDeleteServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Autowired ReservationService reservationService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	protected void doGet(final HttpServletRequest request,final HttpServletResponse
			response) throws ServletException, IOException {
	 
	 
	 
	 try {
		 Reservation reservation =reservationService.findById(Integer.parseInt(request.getParameter("id")));
		 reservationService.delete(reservation);
		 response.sendRedirect("http://localhost:8080/rentmanager/rents");
	 }catch(final Exception e) {
		 request.setAttribute("ErrorMessage",  e.getMessage());
		 e.printStackTrace();
		 System.out.println("Une erreur est survenue:" + e.getMessage());
		 
	 }
	}
	 protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
					
					doGet(request,response);
				}
		 
	

	
}
	
