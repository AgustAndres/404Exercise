package interfaces;

import exception.NotFoundException;
import readingMaterial.Book;
import readingMaterial.ReadingMaterial;

public interface GetBookByNameInterface {
	abstract ReadingMaterial getBookByName(String bookName) throws NotFoundException;
}
