package com.tdd.isbn.test.ISBNValidator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.tdd.isbn.ISBNValidator.ValidadorISBN;

public class ValidadorISBNTest {

	@Test
	public void checkValido10NumerosISBN() {
		ValidadorISBN validador = new ValidadorISBN();
		boolean result = validador.checkISBN("0140449116");
		assertTrue(result);
	}

	@Test
	public void checkValidoISBNCom13Numeros() {
		ValidadorISBN validador = new ValidadorISBN();
		validador.checkISBN("9788550800653");

	}

	@Test
	public void DezNumerosValidosTerminadosComX() {
		ValidadorISBN validador = new ValidadorISBN();
		boolean result = validador.checkISBN("012000030X");
		assertTrue(result);
	}

	@Test
	public void DezNumerosCheckInvalidoISBN() {
		ValidadorISBN validador = new ValidadorISBN();
		boolean result = validador.checkISBN("0140449117");
		assertFalse(result);
	}
	
	@Test
	public void TrezeNumerosCheckInvalidoISBN() {
		ValidadorISBN validador = new ValidadorISBN();
		boolean result = validador.checkISBN("9788550800652");
		assertFalse(result);
	}

	@Test(expected = NumberFormatException.class)
	public void naoSaoPermitidosNoveDigitos() {
		ValidadorISBN validador = new ValidadorISBN();
		boolean result = validador.checkISBN("014044911");
	}

	@Test(expected = NumberFormatException.class)
	public void naoDeveAceitarCaracteresNaoNumericos() {
		ValidadorISBN validador = new ValidadorISBN();
		validador.checkISBN("helloworld");
	}
}
