package sistema_biblioteca;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class EditLivro extends EditAcervo{
	
	public EditLivro(String Tipo, String Acervo, int Codigo) {
		super(Tipo, Acervo, Codigo);
		
		JLabel lblISBN = new JLabel("ISBN:");
		JLabel lblEdicao = new JLabel("Edi��o:");
		JLabel lblEditora = new JLabel("Editora:") ;
		
		JTextField txtISBN = new JTextField();
		JTextField txtEdicao = new JTextField();
		JTextField txtEditora = new JTextField();
		
		lblISBN.setBounds(5,250,100,30);
		txtISBN.setBounds(100,250,150,30);
		lblEdicao.setBounds(5,285,100,30);
		txtEdicao.setBounds(100,285,150,30);
		lblEditora.setBounds(5,320,100,30);
		txtEditora.setBounds(100,320,150,30);
		
		add(lblISBN);
		add(txtISBN);
		add(lblEdicao);
		add(txtEdicao);
		add(lblEditora);
		add(txtEditora);
	}

}
