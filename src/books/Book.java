package books;

public class Book {
	private String name;
	private int id;
	private static int idCounter;

	public Book(String name) {
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

	
}
