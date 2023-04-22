package com.example.project.component;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SignalDefaultTest {

	@Mock
	private Algo algo;
	
	@InjectMocks
	private SignalDefault signalDefault;
	
	@Test
	public void testExecutre() {
		
		// Act
		 signalDefault.execute(algo);
		 //Assert
		 verify(algo, times(1)).cancelTrades();
		 
		 assertEquals(0, signalDefault.getSignal());
	}
}
