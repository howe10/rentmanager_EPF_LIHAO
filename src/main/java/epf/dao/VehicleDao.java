package epf.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import epf.exception.DaoException;
import epf.model.Client;
import epf.model.Vehicle;
import epf.persistence.ConnectionManager;



@Repository
@Scope("singleton")
public class VehicleDao {
	
	private static VehicleDao instance = null;

	private VehicleDao() {}
	 
	
	private static final String CREATE_VEHICLE_QUERY = "INSERT INTO Vehicle(constructeur, nb_places) VALUES(?, ?);";
	private static final String DELETE_VEHICLE_QUERY = "DELETE FROM Vehicle WHERE id=?;";
	private static final String FIND_VEHICLE_QUERY = "SELECT id, constructeur, nb_places FROM Vehicle WHERE id=?;";
	private static final String FIND_VEHICLES_QUERY = "SELECT id, constructeur, nb_places FROM Vehicle;";
	private static final String UPDATE_VEHICLES_QUERY = "UPDATE vehicle SET concstruteur=?,nb_places=? WHERE id=?;";
	
	public long create(Vehicle vehicle) throws DaoException {
		try {
			Connection com= ConnectionManager.getConnection();
			PreparedStatement pstmt=com.prepareStatement(CREATE_VEHICLE_QUERY);
			pstmt.setString(1, vehicle.getConstructor()); 
			pstmt.setInt(2, vehicle.getId()); 
			pstmt.setInt(3, vehicle.getNbPlace()); 
			
		
			
			return pstmt.executeUpdate();
		    
		}
	
		catch (SQLException e){
			e.printStackTrace();
		}
		return 0;
		
	}
			
	

	public long delete(int id) throws DaoException {
		try {
			Connection com = ConnectionManager.getConnection();
			PreparedStatement pstmt=com.prepareStatement(DELETE_VEHICLE_QUERY);
			pstmt.setInt(1, id);
			
return pstmt.executeUpdate();
		    
		}
	
		catch (SQLException e){
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public long update(Vehicle vehicle) throws DaoException {
		
		
	       try {
	    	   
	      Connection com= ConnectionManager.getConnection();
		  PreparedStatement pstmt=com.prepareStatement(CREATE_VEHICLE_QUERY);
		  

		  
		    //pstmt.setInt(5,client.getId());
			pstmt.setString(1, vehicle.getConstructor()); 
			pstmt.setInt(2, vehicle.getId()); 
			pstmt.setInt(3, vehicle.getNbPlace()); 

		
			
			pstmt.executeUpdate();

					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
	}
	

	public Optional<Vehicle> findById(long id) throws DaoException {
		 try {
	    	   
		      Connection com= ConnectionManager.getConnection();
			  PreparedStatement pstmt=com.prepareStatement(CREATE_VEHICLE_QUERY);
			  
			  pstmt.setInt(1, (int) id);
				
				ResultSet rs = pstmt.executeQuery();
				
				rs.next();
				int VehicleId= rs.getInt("id");
				String vehicleConstructor=rs.getString("constructeur");
				String marque =rs.getString("constructeur");
				int vehicleNbPlace=rs.getInt("nb_places");
				
				
				Vehicle vehicle = new Vehicle (VehicleId,vehicleConstructor,vehicleNbPlace);
				
				return Optional.of(vehicle);
				
				} catch (SQLException e){
				e.printStackTrace();
			}
			return null;
			
		}


	public List<Vehicle> findAll() throws DaoException {
		
		try { List<Vehicle> listVehicle = new ArrayList<>();
		      Connection com = ConnectionManager.getConnection();
			   PreparedStatement pstmt = com.prepareStatement(FIND_VEHICLES_QUERY);
			   ResultSet rs = pstmt.executeQuery();
				   
			   
		
			
		
			
			//List<Vehicle> listVehicle = new ArrayList<>();
			 while(rs.next()) {
				 
				    
					String vehicleConstructor=rs.getString("constructeur");
					int vehicleId=rs.getInt("id");
					int vehicleNbPlace=rs.getInt("nb_places");
				 
				
    			 listVehicle.add(new Vehicle(vehicleId, rs.getString("constructeur"),rs.getInt("nb_places")));
    			 
			 }
    		 return listVehicle;
    		 
    	 } catch (SQLException e) {
    		 e.printStackTrace();
    		 throw new DaoException();
    		 
    	 }
		
    		 
    	 }
			
    			 
     }
		
	









