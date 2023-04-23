package com.example.project.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.project.service.SignalService;



@SpringBootTest
@AutoConfigureMockMvc
public class SingleHandlerControllerTest {

	@InjectMocks
	private SignalHandlerController signalHandlerController;

	@Autowired
	private MockMvc mockmvc;
	
	@MockBean 
	private SignalService signalService;
	
	@Test
	public void handleSignalAPI() throws Exception {
		mockmvc.perform(MockMvcRequestBuilders.post("/signals").content("1")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(MockMvcResultMatchers.status().isOk())
	            .andExpect(MockMvcResultMatchers.content().string("Dummy rest call"))
	            .andDo(MockMvcResultHandlers.print());
		
		verify(signalService, times(1)).handleSignal(1);
	}
}
