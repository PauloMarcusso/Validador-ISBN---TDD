package com.tdd.isbn.ISBNValidator;

public class GerenciadorEstoque{

	private ExternalISBNDataService service;
	
	public void setService(ExternalISBNDataService service) {
		this.service = service;
	}

	public String getLocalizadorCodigo(String isbn) {
		Livro livro = service.lookup(isbn);
		StringBuilder localizador = new StringBuilder();
		localizador.append(isbn.substring(isbn.length()-4)); //pega os ultimos 4 numeros
		localizador.append(livro.getAutor().substring(0, 1));//pega a primeira letra do nome do autor
		localizador.append(livro.getTitulo().split(" ").length);//
		return localizador.toString();
	}
}
