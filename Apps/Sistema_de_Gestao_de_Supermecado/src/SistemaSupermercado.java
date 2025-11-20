import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// --- MODELOS (Classes de Dados) ---
class Produto {
    String nome;
    double precoCusto;
    double margemLucro;
    boolean incluiIVA;
    double precoFinal;
    int stock;

    public Produto(String nome, double precoCusto, double margemLucro, boolean incluiIVA, int stock) {
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.margemLucro = margemLucro;
        this.incluiIVA = incluiIVA;
        this.stock = stock;
        calcularPrecoFinal();
    }

    public void calcularPrecoFinal() {
        double valorMargem = precoCusto * (margemLucro / 100.0);
        double base = precoCusto + valorMargem;
        if (incluiIVA) {
            this.precoFinal = base * 1.16; // Exemplo IVA 16%
        } else {
            this.precoFinal = base;
        }
        // Arredondar para 2 casas decimais
        this.precoFinal = Math.round(this.precoFinal * 100.0) / 100.0;
    }
    
    @Override
    public String toString() { return nome; }
}

class Cliente {
    String nome;
    String nif;
    String tipo; // Empresa ou Individual

    public Cliente(String nome, String nif, String tipo) {
        this.nome = nome;
        this.nif = nif;
        this.tipo = tipo;
    }
    
    @Override
    public String toString() { return nome + " (" + tipo + ")"; }
}

// --- SISTEMA PRINCIPAL (Interface e Lógica) ---
public class SistemaSupermercado extends JFrame {

    // Dados em memória (Simulando Base de Dados)
    private List<Produto> produtos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    
    // Componentes de Venda
    private DefaultTableModel modeloTabelaVenda;
    private JLabel lblTotalVenda;
    private JComboBox<Cliente> comboClientesVenda;
    private JComboBox<Produto> comboProdutosVenda;
    private double totalAtual = 0.0;

    public SistemaSupermercado() {
        setTitle("Sistema de Gestão - Supermercado & Mercearia");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criar Abas (Tabs)
        JTabbedPane tabbedPane = new JTabbedPane();
        
        tabbedPane.addTab("🛒 Ponto de Venda (POS)", criarPainelVendas());
        tabbedPane.addTab("📦 Gestão de Produtos", criarPainelProdutos());
        tabbedPane.addTab("👥 Gestão de Clientes", criarPainelClientes());
        tabbedPane.addTab("⚙️ Backup & Admin", criarPainelAdmin());

        add(tabbedPane);
        
        // Dados de Exemplo
        inicializarDadosTeste();
    }

    // ---------------------------------------------------------
    // 1. PAINEL DE PRODUTOS (Com cálculo automático)
    // ---------------------------------------------------------
    private JPanel criarPainelProdutos() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Novo Produto"));

        JTextField txtNome = new JTextField();
        JTextField txtCusto = new JTextField("0.0");
        JTextField txtMargem = new JTextField("0.0");
        JCheckBox chkIVA = new JCheckBox("Incluir IVA (16%)?");
        JTextField txtStock = new JTextField("0");
        JLabel lblPrecoFinal = new JLabel("Preço Venda: 0.00 MT");
        lblPrecoFinal.setFont(new Font("Arial", Font.BOLD, 14));
        lblPrecoFinal.setForeground(Color.BLUE);

        JButton btnSalvar = new JButton("Salvar Produto");

        // Lógica de Cálculo Automático em Tempo Real
        DocumentListener calcListener = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { calcular(); }
            public void removeUpdate(DocumentEvent e) { calcular(); }
            public void changedUpdate(DocumentEvent e) { calcular(); }

