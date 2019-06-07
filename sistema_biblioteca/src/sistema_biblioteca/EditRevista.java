package sistema_biblioteca;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class EditRevista extends EditAcervo {

	public EditRevista(String Tipo, String Acervo, int Codigo) {
		super(Tipo, Acervo, Codigo);
		// TODO Auto-generated constructor stub
		
		JLabel lblEdicao = new JLabel("Edição:");
		
		JTextField txtEdicao = new JTextField();
		
		lblEdicao.setBounds(5,250,100,30);
		txtEdicao.setBounds(100,250,150,30);

		add(lblEdicao);
		add(txtEdicao);
	}

}
