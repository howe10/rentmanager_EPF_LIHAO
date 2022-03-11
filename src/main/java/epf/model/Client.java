package epf.model;

import java.time.LocalDate;

public class Client {
	
	private int id;
	private String name;
	private String lastname;
	private String email;
	private LocalDate birthDate;
	
	
	public Client() {
		
	}
	
	


	public Client(String name, String lastname, String email, LocalDate birthDate) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.birthDate = birthDate;
	}

	public Client(String name, String lastname, String email) {
		super();
	
		this.name = name;
		this.lastname = lastname;
		this.email = email;
	}





	public Client(int id, String name, String lastname, String email, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.birthDate = birthDate;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public LocalDate getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}


	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", lastname=" + lastname + ", email=" + email
				+ ", birthDate=" + birthDate + "]";
	}


	public String gePrenom() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
