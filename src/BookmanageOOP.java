

import java.util.Scanner;

public class BookmanageOOP {
  static int choice = 0;
  static int i = 0;

  /**
   * 主方法 先初始化一个数组 对数组进行赋值 调用Book类的方法实现要求
   * 
   * @author Yan Xinya
   * @author Mtcle
   * @since JDK1.7
   */
  public static void main(String[] args) {
    @SuppressWarnings({"resource", "unused"})
    Scanner input = new Scanner(System.in);
    Menu a = new Menu();
    BookJia shujia = new BookJia();
    shujia.setSum(10);// 把书架容量定为10本
    Book[] book = new Book[shujia.getSum()];// 定义一下图书的最大库存量
    book[0] = new Book("罗马假日", 1, 1, 15);
    book[1] = new Book("飘", 0, 0, 0);
    book[2] = new Book("浪漫满屋", 2, 0, 30);
    shujia.setCounts(3);
    do {
      try {
        choice = a.printMenu();
      } catch (Exception ex) {
        System.out.println("请输入阿拉伯数字！");
      }
      switch (choice) {
        case 1:
          if (shujia.getCounts() < shujia.getSum()) {
            @SuppressWarnings("resource")
            Scanner input2 = new Scanner(System.in);
            System.out.println("请输入书的名字： ");
            String name = input2.next();
            // System.out.println(i);
            book[i] = new Book(name, 0, 0, 0);
            shujia.setCounts(shujia.getCounts() + 1);
            System.out.println("添加图书成功！");
            System.out.println("书架当前容量：" + shujia.getCounts() + "\n书架的总容量：" + shujia.getSum());
          } else
            System.out.println("书架已经满了！");
          break;
        case 2: {

          for (i = 0; i < shujia.getCounts(); i++) {
            if (book[i].getStatus() == 0)

              System.out.println("id: " + (i + 1) + "  图书名字：" + book[i].getName() + "\t"
                  + " 在馆状态： " + " 在馆\t\t" + " 借出日期：\t" + book[i].getDate() + "\t" + " 外借次数：\t"
                  + book[i].getSum());
            else if (book[i].getStatus() == 1)
              System.out.println("id: " + (i + 1) + "  图书名字：" + book[i].getName() + "\t"
                  + " 在馆状态： " + " 外借中\t" + " 借出日期：\t" + book[i].getDate() + "\t" + " 外借次数：\t"
                  + book[i].getSum());
            else
              System.out.println("id: " + (i + 1) + "  图书名字：" + book[i].getName() + "\t"
                  + " 在馆状态： " + " 已删除\t" + " 借出日期：\t" + book[i].getDate() + "\t" + " 外借次数：\t"
                  + book[i].getSum());
          }
        }
          break;
        case 3://刪除图书
          System.out.println("请输入要删除的图书名字：\n");
          Scanner aa = new Scanner(System.in);
          
          String a2 = aa.next();
          for (int i = 0; i < shujia.getCounts(); i++) {
            if (book[i].getName().equals(a2)) {
              book[i].delBook();
            }
          }
          break;
        case 4:// 借书。
          System.out.println("输入您借阅的图书的名字：");
          Scanner inputbb = new Scanner(System.in);
          String bb = inputbb.next();
          for (int j = 0; j < shujia.getCounts(); j++) {
            if (book[j].getName().equals(bb)) {
              book[j].checkOut();
            }
          }
          break;
        case 5:// 还书业务
          Scanner inputaa = new Scanner(System.in);
          System.out.println("请输入您要归还的图书名字： ");
          String cc = inputaa.next();
          for (int j = 0; j < shujia.getCounts(); j++) {
            if (book[j].getName().equals(cc)) {
              book[j].checkIn();
            }
          }
          break;
      }
    } while (choice != 6);
    System.out.println("谢谢使用本系统！版权所有，盗用必究！");
  }
}


/**
 * Book类包含五个属性 分别是名字，借出日期，当前状态，总借出次数 提供了名字的get方法，以及借出日期，当前状态，借出次数的get和set方法
 * addBook(),viewBook(),delBook(),checkOut(),checkIn()方法
 * 
 * @author Yan Xinya
 * @author Mtcle
 * @since JDK1.7
 * */

class Book {// 定义图书类，有图书编号int，名称String，借出日期int，借出次数
  private String name;// 图书名字
  private int date;// 借出日期属性
  private int status;// 0代表在管，1代表借出,2代表删除了
  private int sum = 0;// 图书的借出次数属性
  public int money;// 每次借出的费用属性

