package edu.bicheva.OnlineShop.validate;

import java.util.regex.Pattern;

public class Vaidator {

	public static boolean validateIsInteger(String param) {
		Pattern pattern = Pattern.compile("^[-+]?\\d+");
		boolean result = false;
		if (validateIsNotNullOrNotEmpty(param)) {
			result = pattern.matcher(param).matches();
		}
		return result;
	}

	public static boolean validateIsDecimal(String param) {
		Pattern pattern = Pattern
				.compile("[-+]?(((\\d+(\\.)?((\\d+)?)([eE][+-]?(\\d+))?)|(\\.(\\d+)([eE][+-]?(\\d+))?))[fFdD]?)");
		boolean result = false;
		if (validateIsNotNullOrNotEmpty(param)) {
			result = pattern.matcher(param).matches();
		}
		return result;
	}

	public static boolean validateIsNotNullOrNotEmpty(String param) {
		return !(param == null || param.isEmpty());
	}

	public static void main(String[] args) {
		String decimal = "-.332749287";
		System.out.println(validateIsDecimal(decimal));
	}
}
