package BookManager;

import java.util.List;

public class BookManager {
        private BookDAO dao=new BookDAO();

        public void addBook(Book book) {
            dao.addBook(book);
        }

        public boolean deleteBook(int id) {
            return dao.deleteBook(id);
        }

        public boolean updateBook(int id, Book book) {
            return dao.updateBook(id, book);
        }

        public List<Book> queryAll() {
            return dao.queryAll();
        }

        public Book queryById(int id) {
            return dao.queryById(id);
        }

        public List<Book> queryByTitle(String title) {
            return dao.queryByTitle(title);
        }

        public boolean borrowBook(int id) {
            return dao.borrowBook(id);
        }

        public boolean returnBook(int id) {
            return dao.returnBook(id);
        }
    }

