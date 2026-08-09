package BookManager;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BookManager manager = new BookManager();

        while (true) {
            System.out.println("=== 图书管理系统 ===");
            System.out.println("1.添加 2.查看 3.按编号查 4.按书名查");
            System.out.println("5.修改 6.删除 7.借书 8.还书 0.退出");

            int choice = scan.nextInt();
            scan.nextLine();
            if (choice < 0 || choice > 8) {
                System.out.println("输入错误！请重新输入");
                continue;
            }

            switch (choice) {
                case 1:
                    Book book = new Book();
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
                        System.out.printf("%-6s %-22s %-14s %-26s %-6s%n", "编号", "书名", "作者", "ISBN", "状态");
                        System.out.println("--------------------------------------------------------------------------");
                        for (Book b : list) {
                            System.out.printf("%-6d %-22s %-14s %-26s %-6s%n",
                                    b.getId(),
                                    b.getTitle(),
                                    b.getAuthor(),
                                    b.getIsbn(),
                                    b.isBorrowed() ? "已借出" : "在馆");
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
                    String s = scan.nextLine();
                    List<Book> list1 = manager.queryByTitle(s);
                    if (list1.isEmpty()) {
                        System.out.println("暂无图书");
                    } else {
                        System.out.printf("%-6s %-22s %-14s %-26s %-6s%n", "编号", "书名", "作者", "ISBN", "状态");
                        System.out.println("--------------------------------------------------------------------------");
                        for (Book b1 : list1) {
                            System.out.printf("%-6d %-22s %-14s %-26s %-6s%n",
                                    b1.getId(),
                                    b1.getTitle(),
                                    b1.getAuthor(),
                                    b1.getIsbn(),
                                    b1.isBorrowed() ? "已借出" : "在馆");
                        }
                    }
                    break;

                case 5:
                    System.out.println("请输入要修改的图书编号:");
                    int id1 = scan.nextInt();
                    scan.nextLine();
                    Book oldBook = manager.queryById(id1);
                    if (oldBook == null) {
                        System.out.println("未找到该书");
                        break;
                    }
                    System.out.println("请输入新书名（回车保留原值）:");
                    String newTitle = scan.nextLine();
                    if (newTitle.isEmpty()) newTitle = oldBook.getTitle();

                    System.out.println("请输入新作者（回车保留原值）:");
                    String newAuthor = scan.nextLine();
                    if (newAuthor.isEmpty()) newAuthor = oldBook.getAuthor();

                    System.out.println("请输入新ISBN（回车保留原值）:");
                    String newIsbn = scan.nextLine();
                    if (newIsbn.isEmpty()) newIsbn = oldBook.getIsbn();

                    oldBook.setTitle(newTitle);
                    oldBook.setAuthor(newAuthor);
                    oldBook.setIsbn(newIsbn);

                    if (manager.updateBook(id1, oldBook)) {
                        System.out.println("修改成功");
                    } else {
                        System.out.println("修改失败");
                    }
                    break;

                case 6:
                    System.out.println("请输入图书编号:");
                    int id2 = scan.nextInt();
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
                    return;
            }
        }
    }
}