package br.ufjf.testerds.utils.messages;

public class CodeClassMessage {
	
	public static String getSimpleClassCode(String className) {
		return "public class " + className + " {\n" + 
				"	\n" + 
				"	// Create a method here\n" + 
				"	\n" + 
				"}";
	}
	
	public static String getClassCodeWithMain(String className) {
		return "public class " + className + " {\n" + 
				"	public static void main(String[] args) {\n" + 
				"		\n" + 
				"		// Create a method here\n" + 
				"	}\n" + 
				"}";
	}
	
	public static String getInitializeTree() {
		return "public class Main {\n" + 
				"		\n" + 
				"	public void instantiateTree() {\n" + 
				"		// Create a method here\n" + 
				"	}\n" +
				"		\n" + 
				"	public static void main(String[] args) {\n" + 
				"		\n" + 
				"		instantiateTree()\n" + 
				"	}\n" + 
				"}";
	}
	
	public static String getInsertNode(String side) {
		return "public class Node {\n" + 
				"	\n" + 
				"	insert" + side + "Child(){\n" + 
				"	// Create a method here\n" + 
				"	}\n" + 
				"	\n" + 
				"}"; 
	}
}
