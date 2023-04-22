package com.example.project.component;

import org.springframework.stereotype.Component;

import com.example.project.service.SignalType;


@Component
public class Signal2 implements SignalType{

	
	@Override
	 public void execute(Algo algo) {
		System.out.println("In Strategy Two");
		algo.reverse();
        algo.setAlgoParam(1,80);
        algo.submitToMarket();
    }

	@Override
	public Integer getSignal() {
		return 2;
	}

}
