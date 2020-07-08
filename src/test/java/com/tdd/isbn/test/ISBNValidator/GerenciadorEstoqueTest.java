package com.tdd.isbn.test.ISBNValidator;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;

import com.tdd.isbn.ISBNValidator.ExternalISBNDataService;
import com.tdd.isbn.ISBNValidator.GerenciadorEstoque;
import com.tdd.isbn.ISBNValidator.Livro;

public class GerenciadorEstoqueTest {

	@Test
	public void pegaOLocalizadorCodigoCorreto() {
		
		ExternalISBNDataService testWebService = new ExternalISBNDataService() {
			
			public Livro lookup(String isbn) {
				return new Livro(isbn, "Of Mice And Men", "J. Steinbeck");
			}
		};
		
		ExternalISBNDataService testDataBaseService = new ExternalISBNDataService() {
			
			public Livro lookup(String isbn) {
				return null;
			}
		};
		
		GerenciadorEstoque gerenciadorEstoque = new GerenciadorEstoque();
		gerenciadorEstoque.setWebService(testWebService);
		gerenciadorEstoque.setDatabaseService(testDataBaseService);
		
		String isbn = "0140177396";
		String localizador = gerenciadorEstoque.getLocalizadorCodigo(isbn);
		assertEquals("7396J4", localizador);
	}
	
	@Test
	public void databaseEhUsadoSeHouverDados() {
		ExternalISBNDataService databaseService = mock(ExternalISBNDataService.class);
		ExternalISBNDataService webService = mock(ExternalISBNDataService.class);
		
		when(databaseService.lookup("0140177396")).thenReturn(new Livro("0140177396", "abc", "abc"));
		
		GerenciadorEstoque gerenciadorEstoque = new GerenciadorEstoque();
		gerenciadorEstoque.setWebService(webService);
		gerenciadorEstoque.setDatabaseService(databaseService);
		
		String isbn = "0140177396";
		String localizador = gerenciadorEstoque.getLocalizadorCodigo(isbn);
		
		verify(databaseService, times(1)).lookup("0140177396");
		verify(webService, times(0)).lookup(anyString());
	}

	@Test
	public void webServiceEhUsadoSeNaoHouverDados() {
		ExternalISBNDataService databaseService = mock(ExternalISBNDataService.class);
		ExternalISBNDataService webService = mock(ExternalISBNDataService.class);
		
		when(databaseService.lookup("0140177396")).thenReturn(null);
		when(webService.lookup("0140177396")).thenReturn(new Livro("0140177396", "abc", "abc"));
		
		GerenciadorEstoque gerenciadorEstoque = new GerenciadorEstoque();
		gerenciadorEstoque.setWebService(webService);
		gerenciadorEstoque.setDatabaseService(databaseService);
		
		String isbn = "0140177396";
		String localizador = gerenciadorEstoque.getLocalizadorCodigo(isbn);
		
		verify(databaseService, times(1)).lookup("0140177396");
		verify(webService, times(1)).lookup("0140177396");
	}
	

}
