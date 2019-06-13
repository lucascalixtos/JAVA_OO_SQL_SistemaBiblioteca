package sistema_biblioteca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CadRevista extends CadAcervo {


	public CadRevista(String Tipo) {
		super(Tipo);
		// TODO Auto-generated constructor stub
		
		JLabel lblEdicao = new JLabel("Edição:");
		
		JTextField txtEdicao = new JTextField();
		
		lblEdicao.setBounds(5,250,100,30);
		txtEdicao.setBounds(100,250,150,30);

		add(lblEdicao);
		add(txtEdicao);
		
		this.btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Acervo cadastro = new Acervo();
				Data data = new Data();
				cadastro.setCodigo_Acervo(txtCodigo.getText());
				cadastro.setTitulo(txtTitulo.getText());
				cadastro.setAutor(txtAutor.getText());
				cadastro.setPublicacao(txtPublicacao.getText());
				cadastro.setData_entrada(data.getData());
				cadastro.setTombo(txtTombo.getText());
				cadastro.setPatrimonio(txtPatrimonio.getText());
				cadastro.setTipo(Tipo);
				
				Revista revista = new Revista();
				revista.setEdicao(txtEdicao.getText());
				revista.setFk_Acervo_Codigo_Acervo(txtCodigo.getText());
				
				cadastro.save();
				revista.save();
				JOptionPane.showMessageDialog(null, "Cadastro realizado!");
				dispose();
			}
		});
	}

}
