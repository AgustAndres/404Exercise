package interfaces;

import books.Book;
import exception.NotFoundException;

public interface GetBookByNameInterface {
	abstract Book getBookByName(String bookName) throws NotFoundException;
}
