package sistema_biblioteca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CadTCC extends JFrame {
	
	private JLabel lblCodigo = new JLabel("Código:");
	private JLabel lblTitulo = new JLabel("Título:");
	private JLabel lblAutor = new JLabel("Autor:");
	private JLabel lblPublicacao = new JLabel("Publicação:");
	private JLabel lblTombo = new JLabel("Tombo:");
	private JLabel lblPatrimonio = new JLabel("Patrimônio:");
	
	JTextField txtCodigo = new JTextField();
	JTextField txtTitulo = new JTextField();
	JTextField txtAutor = new JTextField();
	JTextField txtPublicacao = new JTextField();
    JTextField txtTombo = new JTextField();
    JTextField txtPatrimonio = new JTextField();
	
	protected JButton btnSalvar = new JButton ("Salvar");
	private JButton btnCancelar = new JButton ("Cancelar");
	
	public CadTCC(String Tipo){
		this.setTitle("Cadastro de " + Tipo);
		this.setBounds(300, 100, 300, 500);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		
		this.lblCodigo.setBounds(5,5,100,30);
		this.txtCodigo.setBounds(100,5,150,30);
		this.lblTitulo.setBounds(5,40,100,30);
		this.txtTitulo.setBounds(100,40,150,30);
		this.lblAutor.setBounds(5,75,100,30);
		this.txtAutor.setBounds(100,75,150,30);
		this.lblPublicacao.setBounds(5,110,100,30);
		this.txtPublicacao.setBounds(100,110,150,30);
		this.lblTombo.setBounds(5,145,100,30);
		this.txtTombo.setBounds(100,145,150,30);
		this.lblPatrimonio.setBounds(5,180,100,30);
		this.txtPatrimonio.setBounds(100,180,150,30);
		
		this.btnSalvar.setBounds(35,400,100,30);
		this.btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Acervo cadastro = new Acervo();
				TCC tcc = new TCC();
				Data data = new Data();
				
				cadastro.setCodigo_Acervo(txtCodigo.getText());
				cadastro.setTitulo(txtTitulo.getText());
				cadastro.setAutor(txtAutor.getText());
				cadastro.setPublicacao(txtPublicacao.getText());
				cadastro.setData_entrada(data.getData());
				cadastro.setTombo(txtTombo.getText());
				cadastro.setPatrimonio(txtPatrimonio.getText());
				cadastro.setTipo(Tipo);
				tcc.setFk_Acervo_Codigo_Acervo(txtCodigo.getText());
				cadastro.save();
				tcc.save();
				JOptionPane.showMessageDialog(null, "Cadastro realizado!");
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
		this.add(lblTitulo);
		this.add(txtTitulo);
		this.add(lblAutor);
		this.add(txtAutor);
		this.add(txtPublicacao);
		this.add(lblPublicacao);
		this.add(txtTombo);
		this.add(lblTombo);
		this.add(txtPatrimonio);
		this.add(lblPatrimonio);
		this.add(btnSalvar);
		this.add(btnCancelar);
	}
}
