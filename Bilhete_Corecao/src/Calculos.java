import java.util.*;
public class Calculos 
{
	public Calculos() {}
	
	public float calcularValorTotal(ArrayList v) 
	{
		Bilhete b;
		CalculoIVA cal;
		float vT = 0;
		
		for (int i = 0; i < v.size(); i++) 
		{
			b = (Bilhete) v.get(i);
			if(b instanceof Carro) 
			{
				cal = (Carro) b;
				vT += cal.calcularValorFinal();
			}
			
			else 
			{ 
				if(b instanceof Comboio)
				{
					cal = (Comboio) b;
					vT += cal.calcularValorFinal();
				}
				else {
					if(b instanceof Mar || b instanceof Aereo) //em qualquer dos dois casos utiliza-se o valor da super classe
						vT += b.getValorBilhete();
				}
					
			}
		}		
		return vT;
	}
}
