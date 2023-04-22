package com.example.project.component;

import org.springframework.stereotype.Component;

import com.example.project.service.SignalType;


@Component
public class SignalDefault implements SignalType{

	@Override
	 public void execute(Algo algo) {
		System.out.println("In Strategy Default");
		algo.cancelTrades();
    }

	@Override
	public Integer getSignal() {
		return 0;
	}

}
