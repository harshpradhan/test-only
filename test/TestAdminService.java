package com.cognizant.pts.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cognizant.pts.dao.AdminDAO;
import com.cognizant.pts.model.AdminModel;
import com.cognizant.pts.service.AdminServiceImpl;

public class TestAdminService {

	private MockMvc mockMvc;
	private AdminModel adminModel; 
	
	@Mock
	private AdminDAO adminDAO;
	
	@InjectMocks
	private AdminServiceImpl adminServiceImpl;
	
	
	@Before
	public void setUp() throws Exception {
	
		MockitoAnnotations.initMocks(this);
		mockMvc= MockMvcBuilders.standaloneSetup(adminServiceImpl).build();
		adminModel= new AdminModel();
	
	}

	@After
	public void tearDown() throws Exception {
	}

	/*@Test
	public void testResigterAdmin_positive() {
		
		adminModel.setFirstName("Prateek");
		adminModel.setLastName("Kasera");
		adminModel.setAge(22);
		adminModel.setGender("Male");
		adminModel.setDob("30/12/1996");	
		adminModel.setContactNumber("9161480998");
		adminModel.setAlternateContactNumber("9889973880");
		adminModel.setEmailId("abc@gmail.com");
		adminModel.setAdminPassword("prateek");
		
		try{
			String adminId = adminServiceImpl.addAdmin(adminModel);
			if(adminId!=null)
			{
			boolean actual= true;
			}
			else
			{
			boolean	expected=false;
			}

			assertEquals(expected,actual);
			
		}
		
		catch(Exception e)
		{
		fail("Not yet implemented");
	}
	}*/
	
	@Test
	public void testCheckAdminLogin_positive()
	{
		adminModel.setAdminId("A01");
		adminModel.setAdminPassword("prateek");
		try{
			
			int actual= adminServiceImpl.doLogin(adminModel);
			int expected= 0;
			assertEquals(expected,actual);
			
		}
		catch(Exception e)
		{
			fail("doesn't exist");
		}
	}
	
	
	/*@Test
	public void testCheckAdminLogin_negative()
	
		boolean actual =adminServiceImpl.doLogin(adminModel);
		try{
			actual=true;
			assertFalse(actual);
		}
		catch(Exception e)
		{
			assertFalse(actual);
			fail("ffd");
		}
	}*/
}
