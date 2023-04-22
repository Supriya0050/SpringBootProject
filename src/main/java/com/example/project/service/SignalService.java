package com.example.project.service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.project.component.Algo;
import com.example.project.component.SignalDefault;

@Service
public class SignalService implements SignalHandler {
	private final Map<Integer, SignalType> strategies;

	public String result;

	private final SignalType signalDefault;

	public SignalService(List<SignalType> strategiesList, SignalDefault defaultSignal) {
		strategies = strategiesList.stream().collect(Collectors.toMap(SignalType::getSignal, Function.identity()));
		signalDefault = defaultSignal;
	}

	@Override
	public void handleSignal(int signal) {
		Algo algo = new Algo();
		SignalType strategy = strategies.getOrDefault(signal, signalDefault);
		strategy.execute(algo);
		algo.doAlgo();

	}

}
