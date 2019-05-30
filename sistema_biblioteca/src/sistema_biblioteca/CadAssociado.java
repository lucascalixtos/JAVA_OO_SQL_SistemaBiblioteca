package sistema_biblioteca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class CadAssociado extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String[] tipoAssociado = {"Aluno", "Professor", "Servidor"};
	JComboBox cmbTipoAssociado = new JComboBox(tipoAssociado);
	
	private JLabel lblNome;
	private JLabel lblTelefone;
	private JLabel lblProntuario;
	private JLabel lblSenha;
	private JLabel lblEndereco; 	
	
	private JTextField txtProntuario;
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtSenha;
	private JTextField txtEndereco;

	
	private JButton btnSalvar = new JButton ("Salvar");
	private JButton btnCancelar = new JButton ("Cancelar");
	
	public CadAssociado() {
		this.setTitle("Cadastro de Associado");
		this.setBounds(300, 300, 300, 280);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		
		this.lblProntuario = new JLabel("Prontuário:");
		this.lblProntuario.setBounds(5,5,100,30);
		this.txtProntuario = new JTextField();
		this.txtProntuario.setBounds(100,5,150,30);
		
		this.lblNome = new JLabel("Nome:");
		this.lblNome.setBounds(5,40,100,30);
		this.txtNome = new JTextField();
		this.txtNome.setBounds(100,40,150,30);
		
		this.lblEndereco = new JLabel("Endereço:");
		this.lblEndereco.setBounds(5,75,100,30);
		this.txtEndereco = new JTextField();
		this.txtEndereco.setBounds(100,75,150,30);
		
		this.lblTelefone = new JLabel("Telefone:");
		this.lblTelefone.setBounds(5,110,100,30);
		this.txtTelefone = new JTextField();
		this.txtTelefone.setBounds(100,110,150,30);
		
		this.lblSenha = new JLabel("Senha:");
		this.lblSenha.setBounds(5,145,100,30);
		this.txtSenha = new JTextField();
		this.txtSenha.setBounds(100,145,150,30);
		
		this.cmbTipoAssociado.setSelectedIndex(1);
		this.cmbTipoAssociado.setBounds(100,180,150,30);
		this.cmbTipoAssociado.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
		
		
		this.btnSalvar = new JButton("Salvar");
		this.btnSalvar.setBounds(50,215,100,30);
		
		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.setBounds(160,215,100,30);
		
		this.add(lblProntuario);
		this.add(txtProntuario);
		this.add(lblNome);
		this.add(txtNome);
		this.add(lblEndereco);
		this.add(txtEndereco);
		this.add(lblTelefone);
		this.add(txtTelefone);
		this.add(lblSenha);
		this.add(txtSenha);
		this.add(cmbTipoAssociado);
		this.add(btnSalvar);
		this.add(btnCancelar);
	}
}
