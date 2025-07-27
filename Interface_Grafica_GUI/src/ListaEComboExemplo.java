import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ListaEComboExemplo {
    public static void main(String[] args) {
        // Criando o frame
        JFrame frame = new JFrame("Exemplo com JList e JComboBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        // Dados para a JList
        String[] frutas = {"Maçã", "Banana", "Laranja", "Pera", "Uva"};
        JList<String> listaFrutas = new JList<>(frutas);
        listaFrutas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollFrutas = new JScrollPane(listaFrutas);
        scrollFrutas.setPreferredSize(new Dimension(120, 100));
        //listaFrutas.setSelectionMode(ListSelectionMode.);

        // Dados para a JComboBox
        String[] cores = {"Vermelho", "Verde", "Azul", "Amarelo"};
        JComboBox<String> comboCores = new JComboBox<>(cores);

        // Labels para mostrar seleções
        JLabel labelFruta = new JLabel("Fruta selecionada: ");
        JLabel labelCor = new JLabel("Cor selecionada: ");

        // Eventos de seleção
        listaFrutas.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String frutaSelecionada = listaFrutas.getSelectedValue();
                labelFruta.setText("Fruta selecionada: " + frutaSelecionada);
            }
        });

        comboCores.addActionListener(e -> {
            String corSelecionada = (String) comboCores.getSelectedItem();
            labelCor.setText("Cor selecionada: " + corSelecionada);
        });

        // Adicionando componentes ao frame
        frame.add(scrollFrutas);
        frame.add(comboCores);
        frame.add(labelFruta);
        frame.add(labelCor);

        // Exibir a janela
        frame.setVisible(true);
    }
}
