import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;

public class JTreeExemplo extends JFrame {

    private JTree arvore;
    private DefaultTreeModel modelo;
    private DefaultMutableTreeNode raiz;

    public JTreeExemplo() {
        super("Exemplo de JTree - Funções Básicas");

        // --- Raiz e estrutura inicial da árvore ---
        raiz = new DefaultMutableTreeNode("Biblioteca");
        DefaultMutableTreeNode livros = new DefaultMutableTreeNode("Livros");
        DefaultMutableTreeNode autores = new DefaultMutableTreeNode("Autores");

        livros.add(new DefaultMutableTreeNode("Programação"));
        livros.add(new DefaultMutableTreeNode("Banco de Dados"));
        autores.add(new DefaultMutableTreeNode("Alan Turing"));
        autores.add(new DefaultMutableTreeNode("Ada Lovelace"));

        raiz.add(livros);
        raiz.add(autores);

        modelo = new DefaultTreeModel(raiz);
        arvore = new JTree(modelo);

        JScrollPane scroll = new JScrollPane(arvore);

        // --- Painel de botões ---
        JPanel botoes = new JPanel();
        botoes.setLayout(new FlowLayout());

        JButton btnAdicionar = new JButton("Adicionar Nó");
        JButton btnRemover = new JButton("Remover Nó");
        JButton btnRenomear = new JButton("Renomear Nó");

        botoes.add(btnAdicionar);
        botoes.add(btnRemover);
        botoes.add(btnRenomear);

        // --- Eventos dos botões ---
        btnAdicionar.addActionListener(e -> adicionarNo());
        btnRemover.addActionListener(e -> removerNo());
        btnRenomear.addActionListener(e -> renomearNo());

        // --- Layout principal ---
        setLayout(new BorderLayout());
        add(scroll, BorderLayout.CENTER);
        add(botoes, BorderLayout.SOUTH);

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void adicionarNo() {
        TreePath caminho = arvore.getSelectionPath();
        if (caminho == null) {
            JOptionPane.showMessageDialog(this, "Selecione um nó para adicionar um filho.");
            return;
        }

        DefaultMutableTreeNode selecionado = (DefaultMutableTreeNode) caminho.getLastPathComponent();
        String nome = JOptionPane.showInputDialog(this, "Nome do novo nó:");
        if (nome != null && !nome.trim().isEmpty()) {
            DefaultMutableTreeNode novoNo = new DefaultMutableTreeNode(nome);
            modelo.insertNodeInto(novoNo, selecionado, selecionado.getChildCount());
            arvore.scrollPathToVisible(new TreePath(novoNo.getPath()));
        }
    }

    private void removerNo() {
        TreePath caminho = arvore.getSelectionPath();
        if (caminho == null) {
            JOptionPane.showMessageDialog(this, "Selecione um nó para remover.");
            return;
        }

        DefaultMutableTreeNode selecionado = (DefaultMutableTreeNode) caminho.getLastPathComponent();
        if (selecionado == raiz) {
            JOptionPane.showMessageDialog(this, "Não é possível remover a raiz.");
            return;
        }

        modelo.removeNodeFromParent(selecionado);
    }

    private void renomearNo() {
        TreePath caminho = arvore.getSelectionPath();
        if (caminho == null) {
            JOptionPane.showMessageDialog(this, "Selecione um nó para renomear.");
            return;
        }

        DefaultMutableTreeNode selecionado = (DefaultMutableTreeNode) caminho.getLastPathComponent();
        String novoNome = JOptionPane.showInputDialog(this, "Novo nome:", selecionado.getUserObject());
        if (novoNome != null && !novoNome.trim().isEmpty()) {
            selecionado.setUserObject(novoNome);
            modelo.nodeChanged(selecionado);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JTreeExemplo::new);
    }
}
