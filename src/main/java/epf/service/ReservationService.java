/*package epf.service;
  
 import java.util.List;

import epf.dao.ReservationDao; import epf.exception.DaoException; import
  epf.exception.ServiceException;
import epf.model.Client;
import epf.model.Reservation;
  
public class ReservationService {
  
  
private ReservationDao reservationDao;
  
private void ReservationDao(ReservationDao reservationDao) {
this.reservationDao = reservationDao; }
  
  
public long delete(Reservation reservation) throws ServiceException{ try {
return this.reservationDao.delete(reservation); }catch(DaoException e) {
  e.printStackTrace();
  
  } return 0;
  
  
  }
  
  public long create(Reservation reservation)throws ServiceException{
  
  try { return this.reservationDao.create(reservation); }catch(DaoException e)
  { e.printStackTrace();
  
  } return 0;
  
  
  }
  
  
  public Object count() { // TODO Auto-generated method stub return null; }
  
  
  
  }
  
  
  public Reservation findById(long id) throws ServiceException {
		// TODO: récupérer un client par son id
		try {
			return this.reservationtDao.findById(id).get();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public List<Reservation> findAll() throws ServiceException, DaoException {
		
		try {
			return this.reservationDao.findAll();
		
		
	} catch (DaoException e) {
		 e.printStackTrace();
	}
   return null;
}
}*/
 

package epf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import epf.dao.ClientDao;
import epf.dao.ReservationDao;
import epf.exception.DaoException;
import epf.exception.ServiceException;
import epf.model.Client;
import epf.model.Reservation;
import epf.model.Vehicle;

@Service
@Scope("singleton")
public class ReservationService {

	@Autowired
	private ReservationDao reservationDao;
	private Reservation reservation;
	//public static ClientService instance;
	private ReservationService(ReservationDao reservationDao){
		this.reservationDao = reservationDao;
		}
	
	/*private ClientService() {
		this.clientDao = ClientDao.getInstance();
	}
	
	public static ClientService getInstance() {
		if (instance == null) {
			instance = new ClientService();
		}
		
		return instance;
	}*/
	
	
	public long create(Reservation reservation) throws ServiceException, DaoException {
		// TODO: créer une réservation
		return this.reservationDao.create(reservation);
	}

	public Reservation findById(int id) throws ServiceException {
		try {
			return this.reservationDao.findById(id).get();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	   public long delete (Reservation reservation) throws ServiceException{
			try {
				return this.reservationDao.delete(reservation.getId());
			}catch(DaoException e) {
				e.printStackTrace();
				
			}
			return 0;
		}
	   
	   
	   public long update (Reservation reservation) throws ServiceException{
		   try {
			   return this.reservationDao.update(reservation);
		   }catch(DaoException e) {
			   e.printStackTrace();
				
			}
			return 0;
		}  
		   
	public List<Reservation> findAll() throws ServiceException {
		try {
			return this.reservationDao.findAll();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
	}
	public int count() throws DaoException {
		// TODO Auto-generated method stub
		List<Reservation> c= this.reservationDao.findAll();
//		int len = c.size();
		return 2;
		
	}
	
}
  
  
 
