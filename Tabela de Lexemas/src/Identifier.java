import java.util.*;

public class Identifier 
{
    static ArrayList<String> lista = new ArrayList<>();


	 private static final Map<String, String> KEYWORDS_AND_CATEGORIES = new HashMap<>();

	    static {
	        // Populando o mapa com palavras-chave e categorias
	        KEYWORDS_AND_CATEGORIES.put("if", "Palavra Reservada");
	        KEYWORDS_AND_CATEGORIES.put("for", "Palavra Reservada");
	        KEYWORDS_AND_CATEGORIES.put("while", "Palavra Reservada");
	        KEYWORDS_AND_CATEGORIES.put("int", "Tipo de dado");
	        KEYWORDS_AND_CATEGORIES.put("long", "Tipo de dado");
	        KEYWORDS_AND_CATEGORIES.put("double", "Tipo de dado");
	        KEYWORDS_AND_CATEGORIES.put("String", "Classe");
	        KEYWORDS_AND_CATEGORIES.put("boolean", "Tipo de dado");
	        KEYWORDS_AND_CATEGORIES.put("public", "Modificador de acesso");
	        KEYWORDS_AND_CATEGORIES.put("private", "Modificador de acesso");
	        KEYWORDS_AND_CATEGORIES.put("protected", "Modificador de acesso");
	        KEYWORDS_AND_CATEGORIES.put("assert", "Palavra Reservada");
	        KEYWORDS_AND_CATEGORIES.put("enum", "Tipo de dado enumerado");
	        KEYWORDS_AND_CATEGORIES.put("extends", "Herança de classe");
	        KEYWORDS_AND_CATEGORIES.put("implements", "Implementação de interface)");
	        KEYWORDS_AND_CATEGORIES.put("import", "Importação de classes");
	        KEYWORDS_AND_CATEGORIES.put("instanceof", "Instância de classe");
	        KEYWORDS_AND_CATEGORIES.put("interface", "Palavra Reservada");
	        KEYWORDS_AND_CATEGORIES.put("new", "Palavra Reservada");
	        KEYWORDS_AND_CATEGORIES.put("package", "Palavra Reservada");
	        KEYWORDS_AND_CATEGORIES.put("super", "Palavra Reservada");
	        KEYWORDS_AND_CATEGORIES.put("class", "Classe");
	        KEYWORDS_AND_CATEGORIES.put("{", "Separador");
	        KEYWORDS_AND_CATEGORIES.put("}", "Separador");
	        KEYWORDS_AND_CATEGORIES.put("(", "Separador");
	        KEYWORDS_AND_CATEGORIES.put(")", "Separador");
	        KEYWORDS_AND_CATEGORIES.put("<", "Separador");
	        KEYWORDS_AND_CATEGORIES.put(">", "Separador");
	        KEYWORDS_AND_CATEGORIES.put(">=", "Separador");
	        KEYWORDS_AND_CATEGORIES.put("<=", "Separador");
	        KEYWORDS_AND_CATEGORIES.put(";", "Separador");
	        KEYWORDS_AND_CATEGORIES.put("''", "Separador");
	        KEYWORDS_AND_CATEGORIES.put(",", "Separador");
	        KEYWORDS_AND_CATEGORIES.put(":", "Separador");
	        KEYWORDS_AND_CATEGORIES.put("+", "Separador");
	        KEYWORDS_AND_CATEGORIES.put("-", "Separador");
	        KEYWORDS_AND_CATEGORIES.put("'", "Separador");
	      //KEYWORDS_AND_CATEGORIES.put(".", "Separador");
	        KEYWORDS_AND_CATEGORIES.put("=", "Separador");
	        KEYWORDS_AND_CATEGORIES.put("[", "Separador");
	        KEYWORDS_AND_CATEGORIES.put("]", "Separador");
	        
	    }

	    public static String getCategory(String keyword) {
	        return KEYWORDS_AND_CATEGORIES.get(keyword);
	    }
	    
	    //método para gerar o ArrayList
	    public static void gerarLista() {
	      //ArrayList para armazenar os separadores e palavras reservadas

	      // Adicionar os separadores à lista
	      lista.add(";");
	      lista.add(",");
	      lista.add(".");
	      lista.add("?");
	      lista.add("!");
	      lista.add(":");
	      lista.add("'");
	      lista.add("\"");
	      lista.add("\\");
	      lista.add("/");
	      lista.add("<");
	      lista.add("<=");
	      lista.add(">=");
	      lista.add(">");
	      lista.add("(");
	      lista.add(")");
	      lista.add("{");
	      lista.add("}");
	      lista.add("[");
	      lista.add("]");

	      // Adicionar as palavras reservadas à lista
	      lista.add("abstract");
	      lista.add("assert");
	      lista.add("boolean");
	      lista.add("break");
	      lista.add("byte");
	      lista.add("case");
	      lista.add("catch");
	      lista.add("char");
	      lista.add("class");
	      lista.add("const");
	      lista.add("continue");
	      lista.add("default");
	      lista.add("do");
	      lista.add("double");
	      lista.add("else");
	      lista.add("enum");
	      lista.add("extends");
	      lista.add("final");
	      lista.add("finally");
	      lista.add("float");
	      lista.add("for");
	      lista.add("if");
	      lista.add("implements");
	      lista.add("import");
	      lista.add("instanceof");
	      lista.add("int");
	      lista.add("interface");
	      lista.add("long");
	      lista.add("native");
	      lista.add("new");
	      lista.add("null");
	      lista.add("package");
	      lista.add("private");
	      lista.add("protected");
	      lista.add("public");
	      lista.add("return");
	      lista.add("short");
	      lista.add("static");
	      lista.add("strictfp");
	      lista.add("super");
	      lista.add("switch");
	      lista.add("synchronized");
	      lista.add("this");
	      lista.add("throw");
	      lista.add("throws");
	      lista.add("transient");
	      lista.add("try");
	      lista.add("void");
	      lista.add("volatile");
	      lista.add("while");
	    }
	    public static boolean isID(String c)
	    {
	    	if(lista.contains(c))
	    	{
	    		return true;
	    	}
	    	else
	    	{
	    		return false;
	    	}
	    }
}
