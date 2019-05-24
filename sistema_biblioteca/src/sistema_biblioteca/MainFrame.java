package sistema_biblioteca;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import sistema_biblioteca.MainFrame;

public class MainFrame extends JFrame {
	
	private JDesktopPane desktopPane = new JDesktopPane();
	
public MainFrame() {
		
		this.setTitle("Gerenciamento de Biblioteca");
		this.setBounds(0, 0, 500, 500);
		this.setLayout(null);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
	JMenu menuUsuarios = new JMenu("Usuários");
	JMenu menuAcervo = new JMenu("Acervo");
	JMenu menuEmprestimos = new JMenu("Empréstimos");
	JMenu menuSair = new JMenu("Sair");
	JMenuItem menuCadUsuario = new JMenuItem("Cadastrar");
	JMenuItem menuListUsuario = new JMenuItem("Listar");

	JMenuItem menuCatalogAcervo = new JMenuItem("Catalogar");
	JMenuItem menuListAcervo = new JMenuItem("Listar");
	
	JMenuItem menuNovoEmprestimo = new JMenuItem("Novo Empréstimo");
	JMenuItem menuListEmprestimo = new JMenuItem("Listar");

	JMenuItem menuBuscar = new JMenuItem("Buscar");

	menuUsuarios.add(menuCadUsuario);
	menuUsuarios.add(menuListUsuario);

	menuAcervo.add(menuCatalogAcervo);
	menuAcervo.add(menuListAcervo);
	menuAcervo.add(menuBuscar);
	
	menuEmprestimos.add(menuNovoEmprestimo);
	menuEmprestimos.add(menuListEmprestimo);

	menuBar.add(menuUsuarios);
	menuBar.add(menuAcervo);
	menuBar.add(menuEmprestimos);

	return (menuBar);
	}
}
