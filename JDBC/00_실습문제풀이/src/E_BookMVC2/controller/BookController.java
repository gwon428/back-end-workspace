package E_BookMVC2.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import E_BookMVC2.model.dao.BookDAO;
import E_BookMVC2.model.vo.Book;

public class BookController {

	private BookDAO dao = new BookDAO();

	// 1. 전체 책 조회
	public ArrayList<Book> printBookAll() {
		try {
			return dao.printBookAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 2. 책 등록
	public boolean registerBook(String title, String author) {
		try {
			if (dao.registerBook(title, author)==1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 3. 책 삭제
	public boolean sellBook(int no) {
		try {
			if(dao.sellBook(no)==1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
