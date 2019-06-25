package sistema_biblioteca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import sistema_biblioteca.Associado;

public class EditAssociadoUser  extends JFrame{
	
	//private JDesktopPane desktop = new JDesktopPane();
	String[] tipoAssociado = {"Aluno", "Professor", "Servidor"};
	JComboBox cmbTipoAssociado = new JComboBox(tipoAssociado);
	String comboTipo;
	
	private JLabel lblNome = new JLabel("Nome"); 
	private JLabel lblTelefone = new JLabel("Telefone");
	private JLabel lblSenha =  new JLabel("Senha");
	private JLabel lblEndereco =  new JLabel("Endereço");
	private JLabel lblTipo = new JLabel("Tipo");

	
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtEndereco;
	private JPasswordField txtSenha;
	
	private JButton btnSalvar = new JButton ("Salvar");
	private JButton btnCancelar = new JButton ("Cancelar");
	
	
	public EditAssociadoUser(String[] Array) {
		this.setTitle("Edição de Usuário");
		this.setBounds(300, 300, 300, 300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		
		this.lblNome.setBounds(5,40,100,30);
		this.txtNome = new JTextField( Array[1]);
		this.txtNome.setBounds(100,40,150,30);
		
		this.lblEndereco.setBounds(5,75,100,30);
		this.txtEndereco = new JTextField(Array[2]);
		this.txtEndereco.setBounds(100,75,150,30);
		
		this.lblTelefone.setBounds(5,110,100,30);
		this.txtTelefone = new JTextField(Array[3]);
		this.txtTelefone.setBounds(100,110,150,30);
		
		this.lblSenha.setBounds(5,145,100,30);
		this.txtSenha = new JPasswordField(Array[5]);
		this.txtSenha.setBounds(100,145,150,30);
		
		this.lblTipo.setBounds(5,185,100,30);
		this.cmbTipoAssociado.setSelectedIndex(1);
		this.cmbTipoAssociado.setBounds(100,185,150,30);
		comboTipo = Array[4];
		this.cmbTipoAssociado.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				comboTipo = cmbTipoAssociado.getSelectedItem().toString();
			}
		});
		
		
		this.btnSalvar.setBounds(50,230,100,30);
		this.btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Associado cadastro = new Associado();
				cadastro.setProntuario(Array[0]);
				cadastro.setNome(txtNome.getText());
				cadastro.setEndereco(txtEndereco.getText());
				cadastro.setTelefone(txtTelefone.getText());
				cadastro.setTipo(comboTipo);
				cadastro.setSenha(txtSenha.getText());
				cadastro.update();
				JOptionPane.showMessageDialog(null, "Edição realizada!");
				dispose();
				JTableAssociado.reloadJTable(JTableAssociado.jPanelTabela);

			}
		});
		
		this.btnCancelar.setBounds(160,230,100,30);
		this.btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
		
		this.add(lblNome);
		this.add(txtNome);
		this.add(lblEndereco);
		this.add(txtEndereco);
		this.add(lblTelefone);
		this.add(txtTelefone);
		this.add(lblTipo);
		this.add(txtSenha);
		this.add(lblSenha);
		this.add(cmbTipoAssociado);
		this.add(btnSalvar);
		this.add(btnCancelar);
		
	}
	
	private void CloseEditAssociado(){
		this.setVisible(false);
		this.dispose();
	}

}
