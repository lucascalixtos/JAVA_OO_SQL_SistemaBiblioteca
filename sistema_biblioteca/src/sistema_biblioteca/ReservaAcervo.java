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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ReservaAcervo extends JFrame {
	
	private JLabel lblProntuario = new JLabel ("Prontuário:");
	private JLabel lblTitulo = new JLabel("Título:");
	private JLabel lblAutor = new JLabel("Autor:");
	private JLabel lblCodigoReserva = new JLabel("CodigoReserva:");
	private JLabel lblPatrimonio = new JLabel("Patrimônio:");
	private JLabel lblDataRealizacao = new JLabel("Data de Empréstimo:");
	
	JTextField txtProntuario;
	JTextField txtTitulo;
	JTextField txtAutor;
	JTextField txtPatrimonio;
	JTextField txtCodigoReserva;
	JTextField txtDataRealizacao;
	
	
	protected JButton btnConfirmar = new JButton ("Confirmar");
	private JButton btnCancelar = new JButton ("Cancelar");
	
	public ReservaAcervo(String Tipo, String[] Array) throws SQLException{
		
		
		this.setTitle("Reserva de " + Tipo);
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
		
		this.lblCodigoReserva.setBounds(5,145,100,30);
		this.txtCodigoReserva = new JTextField();
		this.txtCodigoReserva.setBounds(100,145,150,30);
		
		this.lblProntuario.setBounds(5,180,100,30);
		this.txtProntuario = new JTextField();
		this.txtProntuario.setBounds(100,180,150,30);
		
		this.lblDataRealizacao.setBounds(5,215,100,30);
		this.txtDataRealizacao = new JTextField();
		this.txtDataRealizacao.setBounds(100,215,150,30);
				
		this.btnConfirmar.setBounds(35,400,100,30);
		this.btnConfirmar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Data data = new Data();
				Reserva reserva = new Reserva();
				
				reserva.setCodigoAcervo(Array[0]);
				reserva.setNumeroReserva(txtCodigoReserva.getText());
				reserva.setProntuario(txtProntuario.getText());
				reserva.setDataReserva(data.getData());
				reserva.setDataRealizacao(txtDataRealizacao.getText());
				reserva.save();
			
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
		this.add(txtCodigoReserva);
		this.add(lblCodigoReserva);
		this.add(txtDataRealizacao);
		this.add(lblDataRealizacao);
		this.add(btnConfirmar);
		this.add(btnCancelar);
	}
}
