package sistema_biblioteca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EmprestimoAcervo extends JFrame {
	
	private JLabel lblProntuario = new JLabel ("Prontuário:");
	private JLabel lblTitulo = new JLabel("Título:");
	private JLabel lblAutor = new JLabel("Autor:");
	private JLabel lblId = new JLabel("Id:");
	private JLabel lblPatrimonio = new JLabel("Patrimônio:");
	
	JTextField txtProntuario;
	JTextField txtTitulo;
	JTextField txtAutor;
	JTextField txtPatrimonio;
	JTextField txtId;
	
	
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
		
		this.lblPatrimonio.setBounds(5,110,100,30);
		this.txtPatrimonio = new JTextField(Array[6]);
		this.txtPatrimonio.setBounds(100,110,150,30);
		
		this.lblId.setBounds(5,145,100,30);
		this.txtId = new JTextField();
		this.txtId.setBounds(100,145,150,30);
		
		this.lblProntuario.setBounds(5,180,100,30);
		this.txtProntuario = new JTextField();
		this.txtProntuario.setBounds(100,180,150,30);
				
		this.btnConfirmar.setBounds(35,400,100,30);
		this.btnConfirmar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Exemplar exemplar = new Exemplar();
				Associado verificacao = new Associado();
				Emprestimo emprestimo = new Emprestimo();
				Data data = new Data();
				ResultSet rs = new Exemplar().select("fkAcervo_Codigo_Acervo = " + Array[0]);
				
				try {
					while(rs.next()) {
						try {
							String CodigoExemplar = rs.getString(1);
							exemplar.setCodigo(rs.getString(1));
							exemplar.setQtd(rs.getInt(2)-1);
							exemplar.updateEmprestimo();
							
							
							rs = new Associado().select("Prontuario = "+txtProntuario.getText());
							
							while(rs.next()){
								if(rs.getString(5).equals("Aluno")){
									emprestimo.setAssociadoProntuario(txtProntuario.getText());
									emprestimo.setId(txtId.getText());
									emprestimo.setCodigoExemplar(CodigoExemplar);
									emprestimo.setDataEmprestimo(data.getData());
									emprestimo.setDataDevolucao(data.Prazo(7));
									emprestimo.save();
								}
								else if(rs.getString(5).equals("Professor")){
									emprestimo.setAssociadoProntuario(txtProntuario.getText());
									emprestimo.setId(txtId.getText());
									emprestimo.setCodigoExemplar(CodigoExemplar);
									emprestimo.setDataEmprestimo(data.getData());
									emprestimo.setDataDevolucao(data.Prazo(10));
									emprestimo.save();
								}
								else if(rs.getString(5).equals("Servidor")){
									emprestimo.setAssociadoProntuario(txtProntuario.getText());
									emprestimo.setId(txtId.getText());
									emprestimo.setCodigoExemplar(CodigoExemplar);
									emprestimo.setDataEmprestimo(data.getData());
									emprestimo.setDataDevolucao(data.Prazo(14));
									emprestimo.save();
								}
							}
							
							
							
					} catch (SQLException e2) { 
						// TODO Auto-generated catch block
						e2.printStackTrace();
						}
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				

				int Quantidade = 0;
				try {
					while(rs.next()){
						System.out.println("Quantidade: " + rs.getInt(2));
						Quantidade = rs.getInt(2) - 1;
	
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
		this.add(lblProntuario);
		this.add(txtProntuario);
		this.add(txtPatrimonio);
		this.add(lblPatrimonio);
		this.add(txtId);
		this.add(lblId);
		this.add(btnConfirmar);
		this.add(btnCancelar);
	}
}
