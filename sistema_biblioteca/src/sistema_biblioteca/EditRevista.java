package sistema_biblioteca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class EditRevista extends EditAcervo {

	public EditRevista(String Tipo, String Acervo, int linha) {
		super(Tipo, Acervo, linha);
		// TODO Auto-generated constructor stub
		
		JLabel lblEdicao = new JLabel("Edição:");
		
		JTextField txtEdicao = new JTextField();
		
		lblEdicao.setBounds(5,250,100,30);
		txtEdicao.setBounds(100,250,350,30);

		add(lblEdicao);
		add(txtEdicao);
		
		this.btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Acervo cadastro = new Acervo();
				cadastro.setCodigo_Acervo((String) JTableAcervo.jTable.getValueAt(linha, 0));
				cadastro.setTitulo(txtTitulo.getText());
				cadastro.setAutor(txtAutor.getText());
				cadastro.setPublicacao(txtPublicacao.getText());
				cadastro.setData_entrada(txtDataEntrada.getText());
				cadastro.setTombo(txtTombo.getText());
				cadastro.setPatrimonio(txtPatrimonio.getText());
				cadastro.setTipo(Tipo);
				
				MidiaDigital revista = new MidiaDigital();
				revista.setTipo((String) JTableAcervo.jTable.getValueAt(linha, 0));
				revista.setFk_Acervo_Codigo_Acervo((String) JTableAcervo.jTable.getValueAt(linha, 0));
				
				cadastro.save();
				revista.save();
				dispose();
			}
		});
	}

}
