import java.io.*;
import javax.swing.*;

public class Validar 
{
	public Validar()
	{
		
	}
	public String validarNumeroA()
	{
		String i="";
		
		i = JOptionPane.showInputDialog(null, "Introduz Numero de Apoles:", "Entrada de Dados", JOptionPane.QUESTION_MESSAGE);
		
		return i;
	}
}
