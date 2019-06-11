package sistema_biblioteca;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class
import java.util.Calendar;
import java.util.Date;

public class Data {
  public String getData() { 
	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-uuuu");
		String formattedDate = formatter.format(LocalDate.now());
		return formattedDate;
  } 
  
  public String Prazo(int dias){
	  Date data = new Date();
	  Calendar c = Calendar.getInstance();  
	  c.setTime(data);  
	  //Se vc precisa somar 30 e não um mes  
	  c.add(Calendar.DATE, dias);  
	  //Retorne sua data para o objeto java.util.Date  
	  Date devolucao = c.getTime();  
	  DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
	  String devolucaoFormatada = df.format(devolucao);
	  return devolucaoFormatada;
  }
}