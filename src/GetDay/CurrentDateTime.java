package GetDay;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class CurrentDateTime {
   	private static Calendar calendar;
    public static String dd;
	public static String mm;
	public static String yyyy;
	private static String hr;
	private static String min;
	private static String sec;
	private static String pmam;
     public static String date;
     public static String time;
     public static Date today;
     public static java.sql.Date sqldate;

     public static void getDay()
     {
      
   	  calendar=Calendar.getInstance(TimeZone.getDefault());

   	  dd=String.valueOf(calendar.get(Calendar.DATE));
   	  mm=String.valueOf(calendar.get(Calendar.MONTH)+1);
   	  yyyy=String.valueOf(calendar.get(Calendar.YEAR));
 
   	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy hh.mm.ss aa");
	 time = dateFormat.format(new Date()).toString();
   	 
	 date = dd+"-"+mm+"-"+yyyy;
   	  try {
		today = new SimpleDateFormat("dd-mm-yyyy").parse(date);
		//time = (today.getTime()/1000/60/60)%24+":"+((today.getTime()/1000/60)%60)+":"+(today.getTime()/1000)%60;
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  sqldate = new java.sql.Date(CurrentDateTime.today.getTime());

   	  
     }
}
