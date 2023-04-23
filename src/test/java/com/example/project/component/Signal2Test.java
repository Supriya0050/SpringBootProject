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
public class Signal2Test {

	@Mock
	private Algo algo;
	
	@InjectMocks
	private Signal2 signal2;
	
	@Test
	public void testExecutre() {
		
		// Act
		signal2.execute(algo);
		 //Assert
		 verify(algo).reverse();
		 verify(algo).submitToMarket();
		 verify(algo).setAlgoParam(1, 80);
		 
		 assertEquals(2, signal2.getSignal());
	}
}
