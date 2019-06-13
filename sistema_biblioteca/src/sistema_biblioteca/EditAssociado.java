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

public class EditAssociado  extends JFrame{
	
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
	private JTextField txtSenha;
	private JTextField txtEndereco;
	
	private JButton btnSalvar = new JButton ("Salvar");
	private JButton btnCancelar = new JButton ("Cancelar");
	
	
	public EditAssociado(String Prontuario, int linha) {
		this.setTitle("Edição de Usuário");
		this.setBounds(300, 300, 300, 280);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		
		this.lblNome.setBounds(5,40,100,30);
		this.txtNome = new JTextField((String) JTableAssociado.jTable.getValueAt(linha, 1));
		this.txtNome.setBounds(100,40,150,30);
		
		this.lblEndereco.setBounds(5,75,100,30);
		this.txtEndereco = new JTextField((String) JTableAssociado.jTable.getValueAt(linha, 2));
		this.txtEndereco.setBounds(100,75,150,30);
		
		this.lblTelefone.setBounds(5,110,100,30);
		this.txtTelefone = new JTextField((String) JTableAssociado.jTable.getValueAt(linha, 3));
		this.txtTelefone.setBounds(100,110,150,30);
		
		this.lblTipo.setBounds(5,155,100,30);
		this.cmbTipoAssociado.setSelectedIndex(1);
		this.cmbTipoAssociado.setBounds(100,155,150,30);
		this.cmbTipoAssociado.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				comboTipo = cmbTipoAssociado.getSelectedItem().toString();
			}
		});
		
		
		this.btnSalvar.setBounds(50,210,100,30);
		this.btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Associado cadastro = new Associado();
				cadastro.setProntuario((String) JTableAssociado.jTable.getValueAt(linha, 0));
				cadastro.setNome(txtNome.getText());
				cadastro.setEndereco(txtEndereco.getText());
				cadastro.setTelefone(txtTelefone.getText());
				cadastro.setTipo(comboTipo);
				cadastro.update();
				JOptionPane.showMessageDialog(null, "Edição realizada!");
				dispose();
				JTableAssociado.reloadJTable(JTableAssociado.jPanelTabela);

			}
		});
		
		this.btnCancelar.setBounds(160,210,100,30);
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
		this.add(cmbTipoAssociado);
		this.add(btnSalvar);
		this.add(btnCancelar);
		
	}
	
	private void CloseEditAssociado(){
		this.setVisible(false);
		this.dispose();
	}

}
