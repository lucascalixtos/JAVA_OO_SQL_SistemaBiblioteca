package sistema_biblioteca;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class CadUsuario extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblLogin;
	private JLabel lblSenha;
	
	private JTextField txtLogin;
	private JTextField txtSenha;
	
	private JButton btnSalvar = new JButton ("Salvar");
	
	public CadUsuario() {
		this.setTitle("Cadastro de Usuário");
		this.setBounds(300, 300, 300, 200);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		
		this.lblLogin = new JLabel("Login:");
		this.lblLogin.setBounds(5,5,100,30);
		this.txtLogin = new JTextField();
		this.txtLogin.setBounds(100,5,150,30);
		
		this.lblSenha = new JLabel("Senha:");
		this.lblSenha.setBounds(5,40,100,30);
		this.txtSenha = new JTextField();
		this.txtSenha.setBounds(100,40,150,30);
		
		//this.btnSalvar = new JButton("Salvar");
		this.btnSalvar.setBounds(100,75,100,30);
		
		this.add(lblLogin);
		this.add(txtLogin);
		this.add(lblSenha);
		this.add(txtSenha);
		this.add(btnSalvar);
	}
}
