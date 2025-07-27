import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MeuProgramaGUI extends JFrame 
{
    private JLabel mensagemLabel;
    private JButton botao;

    public MeuProgramaGUI() 
    {
        // Configurações da janela
        //setTitle("Minha Janela Java");
        super("Minha Janela Java");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Texto (label)
        mensagemLabel = new JLabel("Bem-vindo!", SwingConstants.CENTER);
        mensagemLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(mensagemLabel, BorderLayout.NORTH);

        // Imagem
        ImageIcon imagem = new ImageIcon("imagem.jpg"); // Troque por sua imagem local
        JLabel imagemLabel = new JLabel(imagem);
        imagemLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(imagemLabel, BorderLayout.CENTER);

        // Botão
        botao = new JButton("Clique aqui");
        botao.addActionListener
        (
            new ActionListener() 
            {
                public void actionPerformed(ActionEvent e)
                {
                    mensagemLabel.setText("Você clicou no botão!");
                }
            }
        );
        add(botao, BorderLayout.SOUTH);
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> 
        {
            MeuProgramaGUI janela = new MeuProgramaGUI();
            janela.setLocationRelativeTo(null);
            janela.setVisible(true);
        });
    }
}
