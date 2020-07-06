package com.tdd.isbn.ISBNValidator;

public class ValidadorISBN {

	public boolean checkISBN(String isbn) {

		if (isbn.length() != 10)
			throw new NumberFormatException("Numero ISBN devem term 10 caracteres");

		int total = 0;
		for (int i = 0; i < 10; i++) {

			if (!Character.isDigit(isbn.charAt(i)))
				if (i == 9 && isbn.charAt(i) == 'X') {
					total += 10;
				} else {

					throw new NumberFormatException("ISBN só pode conter caracteres numéricos");
				}
			else {

				total += Character.getNumericValue(isbn.charAt(i)) * (10 - i);
			}
		}

		if (total % 11 == 0) {
			return true;
		} else {
			return false;
		}
	}
}
