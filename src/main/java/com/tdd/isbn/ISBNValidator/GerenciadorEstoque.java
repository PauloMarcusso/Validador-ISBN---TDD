package com.tdd.isbn.ISBNValidator;

public class GerenciadorEstoque{

	private ExternalISBNDataService webService;
	private ExternalISBNDataService databaseService;

	public String getLocalizadorCodigo(String isbn) {
		Livro livro = databaseService.lookup(isbn);
		if(livro == null) {
			livro = webService.lookup(isbn);
		}
		StringBuilder localizador = new StringBuilder();
		localizador.append(isbn.substring(isbn.length()-4)); //pega os ultimos 4 numeros
		localizador.append(livro.getAutor().substring(0, 1));//pega a primeira letra do nome do autor
		localizador.append(livro.getTitulo().split(" ").length);//
		return localizador.toString();
	}

	public void setWebService(ExternalISBNDataService service) {
		this.webService = service;
	}

	public void setDatabaseService(ExternalISBNDataService databaseService) {
		this.databaseService = databaseService;
	}
	
	
}
