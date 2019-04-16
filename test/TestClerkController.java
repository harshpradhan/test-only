package com.cognizant.pts.test;

import static org.junit.Assert.*;
 
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; 
 

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.pts.controller.AdminController;
import com.cognizant.pts.controller.ClerkController;
import com.cognizant.pts.exception.AddClerkParamException;
import com.cognizant.pts.model.ClerkModel;
import com.cognizant.pts.service.AdminService;
import com.cognizant.pts.service.AdminServiceImpl;
import com.cognizant.pts.service.ClerkService;
import com.cognizant.pts.service.ClerkServiceImpl;
import com.cognizant.pts.validator.AdminRegValidator;
import com.cognizant.pts.validator.ClerkValidator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/config/applicationContext.xml")
public class TestClerkController {

     private MockMvc mockMvc;
     
	
     
     
     @Autowired
     @Spy
 	private ClerkValidator clerkValidator;
     
 	@Autowired
 	private ClerkService clerkService;
     
     @InjectMocks
     private ClerkController clerkController;
	
     public void init()
     {
    	 MockitoAnnotations.initMocks(this);
    	 mockMvc= MockMvcBuilders.standaloneSetup(clerkController).build();
     }


	@Test
	public void testClerkController_positive() 
	{
		try{
			ClerkModel clerkModel= new ClerkModel(); 
			clerkModel.setClerkId("CLERK11");
			clerkModel.setFirstName("Cersie");
			clerkModel.setLastName("Lanister");
			clerkModel.setAge(45);
			clerkModel.setGender("Male");
			clerkModel.setDob("12/12/1235");
			clerkModel.setContactNumber("92432440000");
			clerkModel.setAlternateContactNumber("32442442");
			clerkModel.setEmailId("dfg@gmail.com");
			clerkModel.setAddressLine1("King's landing");
			clerkModel.setAddressLine2("uihui");
			clerkModel.setCity("juhju");
			clerkModel.setState("ubui");
			clerkModel.setZipCode(123456);
			Errors errors = new BeanPropertyBindingResult("90", "pts.wrongInfo");
			ModelAndView mv= clerkController.viewClerks();
			String actual= mv.getViewName();
			String expected= "viewclerks";
			assertEquals(actual, expected);
	}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	
	/*@Test
	public void testClerkController_negative()
	{
		try{
			Errors errors= null;
			ModelAndView mv= clerkController.addClerk(clerkModel, errors);
			assertTrue(false);
		}
		catch(Exception e)
		{
			assertTrue(true);
			assertEqualsIs("Parameters are null", new AddClerkParamException ("Parameters are null").getMessage());
		}
}*/
}
