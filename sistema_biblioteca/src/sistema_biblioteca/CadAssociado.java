package sistema_biblioteca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class CadAssociado extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String[] tipoAssociado = {"Aluno", "Professor", "Servidor"};
	JComboBox cmbTipoAssociado = new JComboBox(tipoAssociado);
	String comboTipo;
	
	private JLabel lblNome = new JLabel("Nome");
	private JLabel lblTelefone = new JLabel("Telefone");
	private JLabel lblProntuario =  new JLabel("Prontuário");
	private JLabel lblSenha =  new JLabel("Senha");
	private JLabel lblEndereco =  new JLabel("Endereço"); 	
	
	private JTextField txtProntuario = new JTextField();
	private JTextField txtNome = new JTextField();
	private JTextField txtTelefone = new JTextField();
	private JTextField txtSenha = new JTextField();
	private JTextField txtEndereco = new JTextField();
	
	private JButton btnSalvar = new JButton ("Salvar");
	private JButton btnCancelar = new JButton ("Cancelar");
	
	public CadAssociado() {
		this.setTitle("Cadastro de Associado");
		this.setBounds(300, 300, 300, 280);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		
		this.lblProntuario.setBounds(5,5,100,30);
		this.txtProntuario.setBounds(100,5,150,30);
		
		this.lblNome.setBounds(5,40,100,30);
		this.txtNome.setBounds(100,40,150,30);
		
		this.lblEndereco.setBounds(5,75,100,30);
		this.txtEndereco.setBounds(100,75,150,30);
		
		this.lblTelefone.setBounds(5,110,100,30);
		this.txtTelefone.setBounds(100,110,150,30);
		
		this.lblSenha.setBounds(5,145,100,30);
		this.txtSenha.setBounds(100,145,150,30);
		
		this.cmbTipoAssociado.setSelectedIndex(1);
		this.cmbTipoAssociado.setBounds(100,180,150,30);
		this.cmbTipoAssociado.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				comboTipo = cmbTipoAssociado.getSelectedItem().toString();
			}
		});
		
		
		this.btnSalvar.setBounds(50,215,100,30);
		this.btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Associado cadastro = new Associado();
				cadastro.setProntuario(txtProntuario.getText());
				cadastro.setNome(txtNome.getText());
				cadastro.setEndereco(txtEndereco.getText());
				cadastro.setTelefone(txtTelefone.getText());
				cadastro.setTipo(comboTipo);
				cadastro.save();
				dispose();
				JOptionPane.showMessageDialog(null, "Cadastro realizado!");
				JTableAssociado.reloadJTable(JTableAssociado.jPanelTabela);

			}
		});
		
		this.btnCancelar.setBounds(160,215,100,30);
		this.btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
		
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
