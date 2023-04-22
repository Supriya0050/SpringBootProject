package com.example.project.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.project.component.Algo;
import com.example.project.component.SignalDefault;

@SpringBootTest
public class SignalServiceTest {
	
    @Mock
    private SignalType signal1;

    @Mock
    private SignalType signal2;
    
    @Mock
    private SignalDefault signalDefault;

    private List<SignalType> strategiesList;

    private SignalService signalService;
    
    @BeforeEach
    public void setUp() {
       
        when(signal1.getSignal()).thenReturn(1);
        when(signal2.getSignal()).thenReturn(2);
        when(signalDefault.getSignal()).thenReturn(0);
        strategiesList = new ArrayList<>(Arrays.asList(signal1, signal2, signalDefault));
        signalService = new SignalService(strategiesList, signalDefault);
    }
    
    @Test
    public void test_should_execute_signal_1() {
        signalService.handleSignal(1);
        verify(signal1, times(1)).execute(any(Algo.class));
        verify(signal2, times(0)).execute(any(Algo.class));
        verify(signalDefault, times(0)).execute(any(Algo.class));
    }
    
    @Test
    public void test_should_execute_signal_2() {
        signalService.handleSignal(2);
        verify(signal2, times(1)).execute(any(Algo.class));
        verify(signal1, times(0)).execute(any(Algo.class));
        verify(signalDefault, times(0)).execute(any(Algo.class));
    }
    

    @Test
    public void test_should_execute_defualt_signal() {
        signalService.handleSignal(0);
        verify(signalDefault, times(1)).execute(any(Algo.class));
        verify(signal2, times(0)).execute(any(Algo.class));
        verify(signal1, times(0)).execute(any(Algo.class));
    }
    
    @Test
    public void test_should_execute_signal_unknown() {
        signalService.handleSignal(100);
        verify(signal2, times(0)).execute(any(Algo.class));
        verify(signal1, times(0)).execute(any(Algo.class));
        verify(signalDefault, times(1)).execute(any(Algo.class));
    }

    

}
