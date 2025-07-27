import java.util.*;
public class Calculos 
{
	public Calculos() {}

	public float calcularValorTotalComissoes(Vector v) 
	{
		float vT=0;
		Agente a;
		AgenteComerciante ac;
		AgenteRegisto ar;
		AgenteVendedor av;
				
		for (int i = 0; i < v.size(); i++) 
		{
			a = (Agente) v.elementAt(i);
			
			if(a instanceof AgenteComerciante) 
			{
				ac = (AgenteComerciante) a;
				vT += 0.05f * ac.getValTransacao();
			}
				
			else 
			{
				if(a instanceof AgenteRegisto) 
				{
					ar = (AgenteRegisto) a;
					float d;
			
					if(ar.getTipoRegisto() == 'E') 
						d = ar.getNumRegistos() * 100;
					else
						d = ar.getNumRegistos() * 20;
					
					vT += (0.02f * d);
				}
					
				else
					if(a instanceof AgenteVendedor) 
					{
						av = (AgenteVendedor) a;
						vT += 0.03 * av.getNumVendas() * av.getValRecarga();	
					}	
			}
		}
		return vT;
	}

}
