package epf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import epf.dao.VehicleDao;
import epf.exception.DaoException;
import epf.exception.ServiceException;
import epf.model.Client;
import epf.model.Reservation;
import epf.model.Vehicle;



@Service
@Scope("singleton")
public class VehicleService {

	@Autowired
	private VehicleDao vehicleDao;
	
	public static VehicleService instance;
	
	private VehicleService(VehicleDao vehicleDao) {
		 
	}
	
	
	
	public long create(Vehicle vehicle) throws ServiceException {
		return 0;
		// TODO: créer un véhicule
		
	}
	   public long delete (int id) throws ServiceException{
			try {
				return this.vehicleDao.delete(id);
			}catch(DaoException e) {
				e.printStackTrace();
				
			}
			return 0;
		}
		   

	public Vehicle findById(long id) throws ServiceException, DaoException {
		
		// TODO: récupérer un véhicule par son id
		return this.vehicleDao.findById(id).get();
		
	}
	
	   public long update (Vehicle vehicle) throws ServiceException{
		   try {
			   return this.vehicleDao.update(vehicle);
		   }catch(DaoException e) {
			   e.printStackTrace();
				
			}
			return 0;
		}  

	public List<Vehicle> findAll() throws ServiceException {
		try {
			return this.vehicleDao.findAll();
		
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO: récupérer tous les clients
		return null;
		
	}

	public int count() throws DaoException {
		// TODO Auto-generated method stub
		List<Vehicle> c= this.vehicleDao.findAll();
		int len = c.size();
		return len;
	

		
	}



	//public static ClientService getInstance() {
		// TODO Auto-generated method stub
		//return null;
	}
	
//}
