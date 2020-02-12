package readingMaterial;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


public abstract class ReadingMaterial {
	private String name;
	private int id;
	private int quality;
	private static int idCounter;
	

	public ReadingMaterial(String name, int quality) {
		this.name = name;
		this.quality=quality;
		this.id = ++idCounter;
	}
	public ReadingMaterial(String name) {
		this.name = name;
		this.id = ++idCounter;
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
	public static int getIdCounter() {
		return idCounter;
	}
	public static void setIdCounter(int idCounters) {
		idCounter = idCounters;
	}
	public static DateFormat getDateformat() {
		return dateFormat;
	}
	
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
	@Override
	public String toString() {
		return "ReadingMaterial [name=" + name + ", id=" + id + ", quality=" + quality + "]";
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
		ReadingMaterial other = (ReadingMaterial) obj;
		if (id != other.id)
			return false;
		return true;
	}



	private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
}
