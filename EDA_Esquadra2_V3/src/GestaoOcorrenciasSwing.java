import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* =========================================================
 *  SWING  INTERFACE  (only public class in the file)
 * ========================================================= */
public class GestaoOcorrenciasSwing extends JFrame {

    /* --------------  business data -------------- */
    private final ArvoreBinariaOcorrencias arvore = new ArvoreBinariaOcorrencias();
    private final List<Informador> informadores = new ArrayList<>();

    /* --------------  file names -------------- */
    private static final String ARQ_OCORRENCIAS  = "ocorrencias.txt";
    private static final String ARQ_INFORMADORES = "informadores.txt";

    /* --------------  swing components -------------- */
    private final CardLayout cardLayout = new CardLayout();
    private final JPanel mainPanel = new JPanel(cardLayout);

    /* menus */
    private final JButton btCadOcorrencia  = new JButton("Cadastrar Ocorrência");
    private final JButton btListOcorrencia = new JButton("Listar Ocorrências");
    private final JButton btBuscaOcorrencia= new JButton("Buscar Ocorrência");
    private final JButton btEditOcorrencia = new JButton("Editar Ocorrência");
    private final JButton btDelOcorrencia  = new JButton("Remover Ocorrência");
    private final JButton btCadInformador  = new JButton("Cadastrar Informador");
    private final JButton btListInformador = new JButton("Listar Informadores");
    private final JButton btRelatorios     = new JButton("Relatórios");
    private final JButton btSair           = new JButton("Sair");

    /* panels */
    private final JPanel menuPanel   = new JPanel(new GridLayout(0,1,5,5));
    private final JPanel cadOcoPanel = new JPanel(new BorderLayout());
    private final JPanel listOcoPanel= new JPanel(new BorderLayout());
    private final JPanel buscOcoPanel= new JPanel(new BorderLayout());
    private final JPanel editOcoPanel= new JPanel(new BorderLayout());
    private final JPanel delOcoPanel = new JPanel(new BorderLayout());
    private final JPanel cadInfPanel = new JPanel(new BorderLayout());
    private final JPanel listInfPanel= new JPanel(new BorderLayout());
    private final JPanel relPanel    = new JPanel(new BorderLayout());

    public GestaoOcorrenciasSwing() {
        super("Sistema de Gestão de Ocorrências Policiais");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900,700);
        setLocationRelativeTo(null);

        /* build menu */
        menuPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        menuPanel.add(new JLabel("Escolha uma opção:", SwingConstants.CENTER));
        menuPanel.add(btCadOcorrencia);
        menuPanel.add(btListOcorrencia);
        menuPanel.add(btBuscaOcorrencia);
        menuPanel.add(btEditOcorrencia);
        menuPanel.add(btDelOcorrencia);
        menuPanel.add(btCadInformador);
        menuPanel.add(btListInformador);
        menuPanel.add(btRelatorios);
        menuPanel.add(btSair);

        /* build cards */
        buildCadOcorrenciaCard();
        buildListOcorrenciaCard();
        buildBuscaOcorrenciaCard();
        buildEditOcorrenciaCard();
        buildDelOcorrenciaCard();
        buildCadInformadorCard();
        buildListInformadorCard();
        buildRelatoriosCard();

        mainPanel.add(menuPanel, "MENU");
        mainPanel.add(cadOcoPanel, "CAD_OCO");
        mainPanel.add(listOcoPanel,"LIST_OCO");
        mainPanel.add(buscOcoPanel,"BUSC_OCO");
        mainPanel.add(editOcoPanel,"EDIT_OCO");
        mainPanel.add(delOcoPanel ,"DEL_OCO");
        mainPanel.add(cadInfPanel,"CAD_INF");
        mainPanel.add(listInfPanel,"LIST_INF");
        mainPanel.add(relPanel   ,"REL");

        add(mainPanel);
        cardLayout.show(mainPanel, "MENU");

