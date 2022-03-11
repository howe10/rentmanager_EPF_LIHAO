package epf.ui.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import epf.exception.DaoException;
import epf.service.ClientService;
import epf.service.ReservationService;
//import epf.service.ReservationService;
import epf.service.VehicleService;

@WebServlet("/home")

public class HomeServlet extends HttpServlet {

  private static String Vue_Formulaire = "/WEB-INF/views/home.jsp";
  
  @Autowired VehicleService vehicleService;
  
  @Autowired ClientService clientService; 
  @Autowired ReservationService reservationService;
  
  @Override 
  public void init() throws ServletException { 
	  super.init();
  SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this); }
  
  
  //@Override
  
  protected void doGet(HttpServletRequest request, HttpServletResponse
  response) throws ServletException, IOException{
  
//  
//  RequestDispatcher r = request.getRequestDispatcher("WEB-INF/views/home.jsp");
//  
//  r.forward(request, response); 
  
  
  try {
	request.setAttribute("nb_clients", this.clientService.count());
} catch (DaoException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  try {
	request.setAttribute("nb_vehicles", this.vehicleService.count());
} catch (DaoException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  try {
	request.setAttribute("nb_reservations", this.reservationService.count());
} catch (DaoException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  getServletContext().getRequestDispatcher(Vue_Formulaire).forward(request,response); 
  }
  }
 