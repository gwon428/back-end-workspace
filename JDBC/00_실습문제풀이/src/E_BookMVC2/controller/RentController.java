package E_BookMVC2.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import E_BookMVC2.model.dao.RentDAO;
import E_BookMVC2.model.vo.Rent;

public class RentController {

	RentDAO dao = new RentDAO();

	// 1. 책 대여
	public boolean rentBook(int bkNo, int memberNo) {
		try {
			if (dao.rentBook(bkNo, memberNo) == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 2. 내가 대여한 책 조회
	public ArrayList<Rent> printRentBook(int no) {
		try {
			return dao.printRentBook(no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 3. 대여 취소
	public boolean deleteRent(int no) {
		try {
			if (dao.deleteRent(no) == 1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
