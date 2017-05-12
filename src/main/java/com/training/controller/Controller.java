package com.training.controller;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.training.controller.localization.ResourceManager;
import com.training.controller.services.search.QuerryBuilder;
import com.training.controller.services.search.SearchParameter;
import com.training.controller.services.search.TariffSearchEngine;
import com.training.controller.services.sort.SortUtils;
import com.training.model.Model;
import com.training.model.tariff.ServiceType;
import com.training.model.tariff.Tariff;
import com.training.view.View;

public class Controller {

	private View view;
	private Model model;

	public Controller(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	public void run() {
		view.print(View.REQUEST_INPUT_LANGUAGE);
		int option = readNumber();
		switch (option) {
		case 0:
			ResourceManager.INSTANCE.changeResource(Locale.ENGLISH);
			break;
		case 1:
			ResourceManager.INSTANCE.changeResource(new Locale("ua_UA"));
		}
		System.out.println();
		mainMenu();

	}

	private void mainMenu() {
		view.print(View.MENU_OPTION_LIST);
		int option = readNumber(3);
		switch (option) {
		case 0:
			view.print(model.getTariffs());
			break;
		case 1:
			view.print(String.valueOf(model.getUsersQuantity()));
			break;
		case 2:
			view.print(sort(model.getTariffs()));
			break;
		case 3:
			view.print(find(model.getTariffs()));
			break;
		}
	}

	private List<Tariff> find(List<Tariff> list) {
		TariffSearchEngine search = new TariffSearchEngine();
		QuerryBuilder builder = search.getQuerryBuilder();
		int option;
		do {
			view.print(View.SEARCH_SERVICE_REQUEST);
			for (ServiceType type : ServiceType.values()) {
				view.print(type.ordinal() + " " + type.name());
			}
			option = readNumber(ServiceType.values().length);
			ServiceType type = ServiceType.values()[option];
			view.print(View.SEARCH_PARAMETER_REQUEST);
			for (SearchParameter parameter : SearchParameter.values()) {
				view.print(parameter.ordinal() + " " + parameter.name());
			}
			option = readNumber(SearchParameter.values().length);
			SearchParameter parameter = SearchParameter.values()[option];

			view.print(View.SEARCH_LOW_BOUNDARY_REQUEST);
			int leftBorder = readNumber();
			view.print(View.SEARCH_HIGH_BOUNDARY_REQUEST);
			int rightBorder = readNumber();
			builder.addOperrator(type, parameter, leftBorder, rightBorder);
			view.print(View.SEARCH_CONFORMATION_REQUEST);
			option = readNumber(1);
		} while (option != 1);
		search.setQuerry(builder.build());
		return search.execute(list);
	}

	private List<Tariff> sort(List<Tariff> tariffs) {
		SortUtils sort = new SortUtils();
		return sort.sortTariffs(tariffs, sort.getByFeeComparator());
	}

	private int readNumber() {
		Scanner sc = new Scanner(System.in);
		while (!sc.hasNextInt()) {
			view.print(View.WRONG_UNMERIC_INPUT);
			sc.next();
		}
		return sc.nextInt();
	}

	private int readNumber(int border) {
		Scanner sc = new Scanner(System.in);
		int i = 0;
		do {
			if (i != 0) {
				view.print(View.WRONG_UNMERIC_INPUT_OUT_OF_BORDER);
			}
			while (!sc.hasNextInt()) {
				view.print(View.WRONG_UNMERIC_INPUT);
				sc.next();
			}
			i = sc.nextInt();
		} while (i > border);
		return i;
	}

}
