package epf.model;

import java.time.LocalDate;

public class Reservation {
      private int id;
      private int client_id;
      private int vehicle_id;
      private LocalDate debut;
      private LocalDate fin;
      
      
      
      
      
	public Reservation(int id, int client_id, int vehicle_id, LocalDate debut, LocalDate fin) {
		super();
		this.id = id;
		this.client_id = client_id;
		this.vehicle_id = vehicle_id;
		this.debut = debut;
		this.fin = fin;
		
		
	}
	public Reservation(int client_id, int vehicle_id, LocalDate debut, LocalDate fin) {
		super();
		this.client_id = client_id;
		this.vehicle_id = vehicle_id;
		this.debut = debut;
		this.fin = fin;
	}
	public Reservation() {
		super();
		this.client_id = client_id;
		this.vehicle_id = vehicle_id;
		this.debut = debut;
		this.fin = fin;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public int getVehicle_id() {
		return vehicle_id;
	}
	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	public LocalDate getDebut() {
		return debut;
	}
	public void setDebut(LocalDate debut) {
		this.debut = debut;
	}
	public LocalDate getFin() {
		return fin;
	}
	public void setFin(LocalDate fin) {
		this.fin = fin;
	}
   
	
	
	
	
	
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", client_id=" + client_id + ", vehicle_id=" + vehicle_id + ", debut=" + debut
				+ ", fin=" + fin + "]";
	}


	public String gePrenom() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}



      
      
      
      
      

