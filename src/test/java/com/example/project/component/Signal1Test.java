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
public class Signal1Test {

	@Mock
	private Algo algo;
	
	@InjectMocks
	private Signal1 signal1;
	
	 @Test
	  public void testExecute() {
		// Act
		 signal1.execute(algo);
		 //Assert
		 verify(algo, times(1)).setUp();
		 verify(algo).performCalc();
		 verify(algo).submitToMarket();
		 verify(algo).setAlgoParam(1, 60);
		 
		 assertEquals(1, signal1.getSignal());
	 }
}
