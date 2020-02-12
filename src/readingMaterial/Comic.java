package readingMaterial;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Comic extends ReadingMaterial{
	private Date editionDate;
	private Date degradedDate;
	private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
	
	public Comic(String name, int quality) {
		super(name);
		editionDate = new Date();
		Calendar c = Calendar.getInstance();
        c.setTime(editionDate);
        c.add(Calendar.DATE, quality/2);
        this.degradedDate = c.getTime();
        setQuality();
	}
	public Comic(String name) {
		super(name);
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
	public static DateFormat getDateformat() {
		return dateFormat;
	}
	
	public void setQuality() {
		this.setQuality((int) ((degradedDate.getTime()-editionDate.getTime())/86400000)); 
	}
	
	@Override
	public String toString() {
		return super.toString() +"Comic [editionDate=" + ( dateFormat.format(editionDate) )+ ", degradedDate=" + (dateFormat.format(degradedDate) )+ "]";
	}
	public void getTimeLeft() {
		System.out.println("Edition date: "+dateFormat.format(editionDate));
		System.out.println("Degraded date: "+dateFormat.format(degradedDate));
		System.out.println((int) ((degradedDate.getTime()-editionDate.getTime())/86400000)+ " days left to get removed");
	}
}
