package sistema_biblioteca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import sistema_biblioteca.MainFrameAdmin;

public class MainFrameAdmin extends JFrame {
	
	private JDesktopPane desktopPane = new JDesktopPane();
	
public MainFrameAdmin() {
		
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

public MainFrameAdmin getThis(){
	return this;
}

private JMenuBar menuCreate() {
	
	JMenuBar menuBar = new JMenuBar();
	JMenu menuAssociados = new JMenu("Associados");
	JMenu menuAcervo = new JMenu("Acervo");
	JMenu menuEmprestimos = new JMenu("Empréstimos");
	JMenu menuSobre = new JMenu("Sobre");
	JMenu menuSair = new JMenu("Sair");
	JMenuItem menuCadAssociado = new JMenuItem("Cadastrar");
	JMenuItem menuListAssociado = new JMenuItem("Listar");

	JMenuItem menuCatalogAcervo = new JMenuItem("Catalogar");
	JMenuItem menuListAcervo = new JMenuItem("Listar");
	
	JMenuItem menuNovoEmprestimo = new JMenuItem("Novo Empréstimo");
	JMenuItem menuNovaReserva = new JMenuItem("Nova Reserva");
	JMenuItem menuListEmprestimo = new JMenuItem("Listar Empréstimos");
	JMenuItem menuListReserva = new JMenuItem("Listar Reservas");
	

	JMenuItem menuItemSobre = new JMenuItem("Sobre");

	menuAssociados.add(menuCadAssociado);
	menuAssociados.add(menuListAssociado);

	menuAcervo.add(menuCatalogAcervo);
	menuAcervo.add(menuListAcervo);
	//menuAcervo.add(menuBuscar);
	
	menuEmprestimos.add(menuNovoEmprestimo);
	menuEmprestimos.add(menuNovaReserva);
	menuEmprestimos.add(menuListEmprestimo);
	menuEmprestimos.add(menuListReserva);
	
	menuSobre.add(menuItemSobre);

	menuBar.add(menuAssociados);
	menuBar.add(menuAcervo);
	menuBar.add(menuEmprestimos);
	menuBar.add(menuSobre);
	
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
	
	menuNovaReserva.addActionListener (new ActionListener(){
		public void actionPerformed(ActionEvent e){
			new ReservaBusca();
		}
	});
	
	
	menuListEmprestimo.addActionListener (new ActionListener(){
		public void actionPerformed(ActionEvent e){
			new JTableEmprestimo();
			//JOptionPane.showMessageDialog(null, "Funcionou");
		}
	});
	
	menuListReserva.addActionListener (new ActionListener(){
		public void actionPerformed(ActionEvent e){
			new JTableReserva();
			//JOptionPane.showMessageDialog(null, "Funcionou");
		}
	});
	
	menuItemSobre.addActionListener (new ActionListener(){
		public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(null, "Feito por: \n"
					+ "Lucas Calixto - GU3002543\n"
					+ "Thiago Henrique - GU3001636\n"
					+ "Vinicius Ferrreira - GU3002519");
		}
	});

	return (menuBar);
	}
}
