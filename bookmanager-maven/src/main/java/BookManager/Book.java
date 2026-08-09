package BookManager;

public class Book {
    private int id;              //图书编号
    private String title;        //书名
    private String author;       //作者
    private String isbn;         //ISBN号
    private boolean isBorrowed;  //是否借出

    public Book() {
    }

    public Book(int id, String title, String author, String isbn, boolean isBorrowed) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isBorrowed = isBorrowed;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
