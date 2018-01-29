package Property;

public class Book {
	private String bookname;
	//set方法

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public void demobook() {
		System.out.println("book.........."+bookname);
	}

}
