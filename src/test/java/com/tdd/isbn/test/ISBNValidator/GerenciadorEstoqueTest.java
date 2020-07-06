package com.tdd.isbn.test.ISBNValidator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tdd.isbn.ISBNValidator.GerenciadorEstoque;

public class GerenciadorEstoqueTest {

	@Test
	public void pegaOLocalizadorCodigoCorreto() {

		String isbn = "0140177396";
		GerenciadorEstoque gerenciadorEstoque = new GerenciadorEstoque();
		String localizador = gerenciadorEstoque(isbn);
		assertEquals("7396J4", localizador);
	}

}
