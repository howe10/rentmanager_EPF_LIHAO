package epf.ui.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import epf.exception.ServiceException;
import epf.model.Client;
import epf.service.ClientService;




@WebServlet(urlPatterns = "/users/create")
public class UserCreateServlet extends HttpServlet{
	private static String Vue_Formulaire="/WEB-INF/views/users/create.jsp";
	
	@Autowired ClientService clientService;
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
	  //  DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/mm/yyyy");
	    
	
    try {
    	
	    String last_name = request.getParameter("last_name");
	    String name = request.getParameter("first_name");
	    String email = request.getParameter("email");
	    //String birthDate= request.getParameter("dateajout");
	    LocalDate naissance = LocalDate.parse(request.getParameter("birthDate"));
	   
	    this.clientService.create(new Client(last_name,name,email,naissance));
	  
	    response.sendRedirect(request.getContextPath()+"/users");

	    	//int cpt = (int) clientService.count();
	    	//cpt++;
	    	
	    	//Client client = new Client(cpt,last_name,first_name,email,birth);
	    	
	    	
	    	//clientService.create(client);
	    }catch(ServiceException e) {
			 e.printStackTrace();
	    }
	  
	    
	    
}
}
