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

public class ReservaBusca extends JFrame {
	
	private JLabel lblTitulo = new JLabel("Título:");
	
	private JTextField txtTitulo = new JTextField();
	
	private JButton btnPesquisar1 = new JButton("Pesquisar");

	
	public ReservaBusca() {
		this.setTitle("Nova Reserva");
		this.setBounds(300, 100, 500, 100);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		
		this.lblTitulo.setBounds(5,5,100,30);
		this.txtTitulo.setBounds(100,5,150,30);
		this.btnPesquisar1.setBounds(260,5,150,30);

		this.add(lblTitulo);
		this.add(txtTitulo);
		this.add(btnPesquisar1);
		
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
						new ReservaAcervo(Array[4], Array);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				dispose();
			}
		});

	}


	
}
