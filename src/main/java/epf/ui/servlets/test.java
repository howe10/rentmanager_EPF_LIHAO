/*
 * package epf.ui.servlets;
 * 
 * import java.io.IOException;
 * 
 * import javax.servlet.RequestDispatcher; import
 * javax.servlet.ServletException; import javax.servlet.annotation.WebServlet;
 * import javax.servlet.http.HttpServlet; import
 * javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.context.support.SpringBeanAutowiringSupport;
 * 
 * //import epf.exception.DaoException; //import epf.exception.ServiceException;
 * import epf.exception.*; import epf.service.ClientService;
 * 
 * @WebServlet("/users") public class test extends HttpServlet{
 * 
 * private static String Vue_Formulaire="/WEB-INF/views/users/list.jsp";
 * 
 * @Autowired ClientService clientService; private static final long
 * serialVersionUID = 1L;
 * 
 * @Override public void init() throws ServletException{ super.init();
 * SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this); }
 * 
 *
 * 
 * @Autowired ClientService clientService; private static final long
 * serialVersionUID =1L;
 * 
 * 
 * 
 * @Override public void init() throws ServletException { super.init();
 * SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this); }
 * 
 * //public ClientService clientService= ClientService.getInstance();
 * 
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException {
 * 
 * 
 * 
 * try { request.setAttribute("clients", this.clientService.findAll());
 * 
 * RequestDispatcher r =
 * request.getRequestDispatcher("WEB-INF/views/users/list.jsp");
 * r.forward(request, response);
 * 
 * 
 * }catch(ServiceException e) { e.printStackTrace();
 * 
 * } catch (DaoException e) {
 * 
 * // TODO Auto-generated catch block e.printStackTrace(); }
 * //getServletContext().getRequestDispatcher(Vue_Formulaire).forward(request,
 * response); }
 * 
 * 
 * protected void doPost(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException {
 * 
 * 
 * 
 * 
 * String strIdrecup = request.getParameter("id"); int idRecup=
 * Integer.valueOf(strIdrecup);
 * 
 * try { this.clientService.delete(idRecup);
 * 
 * } catch (ServiceException e) {
 * 
 * }
 * 
 * this.doGet(request,response); } }
 */