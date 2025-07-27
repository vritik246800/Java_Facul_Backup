import java.util.Vector;

public class Pesquisas 
{
	public Pesquisas() {}

	public int pesquisarPorCodigo(Vector ag, int cod) 
	{
		Agente aux;
		AgenteVendedor aux1;
		int pos = -1;
		boolean encontrou = false;
		
		for (int i = 0; i < ag.size() && encontrou == false; i++) 
		{
			aux = (Agente) ag.elementAt(i);
			if(aux instanceof AgenteVendedor) 
			{
				aux1 = (AgenteVendedor) aux;
				if(aux1.getCodigo() == cod) 
				{
					pos = i;
					encontrou = true;
				}
			}	
		}
		return pos;
	}
}
