package org.contaazul.discovery.explorer.api.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.contaazul.discovery.explorer.api.controller.MarsController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@RunWith(SpringRunner.class)
public class MarsControllerTest {

	private MockMvc mockMvc;
		
	@Before
	public void setup() {
		mockMvc = standaloneSetup(new  MarsController()).build();
	}
	
	@Test
	public void testValidRobotCommunication() throws Exception {
		mockMvc.perform(post("/rest/mars/MMRMMRMM"))
			.andExpect(status().isOk());
	}
	
	@Test
	public void testValidRobotCommunicationAndGettingLocation() throws Exception {
		MvcResult result = mockMvc.perform(post("/rest/mars/MMRMMRMM"))
							.andExpect(status().isOk())
							.andReturn();
		Assert.assertEquals("(2, 0, S)", result.getResponse().getContentAsString());
	}
	
	@Test
	public void testInvalidRobotCommunication() throws Exception {
		mockMvc.perform(post("/rest/mars/AAA"))
			.andExpect(status().is4xxClientError());
	}
	
	
}
