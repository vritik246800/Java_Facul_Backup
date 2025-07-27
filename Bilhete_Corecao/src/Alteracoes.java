import java.util.*;

public class Alteracoes {
	
	public Alteracoes() 
	{}
	
	public void alterarMilhas(ArrayList v, int i, int milhas) 
	{	
		Aereo a = (Aereo) v.get(i);	
		a.setQtdMilhas(milhas);
		System.out.println("Alteracao feita com sucesso");
	}
}
