package com.training.model.utils;

import com.training.model.Account;

public class AccountUtils {
	public TariffUtils builder = new TariffUtils();
	public NumberGenerator generator = new NumberGenerator();

	public Account createRandomAccount() {
		Account acc = new Account();
		acc.setNumber(generator.generate());
		acc.setTariff(builder.createRandomTariff());
		return acc;
	}
}