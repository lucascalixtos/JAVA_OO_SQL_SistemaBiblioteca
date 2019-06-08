package sistema_biblioteca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EditAcervo extends JFrame {
	
	private JLabel lblTitulo = new JLabel("Título:");
	private JLabel lblAutor = new JLabel("Autor:");
	private JLabel lblPublicacao = new JLabel("Publicação:");
	private JLabel lblDataEntrada = new JLabel("Data de entrada:");
	private JLabel lblTombo = new JLabel("Tombo:");
	private JLabel lblPatrimonio = new JLabel("Patrimônio:");
	
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtPublicacao;
	private JTextField txtDataEntrada;
	private JTextField txtTombo;
	private JTextField txtPatrimonio;
	
	private JButton btnSalvar = new JButton ("Salvar");
	private JButton btnCancelar = new JButton ("Cancelar");
	
	public EditAcervo(String Tipo, String Codigo, int linha){
		this.setTitle("Edição de " + Tipo);
		this.setBounds(300, 100, 300, 500);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		
		this.lblTitulo.setBounds(5,40,100,30);
		this.txtTitulo = new JTextField((String) JTableAcervo.jTable.getValueAt(linha, 1));
		this.txtTitulo.setBounds(100,40,150,30);
		
		this.lblAutor.setBounds(5,75,100,30);
		this.txtAutor = new JTextField((String) JTableAcervo.jTable.getValueAt(linha, 2));
		this.txtAutor.setBounds(100,75,150,30);
		
		this.lblPublicacao.setBounds(5,110,100,30);
		this.txtPublicacao = new JTextField((String) JTableAcervo.jTable.getValueAt(linha, 3));
		this.txtPublicacao.setBounds(100,110,150,30);
		
		this.lblDataEntrada.setBounds(5,145,100,30);
		this.txtDataEntrada = new JTextField((String) JTableAcervo.jTable.getValueAt(linha, 7));
		this.txtDataEntrada.setBounds(100,145,150,30);
		
		this.lblTombo.setBounds(5,180,100,30);
		this.txtTombo = new JTextField((String) JTableAcervo.jTable.getValueAt(linha, 5));
		this.txtTombo.setBounds(100,180,150,30);
		
		this.lblPatrimonio.setBounds(5,215,100,30);
		this.txtPatrimonio = new JTextField((String) JTableAcervo.jTable.getValueAt(linha, 6));
		this.txtPatrimonio.setBounds(100,215,150,30);
		
		this.btnSalvar.setBounds(35,400,100,30);
		this.btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Acervo cadastro = new Acervo();
				cadastro.setCodigo_Acervo((String) JTableAcervo.jTable.getValueAt(linha, 0));
				cadastro.setTitulo(txtTitulo.getText());
				cadastro.setAutor(txtAutor.getText());
				cadastro.setPublicacao(txtPublicacao.getText());
				cadastro.setData_entrada(txtDataEntrada.getText());
				cadastro.setTombo(txtTombo.getText());
				cadastro.setPatrimonio(txtPatrimonio.getText());
				cadastro.setTipo((String) JTableAcervo.jTable.getValueAt(linha, 4));
				cadastro.update();
				dispose();
				JTableAcervo.reloadJTable(JTableAcervo.jPanelTabela);
			}
		});
		
		this.btnCancelar.setBounds(145,400,100,30);
		this.btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
		

		this.add(lblTitulo);
		this.add(txtTitulo);
		this.add(lblAutor);
		this.add(txtAutor);
		this.add(txtPublicacao);
		this.add(lblPublicacao);
		this.add(txtDataEntrada);
		this.add(lblDataEntrada);
		this.add(txtTombo);
		this.add(lblTombo);
		this.add(txtPatrimonio);
		this.add(lblPatrimonio);
		this.add(btnSalvar);
		this.add(btnCancelar);
	}
}
