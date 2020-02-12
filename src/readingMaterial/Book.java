package readingMaterial;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Book extends ReadingMaterial{
	private Date editionDate;
	private Date degradedDate;
	private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	/*public Book(String name, int quality) {
		this.name = name;
		this.id = ++idCounter;
		
		editionDate = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(editionDate);
		c.add(Calendar.DATE, quality);
		this.degradedDate = c.getTime();
		setQuality();
	}*/
	public Book(String name, int quality) {
		super(name,quality);
		editionDate = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(editionDate);
		c.add(Calendar.DATE, quality);
		this.degradedDate = c.getTime();
		setQuality();
	}
	/*
	public int getQuality() {
		setQuality();
		return quality;
	}
	*/

	public static DateFormat getDateformat() {
		return dateFormat;
	}
	
	public Date getEditionDate() {
		return editionDate;
	}
	public void setEditionDate(Date editionDate) {
		this.editionDate = editionDate;
	}
	public Date getDegradedDate() {
		return degradedDate;
	}
	public void setDegradedDate(Date degradedDate) {
		this.degradedDate = degradedDate;
	}
	public void setQuality() {
		this.setQuality((int) ((degradedDate.getTime()-editionDate.getTime())/86400000)); 
	}
		
	public void getTimeLeft() {
		System.out.println("Edition date: "+dateFormat.format(editionDate));
		System.out.println("Degraded date: "+dateFormat.format(degradedDate));
		System.out.println((int) ((degradedDate.getTime()-editionDate.getTime())/86400000)+ " days left to get removed");
	}

}
