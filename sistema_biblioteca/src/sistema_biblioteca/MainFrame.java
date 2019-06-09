package sistema_biblioteca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import sistema_biblioteca.MainFrame;

public class MainFrame extends JFrame {
	
	private JDesktopPane desktopPane = new JDesktopPane();
	
public MainFrame() {
		
		this.setTitle("Gerenciamento de Biblioteca");
		this.setBounds(400, 100, 500, 500);
		this.setLayout(null);
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(this.menuCreate());
		
		this.add(desktopPane);
		desktopPane.setAutoscrolls(true);
		
		this.setVisible(true);
	}

public MainFrame getThis(){
	return this;
}

private JMenuBar menuCreate() {
	
	JMenuBar menuBar = new JMenuBar();
	JMenu menuAssociados = new JMenu("Associados");
	JMenu menuAcervo = new JMenu("Acervo");
	JMenu menuEmprestimos = new JMenu("Empréstimos");
	JMenu menuSair = new JMenu("Sair");
	JMenuItem menuCadAssociado = new JMenuItem("Cadastrar");
	JMenuItem menuListAssociado = new JMenuItem("Listar");

	JMenuItem menuCatalogAcervo = new JMenuItem("Catalogar");
	JMenuItem menuListAcervo = new JMenuItem("Listar");
	
	JMenuItem menuNovoEmprestimo = new JMenuItem("Novo Empréstimo");
	JMenuItem menuNovaReserva = new JMenuItem("Nova Reserva");
	JMenuItem menuDevolucao = new JMenuItem("Devolução");
	JMenuItem menuListEmprestimo = new JMenuItem("Listar");

	JMenuItem menuBuscar = new JMenuItem("Buscar");

	menuAssociados.add(menuCadAssociado);
	menuAssociados.add(menuListAssociado);

	menuAcervo.add(menuCatalogAcervo);
	menuAcervo.add(menuListAcervo);
	//menuAcervo.add(menuBuscar);
	
	menuEmprestimos.add(menuNovoEmprestimo);
	menuEmprestimos.add(menuNovaReserva);
	menuEmprestimos.add(menuDevolucao);
	menuEmprestimos.add(menuListEmprestimo);

	menuBar.add(menuAssociados);
	menuBar.add(menuAcervo);
	menuBar.add(menuEmprestimos);
	
	menuCadAssociado.addActionListener (new ActionListener(){
		public void actionPerformed(ActionEvent e){
			new CadAssociado();
		}
	});
	
	menuListAssociado.addActionListener (new ActionListener(){
		public void actionPerformed(ActionEvent e){
			new JTableAssociado();
		}
	});
	
	menuCatalogAcervo.addActionListener (new ActionListener(){
		public void actionPerformed(ActionEvent e){
			new TipoCadAcervo();
		}
	});
	
	menuListAcervo.addActionListener (new ActionListener(){
		public void actionPerformed(ActionEvent e){
			//JOptionPane.showMessageDialog(null, "Funcionou");
			new JTableAcervo();
		}
	});
	
	menuNovoEmprestimo.addActionListener (new ActionListener(){
		public void actionPerformed(ActionEvent e){
			new EmprestimoBusca();
		}
	});
	
	menuDevolucao.addActionListener (new ActionListener(){
		public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(null, "Funcionou");
		}
	});
	
	menuListEmprestimo.addActionListener (new ActionListener(){
		public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(null, "Funcionou");
		}
	});

	return (menuBar);
	}
}
