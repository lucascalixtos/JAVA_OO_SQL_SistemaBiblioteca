package sistema_biblioteca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CadExemplar extends JFrame {
	
	private JLabel lblCodigo = new JLabel("Código:");
	private JLabel lblQuantidade = new JLabel("Quantidade:");
	private JLabel lblNF = new JLabel("Nota Fiscal:");
	
	JTextField txtCodigo = new JTextField();
	JTextField txtQuantidade = new JTextField();
	JTextField txtNF = new JTextField();
	
	protected JButton btnSalvar = new JButton ("Salvar");
	private JButton btnCancelar = new JButton ("Cancelar");
	
	public CadExemplar(String CodigoAcervo){
		
		this.setTitle("Cadastro de Exemplar");
		this.setBounds(300, 100, 300, 500);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		
		this.lblCodigo.setBounds(5,40,100,30);
		this.txtCodigo.setBounds(100,40,150,30);
		this.lblQuantidade.setBounds(5,75,100,30);
		this.txtQuantidade.setBounds(100,75,150,30);
		this.lblNF.setBounds(5,110,100,30);
		this.txtNF.setBounds(100,110,150,30);
		
		this.btnSalvar.setBounds(35,400,100,30);
		this.btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Exemplar cadastro = new Exemplar();
				cadastro.setCodigoAcervo(CodigoAcervo);
				cadastro.setCodigo(txtCodigo.getText());
				cadastro.setQuantidade(txtQuantidade.getText());
				cadastro.setNF(txtNF.getText());
				cadastro.save();
				dispose();
			}
		});
		
		this.btnCancelar.setBounds(145,400,100,30);
		this.btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
		
		this.add(lblCodigo);
		this.add(txtCodigo);
		this.add(lblQuantidade);
		this.add(txtQuantidade);
		this.add(txtNF);
		this.add(lblNF);
		this.add(btnSalvar);
		this.add(btnCancelar);
	}
}
