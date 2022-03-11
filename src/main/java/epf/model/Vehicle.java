package epf.model;

public class Vehicle {
//private String marque;
private int id;
private String constructor;
private int nbPlace;

@Override
public String toString() {
	return "Vehicle [id=" + id + ", constructor=" + constructor + ", nbPlace=" + nbPlace + "]";
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

//public String getmarque() {
//	return marque;
//}
//
//public void setmarque(String marque) {
//	this.marque = marque;
//}

public String getConstructor() {
	return constructor;
}

public void setConstructor(String constructor) {
	this.constructor = constructor;
}

public int getNbPlace() {
	return nbPlace;
}

public void setNbPlace(int nbPlace) {
	this.nbPlace = nbPlace;
}

public Vehicle(int vehicleId,String constructor,int vehicleNbPlace) {
	this.id = vehicleId;
	this.constructor=constructor;
	this.nbPlace=vehicleNbPlace;
}

public Vehicle(String constructor,int vehicleNbPlace) {
	this.constructor=constructor;
	this.nbPlace=vehicleNbPlace;
}

public Vehicle() {
	// TODO Auto-generated constructor stub
}



}
