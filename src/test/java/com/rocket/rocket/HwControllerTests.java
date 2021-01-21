package com.rocket.rocket;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.rocket.rocket.configuration.DatabaseConfiguration;
import com.rocket.rocket.configuration.SecurityConfig;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@WebAppConfiguration
@ContextConfiguration(classes = { SecurityApplication.class, DatabaseConfiguration.class, SecurityConfig.class })
@Slf4j
class HwControllerTests {

	@Setter(onMethod_ = @Autowired) 
	private WebApplicationContext ctx;

	private MockMvc mockMvc;

	@Test
	void testRead() throws Exception {
		log.info(null, mockMvc.perform(MockMvcRequestBuilders.get("/hw/read").param("hw_num", "hw_1")).andReturn()
				.getModelAndView().getModelMap());
	}

}
