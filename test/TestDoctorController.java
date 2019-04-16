package com.cognizant.pts.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.pts.controller.ClerkController;
import com.cognizant.pts.controller.DoctorController;
import com.cognizant.pts.model.ClerkModel;
import com.cognizant.pts.model.DoctorModel;
import com.cognizant.pts.service.AdminServiceImpl;
import com.cognizant.pts.service.ClerkService;
import com.cognizant.pts.service.DoctorService;
import com.cognizant.pts.service.DoctorServiceImpl;
import com.cognizant.pts.validator.ClerkValidator;
import com.cognizant.pts.validator.DoctorValidator;

public class TestDoctorController {

	 private MockMvc mockMvc;
     
     @Autowired
     private DoctorService doctorService;
     
     @Autowired
	 @Spy
	 private DoctorValidator validator; 
     
     @InjectMocks
     private DoctorController doctorController;
	
     public void init()
     {
    	 MockitoAnnotations.initMocks(this);
    	 mockMvc= MockMvcBuilders.standaloneSetup(doctorController).build();
     }
     
     
	/*@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}*/

	@Test
	public void testDoctorController_positive() 
	{
		try{
			DoctorModel doctorModel= new DoctorModel(); 
			doctorModel.setDoctorId("12");
			doctorModel.setFirstName("abc");
			doctorModel.setLastName("dsdjfffff");
			doctorModel.setAge(39);
			doctorModel.setGender("Male");
			doctorModel.setDob("25/09/1980");
			doctorModel.setContactNumber("8879879870");
			doctorModel.setAlternateContactNumber("54637382");
			doctorModel.setEmailId("dsfsdf@dsfsd.com");
			doctorModel.setAddressLine1("sdfh");
			doctorModel.setAddressLine2("brooklyn");
			doctorModel.setCity("newyork");
			doctorModel.setState("newyork");
			doctorModel.setZipCode(784512);
			doctorModel.setDegree("MBBS");
			doctorModel.setSpeciality("Neuro");
			
			doctorModel.setWorkHours("13:00-16:00");
			doctorModel.setHospitalClinicName("gsgha");
			
			Errors errors = new BeanPropertyBindingResult("90", "pts.wrongInfo");
			ModelAndView mv= doctorController.viewDoctors();
			String actual= mv.getViewName();
			String expected= "viewdoctor";
			assertEquals(actual, expected);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
	}
	}
	
	/*@Test
	public void testDoctorController_negative()
	{
		try{
			Errors errors= null;
			ModelAndView mv= doctorController.persistDoctor(doctorModel, errors);
			assertTrue(false);
		}
		catch(Exception e)
		{
			assertTrue(true);
			assertEqualsIs("Parameters are null", new persistDoctorParamException ("Parameters are null").getMessage());
		}*/
}
