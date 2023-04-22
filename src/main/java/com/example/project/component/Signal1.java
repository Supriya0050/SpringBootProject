package com.example.project.component;

import org.springframework.stereotype.Component;

import com.example.project.service.SignalType;



@Component
public class Signal1 implements SignalType{

	
	@Override
	 public void execute(Algo algo) {
		System.out.println("In Strategy One");
        algo.setUp();
        algo.setAlgoParam(1, 60);
        algo.performCalc();
        algo.submitToMarket();
    }

	@Override
	public Integer getSignal() {
		return 1;
	}

	

}
