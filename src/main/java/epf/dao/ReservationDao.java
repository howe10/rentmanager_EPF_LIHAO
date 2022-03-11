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
import epf.model.Reservation;
import epf.persistence.ConnectionManager;

@Repository
@Scope("singleton")
public class ReservationDao {


	private String vehicleID;
	private ReservationDao() {}
 
	
	private static final String CREATE_RESERVATION_QUERY = "INSERT INTO Reservation(client_id, vehicle_id, debut, fin) VALUES(?, ?, ?, ?);";
	private static final String DELETE_RESERVATION_QUERY = "DELETE FROM Reservation WHERE id=?;";
	private static final String FIND_RESERVATIONS_BY_CLIENT_QUERY = "SELECT id, vehicle_id, debut, fin FROM Reservation WHERE client_id=?;";
	private static final String FIND_RESERVATIONS_BY_VEHICLE_QUERY = "SELECT id, client_id, debut, fin FROM Reservation WHERE vehicle_id=?;";
	private static final String FIND_RESERVATIONS_QUERY = "SELECT id, client_id, vehicle_id, debut, fin FROM Reservation;";
	private static final String UPDATE_RESERVATIONS_QUERY = "UPDATE client SET nom=?,prenom=?,email=?,naissance=?WHERE id=?;";	
	public long create(Reservation reservation) throws DaoException {
		
		try {
			Connection com= ConnectionManager.getConnection();
			PreparedStatement pstmt=com.prepareStatement(CREATE_RESERVATION_QUERY);
			
			pstmt.setDate(1, Date.valueOf(reservation.getDebut()));
			pstmt.setDate(1, Date.valueOf(reservation.getFin()));
			
			return pstmt.executeUpdate();
		    
		}
	
		catch (SQLException e){
			e.printStackTrace();
		}
		return 0;
		
	}
	
	
	public long delete(int id) throws DaoException {
		try {
			Connection com= ConnectionManager.getConnection();
			PreparedStatement pstmt=com.prepareStatement(DELETE_RESERVATION_QUERY);
			
			
			pstmt.setInt(1,id);
			
			  return pstmt.executeUpdate();
			

			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return 0;
	
		}
	
	public long update(Reservation reservation) throws DaoException {
		
		
	       try {
	    	   
	      Connection com= ConnectionManager.getConnection();
		  PreparedStatement pstmt=com.prepareStatement(UPDATE_RESERVATIONS_QUERY);
		  

		  
		   
		    pstmt.setDate(4, Date.valueOf(reservation.getDebut()));
			pstmt.setDate(5, Date.valueOf(reservation.getFin()));
			
		
			
			pstmt.executeUpdate();

					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
	}
	
	public Optional<Reservation> findResaByClientId(long idClient) throws DaoException {
		try {
			Connection com=  ConnectionManager.getConnection();
			PreparedStatement pstmt=com.prepareStatement(FIND_RESERVATIONS_BY_CLIENT_QUERY);
			
			
			pstmt.setInt(2, (int) idClient);
			
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			int clientId= rs.getInt("client_id");
			int vehicleId= rs.getInt("vehicle_id");
			LocalDate debut=rs.getDate("debut").toLocalDate();
			LocalDate fin=rs.getDate("fin").toLocalDate();
			
			
			Reservation  reservation = new Reservation (clientId,vehicleId,debut,fin);
			return Optional.of(reservation);
		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
		
	}
	public Optional<Reservation> findById(long idVehicle) throws DaoException {
		try {
			Connection com=  ConnectionManager.getConnection();
			PreparedStatement pstmt=com.prepareStatement(FIND_RESERVATIONS_BY_CLIENT_QUERY);
			
			
			pstmt.setInt(3, (int) idVehicle);
			
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			int clientId= rs.getInt("client_id");
			int vehicleId= rs.getInt("vehicle_id");
			LocalDate debut=rs.getDate("debut").toLocalDate();
			LocalDate fin=rs.getDate("fin").toLocalDate();
			
			
			Reservation  reservation = new Reservation (clientId,vehicleId,debut,fin);
			return Optional.of(reservation);
		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
		
	}
	
	public List<Reservation> findAll() throws DaoException {
		try {

			List<Reservation> listReservation = new ArrayList<Reservation>();
		
			Connection com=  ConnectionManager.getConnection();
			
			PreparedStatement pstmt=com.prepareStatement(FIND_RESERVATIONS_QUERY);
			
			
			ResultSet rs = pstmt.executeQuery();
			
	
			while(rs.next()){
				
				
		
				int clientId= rs.getInt("id");
				int clientID= rs.getInt("client_id");
				int vehicleID= rs.getInt("vehicle_id");
				LocalDate debut=rs.getDate("debut").toLocalDate();
				LocalDate fin=rs.getDate("fin").toLocalDate();
				
				Reservation  reservation = new Reservation (clientId,clientID,vehicleID,debut,fin);
			

		
				listReservation.add(reservation);
			}
		
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	
}
