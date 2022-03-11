package epf.ui.servlets;

import java.io.IOException;

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

public class UserdeleteServlet {
	
	@WebServlet("/users/delete")
	public class ReservationDeleteServlet extends HttpServlet{
		private static final long serialVersionUID = 1L;
		
		@Autowired ClientService clientservice;
		
		@Override
		public void init() throws ServletException {
			super.init();
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		}
		protected void doGet(final HttpServletRequest request,final HttpServletResponse
				response) throws ServletException, IOException {
		 
		 
		 
		 try {
			 Client client =clientservice.findById(Integer.parseInt(request.getParameter("id")));
			 clientservice.delete(client.getId());
			 response.sendRedirect("http://localhost:8080/rentmanager/users");
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
}