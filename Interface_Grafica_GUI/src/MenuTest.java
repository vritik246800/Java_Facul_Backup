import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.event.*;

public class MenuTest extends JFrame
{
    private JMenuBar bar;
    //Declarar barra de menu que fica em cima
    private JMenu fileMenu,formatMenu,colorMenu,fontMenu;
    //declarar o que vai ficar na barra de menu como EDICAO neste caso
    private JMenuItem aboutItem,exitItem;
    //declarar o que vai ficar na barra de menu como Item
    private Color[] colorValues=
    {
        Color.BLACK,Color.BLUE,Color.RED,Color.GREEN
    };
    //declarar um array de constant de CORES
    private String[] colors=
    {
        "Black","Blue","Red","Green"
    };
    //declarar um array de nomes para cores
    private String[] fontNames=
    {
        "Serif","Monospaced","SansSerif"
    };
    //declarar um array de nomes para font
    private String[] styleNames=
    {
        "Bold","Italic"
    };
    //declarar um array de nomes para tipo de estilo de texto
    private JRadioButtonMenuItem colorItem[],font[];
    //declarar um array de radio butao para opcao de menu
    private JCheckBoxMenuItem styleItem[];
    //declarar um array check box para opcao de menu
    private JLabel displayLabel;
    //declaracao de um label
    private ButtonGroup fontGroup,colorGroup;
    //declaracao de grupo de butao
    private int style;
    //declaracao de inteiro 
    private Container cc;
    //declaracao de container

    public MenuTest()
    {
        super("Teste JMenu");
        //criar bara de menu
        bar=new JMenuBar();
        setJMenuBar(bar);
        //definir File menu e itens menu
        fileMenu=new JMenu("File");
        fileMenu.setMnemonic('F');
        //define About.. menu item
        aboutItem=new JMenuItem("About...");
        aboutItem.setMnemonic('A');
        aboutItem.addActionListener
        (
            new ActionListener() 
            {
                public void actionPerformed(ActionEvent event)
                {
                    JOptionPane.showMessageDialog(MenuTest.this,"Isso e um exemplo\nde uso de Menu","About",JOptionPane.PLAIN_MESSAGE);
                }
            }
        );
        fileMenu.add(aboutItem);
        //define Exit Menu Item
        exitItem=new JMenuItem("Exit");
        exitItem.setMnemonic('X');
        exitItem.addActionListener
        (
            new ActionListener() 
            {
                public void actionPerformed(ActionEvent event)
                {
                    System.exit(0);
                }
            }
        );
        fileMenu.add(exitItem);
        bar.add(fileMenu);
        //criar format menu, com submenus e itens do menu
        formatMenu=new JMenu("Format");
        formatMenu.setMnemonic('r');
        //criar Color submenu
        colorMenu=new JMenu("Color");
        colorMenu.setMnemonic('C');
        colorItem=new JRadioButtonMenuItem[colors.length];
        colorGroup=new ButtonGroup();

        TrataEv tr=new TrataEv();

        //cria botoes de Radio do menu Color
        for(int i=0;i<colors.length;i++)
        {
            colorItem[i]=new JRadioButtonMenuItem(colors[i]);
            colorMenu.add(colorItem[i]);
            colorGroup.add(colorItem[i]);
            colorItem[i].addActionListener(tr);
        }
        //activa 1-o item do menu Color
        colorItem[0].setSelected(true);
        //adiciona color sub menu a menu format
        formatMenu.add(colorMenu);
        // criar Fonte menu
        fontMenu=new JMenu("Font");
        fontMenu.setMnemonic('n');
        font=new JRadioButtonMenuItem[fontNames.length];
        fontGroup=new ButtonGroup();

        // criar botoes de radio para Fontes menu itens
        for(int i=0;i<font.length;i++)
        {
            font[i]=new JRadioButtonMenuItem(fontNames[i]);
            fontGroup.add(font[i]);
            font[i].addActionListener(tr);
        }
        //seleciona 1-o item do menu Font
        font[0].setSelected(true);
        fontMenu.addSeparator();

        styleItem=new JCheckBoxMenuItem[styleNames.length];
        TratarEstilos styleTr=new TratarEstilos();
        //cria itens de estilos com checkbox
        for(int i=0;i<styleNames.length;i++)
        {
            styleItem[i]=new JCheckBoxMenuItem(styleNames[i]);
            fontMenu.add(styleItem[i]);
            styleItem[i].addItemListener(styleTr);
        }
        formatMenu.add(fontMenu);
        //adiciona Format menu a bara de Menu
        bar.add(formatMenu);
        displayLabel=new JLabel("Teste de Texto",SwingConstants.CENTER);
        displayLabel.setForeground(colorValues[0]);
        displayLabel.setFont(new Font("TimesRoman",Font.PLAIN,72));
        
        cc=getContentPane();
        cc.setBackground(Color.cyan);
        cc.add(displayLabel,BorderLayout.CENTER);
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public static void main(String[]args)
    {
        new MenuTest();
    }
    private class TrataEv implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            //processo a selecao de cores
            for(int i=0;i<colorItem.length;i++)
            {
                if(colorItem[i].isSelected())
                {
                    displayLabel.setForeground(colorValues[i]);
                    break;
                }
            }
            //processa a selecao da fonte
            for(int i=0;i<font.length;i++)
            {
                if(event.getSource()==font[i])
                {
                    displayLabel.setFont(new Font(font[i].getText(),style,72));
                    break;
                }
                repaint();
            }
        }
    }
    private class TratarEstilos implements ItemListener
    {
        public void itemStateChanged(ItemEvent e)
        {
            style=0;
            if(styleItem[0].isSelected())
                style+=Font.BOLD;
            if(styleItem[1].isSelected())
                style+=Font.ITALIC;
            displayLabel.setFont(new Font(displayLabel.getFont().getName(),style,72));
            repaint();
        }
    }
}
