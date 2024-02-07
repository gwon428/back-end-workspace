package E_BookMVC.model.vo;

// VO(Value Object) : 한 개 또는 그 이상의 속성들을 묶어서 특정 값을 나타내는 객체
// 		기존에 만들었던 모델이라고 생각하면 됨
// 주로 테이블마다 객체 하나씩 생성 + SQL 테이블의 컬럼명을 그대로
public class Book {
	private int bkNo;
	private String bkTitle;
	private String bkAuthor;
	private int bkPrice;

//	private int pubNo; => foreign key 걸려있는 것들 확인해서 publisher와 연결하기 위해 포함관계
	private Publisher publisher;

	public Book() {
	}

	public Book(String bkTitle, String bkAuthor) {
		this.bkTitle = bkTitle;
		this.bkAuthor = bkAuthor;
	}

	public Book(int bkNo, String bkTitle, String bkAuthor, int bkPrice, Publisher publisher) {
		super();
		this.bkNo = bkNo;
		this.bkTitle = bkTitle;
		this.bkAuthor = bkAuthor;
		this.bkPrice = bkPrice;
		this.publisher = publisher;
	}

	public int getBkNo() {
		return bkNo;
	}

	public void setBkNo(int bkNo) {
		this.bkNo = bkNo;
	}

	public String getBkTitle() {
		return bkTitle;
	}

	public void setBkTitle(String bkTitle) {
		this.bkTitle = bkTitle;
	}

	public String getBkAuthor() {
		return bkAuthor;
	}

	public void setBkAuthor(String bkAuthor) {
		this.bkAuthor = bkAuthor;
	}

	public int getBkPrice() {
		return bkPrice;
	}

	public void setBkPrice(int price) {
		this.bkPrice = bkPrice;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Book [bkNo=" + bkNo + ", bkTitle=" + bkTitle + ", bkAuthor=" + bkAuthor + ", price=" + bkPrice
				+ ", publisher=" + publisher + "]";
	}

}
