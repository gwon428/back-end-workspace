package E_BookMVC;

// try-catch로 한 번 잡으면 모든 곳에서 try-catch로 잡아야 함
// controller에서 try-catch로 로그값을 보내기도 함 (이건 나중에)
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import E_BookMVC.model.vo.Member;
import E_BookMVC.model.vo.Rent;
import E_BookMVC.controller.BookController;
import E_BookMVC.controller.MemberController;
import E_BookMVC.controller.RentController;
import E_BookMVC.model.vo.Book;

public class Application {

	private Scanner sc = new Scanner(System.in);
	private BookController bc = new BookController();
	private MemberController mc = new MemberController();
	private RentController rc = new RentController();
	// 로그인했을 때의 사용자 정보를 담은 객체
	private Member member = new Member();

	public static void main(String[] args) {

		Application app = new Application();
		try {
			app.mainMenu();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void mainMenu() throws SQLException {
		System.out.println("===== 도서 관리 프로그램 =====");

		boolean check = true;
		while (check) {
			System.out.println("1. 전체 책 조회");
			System.out.println("2. 책 등록");
			System.out.println("3. 책 삭제");
			System.out.println("4. 회원가입");
			System.out.println("5. 로그인");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 입력 : ");
			switch (Integer.parseInt(sc.nextLine())) {
			case 1:
				printBookAll();
				break;
			case 2:
				registerBook();
				break;
			case 3:
				sellBook();
				break;
			case 4:
				registerMember();
				break;
			case 5:
				login();
				break;
			case 9:
				check = false;
				System.out.println("프로그램 종료");
				break;
			}
		}
	}

	// 1. 전체 책 조회
	public void printBookAll() {
		// 반복문을 이용해서 책 리스트 출력
		try {
			for (Book b : bc.printBookAll()) {
				String pubName = b.getPublisher().getPubName();

				System.out.println("책 번호 : " + b.getBkNo() + " / " + b.getBkTitle() + " / " + b.getBkAuthor()
						+ (pubName != null ? " / " + pubName : " "));
			}
		} catch (SQLException e) {
			System.out.println("책 정보 리스트를 불러오지 못했습니다.");
		}
	}

	// 2. 책 등록
	public void registerBook() {
		// 책 제목, 책 저자를 사용자한테 입력 받아
		System.out.print("책 제목 : ");
		String title = sc.nextLine();

		System.out.print("책 저자 : ");
		String author = sc.nextLine();

		try {
			// 등록에 성공하면 "성공적으로 책을 등록했습니다." 출력
			bc.registerBook(title, author);
			System.out.println("성공적으로 책을 등록했습니다.");
		} catch (SQLException e) {
			// 실패하면 "책을 등록하는데 실패했습니다." 출력
			System.out.println("책을 등록하는데 실패했습니다.");
		}
	}

	// 3. 책 삭제
	public void sellBook() {
		// printBookAll(전체 책 조회)를 한 후
		printBookAll();

		// 삭제할 책 번호 선택을 사용자한테 입력 받아
		System.out.print("삭제할 책 번호 : ");
		int no = Integer.parseInt(sc.nextLine());

		try {
			// 삭제에 성공하면 "성공적으로 책을 삭제했습니다." 출력
			bc.sellBook(no);
			System.out.println("성공적으로 책을 삭제했습니다.");
		} catch (SQLException e) {
			// 실패하면 "책을 삭제하는데 실패했습니다." 출력
			System.out.println("책을 삭제하는데 실패했습니다.");
		}

	}

	// 4. 회원가입
	public void registerMember() {
		// 아이디, 비밀번호, 이름을 사용자한테 입력 받아
		System.out.print("아이디 : ");
		String id = sc.nextLine();

		System.out.print("비밀번호 : ");
		String password = sc.nextLine();

		System.out.print("이름 : ");
		String name = sc.nextLine();

		try {
			mc.registerMember(id, password, name);
			// 회원가입에 성공하면 "성공적으로 회원가입을 완료하였습니다." 출력
			System.out.println("성공적으로 회원가입을 완료하였습니다.");
		} catch (SQLException e) {
			// 실패하면 "회원가입에 실패했습니다." 출력
			System.out.println("회원가입에 실패했습니다.");
		}

	}

	// 5. 로그인
	public void login() {
		// 아이디, 비밀번호를 사용자한테 입력 받아
		System.out.print("아이디 : ");
		String id = sc.nextLine();

		System.out.print("비밀번호 : ");
		String pwd = sc.nextLine();

		try {
			// 로그인에 성공하면 "~~님, 환영합니다!" 출력 후
			member = mc.login(id, pwd);
			System.out.println(member.getMemberName() + "님, 환영합니다!");
			// --> memberMenu() 호출
			memberMenu();
		} catch (SQLException e) {
			System.out.println("로그인에 실패했습니다.");
		}

		// 실패하면 "로그인에 실패했습니다." 출력
	}

	public void memberMenu() {
		boolean check = true;
		while (check) {
			System.out.println("1. 책 대여");
			System.out.println("2. 내가 대여한 책 조회");
			System.out.println("3. 대여 취소");
			System.out.println("4. 로그아웃");
			System.out.println("5. 회원탈퇴");
			System.out.print("메뉴 번호 입력 : ");
			switch (Integer.parseInt(sc.nextLine())) {
			case 1:
				rentBook();
				break;
			case 2:
				printRentBook();
				break;
			case 3:
				deleteRent();
				break;
			case 4:
				check = false;
				break;
			case 5:
				deleteMember();
				check = false;
				break;
			}
		}
	}

	// 1. 책 대여
	public void rentBook() {
		// printBookAll(전체 책 조회) 출력 후
		printBookAll();
		// 대여할 책 번호 선택을 사용자한테 입력 받아
		System.out.print("대여할 책 번호 : ");
		int no = Integer.parseInt(sc.nextLine());

		try {
			// 대여에 성공하면 "성공적으로 책을 대여했습니다." 출력
			rc.rentBook(no, member.getMemberNo());
			System.out.println("성공적으로 책을 대여했습니다.");
		} catch (SQLException e) {
			// 실패하면 "책을 대여하는데 실패했습니다." 출력
			System.out.println("책을 대여하는데 실패했습니다.");
		}
	}

	// 2. 내가 대여한 책 조회
	public void printRentBook() {
		// 내가 대여한 책들을 반복문을 이용하여 조회
		// 대여 번호, 책 제목, 책 저자, 대여 날짜, 반납 기한 조회
		try {
			ArrayList<Rent> list = rc.printRentBook(member.getMemberNo());

			for (Rent rent : list) {
				LocalDate localDate = new java.sql.Date(rent.getRentDate().getTime()).toLocalDate();
				System.out.println("대여 번호 : " + rent.getRentNo() + " / " + rent.getBook().getBkTitle() + " / "
						+ rent.getBook().getBkAuthor() + " / 대여 날짜 : " + rent.getRentDate() + " / 반납 기한 : "
						+ localDate.plusDays(7));
				;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 3. 대여 취소
	public void deleteRent() {
		// printRentBook(내가 대여한 책 조회) 출력 후
		printRentBook();
		// 취소할 대여 번호 선택을 사용자한테 입력 받아
		System.out.print("취소할 대여 번호 : ");
		int no = Integer.parseInt(sc.nextLine());

		try {
			// 취소에 성공하면 "성공적으로 대여를 취소했습니다." 출력
			rc.deleteRent(no);
			System.out.println("성공적으로 대여를 취소했습니다.");
		} catch (SQLException e) {
			// 실패하면 "대여를 취소하는데 실패했습니다." 출력
			System.out.println("대여를 취소하는데 실패했습니다.");
		}
	}

	// 4. 회원탈퇴
	public void deleteMember() {
		try {
			// 회원탈퇴에 성공하면 "회원탈퇴 하였습니다 ㅠㅠ" 출력
			mc.deleteMember(member.getMemberNo());
			System.out.println("회원탈퇴 하였습니다 ㅠㅠ");
		} catch (SQLException e) {
			// 실패하면 "회원탈퇴하는데 실패했습니다." 출력
			System.out.println("회원탈퇴하는데 실패했습니다.");
		}
	}
}