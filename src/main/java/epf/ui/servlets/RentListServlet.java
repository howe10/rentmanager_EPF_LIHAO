/*
 * package epf.ui.servlets;
 * 
 * import java.io.IOException;
 * 
 * import javax.servlet.RequestDispatcher; import
 * javax.servlet.ServletException; import javax.servlet.http.HttpServlet; import
 * javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.context.support.SpringBeanAutowiringSupport;
 * 
 * import epf.exception.ServiceException; import epf.model.Reservation; import
 * epf.service.ReservationService;
 * 
 * public class RentListServlet extends HttpServlet { private static String
 * Vue_Formulaire="/WEB-INF/views/rents/list.jsp";
 * 
 * @Autowired ReservationService reservationService; private static final long
 * serialVersionUID = 1L;
 * 
 * @Override public void init() throws ServletException{ super.init();
 * SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this); }
 * 
 * @Override protected void doGet(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException, IOException { try {
 * request.setAttribute("listRents", this.reservationService.findAll());
 * 
 * }catch(ServiceException e) { e.printStackTrace(); }
 * this.getServletContext().getRequestDispatcher(Vue_Formulaire).forward(request
 * ,response); }
 * 
 * 
 * protected void doPost(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException { String delete =
 * request.getParameter("delete");
 * System.out.println("Selete qui va etre fait");
 * 
 * 
 * if(delete !=null) { int id_reservation = Integer.parseInt(delete);
 * Reservation reservation = new Reservation(id_reservation); try {
 * reservationService.delete(reservation); System.out.println("Delete fait");
 * }catch(ServiceException e) { }
 * this.getServletContext().getRequestDispatcher(Vue_Formulaire).forward(request
 * ,response); } } }
 */

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

import epf.exception.ServiceException;
import epf.service.ReservationService;

@WebServlet("/rents")
public class RentListServlet extends HttpServlet {

	@Autowired
	ReservationService ReservationService;

	@Override
	public void init() throws ServletException {
		super.init();
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	// ClientService clientService = ClientService.getInstance();
	
	

	// private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.setAttribute("listRents", this.ReservationService.findAll()); // List<Client>
			
			 RequestDispatcher r = request.getRequestDispatcher("WEB-INF/views/rents/list.jsp");
			 r.forward(request, response);
			
			
			//this.getServletContext().getRequestDispatcher("/WEB-INF/views/rents/list.jsp").forward(request, response);

		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}


protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	
	


    //String strIdrecup = request.getParameter("id");
	//int idRecup= Integer.valueOf(strIdrecup);
	
   // try {
    	//this.vehicleService.delete(idRecup);
    	
	//} catch (ServiceException e) {
	
	//}
    
	this.doGet(request,response);
}
}


