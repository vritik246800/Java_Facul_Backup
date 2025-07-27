import java.text.DecimalFormat;
public class Executavel
{ 
	public static void main (String []args)
	{
		TodasRevistas ar = new TodasRevistas();
		DecimalFormat m = new DecimalFormat ("###,###.00 Mt");
		ar.lerFichCriarArray();
		System.out.println(ar);
		ar.gravar();
		System.out.println("O valor global sao: "+m.format(ar.calcTotGlobal()));
	}
}