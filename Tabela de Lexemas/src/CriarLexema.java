
public class CriarLexema
{
	private String token, classi;
	private int linha;
	
	public CriarLexema (String t, String cl, int li)
	{
		this.token=t;
		this.classi=cl;
		this.linha=li;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getClassi() {
		return classi;
	}

	public void setClassi(String classi) {
		this.classi = classi;
	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	@Override
	public String toString() {
		return token + "  |  " + classi + "  |  " + linha + "  |  ";
	}
	 
	
}
