package com.cognizant.pts.test;

import static org.junit.Assert.*;

import javax.servlet.http.HttpSession;

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
import com.cognizant.pts.model.AdminModel;
import com.cognizant.pts.model.ClerkModel;
import com.cognizant.pts.service.AdminService;
import com.cognizant.pts.service.AdminServiceImpl;
import com.cognizant.pts.service.ClerkService;
import com.cognizant.pts.validator.AdminRegValidator;
import com.cognizant.pts.validator.ClerkValidator;
import com.cognizant.pts.validator.LoginValidator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/config/applicationContext.xml")
public class TestAdminController {

     private MockMvc mockMvc;
    
    @Autowired
    @Spy
    private AdminServiceImpl adminService;
     
    @Autowired
    @Spy
	private AdminRegValidator adminRegValidator; 
    
     @Autowired
	 @Spy
	 private LoginValidator loginValidator; 
     
     @InjectMocks
     private AdminController adminController;
	
     public void init()
     {
    	 MockitoAnnotations.initMocks(this);
    	 mockMvc= MockMvcBuilders.standaloneSetup(adminController).build();
     }
     
     
	/*@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(clerkController).build();
	}

	@After
	public void tearDown() throws Exception {
	}*/

	@Test
	public void testAdminController_positive() 
	{
		try{
		
			AdminModel adminModel= new AdminModel(); 
			adminModel.setAdminId("A01");
			adminModel.setAdminPassword("prateek");
			Errors errors = new BeanPropertyBindingResult("3", "admin.password.required");
			ModelAndView mv= adminController.doLogin(adminModel, errors);
			String actual= mv.getViewName();
			String expected= "home";
			assertEquals(expected,actual);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	@Test
	public void testAdminLogin_negative()
	{
		AdminModel adminModel= new AdminModel();
		try{
			//HttpSession session= null;
			Errors errors= new BeanPropertyBindingResult(adminModel,"adminModel");
			ModelAndView mv= adminController.doLogin(adminModel, errors);
			assertTrue(true);
		}
		catch(Exception e)
		{
			assertTrue(false);
           fail("admin Login Negative ");
		}
}
}
