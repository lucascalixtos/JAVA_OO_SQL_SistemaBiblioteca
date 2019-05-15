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
	JMenu menuSair = new JMenu("Sair");
	JMenuItem menuCadUsuarios = new JMenuItem("Cadastro de Usuários");
	JMenuItem menuCatalogacao = new JMenuItem("Catalogação");
	JMenuItem menuBusca = new JMenuItem("Busca");


	menuUsuarios.add(menuCadUsuarios);
	
	menuAcervo.add(menuCatalogacao);
	menuAcervo.add(menuBusca);

	menuBar.add(menuUsuarios);
	menuBar.add(menuAcervo);

	return (menuBar);
}
}
