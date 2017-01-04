package com.barath.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;



@RunWith(SpringRunner.class)
@WebMvcTest(controllers=TestController.class)
public class SpringTestWebappApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	

	@Test
	public void testMessage() throws Exception {
		
		mockMvc.perform(get("/getMess").accept(MediaType.APPLICATION_JSON_UTF8))
			.andDo(print())
			.andExpect(new ResultMatcher() {				
				@Override
				public void match(MvcResult result) throws Exception {				
					Assert.assertEquals("hello test",result.getResponse().getContentAsString());
				}
			});
		
	}
	
	@Test
	public void testuser() throws Exception {
		
		mockMvc.perform(get("/getUser/{id}",1000).accept(MediaType.APPLICATION_JSON_UTF8))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("userName").value("Barath"));
		
	}
	
	

}
