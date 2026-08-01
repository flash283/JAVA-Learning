package BookManager;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        BookManager manager=new BookManager();

        while (true){
            System.out.println("=== 图书管理系统 ===");
            System.out.println("1.添加 2.查看 3.按编号查 4.按书名查");
            System.out.println("5.修改 6.删除 7.借书 8.还书 0.退出");

            int choice=scan.nextInt();
            scan.nextLine();      //吃掉换行
             if (choice<0 ||choice>8){
                 System.out.println("输入错误！请重新输入");
                 continue;
             }

             switch (choice){
                 case 1:
                  Book book=new Book();
                  book.setId(manager.generateId());  //自动生成编号
                  System.out.println("请输入书名:");
                  book.setTitle(scan.nextLine());
                  System.out.println("请输入作者:");
                  book.setAuthor(scan.nextLine());
                  System.out.println("请输入ISBN:");
                  book.setIsbn(scan.nextLine());
                  manager.addBook(book);
                  System.out.println("添加成功");
                  break;

                 case 2:
                     List<Book> list = manager.queryAll();
                     if (list.isEmpty()) {
                         System.out.println("暂无图书");
                     } else {
                         for (Book b : list) {
                             String status = b.isBorrowed() ? "已借出" : "在馆";
                             System.out.println("编号：" + b.getId() +
                                     " 书名：" + b.getTitle() +
                                     " 作者：" + b.getAuthor() +
                                     " ISBN：" + b.getIsbn() +
                                     " 状态：" + status);
                         }
                     }
                     break;
                 case 3:
                     System.out.println("请输入图书编号:");
                     int id = scan.nextInt();
                     scan.nextLine();
                     Book b = manager.queryById(id);
                     if (b == null) {
                         System.out.println("未找到该书");
                     } else {
                         System.out.println("编号：" + b.getId() +
                                 " 书名：" + b.getTitle() +
                                 " 作者：" + b.getAuthor() +
                                 " ISBN：" + b.getIsbn() +
                                 " 状态：" + (b.isBorrowed() ? "已借出" : "在馆"));
                     }
                     break;

                 case 4:
                    System.out.println("请输入书名关键字");
                    String s=scan.nextLine();
                    List<Book> list1 =manager.queryByTitle(s);
                     if (list1.isEmpty()) {
                         System.out.println("暂无图书");
                     } else {
                         for (Book b1 : list1) {
                             System.out.println("编号：" + b1.getId() +
                                     " 书名：" + b1.getTitle() +
                                     " 作者：" + b1.getAuthor() +
                                     " ISBN：" + b1.getIsbn() +
                                     " 状态：" + (b1.isBorrowed() ? "已借出" : "在馆"));
                         }
                     }
                     break;

                 case 5:
                     Book book1=new Book();
                     System.out.println("请输入图书编号:");
                     int id1=scan.nextInt();
                     scan.nextLine();
                     System.out.println("请输入书名:");
                     book1.setTitle(scan.nextLine());
                     System.out.println("请输入作者:");
                     book1.setAuthor(scan.nextLine());
                     System.out.println("请输入ISBN:");
                     book1.setIsbn(scan.nextLine());
                     if (manager.updateBook(id1, book1)) {
                         System.out.println("修改成功");
                     } else {
                         System.out.println("未找到该书");
                     }
                     break;
                 case 6:
                     System.out.println("请输入图书编号:");
                     int id2=scan.nextInt();
                     scan.nextLine();
                     if (manager.deleteBook(id2)) {
                         System.out.println("删除成功");
                     } else {
                         System.out.println("删除失败");
                     }
                     break;

                 case 7:
                     System.out.println("请输入图书编号:");
                     int id3 = scan.nextInt();
                     scan.nextLine();
                     if (manager.borrowBook(id3)) {
                         System.out.println("借书成功");
                     } else {
                         System.out.println("借书失败");
                     }
                     break;

                 case 8:
                     System.out.println("请输入图书编号:");
                     int id4 = scan.nextInt();
                     scan.nextLine();
                     if (manager.returnBook(id4)) {
                         System.out.println("还书成功");
                     } else {
                         System.out.println("还书失败");
                     }
                     break;
                 case 0:
                     System.out.println("谢谢使用，再见！");
                     scan.close();
                     return;       // 或 System.exit(0)
             }

        }
    }
}