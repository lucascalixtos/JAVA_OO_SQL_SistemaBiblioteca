package sistema_biblioteca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EmprestimoAcervo extends JFrame {
	
	private JLabel lblTitulo = new JLabel("Título:");
	private JLabel lblAutor = new JLabel("Autor:");
	private JLabel lblPublicacao = new JLabel("Publicação:");
	private JLabel lblDataEntrada = new JLabel("Data de entrada:");
	private JLabel lblTombo = new JLabel("Tombo:");
	private JLabel lblPatrimonio = new JLabel("Patrimônio:");
	
	JTextField txtTitulo;
	JTextField txtAutor;
	JTextField txtPublicacao;
	JTextField txtDataEntrada;
	JTextField txtTombo;
	JTextField txtPatrimonio;
	
	
	protected JButton btnConfirmar = new JButton ("Confirmar");
	private JButton btnCancelar = new JButton ("Cancelar");
	
	public EmprestimoAcervo(String Tipo, String[] Array) throws SQLException{
		
		
		this.setTitle("Empréstimo de " + Tipo);
		this.setBounds(300, 100, 300, 500);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		
		this.lblTitulo.setBounds(5,40,100,30);
		this.txtTitulo = new JTextField(Array[1]);
		this.txtTitulo.setBounds(100,40,150,30);
		
		this.lblAutor.setBounds(5,75,100,30);
		this.txtAutor = new JTextField(Array[2]);
		this.txtAutor.setBounds(100,75,150,30);
		
		this.lblPublicacao.setBounds(5,110,100,30);
		this.txtPublicacao = new JTextField(Array[4]);
		this.txtPublicacao.setBounds(100,110,150,30);
		
		this.lblDataEntrada.setBounds(5,145,100,30);
		this.txtDataEntrada = new JTextField(Array[7]);
		this.txtDataEntrada.setBounds(100,145,150,30);
		
		this.lblTombo.setBounds(5,180,100,30);
		this.txtTombo = new JTextField(Array[5]);
		this.txtTombo.setBounds(100,180,150,30);
		
		this.lblPatrimonio.setBounds(5,215,100,30);
		this.txtPatrimonio = new JTextField(Array[6]);
		this.txtPatrimonio.setBounds(100,215,150,30);
				
		this.btnConfirmar.setBounds(35,400,100,30);
		this.btnConfirmar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Exemplar exemplar = new Exemplar();
				ResultSet rs = new Exemplar().select("fkAcervo_Codigo_Acervo = " + Array[0]);
				int Quantidade = 0;
				try {
					while(rs.next()){
						System.out.println("Quantidade: " + rs.getInt(2));
						Quantidade = rs.getInt(2) - 1;
						System.out.println("Quantidade: " + Quantidade);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
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
		this.add(btnConfirmar);
		this.add(btnCancelar);
	}
}
