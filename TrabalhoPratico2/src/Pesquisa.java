
public class Pesquisa
{
	private Validacoes vl;
	public Pesquisa()
	{
		vl=new Validacoes();
	}
	public int pesquisar(int ct,Reserva [] array)
	{
		
		int aux =-1;
		String tipoR=" ",numeroT=" ";
		
		tipoR=vl.validarPesq("| Introduz o tipo de reserva (Empresa || Casal     || Particular): |","|==================================================================|");
		numeroT=vl.validarPesq("| Introduz o Numero de Telefone (82/83/84/85/86/87): |","|====================================================|");
		
		for(int i=0;i<ct;i++)
		{
			if(array[i].getnumeroT().equals(numeroT) && array[i].gettipoR().equalsIgnoreCase(tipoR))
				 aux=i;
		}
		return aux ;
	}
}