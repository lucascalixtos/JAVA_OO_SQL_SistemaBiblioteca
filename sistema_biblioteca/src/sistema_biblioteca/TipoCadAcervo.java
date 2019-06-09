package sistema_biblioteca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TipoCadAcervo extends JFrame{
	
	JLabel lblTipo;
	
	private JButton btnLivro = new JButton("Livro");
	private JButton btnMidia = new JButton("M�dia Digital");
	private JButton btnRevista = new JButton("Revista");
	private JButton btnTCC = new JButton("TCC");
	
	public TipoCadAcervo() {
		this.setTitle("Cataloga��o de Acervo");
		this.setBounds(300, 100, 300, 250);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		
		this.lblTipo = new JLabel("Categoria: ");
		this.lblTipo.setBounds(100,5,100,30);
		
		this.btnLivro.setBounds(100,35,110,30);
		this.btnLivro.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
				new CadLivro("Livro");
			}
		});
		
		this.btnMidia.setBounds(100,70,110,30);
		this.btnMidia.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
				new CadMidiaDigital("M�dia Digital");
			}
		});
		
		this.btnRevista.setBounds(100,105,110,30);
		this.btnRevista.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
				new CadRevista("Revista");
			}
		});
		
		this.btnTCC.setBounds(100,140,110,30);
		this.btnTCC.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
				new CadAcervo("TCC");
			}
		});
		
		this.add(lblTipo);
		this.add(btnLivro);
		this.add(btnMidia);
		this.add(btnRevista);
		this.add(btnTCC);
	}
}
