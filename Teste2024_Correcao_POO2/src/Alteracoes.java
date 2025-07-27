import java.util.*;
import javax.swing.JOptionPane;
public class Alteracoes 
{
	public Alteracoes() {}
	
	public void alterarVendedor(Vector v, int pos) 
	{
		if(pos >= 0) 
		{
			AgenteVendedor av = (AgenteVendedor) v.elementAt(pos);
			byte novoVal = Byte.parseByte(JOptionPane.showInputDialog(null, "Introduza o novo valor da recarga"));
			av.setValRecarga(novoVal);
			JOptionPane.showMessageDialog(null, "Valor de recargas actualizado");
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "Agente não encontrado!");
		}
	}
}
