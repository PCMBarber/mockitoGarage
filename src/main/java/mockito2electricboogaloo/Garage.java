package mockito2electricboogaloo;

import java.util.ArrayList;

public class Garage {
	
	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	factory fact;
	
	public ArrayList<Vehicle> getVehicles(){
		return vehicles;
	}

	public void addVehicle(Vehicle v) {
		this.vehicles.add(v);
	}

	public void addVehicle(String make, int wheels, int mileage, String colour, boolean fourWheelDrive, int doors) {
		this.vehicles.add(fact.getCar(make, wheels, mileage, colour, fourWheelDrive, doors));
	}

	public void addVehicle(String make, int wheels, int mileage, String colour, boolean requiresHelmet) {
		this.vehicles.add(fact.getMotorcycle(make, wheels, mileage, colour, requiresHelmet));
	}

	public void addVehicle(String make, int wheels, int mileage, String colour, int wingspan, int doors) {
		this.vehicles.add(fact.getPlane(make, wheels, mileage, colour, wingspan, doors));
	}

	public void removeVehicle(Vehicle v) {
		this.vehicles.remove(v);
	}

	public void removeVehicle(int ID) {
		for (Vehicle v : vehicles) {
			if (v.getID() == ID) {
				this.vehicles.remove(v);
			}
		}
	}

	public Vehicle findByID(int ID) {

		for (Vehicle v : vehicles) {
			if (v.getID() == ID) {
				return v;
			} else {
				System.out.println("Vehicle not found");
				return null;
			}
		}
		return null;
	}

	public void fixVehicle() {
		for (Vehicle v : vehicles) {
			System.out.println("ID: " + v.getID() + "\nMake: " + v.getMake() + "\nCost: £" + v.calculateBill());
		}
	}

	public void emptyGarage() {
		vehicles.clear();
		System.out.println("Garage emptied.");
		return;
	}
}
