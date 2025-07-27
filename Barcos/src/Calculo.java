import java.util.*;
import java.text.DecimalFormat;

public class Calculo 
{
	private Visualizacao vis;
	private DecimalFormat m;
	
	public Calculo()
	{
		vis=new Visualizacao();
		m=new DecimalFormat("###,###,###.00 Mts");
		
	}
	public void ct(ArrayList array)
	{
		int ctP=0,ctC=0,ctR=0;
			
		Barco pai;
		Pesca pesca;
		Carga carga;
		Cruseiro cruz;
		
		for(int i=0;i<array.size();i++)
		{
			pai=(Barco)array.get(i);
			if(pai instanceof Pesca)
			{
				pesca=(Pesca)pai;
				ctP=pesca.ctPesca;
			}
			else
			{
				if(pai instanceof Carga)
				{
					carga=(Carga)pai;
					ctC=Carga.ctCarga;
				}
				else
				{
					if(pai instanceof Cruseiro)
					{
						cruz=(Cruseiro)pai;
						ctR=Cruseiro.ctCruz;
					}
				}
			}	
		}
		vis.vizct("A quantidade de Barcos de Pescador: ", ctP,"\nA quantidade de Barcos de Carga: ", ctC,"\nA quantidade de Cruzeiro: ",ctR);
	}
	public void vp(ArrayList array)
	{
		Barco pai;
		Pesca pesca;
		Carga carga;
		Cruseiro cruz;
		
		float vpPesc=0,vpCg=0,vpCruz=0;
		final int PESC=1000,CARGA=100000,CRUZ=150;
		
		for(int i=0;i<array.size();i++)
		{
			pai=(Barco)array.get(i);
			if(pai instanceof Pesca)
			{
				pesca=(Pesca)pai;
				vpPesc=pesca.getqtyMarico()*PESC;
			}
			else
			{
				if(pai instanceof Carga)
				{
					carga=(Carga)pai;
					vpCg=carga.getnContetor()*CARGA;
				}
				else
				{
					if(pai instanceof Cruseiro)
					{
						cruz=(Cruseiro)pai;
						vpCruz=cruz.getqtyPassageiro()*CRUZ;
					}
				}
			}
		}
		vis.vizVP("O valor a pagar do pescador sao de: ", m.format(vpPesc), "\nO valor a pagar da Cargas: ", m.format(vpCg), "\nO valor a pagar do Cruseiro: ",m.format(vpCruz));
		System.out.println("/nO valor total sao de : "+m.format(vpPesc+vpCg+vpCruz));
	}
}
