import java.io.*;
import java.util.*;
public class Classe extends CriarLexema
{
	byte nPar;
	int nivel;

	public Classe(String t, String cl, int li,byte nPar,int nivel) 
	{
		super(t, cl, li);
		this.nivel=nivel;
		this.nPar=nPar;
	}

	public byte getnPar() {
		return nPar;
	}

	public int getNivel() {
		return nivel;
	}
	
}
