import java.io.*;
import java.util.*;
import java.lang.reflect.Modifier;
import javax.lang.model.SourceVersion;
public class Lexema
{
	int contL = 1;
	Vector vec=new Vector(), simb=new Vector();
	Identifier id;
	public void lerDoFile()
	{
		String umaLinha, token,classi; int linha;
		StringTokenizer umaCadeia;
		boolean comentado=false;
		try
		{
			FileReader fl=new FileReader("File.txt");
			BufferedReader br=new BufferedReader(fl);
			umaLinha=br.readLine();
			
			
			while(umaLinha!=null)
			{
				umaCadeia=new StringTokenizer(umaLinha," ");
				String disposable;
				boolean entrou=false;
				
				while(umaCadeia.hasMoreTokens())
				{
					
					disposable=umaCadeia.nextToken();
					String a=disposable.replaceAll("[\\s\\t]+", "");
					//System.out.println(a);
					disposable=a;
					/*while(disposable.equals(" "))
					{
						disposable = umaCadeia.nextToken();
					}*/
					if(disposable.startsWith("//"))
					{
						//disposable=umaCadeia.nextToken();
						while(umaCadeia.hasMoreTokens())
						{
							disposable=umaCadeia.nextToken();
						}
					}
					else
					{
						if(disposable.startsWith("/*") && comentado == false)
						{
							comentado = true;
						}
						if(comentado == true)
						{
							if(!disposable.contains("*/"))
							{
								
								while((umaCadeia.hasMoreTokens()) && (!disposable.contains("*/")))
								{
									disposable = umaCadeia.nextToken();
									if(disposable.contains("*/"))
									{
										comentado=false;
										// nao chega System.out.println(comentado);
									}
									
								}
								if(disposable.contains("*/"))
								{
									comentado=false;
									if(umaCadeia.hasMoreElements())
									{
										disposable=umaCadeia.nextToken();
									}
									
									//System.out.println(comentado);
								}
								
							}
							if(disposable.startsWith("*/"))
							{
								comentado=false;
							}
						}
						else
						{
							if(disposable.isBlank())
							{
							}
							else
							{
								
								if(disposable.contains("("))
								{
								}
								else
								{
								}
								
								token=disposable;
								classi=classif(token);								
								linha=contL;
								int r=0;
								
								//percorrer cada string
								for(int j=0;j<token.length();j++)
								{
									String bf;
									String st = token.charAt(j)+"";
									if(!classif(st).equals("epa"))
									{
										entrou =true;
										bf = token.substring(r, j);
										
										if(j!=0 && !bf.equals(""))
										{
											CriarLexema l = new CriarLexema(bf,classif(bf),linha);
											vec.add(l);
										}
											CriarLexema l2 = new CriarLexema(st,classif(st),linha);
											vec.add(l2);
										
										r=j+1;
									}
									else
									{
										
									}
								}
								if(entrou==false)
								{
									CriarLexema l = new CriarLexema(token, classi, linha);
									vec.add(l);
									vec.trimToSize();
									entrou=false;
								}
								
							}
						
						}
					}
				}
				
				
				
				vec.trimToSize();
				contL ++;
				umaLinha=br.readLine();
			}
			br.close();
			System.out.println("Ficheiro lido");
		}
		catch(FileNotFoundException fnf)
		{
			System.out.println(fnf.getMessage());
		}
		catch(IOException io)
		{
			System.out.println(io.getMessage());
		}
		visualizar();
		System.out.println("\n\n Tabela de Simbolos \n");
		organizar();
	}


	private void organizar() 
	{
		CriarLexema r;
		CriarLexema t;

		String token, classi, token2, classi2;
		int linha, linha2;
		//Organizar Classes
		for(int i=1;i<vec.size();i++)
		{
			//Elemento do sitio
			r = (CriarLexema) vec.elementAt(i);
			token =r.getToken();
			classi=r.getClassi();
			linha=r.getLinha();
			//elemento anterior
			t = (CriarLexema) vec.elementAt(i-1);
			token2 =t.getToken();
			classi2=t.getClassi();
			linha2=t.getLinha();
			byte par;
			int nivel=linha;
			if(token2.equals("class"))
			{
				par = parametros(token,linha, i);
				Classe m = new Classe(token, classi, linha,par,nivel);
				simb.add(m);
				simb.trimToSize();
			}
			else
			{
				if(classi2.equals("Tipo de dado"))
				{
					
				}
			}
			
		}
		
		verSimb();
	}


	private void verSimb() 
	{
		
		System.out.println("===================================================================");
		System.out.println("|      Token       |     classificacao    |Linha|N Par|Nivel|");
		System.out.println("===================================================================");
		
		for(int i=0; i<simb.size(); i++)
		{		

			if(simb.elementAt(i) instanceof Classe)
			{
				Classe m = (Classe) simb.elementAt(i);
				String tok=m.getToken();
				String classi = m.getClassi();
				int lin = m.getLinha();
				byte npar= m.getnPar();
				int nivel=m.getNivel();
				
				System.out.printf("|%20s|%25s|%5d|%5d|%5d|",tok,classi,lin,npar,nivel);
				System.out.println("\n===================================================================");
			}

		}
	}


	private byte parametros(String token, int linha, int i) 
	{
		byte par=0;
		for(int k=i;k<vec.size();k++)
		{
			CriarLexema c = (CriarLexema) vec.elementAt(k);
			if(c.getToken().equals(",")&& c.getLinha()==linha)
			{
				par++;
			}
		}
		return par;
	}


	private void visualizar() {
		System.out.println("======================================================");
		System.out.println("|      Token       |     classificacao    |Linha|");
		System.out.println("======================================================");
		CriarLexema m;
		
		for(int i=0; i<vec.size(); i++)
		{
			m = (CriarLexema) vec.elementAt(i);
			String tok=m.getToken();
			String classi = m.getClassi();
			int lin = m.getLinha();
			
			System.out.printf("|%20s|%25s|%5d|",tok,classi,lin);
			System.out.println("\n======================================================");

		}
		
}
	
	public String classif(String a)
	{
		String classi;
		classi=id.getCategory(a);
		if (classi==null)
		{
		    classi = "epa";
		}
		return classi;
	}
	

	

}
