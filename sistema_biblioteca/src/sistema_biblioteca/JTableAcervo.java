package sistema_biblioteca;


import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class JTableAcervo extends JFrame{
	
	private static final long serialVersionUID = 1L;
	static JTable jTable = new JTable();
	private JPanel jPanelPesquisa = null;
	static JPanel jPanelTabela = null;
	
	private JLabel jLabelPesquisa   = null;
	private JTextField jTextPesquisa= null;
	private JButton jButtonPesquisa = null;
	private static JScrollPane scrollpane = null;
	private JButton btnInserir = new JButton("Inserir");
	
	
	public JTableAcervo() {
		this.setTitle("Acervo Cadastrado");
		this.setBounds(50, 50, 1000, 650);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		this.btnInserir.setBounds(5,400,200,50);
		this.add(btnInserir);
		
		
		this.jPanelPesquisa = new JPanel();
		this.jPanelPesquisa.setBounds(0, 0, 1000, 60);
		this.jPanelPesquisa.setLayout(null);
		
		this.jPanelTabela 	= new JPanel();
		this.jPanelTabela.setBounds(0, 101, 1000, 300);
		this.jPanelTabela.setLayout(new GridLayout(1,1));
		
		this.jLabelPesquisa   = new JLabel("Pesquisar");
		this.jLabelPesquisa.setBounds(5, 5, 100, 30);
		this.jTextPesquisa= new JTextField();
		this.jTextPesquisa.setBounds(110, 5, 500, 30);
		this.jButtonPesquisa = new JButton("Executar");
		this.jButtonPesquisa.setBounds(615, 5, 200, 30);
		
		this.jPanelPesquisa.add(jLabelPesquisa);
		this.jPanelPesquisa.add(jTextPesquisa);
		this.jPanelPesquisa.add(jButtonPesquisa);
		
		this.setLayout(null);
		
		this.add(jPanelPesquisa);
		this.add(jPanelTabela);
		
		this.jTable = montarJtable();
		this.scrollpane = new JScrollPane(this.jTable);
		this.jPanelTabela.add(scrollpane);
		
		this.setVisible(true);
		this.repaint();
		this.validate();

		
		jButtonPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jPanelTabela.remove(scrollpane);
				if (jTextPesquisa.getText().isEmpty()){
					jTable = montarJtable();
				}else{
					String where = jTextPesquisa.getText().replace("*", "%");
					
					
					
					jTable = montarJtable( "Titulo like '"+where+"' OR Autor like '"+where+
											"'OR Codigo_Acervo like '"+where+"'");	
				}
				
				scrollpane = new JScrollPane(jTable);
				jPanelTabela.add(scrollpane);
				validate();
				repaint();
			}
		});
		
		this.jTable.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
				
				String LivroMai = "Livro";
				String LivroMin = "livro";
				String RevistaMai = "Revista";
				String RevistaMin = "revista";
				String MidiaMin = "mídia digital";
				String MidiaMai = "Mídia Digital";
				String TCCMai = "TCC";
				String TCCMin = "tcc";

				int linha = jTable.getSelectedRow();
				
				//JOptionPane.showMessageDialog(null, jTable.getValueAt(linha, 0));
				String Acervo = (String) jTable.getValueAt(linha, 0);
				String Tipo = (String) jTable.getValueAt(linha, 4);
				
				
				System.out.println(Tipo+LivroMin);
				if(Tipo.equals(LivroMin) || Tipo.equals(LivroMai)) {
					new EditLivro(Tipo, Acervo, linha);
				}else if(Tipo.equals(RevistaMin) || Tipo.equals(RevistaMai)) {
					new EditRevista(Tipo, Acervo, linha);
				}else if(Tipo.equals(MidiaMin) || Tipo.equals(MidiaMai)) {
					new EditMidiaDigital(Tipo, Acervo, linha);
				}else if(Tipo.equals(TCCMin) || Tipo.equals(TCCMai)) {
					new EditAcervo(Tipo, Acervo, linha);
				}
				
			}
		});  
		
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new CadAcervo();
			}
		});
	}

	private static JTable montarJtable() {;
		return(montarJtable(""));
	}
	
	private static JTable montarJtable(String where) {
		JTable tmpTable = null;
		ResultSet rs = new Acervo().select(where);
		try {
			System.out.print(rs.next());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSetExtras rsExtras = new ResultSetExtras(rs);
		tmpTable = rsExtras.getjTable();
		return(tmpTable);
	}
	
	
	
	public static void main(String[] args) {
		new JTableAcervo();
	}
	
	public static void reloadJTable(JPanel jPanelTabela){
		jPanelTabela.remove(scrollpane);
		jTable = montarJtable();
		scrollpane = new JScrollPane(jTable);
		jPanelTabela.add(scrollpane);
		jPanelTabela.validate();
		jPanelTabela.repaint();
		
		jTable.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
				
				int linha = jTable.getSelectedRow();
				
				//JOptionPane.showMessageDialog(null, jTable.getValueAt(linha, 0));
				String idUsuario = (String) jTable.getValueAt(linha, 0);
				//new EditUsuarioInd(idUsuario, linha);
			}
		});
		
	}
	
	private static void closeJTable(){
		
	}
	
}