        /* listeners */
        btCadOcorrencia .addActionListener(e -> cardLayout.show(mainPanel, "CAD_OCO"));
        btListOcorrencia.addActionListener(e -> { refreshListOcorrencias(); cardLayout.show(mainPanel, "LIST_OCO"); });
        btBuscaOcorrencia.addActionListener(e -> cardLayout.show(mainPanel, "BUSC_OCO"));
        btEditOcorrencia.addActionListener(e -> cardLayout.show(mainPanel, "EDIT_OCO"));
        btDelOcorrencia .addActionListener(e -> cardLayout.show(mainPanel, "DEL_OCO"));
        btCadInformador .addActionListener(e -> cardLayout.show(mainPanel, "CAD_INF"));
        btListInformador.addActionListener(e -> { refreshListInformadores(); cardLayout.show(mainPanel, "LIST_INF"); });
        btRelatorios    .addActionListener(e -> cardLayout.show(mainPanel, "REL"));
        btSair          .addActionListener(e -> { salvarTudo(); dispose(); });

        /* load data */
        carregarDados();
    }

    /* =========================================================
     *  CARD: cadastrar ocorrência
     * ========================================================= */
    private final JTextField tfCodigo = new JTextField();
    private final JTextField tfTipo   = new JTextField();
    private final JTextField tfVitNome= new JTextField();
    private final JTextField tfVitBI  = new JTextField();
    private final JTextField tfVitCont= new JTextField();
    private final JTextField tfVitEnd = new JTextField();
    private final JTextField tfSusNome= new JTextField();
    private final JTextField tfSusBI  = new JTextField();
    private final JTextField tfSusCont= new JTextField();
    private final JTextField tfSusEnd = new JTextField();
    private final JCheckBox  ckRecorrente = new JCheckBox("Recorrente");
    private final JTextArea  taDesc = new JTextArea(3,30);
    private final JTextField tfData = new JTextField(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()));
    private final JTextField tfLocal= new JTextField();
    private final JTextField tfPessoas = new JTextField("1");
    private final JTextField tfMeios= new JTextField();
    private final JTextField tfPrejMat = new JTextField();
    private final JTextField tfPrejMor = new JTextField();
    private final JComboBox<String> cbStatus = new JComboBox<>(new String[]{"Aberta","Fechada","Anulada"});

    private void buildCadOcorrenciaCard() {
        JPanel p = new JPanel(new BorderLayout());
        p.add(new JLabel("Cadastrar Nova Ocorrência", SwingConstants.CENTER), BorderLayout.NORTH);

        JPanel cen = new JPanel(new GridLayout(0,2,5,5));
        cen.add(new JLabel("Código:"));      cen.add(tfCodigo);
        cen.add(new JLabel("Tipo:"));        cen.add(tfTipo);
        cen.add(new JLabel("Vítima - Nome:")); cen.add(tfVitNome);
        cen.add(new JLabel("Vítima - BI:"));   cen.add(tfVitBI);
        cen.add(new JLabel("Vítima - Contacto:")); cen.add(tfVitCont);
        cen.add(new JLabel("Vítima - Endereço:")); cen.add(tfVitEnd);
        cen.add(new JLabel("Suspeito - Nome (deixe vazio se ignorar):")); cen.add(tfSusNome);
        cen.add(new JLabel("Suspeito - BI:"));   cen.add(tfSusBI);
        cen.add(new JLabel("Suspeito - Contacto:")); cen.add(tfSusCont);
        cen.add(new JLabel("Suspeito - Endereço:")); cen.add(tfSusEnd);
        cen.add(new JLabel("")); cen.add(ckRecorrente);
        cen.add(new JLabel("Descrição:")); cen.add(new JScrollPane(taDesc));
        cen.add(new JLabel("Data/Hora:")); cen.add(tfData);
        cen.add(new JLabel("Local:"));     cen.add(tfLocal);
        cen.add(new JLabel("Nº Pessoas:"));cen.add(tfPessoas);
        cen.add(new JLabel("Meios:"));     cen.add(tfMeios);
        cen.add(new JLabel("Prej. Material:")); cen.add(tfPrejMat);
        cen.add(new JLabel("Prej. Moral:"));    cen.add(tfPrejMor);
        cen.add(new JLabel("Status:"));    cen.add(cbStatus);

        p.add(cen, BorderLayout.CENTER);

        JPanel bot = new JPanel();
        JButton btSalvar = new JButton("Salvar");
        JButton btVoltar = new JButton("Voltar");
        bot.add(btSalvar); bot.add(btVoltar);
        p.add(bot, BorderLayout.SOUTH);

        btVoltar.addActionListener(e -> cardLayout.show(mainPanel, "MENU"));
        btSalvar.addActionListener(e -> {
            try {
                int cod = Integer.parseInt(tfCodigo.getText().trim());
                if (arvore.buscar(cod)!=null) {
                    JOptionPane.showMessageDialog(this,"Código já existe!","Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Pessoa vit = new Pessoa(tfVitNome.getText(), tfVitBI.getText(), tfVitCont.getText(), tfVitEnd.getText());
                Suspeito sus = null;
                if (!tfSusNome.getText().trim().isEmpty()) {
                    sus = new Suspeito(tfSusNome.getText(), tfSusBI.getText(), tfSusCont.getText(), tfSusEnd.getText(), ckRecorrente.isSelected());
                }
                Ocorrencia o = new Ocorrencia(
                        cod, tfTipo.getText(), vit, sus,
                        taDesc.getText(), tfData.getText(), tfLocal.getText(),
                        (String)cbStatus.getSelectedItem(),
                        Integer.parseInt(tfPessoas.getText()),
                        tfMeios.getText(), tfPrejMat.getText(), tfPrejMor.getText());
                arvore.inserir(o);
                arvore.salvarParaArquivo(ARQ_OCORRENCIAS);
                JOptionPane.showMessageDialog(this,"Ocorrência cadastrada!","Sucesso", JOptionPane.INFORMATION_MESSAGE);
                limparCadOco();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,"Dados inválidos:\n"+ex.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        cadOcoPanel.add(p);
    }
    
    private void limparCadOco() {
        tfCodigo.setText(""); tfTipo.setText(""); tfVitNome.setText(""); tfVitBI.setText("");
        tfVitCont.setText(""); tfVitEnd.setText(""); tfSusNome.setText(""); tfSusBI.setText("");
        tfSusCont.setText(""); tfSusEnd.setText(""); ckRecorrente.setSelected(false);
        taDesc.setText(""); tfData.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()));
        tfLocal.setText(""); tfPessoas.setText("1"); tfMeios.setText("");
        tfPrejMat.setText(""); tfPrejMor.setText(""); cbStatus.setSelectedIndex(0);
    }

    /* =========================================================
     *  CARD: listar ocorrências
     * ========================================================= */
    private final JTextArea taListOco = new JTextArea();
    private void buildListOcorrenciaCard() {
        taListOco.setEditable(false);
        JButton voltar = new JButton("Voltar");
        voltar.addActionListener(e -> cardLayout.show(mainPanel, "MENU"));
        JPanel p = new JPanel(new BorderLayout());
        p.add(new JScrollPane(taListOco), BorderLayout.CENTER);
        p.add(voltar, BorderLayout.SOUTH);
        listOcoPanel.add(p);
    }
    private void refreshListOcorrencias() {
        StringBuilder sb = new StringBuilder();
        for (Ocorrencia o : arvore.getTodasOcorrencias()) sb.append(o.toString()).append("\n");
        if (sb.length()==0) sb.append("Nenhuma ocorrência cadastrada.");
        taListOco.setText(sb.toString());
    }

    /* =========================================================
     *  CARD: buscar ocorrência
     * ========================================================= */
    private final JTextField tfBuscaCod = new JTextField();
    private final JTextArea  taBuscaResult = new JTextArea();
    private void buildBuscaOcorrenciaCard() {
        taBuscaResult.setEditable(false);
        JPanel p = new JPanel(new BorderLayout());
        p.add(new JLabel("Buscar Ocorrência por Código"), BorderLayout.NORTH);

        JPanel top = new JPanel(new FlowLayout());
        top.add(new JLabel("Código:")); top.add(tfBuscaCod);
        JButton btBuscar = new JButton("Buscar");
        top.add(btBuscar);
        p.add(top, BorderLayout.NORTH);
        p.add(new JScrollPane(taBuscaResult), BorderLayout.CENTER);

        JButton voltar = new JButton("Voltar");
        voltar.addActionListener(e -> cardLayout.show(mainPanel, "MENU"));
        p.add(voltar, BorderLayout.SOUTH);

        btBuscar.addActionListener(e -> {
            try {
                int c = Integer.parseInt(tfBuscaCod.getText().trim());
                Ocorrencia o = arvore.buscar(c);
                taBuscaResult.setText(o==null ? "Ocorrência não encontrada." : o.toString());
            } catch (NumberFormatException ex) {
                taBuscaResult.setText("Código inválido.");
            }
        });

        buscOcoPanel.add(p);
    }

    /* =========================================================
     *  CARD: editar ocorrência
     * ========================================================= */
    private final JTextField tfEditCod = new JTextField();
    private final JTextField tfEditTipo= new JTextField();
    private final JTextArea  taEditDesc= new JTextArea(3,30);
    private final JTextField tfEditData= new JTextField();
    private final JTextField tfEditLocal=new JTextField();
    private final JComboBox<String> cbEditStatus = new JComboBox<>(new String[]{"Aberta","Fechada","Anulada"});
    private Ocorrencia ocoEditando = null;

    private void buildEditOcorrenciaCard() {
        JPanel p = new JPanel(new BorderLayout());
        p.add(new JLabel("Editar Ocorrência"), BorderLayout.NORTH);

        JPanel top = new JPanel(new FlowLayout());
        top.add(new JLabel("Código:")); top.add(tfEditCod);
        JButton btCarregar = new JButton("Carregar");
        top.add(btCarregar);
        p.add(top, BorderLayout.NORTH);

        JPanel cen = new JPanel(new GridLayout(0,2,5,5));
        cen.add(new JLabel("Novo Tipo:")); cen.add(tfEditTipo);
        cen.add(new JLabel("Nova Descrição:")); cen.add(new JScrollPane(taEditDesc));
        cen.add(new JLabel("Nova Data/Hora:")); cen.add(tfEditData);
        cen.add(new JLabel("Novo Local:")); cen.add(tfEditLocal);
        cen.add(new JLabel("Novo Status:")); cen.add(cbEditStatus);

        p.add(cen, BorderLayout.CENTER);

        JPanel bot = new JPanel();
        JButton btSalvar = new JButton("Salvar Alterações");
        JButton btVoltar = new JButton("Voltar");
        bot.add(btSalvar); bot.add(btVoltar);
        p.add(bot, BorderLayout.SOUTH);

        btVoltar.addActionListener(e -> cardLayout.show(mainPanel, "MENU"));
        btCarregar.addActionListener(e -> {
            try {
                int c = Integer.parseInt(tfEditCod.getText().trim());
                ocoEditando = arvore.buscar(c);
                if (ocoEditando==null) {
                    JOptionPane.showMessageDialog(this,"Ocorrência não encontrada.","Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                tfEditTipo.setText(ocoEditando.getTipoOcorrencia());
                taEditDesc.setText(ocoEditando.getDescricao());
                tfEditData.setText(ocoEditando.getDataHora());
                tfEditLocal.setText(ocoEditando.getLocal());
                cbEditStatus.setSelectedItem(ocoEditando.getStatus());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,"Código inválido.","Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
        btSalvar.addActionListener(e -> {
            if (ocoEditando==null) {
                JOptionPane.showMessageDialog(this,"Carregue uma ocorrência primeiro.","Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            ocoEditando.setTipoOcorrencia(tfEditTipo.getText());
            ocoEditando.setDescricao(taEditDesc.getText());
            ocoEditando.setDataHora(tfEditData.getText());
            ocoEditando.setLocal(tfEditLocal.getText());
            ocoEditando.setStatus((String)cbEditStatus.getSelectedItem());
            arvore.salvarParaArquivo(ARQ_OCORRENCIAS);
            JOptionPane.showMessageDialog(this,"Ocorrência atualizada!","Sucesso", JOptionPane.INFORMATION_MESSAGE);
        });

        editOcoPanel.add(p);
    }

    /* =========================================================
     *  CARD: remover ocorrência
     * ========================================================= */
    private final JTextField tfDelCod = new JTextField();
    private final JTextArea  taDelResult = new JTextArea();
    private void buildDelOcorrenciaCard() {
        taDelResult.setEditable(false);
        JPanel p = new JPanel(new BorderLayout());
        p.add(new JLabel("Remover Ocorrência"), BorderLayout.NORTH);

        JPanel top = new JPanel(new FlowLayout());
        top.add(new JLabel("Código:")); top.add(tfDelCod);
        JButton btRemover = new JButton("Remover");
        top.add(btRemover);
        p.add(top, BorderLayout.NORTH);
        p.add(new JScrollPane(taDelResult), BorderLayout.CENTER);

        JButton voltar = new JButton("Voltar");
        voltar.addActionListener(e -> cardLayout.show(mainPanel, "MENU"));
        p.add(voltar, BorderLayout.SOUTH);

        btRemover.addActionListener(e -> {
            try {
                int c = Integer.parseInt(tfDelCod.getText().trim());
                Ocorrencia o = arvore.buscar(c);
                if (o==null) {
                    taDelResult.setText("Ocorrência não encontrada.");
                    return;
                }
                arvore.remover(c);
                arvore.salvarParaArquivo(ARQ_OCORRENCIAS);
                taDelResult.setText("Ocorrência removida com sucesso.");
            } catch (NumberFormatException ex) {
                taDelResult.setText("Código inválido.");
            }
        });

        delOcoPanel.add(p);
    }

    /* =========================================================
     *  CARD: cadastrar informador
     * ========================================================= */
    private final JTextField tfInfNome = new JTextField();
    private final JTextField tfInfBI  = new JTextField();
    private final JTextField tfInfCont= new JTextField();
    private final JTextField tfInfEnd = new JTextField();
    private void buildCadInformadorCard() {
        JPanel p = new JPanel(new BorderLayout());
        p.add(new JLabel("Cadastrar Informador"), BorderLayout.NORTH);

        JPanel cen = new JPanel(new GridLayout(0,2,5,5));
        cen.add(new JLabel("Nome:"));   cen.add(tfInfNome);
        cen.add(new JLabel("BI:"));     cen.add(tfInfBI);
        cen.add(new JLabel("Contacto:"));cen.add(tfInfCont);
        cen.add(new JLabel("Endereço:"));cen.add(tfInfEnd);

        p.add(cen, BorderLayout.CENTER);

        JPanel bot = new JPanel();
        JButton btSalvar = new JButton("Salvar");
        JButton btVoltar = new JButton("Voltar");
        bot.add(btSalvar); bot.add(btVoltar);
        p.add(bot, BorderLayout.SOUTH);

        btVoltar.addActionListener(e -> cardLayout.show(mainPanel, "MENU"));
        btSalvar.addActionListener(e -> {
            Informador i = new Informador(tfInfNome.getText(), tfInfBI.getText(), tfInfCont.getText(), tfInfEnd.getText());
            informadores.add(i);
            salvarInformadores();
            JOptionPane.showMessageDialog(this,"Informador cadastrado!","Sucesso", JOptionPane.INFORMATION_MESSAGE);
            tfInfNome.setText(""); tfInfBI.setText(""); tfInfCont.setText(""); tfInfEnd.setText("");
        });

        cadInfPanel.add(p);
    }

    /* =========================================================
     *  CARD: listar informadores
     * ========================================================= */
    private final JTextArea taListInf = new JTextArea();
    private void buildListInformadorCard() {
        taListInf.setEditable(false);
        JButton voltar = new JButton("Voltar");
        voltar.addActionListener(e -> cardLayout.show(mainPanel, "MENU"));
        JPanel p = new JPanel(new BorderLayout());
        p.add(new JScrollPane(taListInf), BorderLayout.CENTER);
        p.add(voltar, BorderLayout.SOUTH);
        listInfPanel.add(p);
    }
    private void refreshListInformadores() {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<informadores.size();i++) sb.append((i+1)).append(". ").append(informadores.get(i)).append("\n");
        if (informadores.isEmpty()) sb.append("Nenhum informador cadastrado.");
        taListInf.setText(sb.toString());
    }

    /* =========================================================
     *  CARD: relatórios
     * ========================================================= */
    private final JComboBox<String> cbRelStatus = new JComboBox<>(new String[]{"Aberta","Fechada","Anulada"});
    private final JTextArea taRelResult = new JTextArea();
    private void buildRelatoriosCard() {
        taRelResult.setEditable(false);
        JPanel p = new JPanel(new BorderLayout());
        p.add(new JLabel("Relatórios"), BorderLayout.NORTH);

        JPanel top = new JPanel(new FlowLayout());
        top.add(new JLabel("Filtrar por status:")); top.add(cbRelStatus);
        JButton btGerar = new JButton("Gerar");
        top.add(btGerar);
        top.add(new JLabel("   Total geral:"));
        JButton btTotal = new JButton("Total");
        top.add(btTotal);
        p.add(top, BorderLayout.NORTH);
        p.add(new JScrollPane(taRelResult), BorderLayout.CENTER);

        JButton voltar = new JButton("Voltar");
        voltar.addActionListener(e -> cardLayout.show(mainPanel, "MENU"));
        p.add(voltar, BorderLayout.SOUTH);

        btGerar.addActionListener(e -> {
            String filtro = (String)cbRelStatus.getSelectedItem();
            StringBuilder sb = new StringBuilder();
            int c=0;
            for (Ocorrencia o : arvore.getTodasOcorrencias()) {
                if (o.getStatus().equalsIgnoreCase(filtro)) { sb.append(o).append("\n"); c++; }
            }
            sb.append("Total com status '").append(filtro).append("': ").append(c);
            taRelResult.setText(sb.toString());
        });
        btTotal.addActionListener(e -> taRelResult.setText("Total de ocorrências: "+arvore.getCount()));

        relPanel.add(p);
    }

    /* =========================================================
     *  persistence helpers
     * ========================================================= */
    private void carregarDados() {
        arvore.carregarDeArquivo(ARQ_OCORRENCIAS);
        File f = new File(ARQ_INFORMADORES);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linha;
            while ((linha=br.readLine())!=null) {
                if (linha.trim().isEmpty()) continue;
                String[] v = linha.split(";",-1);
                if (v.length>=4) informadores.add(new Informador(v[0],v[1],v[2],v[3]));
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,"Erro ao carregar informadores:\n"+e.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void salvarTudo() {
        arvore.salvarParaArquivo(ARQ_OCORRENCIAS);
        salvarInformadores();
    }
    private void salvarInformadores() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARQ_INFORMADORES))) {
            for (Informador i : informadores) pw.println(i.toFileString());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,"Erro ao salvar informadores:\n"+e.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /* =========================================================
     *  main
     * ========================================================= */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GestaoOcorrenciasSwing().setVisible(true));
    }

    /* =========================================================
     *  ORIGINAL BUSINESS CLASSES (unchanged, only appended)
     * ========================================================= */
}

/* ************************************************************
 *  A partir daqui estão as suas classes originais
 *  copiadas exatamente como estavam (apenas coladas no mesmo
 *  arquivo para facilitar a compilação única).
 * ************************************************************ */

class ArvoreBinariaOcorrencias implements Serializable {
    private static final long serialVersionUID = 1L;
    private NoArvore raiz;
    private int count;

    public ArvoreBinariaOcorrencias() { raiz=null; count=0; }
    public int getCount() { return count; }

    public void inserir(Ocorrencia o) {
        if (buscar(o.getCodigo())!=null) { System.out.println("Já existe"); return; }
        raiz = insRec(raiz,o); count++;
    }
    private NoArvore insRec(NoArvore n, Ocorrencia o) {
        if (n==null) return new NoArvore(o);
        if (o.getCodigo() < n.ocorrencia.getCodigo()) n.esquerda = insRec(n.esquerda,o);
        else if (o.getCodigo() > n.ocorrencia.getCodigo()) n.direita = insRec(n.direita,o);
        return n;
    }
    public Ocorrencia buscar(int cod) { return busRec(raiz,cod); }
    private Ocorrencia busRec(NoArvore n, int cod) {
        if (n==null) return null;
        if (cod==n.ocorrencia.getCodigo()) return n.ocorrencia;
        return cod < n.ocorrencia.getCodigo() ? busRec(n.esquerda,cod) : busRec(n.direita,cod);
    }
    /*
    public void remover(int cod) {
        if (buscar(cod)==null) { System.out.println("Não encontrado"); return; }
        raiz = removerRecursivo(raiz, codigo);

        JButton voltar = new JButton("Voltar");
        voltar.addActionListener(e -> cardLayout.show(mainPanel, "MENU"));
        p.add(voltar, BorderLayout.SOUTH);

        btRemover.addActionListener(e -> {
            try {
                int c = Integer.parseInt(tfDelCod.getText().trim());
                if (arvore.buscar(c)==null) {
                    taDelResult.setText("Ocorrência não encontrada.");
                    return;
                }
                arvore.remover(c);
                arvore.salvarParaArquivo(ARQ_OCORRENCIAS);
                taDelResult.setText("Ocorrência removida com sucesso.");
            } catch (NumberFormatException ex) {
                taDelResult.setText("Código inválido.");
            }
        });

        delOcoPanel.add(p);
    }
         */
    public void remover(int codigo) {
    if (buscar(codigo) == null) {
        System.out.println("Erro: Ocorrência com código " + codigo + " não encontrada para remoção.");
        return;
    }
    // FIX HERE –––––––––––––––––––––––––––––––––––––––––––––––––––––––––
    this.raiz = removerRecursivo(this.raiz, codigo);
    // ––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––
    this.count--;
}
    /* =========================================================
     *  CARD: cadastrar informador
     * ========================================================= */
    private final JTextField tfInfNome = new JTextField();
    private final JTextField tfInfBI   = new JTextField();
    private final JTextField tfInfCont = new JTextField();
    private final JTextField tfInfEnd  = new JTextField();
    private void buildCadInformadorCard() {
        JPanel p = new JPanel(new BorderLayout());
        p.add(new JLabel("Cadastrar Informador"), BorderLayout.NORTH);

        JPanel cen = new JPanel(new GridLayout(0,2,5,5));
        cen.add(new JLabel("Nome:"));     cen.add(tfInfNome);
        cen.add(new JLabel("BI:"));       cen.add(tfInfBI);
        cen.add(new JLabel("Contacto:")); cen.add(tfInfCont);
        cen.add(new JLabel("Endereço:")); cen.add(tfInfEnd);

        p.add(cen, BorderLayout.CENTER);

        JPanel bot = new JPanel();
        JButton btSalvar = new JButton("Salvar");
        JButton btVoltar = new JButton("Voltar");
        bot.add(btSalvar); bot.add(btVoltar);
        p.add(bot, BorderLayout.SOUTH);

        btVoltar.addActionListener(e -> cardLayout.show(mainPanel, "MENU"));
        btSalvar.addActionListener(e -> {
            Informador inf = new Informador(tfInfNome.getText(), tfInfBI.getText(), tfInfCont.getText(), tfInfEnd.getText());
            listaInformadores.add(inf);
            salvarInformadoresNoArquivo();
            JOptionPane.showMessageDialog(this,"Informador cadastrado!","Sucesso", JOptionPane.INFORMATION_MESSAGE);
            tfInfNome.setText(""); tfInfBI.setText(""); tfInfCont.setText(""); tfInfEnd.setText("");
        });

        cadInfPanel.add(p);
    }

    /* =========================================================
     *  CARD: listar informadores
     * ========================================================= */
    private final JTextArea taListInf = new JTextArea();
    private void buildListInformadorCard() {
        taListInf.setEditable(false);
        JButton voltar = new JButton("Voltar");
        voltar.addActionListener(e -> cardLayout.show(mainPanel, "MENU"));
        JPanel p = new JPanel(new BorderLayout());
        p.add(new JScrollPane(taListInf), BorderLayout.CENTER);
        p.add(voltar, BorderLayout.SOUTH);
        listInfPanel.add(p);
    }
    private void refreshListInformadores() {
        StringBuilder sb = new StringBuilder();
        for (Informador i : listaInformadores) sb.append(i).append("\n");
        if (sb.length()==0) sb.append("Nenhum informador cadastrado.");
        taListInf.setText(sb.toString());
    }

    /* =========================================================
     *  CARD: relatórios
     * ========================================================= */
    private final JComboBox<String> cbRelStatus = new JComboBox<>(new String[]{"Aberta","Fechada","Anulada"});
    private final JTextArea taRelResult = new JTextArea();
    private void buildRelatoriosCard() {
        taRelResult.setEditable(false);
        JPanel p = new JPanel(new BorderLayout());
        p.add(new JLabel("Relatórios"), BorderLayout.NORTH);

        JPanel top = new JPanel(new FlowLayout());
        top.add(new JLabel("Filtrar por Status:")); top.add(cbRelStatus);
        JButton btFiltrar = new JButton("Filtrar");
        top.add(btFiltrar);
        JButton btTotal = new JButton("Total Geral");
        top.add(btTotal);
        p.add(top, BorderLayout.NORTH);
        p.add(new JScrollPane(taRelResult), BorderLayout.CENTER);

        JButton voltar = new JButton("Voltar");
        voltar.addActionListener(e -> cardLayout.show(mainPanel, "MENU"));
        p.add(voltar, BorderLayout.SOUTH);

        btFiltrar.addActionListener(e -> {
            String status = (String)cbRelStatus.getSelectedItem();
            StringBuilder sb = new StringBuilder();
            int c=0;
            for (Ocorrencia o : arvore.getTodasOcorrencias()) {
                if (o.getStatus().equalsIgnoreCase(status)) { sb.append(o).append("\n"); c++; }
            }
            if (c==0) sb.append("Nenhuma ocorrência com status ").append(status);
            else sb.append("Total: ").append(c).append(" ocorrência(s)\n");
            taRelResult.setText(sb.toString());
        });
        btTotal.addActionListener(e -> taRelResult.setText("Total de ocorrências cadastradas: "+arvore.getCount()));

        relPanel.add(p);
    }

    /* =========================================================
     *  utilitários
     * ========================================================= */
    private void salvarInformadoresNoArquivo() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARQ_INFORMADORES))) {
            for (Informador i : listaInformadores) pw.println(i.toFileString());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,"Erro ao salvar informadores:\n"+ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }

    /* =========================================================
     *  main
     * ========================================================= */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeel());
            } catch (Exception ignored) {}
            new SwingApp().setVisible(true);
        });
    }
}