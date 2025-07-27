import javax.swing.*;

public class Janela1 extends JFrame
{
	public Janela1(String titulo)
	{
		
		setTitle(titulo);
		// super(titulo) podemos fazer pra dar o nome
		setLocationRelativeTo(null); // para center janela
		setSize(1000,500);
			  // |    |> Altura
			  // |> Largura
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
				// a janela sempre vai ser invisivel entao tem que ser TRUE
		
	}
	public static void main(String [] args)
	{
		new Janela1("JanelaV");
	}

	/*
	 * JFrame.HIDE_ON_CLOSE
	 * JFrame.DISPOSE_ON_CLOSE
	 * JFrame.EXIT_ON_CLOSE
	 * JFrame.DO_NOTHING_ON_CLOSE
	 */
}
