package sistema_biblioteca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class CadMidiaDigital extends CadAcervo {

	public CadMidiaDigital(String Tipo) {
		super(Tipo);
		// TODO Auto-generated constructor stub
		
		JLabel lblTipo = new JLabel("Tipo:");
		
		JTextField txtTipo = new JTextField();
		
		lblTipo.setBounds(5,250,100,30);
		txtTipo.setBounds(100,250,150,30);

		add(lblTipo);
		add(txtTipo);
		
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
				
				MidiaDigital midia = new MidiaDigital();
				midia.setTipo(txtTipo.getText());
				midia.setFk_Acervo_Codigo_Acervo(txtCodigo.getText());
				
				cadastro.save();
				midia.save();
				dispose();
			}
		});
	}

}
