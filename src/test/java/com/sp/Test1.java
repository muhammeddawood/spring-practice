package com.sp;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Test1 {
	
	@Test
	public void testSpring() throws ParseException {
		//DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
		//XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
		//xmlBeanDefinitionReader.loadBeanDefinitions(new FileSystemResource("src/main/resources/applicationContext.xml"));
		
		/*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Triangle triangle = (Triangle)applicationContext.getBean("triangle");
		triangle.draw();
		
		boolean inDaylightTime = TimeZone.getTimeZone( "America/Denver").inDaylightTime( new SimpleDateFormat("dd/MM/yyyy").parse("17/03/2012") );
		System.out.println(inDaylightTime);
		
		TimeZone mntTz = TimeZone.getTimeZone("US/Mountain");
		TimeZone arzTz = TimeZone.getTimeZone("US/Arizona");
		
		GregorianCalendar mntGc = new GregorianCalendar(mntTz);
		GregorianCalendar arzGc = new GregorianCalendar(arzTz);
		
		mntGc.set(2011, 2, 12, 2, 30, 0);
		mntGc.set(mntGc.MILLISECOND, 0);
		arzGc.set(2011, 2, 12, 2, 30, 0);
		arzGc.set(arzGc.MILLISECOND, 0);
		
		for(int dayOffset = 0; dayOffset < 3; dayOffset++) {
			mntGc.add(Calendar.DAY_OF_MONTH, dayOffset);
			
			System.out.println(mntGc.get(Calendar.HOUR) + " : " + mntGc.get(Calendar.MINUTE)
					+ " : " + mntGc.getTimeInMillis()  + " : " + mntGc.getTime());
		}
		
		mntGc.set(Calendar.HOUR, 3);
		
		System.out.println(mntGc.get(Calendar.HOUR) + " : " + mntGc.get(Calendar.MINUTE)
				+ " : " + mntGc.getTimeInMillis()  + " : " + mntGc.getTime());
		System.out.println("\n\n");
		
		for(int dayOffset = 0; dayOffset < 3; dayOffset++) {
			arzGc.add(Calendar.DAY_OF_MONTH, dayOffset);
			
			System.out.println(arzGc.get(Calendar.HOUR) + " : " + arzGc.get(Calendar.MINUTE)
					+ " : " + arzGc.getTimeInMillis()  + " : " + arzGc.getTime());
		}
		
		arzGc.set(Calendar.HOUR, 3);
		
		System.out.println(arzGc.get(Calendar.HOUR) + " : " + arzGc.get(Calendar.MINUTE)
				+ " : " + arzGc.getTimeInMillis() + " : " + arzGc.getTime());
		System.out.println("\n\n");*/
		

		System.out.println(getTimeStampFromString("APR-01-2012 13:45:00", null, "US/Mountain"));
		System.out.println(getTimeStampFromString("APR-01-2012 13:45:00", null, "US/Arizona"));
	
		TimeZone zone = TimeZone.getTimeZone("US/Arizona");
		DateFormat format = DateFormat.getDateTimeInstance();
		format.setTimeZone(zone);
		
		System.out.println(getTimeStampFromString("APR-01-2012 01:45:00", null) + " ::::: " + format.format(getTimeStampFromString("APR-01-2012 01:45:00", null)));
		
		DateFormat formatter = DateFormat.getDateTimeInstance();
	    formatter.setTimeZone(TimeZone.getTimeZone("US/Arizona"));

	    System.out.println(formatter.format(getTimeStampFromString("APR-01-2012 01:45:00", null)));
	    // for me it prints
	    // 2011-05-14 16:11:29
	    // 2011-11-10 15:11:29

	    // now for "UTC"
	    formatter.setTimeZone(TimeZone.getTimeZone("US/Mountain"));
	    System.out.println(formatter.format(getTimeStampFromString("APR-01-2012 01:45:00", null)));
	}
	
    /**
     * This method returns the Timestamp pertaing to the string object.
     * @param elementValue
     * @return style
     */
    public static Timestamp getTimeStampFromString(String elementValue, String style, String timeZoneId) {
        if (style == null) {
            style = "MS";
        }
        if (elementValue != null) {
            Date formatedDate = getDate(style, elementValue);
            
            GregorianCalendar gc = null;
            
            
            if(timeZoneId == null) {
            	gc = new GregorianCalendar();
            }
            else {
            	gc = new GregorianCalendar(TimeZone.getTimeZone(timeZoneId));
            }
            
            gc.setTime(formatedDate);
            
            Timestamp timestamp = new Timestamp(gc.getTimeInMillis());
            return timestamp;
        }
        return null;
    }

	
    /**
     * This method returns the Timestamp pertaing to the string object.
     * @param elementValue
     * @return style
     */
    public static Timestamp getTimeStampFromString(String elementValue, String style) {
        return getTimeStampFromString(elementValue, style, null);
    }

     private static Date getDate(String style, String elementValue) {
        String dateTimePattern = "MMM-dd-yyyy HH:mm:ss";
        SimpleDateFormat df = new SimpleDateFormat(dateTimePattern);
        Date formatedDate=null;
        //non lenient expects exact matching of date value with the given format. Ex: parsing 14/02/2008 with
        // mm//dd/yyyy format throws exception instead of parsing it to 02/02/2008.
        df.setLenient(false);
        try {
            formatedDate = df.parse(elementValue);
        } catch (ParseException e) {
        	throw new RuntimeException(e);
        }
        return formatedDate;
    }

}
