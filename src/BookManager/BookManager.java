package BookManager;

import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private ArrayList<Book> bookList;
    private int nextId = 1;

    public int generateId() {
        return nextId++;
    }

    public BookManager(){
       bookList =new ArrayList<>();
    }


    //添加图书
    public void addBook(Book book){
        bookList.add(book);
    }

    //按编号删除
    public boolean deleteBook(int id){
        for (int i=0;i<bookList.size();i++){
            if(bookList.get(i).getId()==id){
                bookList.remove(i);
            }
        }
        return true;
    }

    //修改图书信息
    public boolean updateBook(int id,Book book){
        for(int i=0;i<bookList.size();i++){
            if(bookList.get(i).getId()==id){
                book.setId(id);
                bookList.set(id,book);
                return true;
            }
        }
        return false;
    }

    //查看所有图书
    public List<Book> queryAll(){
        return bookList;

    }

    //按编号查询
    public Book queryById(int id) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId() == id) {
                return bookList.get(i);
            }

        }
        return null;
    }

    //按书名模糊查询
    public List<Book> queryByTitle(String title){
        List<Book> list=new ArrayList<>();
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getTitle().contains(title)) {     //contain 适用于模糊查询，equals适用于精确查询
                list.add(bookList.get(i));
            }
        }
        return list;
    }

    //借书

   /* public boolean borrowBook(int id){
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId() == id) {
                 bookList.get(i).setBorrowed(true);
                return true;
            }
        }
        return false;
    }

    */
    //更准确写法
   public boolean borrowBook(int id) {
       for (int i = 0; i < bookList.size(); i++) {
           Book book = bookList.get(i);
           if (book.getId() == id) {
               if (book.isBorrowed()) {
                   System.out.println("该书已被借出");
                   return false;
               }
               book.setBorrowed(true);
               return true;
           }
       }
       System.out.println("未找到该书");
       return false;
   }

    //还书
    public boolean returnBook(int id){
        for (int i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i);
            if (book.getId() == id) {
                if (!book.isBorrowed()) {
                    System.out.println("该书已被还");
                    return false;
                }
                book.setBorrowed(false);
                return true;
            }
        }

        return false;
    }

}
