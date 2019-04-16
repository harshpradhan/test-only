package com.cognizant.pts.test;

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

import com.cognizant.pts.controller.MedicineController;
import com.cognizant.pts.controller.PrescriptionController;
import com.cognizant.pts.model.PrescriptionModel;
import com.cognizant.pts.service.MedicineService;
import com.cognizant.pts.service.PrescriptionService;
import com.cognizant.pts.validator.MedicineValidator;
import com.cognizant.pts.validator.PrescriptionValidator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/config/applicationContext.xml")
public class TestPrescriptionController
{
private MockMvc mockMvc;
	
	@Autowired
	@Spy
	private PrescriptionValidator prescriptionValidator;
	
	@Autowired
	private MedicineService medicineService;
	
	@Autowired
	private PrescriptionService prescriptionService;
	
	@InjectMocks
	private PrescriptionController prescriptionController;
	
	public void init()
	{
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(prescriptionController).build();
	}
	
	@Test
	public void testPrescriptionController_positive()
	{
		try
		{
			PrescriptionModel prescriptionModel = new PrescritionModel();
			prescriptionModel.set
		}
	}
}