  public Book(String name, int status, int date, int sum) { // 构造函数
    /*
     * 提供带四个参数的构造函数 name代表名字 status代表状态 date代表借出日期 sum代表借出次数
     */
    this.name = name;
    this.status = status;
    this.date = date;
    this.sum = sum;
  }

  public String getName() {// 获得图书名字
    return name;
  }

  public int getDate() {
    return date;
  }

  public int getStatus() {
    return status;
  }

  public void setDate(int date) {
    this.date = date;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public int getSum() {
    return sum;
  }

  public void setSum(int sum) {
    this.sum = sum;
  }


  /**
   * 增加图书方法 通过实例化Book类产生book新对象 对新对象进行赋值。 状态，借出日期，借出次数都使用默认值。
   */
  public void addBook() {// 定义增加图书方法
    @SuppressWarnings("resource")
    Scanner input = new Scanner(System.in);
    System.out.println("请输入书的名字： ");
    String name = input.next();
    this.name = name;
  }


  /**
   * 通过控制台获得用户输入名字 比对用户输入名字和当前book对象的名字 通过判断条件获得是否可以借出 最终若能借出，改写图书状态，借出日期以及借出次数
   * */
  public void checkOut() {
    try {// 捕获异常，用户可能会输入字符型的数字，把该异常catch住抛出提示信息
      if (this.status == 0) { // 0代表在馆，1代表借出，2代表不存在
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        System.out.println("输入当前借出日期1-31：");
        int temp = input.nextInt();
        if (temp > this.date && temp < 32) {
          this.setStatus(1);// 改写图书状态
          this.sum++;// 借出次数加一
          this.date = temp;// 修改借出日期
          System.out.println("借书成功！谢谢使用！");
        } else
          System.out.println("请输入正确的日期！");
      } else if (this.status == 1)
        System.out.println("该书被借出！");
      else
        System.out.println("该书被删除了！");
    } catch (Exception ex) {
      System.out.println("输入数字！");
    }
  }

  /**
   * 删除图书的方法 通过两重安全判断删除的图书id以及名字 比对成功后删除图书 改写图书状态
   * */
  public void delBook() {// 删除图书
    if (this.status == 0) {
      this.setStatus(2);// 还要设计删除其坐标值后面数组坐标都往前移动一位
      System.out.println("删除图书成功！\n");
    } else if (this.status == 1)
      System.out.println("该图书被借出无法删除！\n");
    else
      System.out.println("该图书已经被删除！\n");
  }



  /**
   * 通过比对还书的图书名字 以及借出状态 提示用户还书 计算借出费用
   * */
  public void checkIn() {
    try {
      if (this.status == 0 || this.status == 2) {// 判断图书状态
        System.out.println("图书状态错误！");
      } else {
        System.out.println("请输入还书日期： ");
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        int temp = input.nextInt();// 获取用户输入的还书日期
        if (temp > date && temp < 32) {// 判断还书日期
          status = 0;// 改写图书状态
          money = temp - date;// 计算计算费用
          this.date = 0;
          System.out.println("恭喜你还书成功!");
          System.out.println("您的借书费用为： " + money + " 元");
        } else
          System.out.println("您输入的还款日期不对！");
      }
    } catch (Exception ex) {
      System.out.println("请输入阿拉伯数字！");
    }
  }
}


/**
 * Menu类主要是负责打印菜单，以及后期的扩展方便。 Menu类能实例化出menu菜单对象，负责该菜单的打印。 menu有一个int型返回值，是用户选择之后的值。
 * Menu类直接使用系统提供的无参构造函数。
 * 
 * @author Yan Xinya
 * @author Mtcle
 * @since JDK1.7
 * */
class Menu {
  public int printMenu() {
    /**
     * 提供一个打印方法 返回值为int型
     */
    String str = new String();
    str =
        "欢迎使用图书管理系统\n-----------------\n1.新增图书\n2.查看图书\n3.删除图书\n4.借出图书\n5.归还图书\n6.退出系统\n-----------------\n请选择：\n";
    System.out.print(str);
    @SuppressWarnings("resource")
    Scanner input = new Scanner(System.in);
    return input.nextInt();
  }
}



/**
 * BookJia类主要管理书架上的图书.
 * BookJia类有两个属性，两个get方法两个set方法 
 * sum属性代表书架的总容量，counts属性代表当前容量. 
 * BookJia类使用系统构造函数.
 * 
 * @author Yan Xinya
 * @author Mtcle
 * @since JDK1.7
 * */

class BookJia {
  private int sum; // 书架总容量
  private int counts;// 当前容量

  public int getSum() {
    return sum;
  }

  public void setSum(int sum) {
    this.sum = sum;
  }

  public int getCounts() {
    return counts;
  }

  public void setCounts(int counts) {
    this.counts = counts;
  }

}
