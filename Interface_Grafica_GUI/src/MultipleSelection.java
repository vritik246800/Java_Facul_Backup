import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class MultipleSelection extends JFrame
{
	private JList listaCores,copiaList;
	private JButton btnCopy;
	private String nomeCores[]=
		{
			"Black","Blue","Cyan","Dark Gray","Gray"
		};
	public MultipleSelection()
	{
		super("Teste de multipla escolha");
		Container cont=getContentPane();
		cont.setLayout(new FlowLayout());
		
		listaCores=new JList(nomeCores);
		listaCores.setVisibleRowCount(5);
		listaCores.setFixedCellHeight(15);
		listaCores.setSelectionMode
		(
			//ListSelectionModel.SINGLE_INTERVAL_SELECTION
			ListSelectionModel.MULTIPLE_INTERVAL_SELECTION
			//ListSelectionModel.SINGLE_SELECTION
		);
		cont.add(new JScrollPane(listaCores));
		btnCopy=new JButton("Copy >>>>");
		btnCopy.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					copiaList.setListData(listaCores.getSelectedValues());
				}
			}
		);
		cont.add(btnCopy);
		
		copiaList=new JList();
		copiaList.setVisibleRowCount(5);
		copiaList.setFixedCellHeight(10);
		copiaList.setFixedCellWidth(100);
		copiaList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cont.add(new JScrollPane(copiaList));
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	public static void main (String[]args)
	{
		new MultipleSelection();
	}
}
