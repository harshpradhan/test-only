package com.cognizant.pts.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.pts.controller.MedicineController;
import com.cognizant.pts.model.MedicineModel;
import com.cognizant.pts.service.MedicineService;
import com.cognizant.pts.validator.MedicineValidator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/config/applicationContext.xml")
public class TestMedicineController {
	
	private MockMvc mockMvc;
	
	@Autowired
	@Spy
	private MedicineValidator medicineValidator;
	
	@Autowired
	private MedicineService medicineService;
	
	@InjectMocks
	private MedicineController medicineController;
	
	public void init()
	{
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(medicineController).build();
	}
	
	@Test
	public void testMedicineController_positive()
	{
		try
		{
			MedicineModel medicineModel = new MedicineModel();
			medicineModel.setMedicineId(60);
			medicineModel.setMedicineDescription("abc");
			medicineModel.setCureFor("abc");
			medicineModel.setCureFor("abc");
			medicineModel.setDosage(10);
			medicineModel.setPrescribedFor("A");
			medicineModel.setAmount(23.0);
			Errors errors = new BeanPropertyBindingResult("90", "pts.WrongInfo");
			ModelAndView mv = medicineController.viewMedicines();
			String actual = mv.getViewName();
			String expected = "viewmedicines";
			assertEquals(actual, expected);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	
	

}
