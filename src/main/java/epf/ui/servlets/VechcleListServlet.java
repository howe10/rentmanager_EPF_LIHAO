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

import epf.exception.DaoException;
import epf.exception.ServiceException;
import epf.service.VehicleService;

@WebServlet(urlPatterns = "/cars")

public class VechcleListServlet extends HttpServlet {
       private static String Vue_Formulaire = "/WEB-INF/views/cars/list.jsp";
       
      @Autowired VehicleService vehicleService;
       private static final long serialVersionULD = 1L;
       
       @Override
       public void init() throws ServletException{
    	   super.init();
    	   SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
   	}
   
       
       
       
       @Override
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
    	   try {
    		   
    		   request.setAttribute("Vehicles", this.vehicleService.findAll());
    		   RequestDispatcher r = request.getRequestDispatcher("WEB-INF/views/cars/list.jsp");
    		   r.forward(request, response);
  			 
    	   } catch(ServiceException e) {
    			   e.printStackTrace();
    	   }
   	 }
   		 
   	 
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
   		throws ServletException, IOException {
	String strIdrecup = request.getParameter("manufacturer");
	int idRecup= Integer.valueOf(strIdrecup);
	   	
       try {
       	this.vehicleService.delete(idRecup);
       	
   	} catch (ServiceException e) {
   	
   	}
       
   	this.doGet(request,response);
   }
   }
