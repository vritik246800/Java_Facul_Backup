import java.util.*;
public class Alteracoes 
{
	public Alteracoes()
	{
		
	}
	public void alterar(ArrayList a,int poz,int lotacao)
	{
		Bilhete pai;
		BilheteBarco barco;
		
		pai=(Bilhete)a.get(poz);
		if(pai instanceof BilheteBarco)
		{
			barco=(BilheteBarco)pai;
			barco.setlotacao(lotacao);
		}
		
	}

}