            void calcular() {
                try {
                    double custo = Double.parseDouble(txtCusto.getText().replace(",", "."));
                    double margem = Double.parseDouble(txtMargem.getText().replace(",", "."));
                    boolean temIVA = chkIVA.isSelected();

                    double preco = custo + (custo * (margem / 100.0));
                    if (temIVA) preco = preco * 1.16;

                    lblPrecoFinal.setText(String.format("Preço Venda: %.2f MT", preco));
                } catch (NumberFormatException ex) {
                    // Ignorar enquanto digita
                }
            }
        };

        txtCusto.getDocument().addDocumentListener(calcListener);
        txtMargem.getDocument().addDocumentListener(calcListener);
        chkIVA.addActionListener(e -> {
            // Forçar recálculo ao clicar no check
            try {
                double custo = Double.parseDouble(txtCusto.getText());
                double margem = Double.parseDouble(txtMargem.getText()); 
                // Simples recálculo visual
                double preco = custo + (custo * (margem / 100.0));
                if (chkIVA.isSelected()) preco *= 1.16;
                lblPrecoFinal.setText(String.format("Preço Venda: %.2f MT", preco));
            } catch (Exception ex) {}
        });

        btnSalvar.addActionListener(e -> {
            try {
                String nome = txtNome.getText();
                double custo = Double.parseDouble(txtCusto.getText());
                double margem = Double.parseDouble(txtMargem.getText());
                int stock = Integer.parseInt(txtStock.getText());
                
                Produto p = new Produto(nome, custo, margem, chkIVA.isSelected(), stock);
                produtos.add(p);
                comboProdutosVenda.addItem(p); // Atualiza na tela de vendas
                JOptionPane.showMessageDialog(this, "Produto salvo com sucesso!");
                txtNome.setText(""); txtCusto.setText("0");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro nos valores numéricos!");
            }
        });

        formPanel.add(new JLabel("Nome Produto:")); formPanel.add(txtNome);
        formPanel.add(new JLabel("Preço Custo:")); formPanel.add(txtCusto);
        formPanel.add(new JLabel("Margem Lucro (%):")); formPanel.add(txtMargem);
        formPanel.add(new JLabel("Stock Inicial:")); formPanel.add(txtStock);
        formPanel.add(chkIVA); formPanel.add(lblPrecoFinal);
        formPanel.add(new JLabel("")); formPanel.add(btnSalvar);

        panel.add(formPanel, BorderLayout.NORTH);
        
        // Tabela de listagem (simplificada)
        String[] colunas = {"Nome", "Custo", "Margem", "Venda", "Stock"};
        DefaultTableModel modelLista = new DefaultTableModel(colunas, 0);
        JTable tabelaLista = new JTable(modelLista);
        panel.add(new JScrollPane(tabelaLista), BorderLayout.CENTER);
        
        // Botão Atualizar Lista
        JButton btnRefresh = new JButton("Atualizar Lista");
        btnRefresh.addActionListener(e -> {
            modelLista.setRowCount(0);
            for(Produto p : produtos) {
                modelLista.addRow(new Object[]{p.nome, p.precoCusto, p.margemLucro, p.precoFinal, p.stock});
            }
        });
        panel.add(btnRefresh, BorderLayout.SOUTH);

        return panel;
    }

    // ---------------------------------------------------------
    // 2. PAINEL DE VENDAS (POS)
    // ---------------------------------------------------------
    private JPanel criarPainelVendas() {
        JPanel panel = new JPanel(new BorderLayout());

        // Topo: Seleção
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        comboClientesVenda = new JComboBox<>();
        comboProdutosVenda = new JComboBox<>();
        JTextField txtQtd = new JTextField("1", 5);
        JButton btnAdd = new JButton("Adicionar (+)");

        topPanel.add(new JLabel("Cliente:"));
        topPanel.add(comboClientesVenda);
        topPanel.add(new JLabel("Produto:"));
        topPanel.add(comboProdutosVenda);
        topPanel.add(new JLabel("Qtd:"));
        topPanel.add(txtQtd);
        topPanel.add(btnAdd);

        // Centro: Tabela do Carrinho
        String[] colunas = {"Produto", "Qtd", "Preço Unit.", "Subtotal"};
        modeloTabelaVenda = new DefaultTableModel(colunas, 0);
        JTable tabelaVenda = new JTable(modeloTabelaVenda);
        
        // Baixo: Totais e Finalizar
        JPanel botPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        lblTotalVenda = new JLabel("TOTAL: 0.00 MT");
        lblTotalVenda.setFont(new Font("Arial", Font.BOLD, 20));
        JButton btnFinalizar = new JButton("FINALIZAR VENDA & IMPRIMIR");
        btnFinalizar.setBackground(new Color(0, 150, 0));
        btnFinalizar.setForeground(Color.WHITE);

        botPanel.add(lblTotalVenda);
        botPanel.add(btnFinalizar);

        // Ações
        btnAdd.addActionListener(e -> {
            Produto p = (Produto) comboProdutosVenda.getSelectedItem();
            if (p != null) {
                int qtd = Integer.parseInt(txtQtd.getText());
                double subtotal = p.precoFinal * qtd;
                modeloTabelaVenda.addRow(new Object[]{p.nome, qtd, p.precoFinal, subtotal});
                totalAtual += subtotal;
                lblTotalVenda.setText(String.format("TOTAL: %.2f MT", totalAtual));
            }
        });

        btnFinalizar.addActionListener(e -> gerarRecibo());

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(tabelaVenda), BorderLayout.CENTER);
        panel.add(botPanel, BorderLayout.SOUTH);

        return panel;
    }

    // ---------------------------------------------------------
    // 3. PAINEL DE CLIENTES
    // ---------------------------------------------------------
    private JPanel criarPainelClientes() {
        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.setBorder(BorderFactory.createTitledBorder("Registo de Clientes / Empresas"));

        JTextField txtNome = new JTextField();
        JTextField txtNif = new JTextField();
        JComboBox<String> comboTipo = new JComboBox<>(new String[]{"Individual", "Empresa"});
        JButton btnSalvar = new JButton("Registar Cliente");

        btnSalvar.addActionListener(e -> {
            Cliente c = new Cliente(txtNome.getText(), txtNif.getText(), (String)comboTipo.getSelectedItem());
            clientes.add(c);
            comboClientesVenda.addItem(c);
            JOptionPane.showMessageDialog(this, "Cliente registado!");
            txtNome.setText(""); txtNif.setText("");
        });

        panel.add(new JLabel("Nome / Razão Social:")); panel.add(txtNome);
        panel.add(new JLabel("NIF / NUIT:")); panel.add(txtNif);
        panel.add(new JLabel("Tipo:")); panel.add(comboTipo);
        panel.add(new JLabel("")); panel.add(btnSalvar);

        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.add(panel, BorderLayout.NORTH);
        return wrapper;
    }

    // ---------------------------------------------------------
    // 4. PAINEL ADMIN & BACKUP
    // ---------------------------------------------------------
    private JPanel criarPainelAdmin() {
        JPanel panel = new JPanel(new FlowLayout());
        JButton btnBackup = new JButton("💾 Fazer Backup da Base de Dados");
        
        btnBackup.addActionListener(e -> fazerBackup());
        
        panel.add(btnBackup);
        return panel;
    }

    // ---------------------------------------------------------
    // FUNÇÕES AUXILIARES
    // ---------------------------------------------------------
    private void gerarRecibo() {
        if (modeloTabelaVenda.getRowCount() == 0) return;

        StringBuilder recibo = new StringBuilder();
        recibo.append("=== SUPERMERCADO JAVA ===\n");
        recibo.append("Data: " + new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()) + "\n");
        recibo.append("Cliente: " + comboClientesVenda.getSelectedItem() + "\n");
        recibo.append("--------------------------------\n");
        
        for (int i = 0; i < modeloTabelaVenda.getRowCount(); i++) {
            String prod = (String) modeloTabelaVenda.getValueAt(i, 0);
            int qtd = (int) modeloTabelaVenda.getValueAt(i, 1);
            double sub = (double) modeloTabelaVenda.getValueAt(i, 3);
            recibo.append(String.format("%-15s x%d   %.2f\n", prod, qtd, sub));
        }
        
        recibo.append("--------------------------------\n");
        recibo.append(String.format("TOTAL A PAGAR: %.2f MT\n", totalAtual));
        recibo.append("IVA incluído à taxa legal.\n");
        recibo.append("================================");

        JOptionPane.showMessageDialog(this, new JTextArea(recibo.toString()), "Recibo", JOptionPane.INFORMATION_MESSAGE);

        // Limpar venda
        modeloTabelaVenda.setRowCount(0);
        totalAtual = 0.0;
        lblTotalVenda.setText("TOTAL: 0.00 MT");
    }

    private void fazerBackup() {
        // Simulação de Backup de ficheiro
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Escolha onde salvar o Backup");
        fileChooser.setSelectedFile(new File("backup_loja_" + System.currentTimeMillis() + ".db"));
        
        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try {
                // Aqui você copiaria o arquivo real do banco de dados (ex: loja.db)
                // Files.copy(new File("loja.db").toPath(), fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);
                
                // Como estamos simulando, vamos criar um arquivo texto
                FileWriter fw = new FileWriter(fileToSave);
                fw.write("BACKUP DADOS - " + new Date() + "\n");
                fw.write("Total Produtos: " + produtos.size() + "\n");
                fw.write("Total Clientes: " + clientes.size() + "\n");
                fw.close();
                
                JOptionPane.showMessageDialog(this, "Backup realizado com sucesso em: " + fileToSave.getAbsolutePath());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao fazer backup: " + ex.getMessage());
            }
        }
    }

    private void inicializarDadosTeste() {
        Cliente c1 = new Cliente("Consumidor Final", "999999999", "Individual");
        clientes.add(c1);
        comboClientesVenda.addItem(c1);
        
        Produto p1 = new Produto("Arroz 1kg", 50, 20, false, 100);
        Produto p2 = new Produto("Teclado USB", 500, 30, true, 10);
        produtos.add(p1); produtos.add(p2);
        comboProdutosVenda.addItem(p1); comboProdutosVenda.addItem(p2);
    }

    public static void main(String[] args) {
        // Estilo visual do sistema (Look and Feel)
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch (Exception e) {}
        
        SwingUtilities.invokeLater(() -> {
            new SistemaSupermercado().setVisible(true);
        });
    }
}