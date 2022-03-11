package epf.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import epf.exception.DaoException;
import epf.model.Client;
import epf.persistence.ConnectionManager;



@Repository
@Scope("singleton")

public class ClientDao {
	
	 
	private ClientDao() {}
	 
	
	//requete neceassaire au crud
	
	private static final String CREATE_CLIENT_QUERY = "INSERT INTO Client(nom, prenom, email, naissance) VALUES(?, ?, ?, ?);";
	private static final String DELETE_CLIENT_QUERY = "DELETE FROM Client WHERE id=?;";
	private static final String FIND_CLIENT_QUERY = "SELECT id, nom, prenom, email, naissance FROM Client WHERE id=?;";
	private static final String FIND_CLIENTS_QUERY = "SELECT id, nom, prenom, email, naissance FROM Client;";
	private static final String UPDATE_CLIENTS_QUERY="UPDATE client SET nom=?,prenom=?,email=?,naissance=? WHERE id=?;";
	
	public long create (Client client) throws DaoException {   //creation d'un client
		
		try {
			Connection com= ConnectionManager.getConnection();
			PreparedStatement pstmt=com.prepareStatement(CREATE_CLIENT_QUERY);
		
			
			pstmt.setString(1, client.getName()); 
			pstmt.setString(2, client.getLastname()); 
			pstmt.setString(3, client.getEmail()); 
			pstmt.setDate(4, Date.valueOf(client.getBirthDate())); 
			
			return pstmt.executeUpdate();
		    
		}
	
		catch (SQLException e){
			e.printStackTrace();
		}
		return 0;
		
	}
	
	
	public long delete (int id) throws DaoException {
		

		try {
			
		
			Connection com= ConnectionManager.getConnection();
			PreparedStatement pstmt=com.prepareStatement(DELETE_CLIENT_QUERY);
			
			
			pstmt.setInt(1,id);
			
			  return pstmt.executeUpdate();
			

			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return 0;
	
		
	}
	
	
	
	public long update(Client client) throws DaoException {
		
	
	       try {
	    	   
	      Connection com= ConnectionManager.getConnection();
		  PreparedStatement pstmt=com.prepareStatement(UPDATE_CLIENTS_QUERY);
		  

		  
		    pstmt.setInt(5,client.getId());
			pstmt.setString(1, client.getName()); 
			pstmt.setString(2, client.getLastname()); 
			pstmt.setString(3, client.getEmail()); 
			pstmt.setDate(4, Date.valueOf(client.getBirthDate())); 
			
		
			
			pstmt.executeUpdate();

					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
	}
	
	

	//private double getLastName() {
		// TODO Auto-generated method stub
		//return 0;
	//}
	public Optional<Client> findById(long id) throws DaoException {
		try {
			Connection com=  ConnectionManager.getConnection();
			PreparedStatement pstmt=com.prepareStatement(FIND_CLIENT_QUERY);
			
			pstmt.setInt(1, (int) id);
			
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			int clientId= rs.getInt("id");
			String clientLastName=rs.getString("nom");
			String clientFirstname=rs.getString("prenom");
			String clientEmail=rs.getString("email");
			LocalDate ClientBirthDate=rs.getDate("naissance").toLocalDate();
			
			
			Client client = new Client (clientId, clientLastName, clientFirstname,clientEmail, ClientBirthDate);
			return Optional.of(client);
			
			
	  
			
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	

	public List<Client> findAll() throws DaoException {
		

		try {
			
		
			
			
			List<Client> listClient = new ArrayList<Client>();
		
			Connection com=  ConnectionManager.getConnection();
			
			PreparedStatement pstmt=com.prepareStatement(FIND_CLIENTS_QUERY);
			
			
			ResultSet rs = pstmt.executeQuery();
			
	
			while(rs.next()){
				
				
		
				int clientId= rs.getInt("id");
				String clientLastName=rs.getString("nom");
				String clientFirstname=rs.getString("prenom");
				String clientEmail=rs.getString("email");
				LocalDate ClientBirthDate=rs.getDate("naissance").toLocalDate();
				
				
				Client client = new Client (clientId,clientLastName,clientFirstname,clientEmail,ClientBirthDate);
				

		
				listClient.add(client);
			}
		
			
			return listClient;
			
	
	}  catch (SQLException e) {
		e.addSuppressed(e);
	}
		return null;
   
}
	
}
