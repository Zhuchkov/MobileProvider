package com.training.model.utils;

import java.util.HashSet;
import java.util.Set;

 class NumberGenerator {
	private Set<String> previousNumbers = new HashSet<>();
	private static final int DIGIT_QUANTITY = 7;

	public String generate() {
		StringBuilder number;
		do {
			number = new StringBuilder();

			for (int i = 0; i < DIGIT_QUANTITY; i++) {
				number.append((int)(Math.random()*10));
			}
		} while (!previousNumbers.add(number.toString()));
		return number.toString();
	}

	

}
