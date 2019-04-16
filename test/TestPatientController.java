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
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.pts.controller.DoctorController;
import com.cognizant.pts.controller.PatientController;
import com.cognizant.pts.model.DoctorModel;
import com.cognizant.pts.model.PatientModel;
import com.cognizant.pts.service.DoctorService;
import com.cognizant.pts.service.PatientService;
import com.cognizant.pts.validator.DoctorValidator;
import com.cognizant.pts.validator.PatientValidator;

public class TestPatientController {

	 private MockMvc mockMvc;
	
     @Autowired
     @Mock
     private PatientService patientService;
     
     @Autowired
	 @Spy
	 private PatientValidator validator; 
     
     @InjectMocks
     private PatientController patientController;
	
     public void init()
     {
    	 MockitoAnnotations.initMocks(this);
    	 mockMvc= MockMvcBuilders.standaloneSetup(patientController).build();
     }
     
     
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPatientController_positive() 
	{
		try{
			PatientModel patientModel= new PatientModel(); 
			patientModel.setPatientId("P01");
			patientModel.setFirstName("PRATEEK");
			patientModel.setLastName("KASERA");
			patientModel.setAge(23);
			patientModel.setGender("Male");
			patientModel.setDob("22JULY1995");
			patientModel.setContactNumber("9506800088");
			patientModel.setAlternateContactNumber("9140591993");
			patientModel.setEmailId("vgfwergh");
			patientModel.setAddressLine1("61/189");
			patientModel.setAddressLine2("HOOLA GANJ");
			patientModel.setCity("KANPUR");
			patientModel.setState("Ut");
			patientModel.setZipCode(208001);
		
			
			Errors errors = new BeanPropertyBindingResult("90", "pts.WrongInfo");
			ModelAndView mv= patientController.viewPatients();
			String actual= mv.getViewName();
			String expected= "viewpatients";
			assertEquals(actual, expected);
		}
		
		catch(Exception e)
		{
		e.printStackTrace();
	}
	/*}
		@Test
		public void testPatientController_negative()
		{
			try{
				Errors errors= null;
				ModelAndView mv= patientController.persistPatient(patientModel, errors);
				assertTrue(false);
			}
			catch(Exception e)
			{
				assertTrue(true);
				assertEqualsIs("Parameters are null", new PatientPersistParamException ("Parameters are null").getMessage());
			}*/
		
		
		
	}

}
