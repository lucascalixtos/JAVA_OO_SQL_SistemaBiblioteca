package sistema_biblioteca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CancelaReserva extends JFrame {
	
	private JLabel lblMsg = new JLabel("Deseja cancelar a reserva deste item?");
	
	
	JTextField txtMsg;
	
		
	protected JButton btnSim = new JButton ("Sim");
	protected JButton btnNao = new JButton ("Não");
	
	
	public CancelaReserva(String NumeroReserva, int linha){
		
		
		this.setTitle("Cancelamento de Reserva");
		this.setBounds(300, 100, 450, 200);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		
		this.lblMsg.setBounds(100,40,500,30);
		
				
		this.btnSim.setBounds(100,80,100,30);
		this.btnSim.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				Reserva reserva = new Reserva();
				reserva.setNumeroReserva(NumeroReserva);
				reserva.delete();
				JTableReserva.reloadJTable(JTableReserva.jPanelTabela);
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
