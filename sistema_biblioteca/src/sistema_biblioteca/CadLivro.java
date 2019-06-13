package sistema_biblioteca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CadLivro extends CadAcervo{
	
	protected static Object txtISBN;

	public CadLivro(String Tipo) {
		super(Tipo);
		
		JLabel lblISBN = new JLabel("ISBN:");
		JLabel lblEdicao = new JLabel("Edição:");
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
		
		this.btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Acervo cadastro = new Acervo();
				cadastro.setCodigo_Acervo(txtCodigo.getText());
				cadastro.setTitulo(txtTitulo.getText());
				cadastro.setAutor(txtAutor.getText());
				cadastro.setPublicacao(txtPublicacao.getText());
				cadastro.setData_entrada(txtDataEntrada.getText());
				cadastro.setTombo(txtTombo.getText());
				cadastro.setPatrimonio(txtPatrimonio.getText());
				cadastro.setTipo(Tipo);
				
				Livro livro = new Livro();
				livro.setISBN(txtISBN.getText());
				livro.setEdicao(txtEdicao.getText());
				livro.setEditora(txtEditora.getText());
				livro.setFk_Acervo_Codigo_Acervo(txtCodigo.getText());
				
				cadastro.save();
				livro.save();
				JOptionPane.showMessageDialog(null, "Cadastro realizado!");
				dispose();
			}
		});
	}

}
