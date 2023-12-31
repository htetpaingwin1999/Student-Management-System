package Handler;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	private static Pattern pattern;
	private static Matcher matcher;
	private static String dayvalidation[] = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
	private static String hrvalidation[] = {"1","2","3","4","5","6","7","8","9","10","11","12"}; 
	private static String minutevalidation[] = {"00","15","30","45","60"}; 
	private static String timevalidation[] = {"AM","PM"};
	private static String durationvalidation[] = {"days","month","months","year","years"}; 
	private static final String URL_REGEX =
			"^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
			"(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)" +
			"([).!';/?:,][[:blank:]])?$";
		
	private static final String timeTest = "(^([0-1]?[0-9]|2[0-3]):[0-5][0-9]-([0-1]?[0-9]|2[0-3]):([0-5][0-9])$)";
	private static final String nameTest="([A-Za-z]{1,30}[ ]{0,1}[A-Za-z]{1,30}[ ]{0,1}[A-Za-z]{1,30})";
	private static final String courseNameTest = "([A-Za-z]{1}[a-z#]{0,20}[ ]{0,1}[A-Z-a-z]{0,30}[ ]{0,1}[A-Z-a-z]{0,30})";
	private static final String productNameTest="([A-Za-z0-9- ]{1,20})";
	private static final String moneyTest="[1-9]{1}[0-9]{3,7}";
	private static final String fineTest="[1-9]{1}[0-9]{2,7}";
	private static final String qtyTest="[1-9]{1}[0-9]{0,2}";
	public static String passwordError;

	private static Pattern DATE_PATTERN = Pattern.compile(
		      "^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$");

	 public static boolean checkEmail(String email) {
	      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	      return email.matches(regex);
	 }
	 
    public static boolean checkDate(String date) {
        return DATE_PATTERN.matcher(date).matches();
    }
	public static boolean checkName(String name)
	{
		pattern=Pattern.compile(nameTest);
		matcher=pattern.matcher(name);
		return matcher.matches();
	}
	public static boolean checkCourseName(String name)
	{
		pattern=Pattern.compile(courseNameTest);
		matcher=pattern.matcher(name);
		return matcher.matches();
	}	
	public static boolean checkMoney(String money) //may be salary or fee
	{
		pattern=Pattern.compile(moneyTest);
		matcher=pattern.matcher(money+"");
		return matcher.matches();
	}
	public static boolean checkFine(String fine)
	{
		pattern=Pattern.compile(fineTest);
		matcher=pattern.matcher(fine+"");
		return matcher.matches();
	}
	
	public static boolean checkTime(String time)
	{
		pattern=Pattern.compile(timeTest);
		matcher=pattern.matcher(time+"");
		return matcher.matches();
	}
	
	private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
	
	  public static boolean checkPassword(String password) 
	  {
		  passwordError = "";
          if (password.length() > 15 || password.length() < 8)
          {
                  passwordError = "Password should be less than 15 and more than 8 characters in length.";
                  return false;
          }
          
          String upperCaseChars = "(.*[A-Z].*)";
          if (!password.matches(upperCaseChars ))
          {
        	  passwordError = "Password should contain atleast one upper case alphabet";
        	  return false;
          }
          String lowerCaseChars = "(.*[a-z].*)";
          if (!password.matches(lowerCaseChars ))
          {
        	  passwordError = "Password should contain atleast one lower case alphabet";
        	  return false;
          }
          String numbers = "(.*[0-9].*)";
          if (!password.matches(numbers ))
          {
        	  passwordError = "Password should contain atleast one number.";
        	  return false;
          }
          String specialChars = "(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
          if (!password.matches(specialChars ))
          {
        	  passwordError = "Password should contain atleast one special character";
        	  return false;
          }
          return true;
	    }
	  
	public static boolean checkPhone(String ph) {
//		String p = "09([0-9]{7}|[0-9]{9})";
		String p = "(09([0-9]{7}|[0-9]{9}))|(o2 ([0-9] {6}))";

		return Pattern.matches(p, ph);
	}

//	public static boolean checkName(String name) {
//		String n = "[a-zA-Z, ]+";
//		return Pattern.matches(n, name);
//	}
	
	public static boolean checkSectionOpenTime(String time)
	{
		int count = 0;
		
		if(time.contains(" ") && time.contains(":") && time.contains("-") && (time.contains("PM") || time.contains("AM")))
		{
			String par[] = time.split(" ");
			if(par.length==2)
			{
				String sectime[] = par[0].split("-");
				if(sectime.length==2)
				{

					String first[] = sectime[0].split(":");
					String second[] = sectime[1].split(":");
					if(first.length==2 && second.length ==2)
					{

						for(int i=0;i<hrvalidation.length;i++)
						{
							if(first[0].equals(hrvalidation[i]))
							{
								count++;
							}
							if(second[0].equals(hrvalidation[i]))
							{
								count++;
							}
						}
						for(int i=0;i<minutevalidation.length;i++)
						{
							if(first[1].equals(minutevalidation[i]))
							{
								count++;
							}
							if(second[1].equals(minutevalidation[i]))
							{
								count++;
							}
						}
						if(count==4)
						{
							
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	public static boolean checkDuration(String duration)
	{
		int count = 0;
		if(duration.contains(" "))
		{
			String d[] = duration.split(" ");
			try
			{
				for(int i=0;i<durationvalidation.length;i++)
				{
					if(d[1].equals(durationvalidation[i]))
					{
						count ++;
					}
				}
				int j = Integer.parseInt(d[0]);
				count++;
				if(count ==2)
				{
					return true;
				}

			}catch(Exception e)
			{
				return false;
			}
		}
		return false;
	}
	
	public static boolean checkImagePath(String path)
	{
		String[] p = path.split(".");
		if(path.contains(".jpg") || path.contains(".png"))
		{
			return true;
		}
		return false;
	}
	
	public static boolean checkLink(String url) {

		if (url == null) {
			return false;
		}

		Matcher matcher = URL_PATTERN.matcher(url);
		return matcher.matches();
	}
}