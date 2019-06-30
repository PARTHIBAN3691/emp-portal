package com.sg.portal.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.sg.portal.model.Employee;
import com.sg.portal.service.EmployeeService;
import com.sg.portal.validator.Validator;

@RunWith(SpringRunner.class)
@WebMvcTest(value=EmployeeController.class)
public class EmployeeControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EmployeeService employeeService;


	
	private String baseURL = "/portal/employee";
	
	@Test
	public void getEmployeeList(){
		
		MvcResult mockResult = null;
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(this.baseURL+"/list").accept(MediaType.APPLICATION_JSON).contextPath("/portal");
		
		try {
			mockResult = mockMvc.perform(requestBuilder).andReturn();
		} catch (Exception e) {
			e.printStackTrace();
			fail("Unknown error occurred");
		}
		assertNotNull(mockResult);
		assertNotNull(mockResult.getResponse());
	}
	
	@Test
	public void createEmployee() {
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(this.baseURL+"/create").contentType(MediaType.APPLICATION_JSON).content(getEmployeeJSONString()).accept(MediaType.APPLICATION_JSON).contextPath("/portal");				
		try {
			mockMvc.perform(requestBuilder).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Unknown error occurred");
		}
		
	}

	private String getEmployeeJSONString()  {
		Employee emp = new Employee();
		emp.setFirstName("TFirst1");
		emp.setLastName("TLast1");		
		emp.setDob(new Date(1220227200));
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);

		try {
			return mapper.writeValueAsString(emp);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
