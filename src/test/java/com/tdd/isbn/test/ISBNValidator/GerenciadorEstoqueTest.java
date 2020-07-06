package com.tdd.isbn.test.ISBNValidator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tdd.isbn.ISBNValidator.ExternalISBNDataService;
import com.tdd.isbn.ISBNValidator.GerenciadorEstoque;
import com.tdd.isbn.ISBNValidator.Livro;

public class GerenciadorEstoqueTest {

	@Test
	public void pegaOLocalizadorCodigoCorreto() {
		
		ExternalISBNDataService testService = new ExternalISBNDataService() {
			
			public Livro lookup(String isbn) {
				return new Livro(isbn, "Of Mice And Men", "J. Steinbeck");
			}
		};
		GerenciadorEstoque gerenciadorEstoque = new GerenciadorEstoque();
		gerenciadorEstoque.setService(testService);
		
		String isbn = "0140177396";
		String localizador = gerenciadorEstoque.getLocalizadorCodigo(isbn);
		assertEquals("7396J4", localizador);
	}

	

}
