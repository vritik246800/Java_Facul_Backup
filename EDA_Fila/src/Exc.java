
public class Exc 
{
	public static void main(String [] args)
	{
		final int CP=5;
		try
		{
			FilaArray f=new FilaArray(CP);
			Fila fila=f;
			
			Carro c1=new Carro("VM","ava-213","Blue",54956);
			Carro c2=new Carro("YM","vaa-232","black",54056);
			Carro c3=new Carro("DK","bfd-213","amarelo",54656);
			Carro c4=new Carro("LM","rty-213","Branco",2056);
			Carro c5=new Carro("VV","ada-253","Blue",54656);
			
			fila.enqueue(c1);
			fila.enqueue(c2);
			fila.enqueue(c3);
			fila.enqueue(c4);
			fila.enqueue(c5);
			
			System.out.println("O total de carro sao: "+fila.size());
			
			for(int i=0;i<CP;i++)
			{
				System.out.println(fila.dequeue());
			}
			
			
		}
		catch (FullQueueException e) 
		{
            System.out.println("Erro: " + e.getMessage());
        }
		catch (EmptyQueueException e) 
		{
	        System.out.println("Fila está vazia.");
	    }
	}
}
