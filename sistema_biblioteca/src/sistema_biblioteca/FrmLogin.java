package sistema_biblioteca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class FrmLogin extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel 			lblUsuario;
	private JLabel 			lblSenha;
	private JTextField 		txtUsuario;
	private JPasswordField 	txtSenha;
	private JButton 		btnAutenticar;
	private JLabel 			lblMessageErro;
	
	public FrmLogin() {
		this.setTitle("Realize sua autenticaÁ„o:");
		this.setBounds(300, 300, 300, 200);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		
		this.lblUsuario = new JLabel("Prontuario:");
		this.lblUsuario.setBounds(5,5,100,30); 
		
		this.txtUsuario = new JTextField();
		this.txtUsuario.setBounds(105,5,150,30);
		
		this.lblSenha	= new JLabel("Senha  :");
		this.lblSenha.setBounds(5,40,100,30); 
		
		this.txtSenha   = new JPasswordField();
		this.txtSenha.setBounds(105,40,150,30);
		
		this.btnAutenticar = new JButton("Entrar");
		this.btnAutenticar.setBounds(105,75,150,30);
		this.btnAutenticar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Associado usuario = new Associado();
				if ( usuario.checkLoginAdmin(txtUsuario.getText(), txtSenha.getText() )){
					JOptionPane.showMessageDialog(null, "Logado!");
					new MainFrameAdmin();
					closeFrmLogin();
				}else
				if ( usuario.checkLogin(txtUsuario.getText(), txtSenha.getText() )){
					JOptionPane.showMessageDialog(null, "Logado!");
					new MainFrameUser(txtUsuario.getText());
					closeFrmLogin();
				}else{
					JOptionPane.showMessageDialog(null, "N√£o Logado!");
					lblMessageErro.setText("Usuario ou Senha Inv√°lidos!");
				}
			}
		});
		
		this.lblMessageErro = new JLabel("Digite seu usu√°rio e senha!");
		this.lblMessageErro.setBounds(5,100,300,30);
		
		
		this.add(this.lblUsuario);
		this.add(this.txtUsuario);
		this.add(this.lblSenha);
		this.add(this.txtSenha);
		this.add(this.btnAutenticar);
		this.add(this.lblMessageErro);
		
		this.setVisible(true);
	}

	public void closeFrmLogin() {
		this.setVisible(false);
		this.dispose();
	}
	
	
	
}
