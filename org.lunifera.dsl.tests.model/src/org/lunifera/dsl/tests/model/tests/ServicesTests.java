package org.lunifera.dsl.tests.model.tests;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.lunifera.dsl.dto.lib.impl.DtoServiceAccess;
import org.lunifera.dsl.dto.lib.services.IDTOService;
import org.lunifera.dsl.tests.carstore.entities.dtos.AddonDto;
import org.lunifera.dsl.tests.carstore.entities.dtos.CarDto;
import org.lunifera.dsl.tests.model.AbstractJPATest;

@SuppressWarnings("restriction")
public class ServicesTests extends AbstractJPATest {

	@Test
	public void testService_CRUD() throws Exception {
		super.setUp();
		
		IDTOService<CarDto> carService = DtoServiceAccess
				.getService(CarDto.class);

		CarDto car = new CarDto();
		car.setNumber("112233");
		car.setFinishingDate(new Date());

		CarDto newCar = carService.update(car);
		Assert.assertEquals(car.getNumber(), newCar.getNumber());
		Assert.assertEquals(car.getUuid(), newCar.getUuid());
		
		CarDto rCar = carService.get(car.getUuid());
		Assert.assertEquals("112233", rCar.getNumber());
		
		carService.delete(rCar);
		
		rCar = carService.get(car.getUuid());
		Assert.assertNull(rCar);
	}
	
	@Test
	public void testService_CRUD_complex() throws Exception {
		super.setUp();
		
		IDTOService<CarDto> carService = DtoServiceAccess
				.getService(CarDto.class);

		CarDto car = new CarDto();
		car.setNumber("777777");
		car.setFinishingDate(new Date());
		
		AddonDto addon1 = new AddonDto();
		addon1.setDescription("addon1");
		car.addToAddons(addon1);
		
		AddonDto addon2 = new AddonDto();
		addon2.setDescription("addon2");
		car.addToAddons(addon2);

		CarDto newCar = carService.update(car);
		Assert.assertEquals(car.getNumber(), newCar.getNumber());
		Assert.assertEquals(car.getUuid(), newCar.getUuid());
		Assert.assertEquals(2, car.getAddons().size());
		Assert.assertEquals("addon1", car.getAddons().get(0).getDescription());
		Assert.assertEquals("addon2", car.getAddons().get(1).getDescription());
		
		CarDto rCar = carService.get(car.getUuid());
		Assert.assertEquals("777777", rCar.getNumber());
		Assert.assertEquals(2, car.getAddons().size());
		Assert.assertEquals("addon1", rCar.getAddons().get(0).getDescription());
		Assert.assertEquals("addon2", rCar.getAddons().get(1).getDescription());
		Assert.assertSame(rCar, rCar.getAddons().get(0).getCar());
		Assert.assertSame(rCar, rCar.getAddons().get(1).getCar());
		
		carService.delete(rCar);
		
		rCar = carService.get(car.getUuid());
		Assert.assertNull(rCar);
	}

}
