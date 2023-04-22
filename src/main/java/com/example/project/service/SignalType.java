package com.example.project.service;

import com.example.project.component.Algo;


public interface SignalType {
	Integer getSignal();
	void execute(Algo algo);
}
