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
import epf.service.VehicleService;



@WebServlet("/rents/details")
public class ReservationDetailServlet extends HttpServlet{
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
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/rents/details.jsp");
	try {
		 int resaId = Integer.parseInt(request.getParameter("id"));
		 Reservation resa = reservationService.findById(resaId);
		 request.setAttribute("reservation", resa);
		 request.setAttribute("vehicle", vehicleService.findById(resa.getVehicle_id()));
		 request.setAttribute("client", clientService.findById(resa.getClient_id()));
	}catch(final Exception e) {
		request.setAttribute("ErrorMessage",  e.getMessage());
		 System.out.println("Une erreur est survenue:" + e.getMessage());
		 
		 }
	
	dispatcher.forward(request,response);
	}
	 protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
			
			doGet(request,response);
		}



	}

