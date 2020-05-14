package mockito2electricboogaloo;

public class factory {
	
	Car car = null;
	Motorcycle motorcycle = null;
	Plane plane = null;
	
	public Car getCar(String make, int wheels, int mileage, String colour, boolean fourWheelDrive, int doors) {
		if (car != null) {
			return car;
		} else {
			car = new Car(make, wheels, mileage, colour, fourWheelDrive, doors);
			return car;
		}
	}
	
	public Motorcycle getMotorcycle(String make, int wheels, int mileage, String colour, boolean requiresHelmet) {
		if (motorcycle != null) {
			return motorcycle;
		} else {
			motorcycle = new Motorcycle(make, wheels, mileage, colour, requiresHelmet);
			return motorcycle;
		}
	}
	
	public Plane getPlane(String make, int wheels, int mileage, String colour, int wingspan, int doors) {
		if (plane != null) {
			return plane;
		} else {
			plane = new Plane(make, wheels, mileage, colour, wingspan, doors);
			return plane;
		}
	}

}
