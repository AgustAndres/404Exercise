package books;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Book {
	private String name;
	private int id;
	private int quality;
	private static int idCounter;
	private Date editionDate;
	private Date degradedDate;

	public Book(String name, int quality) {
		this.name = name;
		this.id = ++idCounter;
		
		editionDate = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(editionDate);
		c.add(Calendar.DATE, quality);
		this.degradedDate = c.getTime();
		setQuality();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuality() {
		setQuality();
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public void getTimeLeft() {
		System.out.println("Edition date: "+dateFormat.format(editionDate));
		System.out.println("Degraded date: "+dateFormat.format(degradedDate));
		System.out.println((int) ((degradedDate.getTime()-editionDate.getTime())/86400000)+ " days left to get removed");
	}

	
	@Override
	public String toString() {
		return "Book [name=" + name + ", id=" + id + ", quality=" + quality + ", editionDate=" + ( dateFormat.format(editionDate) )
				+ ", degradedDate=" + (dateFormat.format(degradedDate)) + "]";
	}


	private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
}
