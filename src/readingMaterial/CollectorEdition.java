package readingMaterial;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CollectorEdition extends ReadingMaterial {
	private Date editionDate;
	private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	public CollectorEdition(String name) {
		super(name);
		editionDate = new Date(); 
		setQuality();
	}
	//Constructor editado con fecha default
	public CollectorEdition(String name, String status) {
		super(name);
		editionDate = new Date(120,1,1);
		setQuality();
	}
	
	public Date getEditionDate() {
		return editionDate;
	}
	public void setEditionDate(Date editionDate) {
		this.editionDate = editionDate;
	}
	public static DateFormat getDateformat() {
		return dateFormat;
	}
	
	public void setQuality() {
		Date actualDate = new Date();
		this.setQuality((int) ((actualDate.getTime()-editionDate.getTime())/86400000)); 
	}


	@Override
	public String toString() {
		return super.toString()  + "CollectorEdition [editionDate=" + (dateFormat.format(editionDate)) + "]";
	}
	
	
	public void getTimeLeft() {
		System.out.println(dateFormat.format(editionDate));
	}

}