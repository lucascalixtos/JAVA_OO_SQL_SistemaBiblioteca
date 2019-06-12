package sistema_biblioteca;

  import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.*;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JTextField;

public class EmprestimoBusca extends JFrame {
	
	private JLabel lblTitulo = new JLabel("T�tulo:");
	private JLabel lblAutor = new JLabel("Autor:");
	private JLabel lblCodigo = new JLabel("C�digo:");
	
	private JTextField txtTitulo = new JTextField();
	private JTextField txtAutor = new JTextField();
	private JTextField txtCodigo = new JTextField();
	
	private JButton btnPesquisar1 = new JButton("Pesquisar");
	private JButton btnPesquisar2 = new JButton("Pesquisar");
	private JButton btnPesquisar3 = new JButton("Pesquisar");

	
	public EmprestimoBusca() {
		this.setTitle("Novo Empr�stimo");
		this.setBounds(300, 100, 500, 150);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		
		this.lblTitulo.setBounds(5,5,100,30);
		this.txtTitulo.setBounds(100,5,150,30);
		this.btnPesquisar1.setBounds(260,5,150,30);

		this.lblAutor.setBounds(5,40,100,30);
		this.txtAutor.setBounds(100,40,150,30);
		this.btnPesquisar2.setBounds(260,40,150,30);
		
		this.lblCodigo.setBounds(5,75,100,30);
		this.txtCodigo.setBounds(100,75,150,30);
		this.btnPesquisar3.setBounds(260,75,150,30);
		
		this.add(lblTitulo);
		this.add(txtTitulo);
		this.add(lblAutor);
		this.add(txtAutor);
		this.add(lblCodigo);
		this.add(txtCodigo);
		this.add(btnPesquisar1);
		this.add(btnPesquisar2);
		this.add(btnPesquisar3);
		
		this.btnPesquisar1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int i = 0;

				String where = "Titulo = '" + txtTitulo.getText().replace("*", "%") + "'";
				//System.out.println("\n"+where);
				ResultSet rs = new Acervo().select(where);
				ResultSetMetaData rsmd = null;
				try {
					rsmd = rs.getMetaData();
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				int rsColumnCount = 0;
				try {
					rsColumnCount = rsmd.getColumnCount();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				String[] Array = new String[rsColumnCount];
					try {
						while(rs.next()){
							while(i < rsColumnCount){
								Array[i] = rs.getString(i+1);
								System.out.println(" " + Array[i]);
								i++;
							}
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					try {
						new EmprestimoAcervo(Array[4], Array);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				dispose();
			}
		});
		
		this.btnPesquisar2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
		
		this.btnPesquisar3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});

	}


	
}