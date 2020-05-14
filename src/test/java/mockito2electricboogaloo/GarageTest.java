package mockito2electricboogaloo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class GarageTest {
	
	@Mock
	factory factory;
	
	@InjectMocks
	Garage garage = new Garage();
	
	@BeforeClass
	public void init() {
	    MockitoAnnotations.initMocks(this);
	}
	
	@Before
	public void insertDummyData() {
		garage.addVehicle(new Car("", 0, 0, "", true, 0));
	}
	
	@Test
	public void addVehicleCar() {
		when(factory.getCar(anyString(), anyInt(), anyInt(), anyString(), true, anyInt())).thenReturn(mock(Car.class));
		garage.addVehicle("",0,0,"",true,0);
		
		verify(factory).getCar(anyString(), anyInt(), anyInt(), anyString(), true, anyInt());
	}
	
	@Test
	public void addVehicleMotorcycle() {
		when(factory.getMotorcycle(anyString(), anyInt(), anyInt(), anyString(), true)).thenReturn(mock(Motorcycle.class));
		
		garage.addVehicle("", 0, 0, "", true);
		
		verify(factory).getMotorcycle(anyString(), anyInt(), anyInt(), anyString(), true);
		
	}
	
	@Test
	public void findByIDTestNotNull() {
		Vehicle test = garage.findByID(1);
		assertNotNull(test);
	}
	
	@Test
	public void findByIDTestNull() {
		Vehicle test = garage.findByID(100);
		assertNull(test);
	}

}
