package sistema_biblioteca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DevolucaoAcervo extends JFrame {
	
	private JLabel lblMsg = new JLabel("Deseja realizar a devolução deste item?");
	
	
	JTextField txtMsg;
	
		
	protected JButton btnSim = new JButton ("Sim");
	protected JButton btnNao = new JButton ("Não");
	
	
	public DevolucaoAcervo(String Id, String CodigoExemplar, int linha){
		
		
		this.setTitle("Devolução de Item");
		this.setBounds(300, 100, 450, 200);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		
		this.lblMsg.setBounds(100,40,500,30);
		
				
		this.btnSim.setBounds(100,80,100,30);
		this.btnSim.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ResultSet rs = new Exemplar().select("Codigo_Exemplar = " + CodigoExemplar);
				Exemplar exemplar = new Exemplar();
				
				try {
					while(rs.next()){
						exemplar.setCodigo(CodigoExemplar);
						exemplar.setQtd(rs.getInt(2)+1);
						exemplar.updateEmprestimo();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				Emprestimo emprestimo = new Emprestimo();
				emprestimo.setId(Id);
				emprestimo.delete();
				JTableEmprestimo.reloadJTable(JTableEmprestimo.jPanelTabela);
				dispose();
			}
		});
		
		this.btnNao.setBounds(210,80,100,30);
		this.btnNao.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
		
		

		this.add(lblMsg);
		this.add(btnSim);
		this.add(btnNao);
	}
}
