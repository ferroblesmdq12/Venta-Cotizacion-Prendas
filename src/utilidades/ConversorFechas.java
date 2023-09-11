package utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConversorFechas {
	
	public static String dateToString(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
		return dateFormat.format(date);
	}
	
	public static Date StringToDate(String dateString) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
		Date date;
		try {
			date = dateFormat.parse(dateString);
			if(!dateToString(date).equals(dateString)) {
				date= null;
			}
		}catch (ParseException e) {
			date = null;
		}
		return date;
	}

}
