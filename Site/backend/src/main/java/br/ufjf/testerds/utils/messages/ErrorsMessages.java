package br.ufjf.testerds.utils.messages;

public class ErrorsMessages {
	
	public static String getObjectNotFoundMessage(String className) {
		return "Objetos não encontrados! Tipo: " + className;
	}
	
	public static String getObjectNotFoundMessage(Integer id, String className) {
		return "Objeto não encontrado! Id: " + id + ", Tipo: " + className;
	}
	
	public static String getObjectNotFoundMessage(String email, String className) {
		return "Objeto não encontrado! eMail: " + email + ", Tipo: " + className;
	}

}
