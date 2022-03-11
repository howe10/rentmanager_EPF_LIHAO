package epf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import epf.exception.DaoException;
import epf.exception.ServiceException;
import epf.model.Client;
import epf.dao.ClientDao;
import epf.dao.ReservationDao;
@Service
@Scope("singleton")
public class ClientService {

	@Autowired
	private ClientDao clientDao;
	
	private ClientService(ClientDao clientDao){
		this.clientDao = clientDao;
		}
	
	//public static ClientService instance;
	
	/*private ClientService() {
		this.clientDao = ClientDao.getInstance();
		
	}
	public static ClientService getInstance() {
		if(instance == null) {
			instance = new ClientService();
			}
		return instance;
	}*/
	

	public long create(Client client) throws ServiceException {
		try {
			return this.clientDao.create(client);
		}catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException();
		}
			
		}
		// TODO: créer un client
		
   public long delete (int id) throws ServiceException{
	try {
		return this.clientDao.delete(id);
	}catch(DaoException e) {
		e.printStackTrace();
		
	}
	return 0;
}
   
   
   public long update (Client client) throws ServiceException{
	   try {
		   return this.clientDao.update(client);
	   }catch(DaoException e) {
		   e.printStackTrace();
			
		}
		return 0;
	}   

	public Client findById(long id) throws ServiceException {
		// TODO: récupérer un client par son id
		try {
			return this.clientDao.findById(id).get();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public List<Client> findAll() throws ServiceException, DaoException {
		
		try {
			return this.clientDao.findAll();
		
		
	} catch (DaoException e) {
		 e.printStackTrace();
	}
     return null;
}
	public int count() throws DaoException {
		// TODO Auto-generated method stub
		List<Client> c= this.clientDao.findAll();
		int len = c.size();
		return len;
	}
}
	//public Object count() {
		// TODO Auto-generated method stub
		//return null;
	//}

	
//}


