import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class JanelaNovoAgente extends JFrame 
{
	private Container cont;
	private JLabel nomeCliente, tipProcesso, numTransacoes, codigo, valTransacao, txt_cod, 
	tipCartao, numRegistos, numRecarga, valRecarga;
	private JTextField txt_agente, txt_numtransacoes, txt_valtransacao, txt_numregistos, txt_numrecarga, txt_valrecarga;
	private JRadioButton rb_comerciante, rb_registo, rb_vendedor, rb_esim, rb_fisico;
	private ButtonGroup bg_tipoAgent, bg_tipoCompra;
	private JButton bt_gravar, bt_voltar;
	private JPanel painel1, painel2;
	public static int cod = 0;

	public JanelaNovoAgente(Vector v) 
	{
		super("Registo de Agente");
		cont = getContentPane();
		setLayout(new GridLayout(10,2));
		
		codigo = new JLabel("Codigo:");
		nomeCliente = new JLabel("Nome do Agente/Estabelecimento:");
		tipProcesso = new JLabel("Tipo de Agente:");
		numTransacoes = new JLabel("Numero de Transacoes/Cod Comerciante:");
		valTransacao = new JLabel("Valor Transacao:");
		tipCartao = new JLabel("Tipo de cart�o/ Tipo de registo:");
		numRegistos = new JLabel("Numero de Registos");
		numRecarga = new JLabel("Numero de Recargas/Numero de vendas:");
		valRecarga = new JLabel("Valor Recarga:");
		cod = v.size()+1;
		
		
		txt_agente = new JTextField(20);
		txt_numtransacoes = new JTextField(20);	
		txt_cod = new JLabel(cod+"");	
		rb_comerciante = new JRadioButton("Comerciante");
		rb_registo = new JRadioButton("Registo");
		rb_vendedor = new JRadioButton("Vendedor");
		rb_esim = new JRadioButton("e-Sim");		
		rb_fisico = new JRadioButton("Fisico");		
		txt_valtransacao = new JTextField(20);		
		txt_numregistos = new JTextField(20);	
		txt_numrecarga = new JTextField(20);
		txt_valrecarga = new JTextField(20);	
		
		//desactiva todos campos associados
		txt_numtransacoes.setEnabled(false);
		txt_valtransacao.setEnabled(false);
		rb_esim.setEnabled(false);
		rb_fisico.setEnabled(false);
		txt_numregistos.setEnabled(false);
		txt_numrecarga.setEnabled(false);
		txt_valrecarga.setEnabled(false);
		
		bg_tipoAgent = new ButtonGroup();
		bg_tipoAgent.add(rb_comerciante);
		bg_tipoAgent.add(rb_registo);
		bg_tipoAgent.add(rb_vendedor);
		
		painel1 = new JPanel();
		painel1.add(rb_comerciante);
		painel1.add(rb_registo);
		painel1.add(rb_vendedor);
		
		bg_tipoCompra = new ButtonGroup();
		bg_tipoCompra.add(rb_esim);
		bg_tipoCompra.add(rb_fisico);
		
		painel2 = new JPanel();
		painel2.add(rb_esim);
		painel2.add(rb_fisico);
		
		//desbloqueio dos campos associados ao comerciante
		rb_comerciante.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent iv) 
			{
				txt_numtransacoes.setEnabled(true);
				txt_valtransacao.setEnabled(true);
				rb_esim.setEnabled(false);
				rb_fisico.setEnabled(false);
				txt_numregistos.setEnabled(false);
				txt_numrecarga.setEnabled(false);
				txt_valrecarga.setEnabled(false);
			}
			
		});
		
		//desbloqueio dos campos associados ao registo
		rb_registo.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent iv) 
			{
				txt_numtransacoes.setEnabled(false);
				txt_valtransacao.setEnabled(false);
				rb_esim.setEnabled(true);
				rb_fisico.setEnabled(true);
				txt_numregistos.setEnabled(true);
				txt_numrecarga.setEnabled(false);
				txt_valrecarga.setEnabled(false);
			}
			
		});
		
		//desbloqueio dos campos associados ao vendedor
		rb_vendedor.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent iv) 
			{
				txt_numtransacoes.setEnabled(false);
				txt_valtransacao.setEnabled(false);
				rb_esim.setEnabled(false);
				rb_fisico.setEnabled(false);
				txt_numregistos.setEnabled(false);
				txt_numrecarga.setEnabled(true);
				txt_valrecarga.setEnabled(true);
			}
			
		});
		
		//tratamento de eventos dos botoes gravar e sair
		bt_gravar = new JButton("Gravar");
		bt_gravar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int c = Integer.parseInt(txt_cod.getText());
				String n = txt_agente.getText();
				String tipo = "";
				char tipAg;
				float valCom=0;
				
				if(rb_comerciante.isSelected()) 
				{
					tipo = "Comerciante";
					tipAg = tipo.charAt(0);
					int codCom = Integer.parseInt(txt_numtransacoes.getText());
					int valTrans = Integer.parseInt(txt_valtransacao.getText());
					valCom = 0.05f * valTrans;
					criarObjectoComerciante(c,n,tipAg,valCom,codCom,valTrans);
				}
				else
				{
					if(rb_registo.isSelected()) 
					{
						tipo = "Registo";
						tipAg = tipo.charAt(0);
						char tipCart = ' ';
						byte numReg = Byte.parseByte(txt_numregistos.getText());
						
						if(rb_esim.isSelected()) 
						{
							tipCart = 'E';
							valCom = 0.02f * (numReg * 100);
						}
						else 
							if(rb_fisico.isSelected()) 
							{
								tipCart = 'F';
								valCom = 0.02f * (numReg * 20);
							}
						criarObjectoRegisto(c,n,tipAg,valCom,tipCart,numReg);
					}
					else
						if(rb_vendedor.isSelected()) 
						{
							tipo = "Vendedor";
							tipAg = tipo.charAt(0);
							byte nR = Byte.parseByte(txt_numrecarga.getText());
							byte vR = Byte.parseByte(txt_valrecarga.getText());
							valCom = 0.03f * (nR * vR);
							criarObjectoVendedor(c,n,tipAg,valCom,nR,vR);
						}
				}
				cod++;
				JOptionPane.showMessageDialog(null,"Novo Agente criado com sucesso");
			}

			private void criarObjectoVendedor(int c, String n, char tipAg, float valCom, byte nR, byte vR) {
				AgenteVendedor av = new AgenteVendedor(c,n,tipAg,valCom,nR,vR);
				v.add(av);
				v.trimToSize();
			}

			private void criarObjectoRegisto(int c, String n, char tipAg, float valCom, char tipCart, byte numReg) {
				AgenteRegisto ar = new AgenteRegisto(c,n,tipAg,valCom,tipCart,numReg);
				v.add(ar);
				v.trimToSize();
			}

			private void criarObjectoComerciante(int cod, String n, char tipAg, float valCom, int codCom,
					int valTrans) {
				AgenteComerciante ac = new AgenteComerciante(cod,n,tipAg,valCom,codCom,valTrans);
				v.add(ac);
				v.trimToSize();
			}
		});
		
		bt_voltar = new JButton("Voltar");
		bt_voltar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
			}
		});
		
		cont.add(codigo);
		cont.add(txt_cod);
		cont.add(nomeCliente);
		cont.add(txt_agente);
		cont.add(tipProcesso);
		cont.add(painel1);
		cont.add(numTransacoes);
		cont.add(txt_numtransacoes);
		cont.add(valTransacao);
		cont.add(txt_valtransacao);
		cont.add(tipCartao);
		cont.add(painel2);
		cont.add(numRegistos);
		cont.add(txt_numregistos);
		cont.add(numRecarga);
		cont.add(txt_numrecarga);
		cont.add(valRecarga);		
		cont.add(txt_valrecarga);
		cont.add(bt_gravar);
		cont.add(bt_voltar);
		
		setSize(800, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}

