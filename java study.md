## Java

- javac

  进入路径后 javac  文件名.扩展名

- java

  java 类名

### II 输入输出

```java
System.out.println();
System.out.println();
//创建键盘扫面器对象
java.util.Scanner s = new java.util.Scanner(System.in);
//调用Scanner对象next()方法接收用户键盘输入
String userInputContent = s.next();//对应String//程序到这里停下来等你输入
System.out.println(userInputContent);
//以int形式接收数字
int number = s.nextInt();//对应int//程序到这里停下来等你输入
System.out.println(number);

System.out.printf("字符串：%2$s，%1$d的十六进制数：%1$#x", i, s);  // "X$" %变量位置$变量类型。  
```

#### next()与nextLine()区别

next():

- 一定要读取到有效字符后才可以结束输入。
- 对输入有效字符之前遇到的空白，next()方法会自动将其去掉。
- 只有输入有效字符后才将其后面输入的空白作为分隔符或者结束符。
- next()不能得到带有空格的字符串。

nextLine()：

- 以Enter为结束符,也就是说nextLine()方法返回的是输入回车之前的所有字符。
- 可以获得空白。

### III 注释

```java
//单行注释
/*多行注释
*/
/**
* javadoc注释
*
*
*/
ctrl + /
ctrl + shift + /
```

### public class  和  class

- 一个java源文件可以定义多个 class 
- 一般只定义一个 class
- public 的 class 不是必须
- 源文件public（公开）的类只能在同名文件编译，且只能有一个
- 没有主方法会出现运行错误

### IV 标识符

1. java源程序中程序员可以自己命名的
   -黑色高亮
   -元素
   *类名
   *方法名
   *接口名
   *常量名

2. 命名规则

   数字、字母、下划线、$组成
   不能数字开头
   理论没有长度限制
   关键字不行
   严格大小写

3. 命名规范

   最好见名知意
   驼峰命名方式
   **==类名接口名：首字母大写，后面单词首字母大写==**
   **==变量名、方法名：首字母小写，后面单词首字母大写==**
   **==常量：全部大写==**

### V 字面值

- 整数，浮点，布尔，字符，字符串，
- 字符要单引号，字符串要双引号

### VI 变量

- 数据类型、名、字面值

- 不同数据不同类型不同空间

- 声明+/*赋值*/才能访问

- 基本规律和C没啥区别

- 全局位置的变量（成员变量）'必须有'static int a=0;

  ##### 分类

- 局部变量

- 成员变量（没有赋值系统会默认赋值）

  - 实例变量 修饰符没有static
  - 静态变量 修饰符有static **存储在方法区内存**

- 类体里面只能定义变量

### VII 数据类型

- 分配空间不同

- ##### 基本数据类型
  
  整数型: byte,short,int,long
  浮点型: float,double
  布尔型: boolean
  
- ##### 引用数据类型
  
    类
    接口
    数组
    "abc" //字符串
    String s = "abc"
    String --> 字符串类型
    String username = " Winter ";
    System.out.println("Welcome" + username + "come back");
    
    ```java
    String.class
    System.class
        
    User.class
    Product.class
    int age = 10;
    String username = "zhangsan";
    那我也可以：
    Students s = ???;
    ```
    
    
    
- ##### 数据类型空间和默认值

    |         |      |        |              |
    | ------- | ---- | ------ | ------------ |
    | byte    | 1    | 0      | -128~127     |
    | short   | 2    | 0      | -32768~32767 |
    | int4    | 4    | 0      | 2147483648   |
    | long    | 8    | 0L     |              |
    | float   | 4    | 0.0    |              |
    | double  | 8    | 0.0    |              |
    | boolean | 1    | false  |              |
    | char    | 2    | \u0000 | 0~65535      |

    0开始：八进制

    0x开始：16进制

- ##### 字符编码ASCTT：支持英文
  
    'a'-->97
    'A'-->65
    '0'-->48
    
- ##### 原码反码补码
  
    1100110011		原
    1011001100		反 除了符号位取负数
    1011001101		补 反+1
    正数三个码是一样的

1. #### char 可以存一个字符，一个中文


```java
char c = 'a'
char k = '中'
char g = 43 //把一个0-65535的数字给一个char变量
char ch = '\u9999'  //输出一个“香”
// 字符数组
char[] charArray ={ 'a', 'b', 'c', 'd', 'e' }; 
```

在某些情况下，Java编译器会自动创建一个**Character**对象。

例如，将一个char类型的参数传递给需要一个Character类型参数时，那么编译器会自动地将char类型参数转换为Character对象。 这种特征称为装箱，反过来称为拆箱。

native2ascii --> 中文转编码

控制台输入命令回车，输入中文

2. ### 转义字符（C的逃逸字符）

```java
 \b		退格
 \n		换行
 \r		回车
 \t		制表
 \"		双引号
 \'		单引号
 \\		反斜杠
```

3. #### 整数及其精度损失

==整数字面值默认当 int==
//当 long 要加 L,
//但是 byte 和 short 没有溢出可以直接写
==所以 long = 2147483648 或以上要写 long = 2147483648L==
强制类型转换 ('变量名')变量/数字 可能会损失精度

4. #### float 浮点型

float	单精度
double	双精度
==默认当 double==
后面加 f/F 变 float //(没有类型转换）

**java 自带的高精度 //java.math.BigDecimal**
*SE类库字节码：\jre\lib\rt.jar
*SE类库原码：\jdkx.x.x\src.zip

5. #### bollen 布尔型

只有两个值 true , false
底层存储是 0 和 1 

6. #### String
   在代码中遇到字符串常量时，这里的值是"Hello world!"，编译器会使用该值创建一个String对象。

   和其它对象一样，可以使用关键字和构造方法来创建String对象。

   ```java
   public class StringDemo{
   
      public static void main(String args[]){
         char[] helloArray = { 'h', 'e', 'l', 'l', 'o', '.'};
         String helloString = new String(helloArray);  
         System.out.println( helloString );
      }
   }
   ```
   
   字符串长度
   
   用于获取有关对象的信息的方法称为访问器方法。
   
   **String类的一个访问器方法是length()方法，它返回字符串对象包含的字符数。**
   
   下面的代码执行后，len变量等于17:
   
   ```java
   public class StringDemo {
   
       public static void main(String args[]) {
       String palindrome = "Dot saw I was Tod";
       int len = palindrome.length();
       System.out.println( "String Length is : " + len );
      }
   }
   ```
   
7. #### 数据类型转换

   除了 boolean 都能转

   小到大叫自动类型转换

   浮点型占字节都比整数大

   char 比 int 表达正整数范围更大

   byte short char 混合运算，先转成int再运算

   多类运算，转换成容量最大再运算

### VIII 运算符

- 算术运算符：+ - * / % ++ --

- 关系运算符：> < == >= <= !=

- 逻辑运算符：

  &	逻辑与		all true is true
  |	逻辑或		all false is false
  !	逻辑非
  ^	逻辑异或	（两边结果不一样就是 true ）
  &&	短路非		和逻辑与运算结果一样
  ||	短路或		和逻辑非运算结果一样
  两边算子都要布尔类型
  短路与存在==短路==现象（ 判断出 false 后后面表达式不再执行）
  短路或存在==短路==现象（ 判断出 true 后后面表达式不再执行）
  
- ```java
  class VarTest
  {
      public static void main(String[] arges) {
          //逻辑和短路
          int x = 10;
          int y = 8;
          System.out.println( x < y & ++x<y );
          System.out.println( x );//11
          x = 10;
          y = 8;
          //短路与 false 后表达式不再执行
          System.out.println( x < y && ++x<y );
          System.out.println( x );//10
      }
  }
  ```

- 字符串连接运算符

  1.  加法运算
  	两边都是数字
  2.  字符串连接运算
      只要有一边是字符串

```java
int i = 10;
int y = 20;
System.out.println( "10 + 20 = " + (i + y) );
System.out.println( i + " + " + y + " = " + ( i + y ) ) ; 
```

- 三元运算符

```java
[ 布尔表达式 ? 表达式1 : 表达式2 ]		//这是个运算符
true : 选择表达式1为整个表达式的执行结果
false : 选择表达式2为整个表达式的执行结果
boolean sex = true;
char c;
c = sex? 'man' : "woman"; //不能一边字符一边串赋给一个字符
System.out.println( sex ? "man" : 'woman');//但是在 println 可以
```

赋值运算符

```java
=		+=
*=		/=		%=
byte x = 0;
z += 128;// z = (int)(z+128)     
不改变类型
System.out.println( z );//-128
```

'**自动做强制类型转换**，损失精度'

**String**--> 字符串类型

- #### 位运算符

  Java定义了位运算符，应用于整数类型(int)，长整型(long)，短整型(short)，字符型(char)，和字节型(byte)等类型。

  位运算符作用在所有的位上，并且按位运算。假设a = 60，和b = 13;它们的二进制格式表示将如下：

  ```java
  A = 0011 1100
  B = 0000 1101
  -----------------
  A&B = 0000 1100
  A | B = 0011 1101
  A ^ B = 0011 0001
  ~A= 1100 0011
  ```

  | ＆   | 按位与操作符，当且仅当两个操作数的某一位都非0时候结果的该位才为1。 | （A＆B），得到12，即0000 1100  |
  | ---- | ------------------------------------------------------------ | ------------------------------ |
  | \|   | 按位或操作符，只要两个操作数的某一位有一个非0时候结果的该位就为1。 | （A \| B）得到61，即 0011 1101 |
  | ^    | 按位异或操作符，两个操作数的某一位不相同时候结果的该位就为1。 | （A ^ B）得到49，即 0011 0001  |
  | 〜   | 按位补运算符翻转操作数的每一位。                             | （〜A）得到-61，即1100 0011    |
  | <<   | 按位左移运算符。左操作数按位左移右操作数指定的位数。         | A << 2得到240，即 1111 0000    |
  | >>   | 按位右移运算符。左操作数按位右移右操作数指定的位数。         | A >> 2得到15即 1111            |
  | >>>  | 按位右移补零操作符。左操作数的值按右操作数指定的位数右移，移动得到的空位以零填充。 | A>>>2得到15即0000 1111         |

### IX 控制语句

1. 条件

    ```java
    if (布尔表达式)
    {
    }else if (布尔表达式)
    {
    }else if (布尔表达式)
    {
    }else {
    }
    //一个语句完成以后就会跳出整个 if 
    //从上到下判断

    switch (int 或 String 字面值或变量)
    {
        case int 或 String 字面值或变量 :
            ... ; 
            break;
        case int 或 String 字面值或变量 :
            ...;
            break;
        default :
            ...;
    }
    有 break 终止，没有往下走直到遇到 break;
    匹配不成功就走 default
    case 后面只能判断 int 和 String (Java 7 开始)
    byte, short, char, 可以自转
    ```

2. 循环

    ```java
    for ( 初始化表达式 ; 布尔表达式 ; 更新表达式 )｛
    ｝
    可以三个都不要
    先执行初始化，并且只做一次，再判断循环更新
    先执行循环体后执行更新表达式
    内外循环变量名不能重名
    break 跳出
    continue 可以指定调到哪个循环
    ```

3. try catch

   ```java
   try catch：自己处理异常
   try {
   可能出现异常的代码
   } catch（异常类名A e）{
   如果出现了异常类A类型的异常，那么执行该代码
   } ...（catch可以有多个）
   finally {
   最终肯定必须要执行的代码（例如释放资源的代码）
   }
   ```

   代码执行的顺序：
     * 1.try内的代码从出现异常的那一行开始，中断执行
     * 2.执行对应的catch块内的代码
     * 3.继续执行try catch结构之后的代码
       *注意点：
     * 1.如果catch内的异常类存在子父类的关系，那么子类应该在前，父类在后
     * 2。如果最后中有返回语句，那么最后返回的结果肯定以最终中的返回值为准
     * 3。如果最后语句中有回报，那么没有被处理的异常将会被吞掉
       *重写的注意点：
     * 1.儿子不能比父亲的本事大
     * 2.儿子要比父亲开放
     * 3.儿子不能比父亲惹更大的麻烦（子类的异常的类型不能是父类的异常的父类型）
       *异常类Api：
     * 1。的getMessage（）：获取异常描述信息字符串
     * 2。的toString（）：返回异常类的包路径和类
   名和异常描述信息字符串  * 3。的printStackTrace（）：除了打印的toString的信息外，还要打印堆栈信息
     * /

### X 方法

    方法的基础语法
    方法的重载机制overload
    方法是一段独立的代码片段
    方法中不能再定义方法
    
    ```java
    public class MethodTest
    {
    //公开 静态 不返回 方法名
    //(String[] args)：形式参数列表，String[]是引用数据类型
    //args是局部变量变量名，可随意
    public static void main(String[] args){
    MethodTest.sumInt(10,20);
    }
    
    public static void sumInt(int a, int b){
    int c = a + b;
    System.out.println( a + " + " + b + " = " + c);
    }	
    }
    ```

1. #### 语法结构：

[修饰符列表] 返回值类型 方法名 (形式参数列表){
方法体
}

2. #### 解释：
   1. ###### **修饰符列表:** 

       *不是必须的
       *暂时统一public static
       *方法修饰符列表有 static 的时候如何调用法
       **调用：类名.方法名(实际参数列表)**

   2. ###### **返回值类型**

       什么是返回值 (例子: 计算器)
       一个数据
       返回值类型：
       数据都是有类型的，包括基本和引用
       也可能不返回数据: void
       有 return 执行，所在方法结束

   3. ###### **方法名：**

       合法标识符
       见名知意
       小驼峰命名方式
       最好是动词

   4. ###### **形式参数列表**

       形式参数是局部变量： int a
       可以是 0 - n 个, 多个之间用逗号隔开
       形参名字是局部变量的名字
       形式参数和实际参数：
           数量相同
           类型对应相同

	#### 3.方法调用 （==一般传过去的是变量保存的值（包括值和地址）==）

    类名.方法名

      方法中有 static 名关键字可以省略类名
      调用其他类的方法要写类名
      调用方法的程序和方法在同一个类可以不写类名
      () 必须有
   
   ##### 	**有static**的时候：类名 . 方法名(实参列表)
   
   ##### 	**没有static**的时候：先new，然后引用 . 方法名(实参列表)【先new对象（跟类名一样）然后 引用 . 方法名】
   
   #### 4. 返回值


```java
public static int divide(int a, int b){
	return 1;
}
```

返回值可以不接收
接收值的数据类型要和方法返回值一样或者可以自转
带有 return 关键字语句只要执行，方法结束
return 下面语句永远不执行
void 中的 return 作用是==终止方法==(包括main)

#### 5. 方法、内存、数据结构

- ##### 方法只定义不调用不会执行，并且JVM不会给方法分配“运行所属内存空间”

- ## **JVM**

  #####  在JVM内存划分有三个主要空间

  方法区内存（静态变量放这）

  堆内存：==new 的对象==（实例变量）==放在这==

  栈内存

  1. JVM ( Java虚拟机)主要包括三块内存空间,分别是:栈内存、堆内存、方法区内存。
  2. 堆内存和方法区内存各有1个。一个线程一个栈内存。
  3. 方法调用的时候,该方法所需要的内存空间在栈内存中分配,称为压栈。方法执行结束之后,该方法所属的内存空间释放。称为弹栈。
  4. 栈中主要存储的是方法体当中的局部变量。
  5. 方法的代码片段以及整个类的代码片段都被存储到方法区内存当中，在类加载的时候这些代码片段会载入。
  6. 在程序执行过程中使用new运算符创建的java对象,存储在堆内存当中。对象内部有实例变量,所以实例变量存储在堆内存当中。
  7. 变量分类:
     一局部变量[方法体中声明]
     一成员变量[方法体外声明]
     *实例变量[前边修饰符没有static]
     *静态变量[前边修饰符中有static]
  8. 静态变量存储在方法区内存当中。 [先背会]
  9. 三块内存当中变化最频繁的是栈内存.最先有数据的是方法区内存,垃圾回收器主要针对的是堆内存。
  10. 垃圾回收器[自动垃圾回收机制、GC机制]什么时候会考虑将某个java对象的内存回收呢?
      *当堆内存当中的java对象成为垃圾数据的时候，会被垃圾回收器回收。
      *什么时候堆内存中的java对象会变成垃圾呢?
          没有更多的引用指向它的时候。
          这个对象无法被访问,因为访问对象只能通过引|用的方式访问。

- ##### 关于栈

  *栈 Stack 是一种数据结构

  *数据结构反应数据存储形态

  *计算机专业必修数据结构 + 算法

  *java在不同精通数据结构和算法的前提下也可能进行java开发

  

  *常见数据结构
  -数组
  -队列
  -链表
  -二叉树
  -哈希表/散列表

  | 栈帧--> | 栈顶元素 |
  | ------- | -------- |
  |         |          |
  |         | 栈底元素 |

  栈帧永远指向栈顶元素

  栈顶元素处于活跃状态，其他元素静止

  术语

  压栈/入栈/push
  弹栈/出栈/pop

  结构特点: 
  '先进后出'
  '后进先出

- ##### 方法代码片段属于 class 字节码文件的一部分，==字节码文件加载的时候把其放到方法区==，所以JVM方法区内存最先有数据

- ##### 代码片段放在方法去内存只有一份但是可以被重复调用，每次调用方法要给这个方法分配独立活动场所==在栈内存中分配==

- ##### 方法在调用的时候会分配独立的内存空间，在栈分配，发生==压栈动作==,方法执行结束后，给该方法分配空间全部释放，此时发生==弹栈==动作。

- ##### 局部变量在方法体里面声明，局部变量运行阶段在栈中分配

- ##### 可能的情况下代码可以从main中拿出来当方法

- ##### 字体红色是 JavaSE 的类名(也是标识符)

#### 6. 方法重载  overload

- 不使用方法重载机制，类似的方法要重复写，分开调用

```java
public class OverloadTest
{
	public static vodi main(String[] args){
		int result1 = sumInt(1,2);
        System.out.println(result1);
        double result2 = sumDouble(1.0, 2.0);
        System.out.println(result1);
        long result3 = sumLong(1L, 2L);
        System.out.println(result1);
	}
	
	public static int sumInt(int a, int b){
		return a + b;
	}
	
	public static double sumDouble(double a, double b){
		return a + b;
	}
	
	public static long sumLong(long a, long b){
		return a + b;
	}
}
```

- 方法重载机制让程序员使用功能相似的方法跟使用同一个方法一样
-  这时候程序靠变量类型区分方法
- 功 能不同要让两个方法名字不同

```java
public class OverloadTest
{
	public static vodi main(String[] args){
        System.out.println(sum(1, 2));
        System.out.println(sum(1.0, 2。0));
        System.out.println(sum(1L, 2L));
	}
	
	public static int sum(int a, int b){
		return a + b;
	}
	
	public static double sum(double a, double b){
		return a + b;
	}
	
	public static long sum(long a, long b){
		return a + b;
	}
}
```

1. 功能相似的时候尽可能让方法名相同

2. 在同一个类，方法名相同参数列表不同可以方法重载

   ==方法重载只和名和参数列表有关==

3. ==方法重载和方法返回值类型无关，和修饰符列表无关==

#### 7. 方法递归

1. 方法自身调用自身叫递归

2. 非常占内存，能不用就不用

3. 发生错误（死循环）

   java.lang.StackOverflowError

   栈内存溢出错误

   JVM停止工作

4. 递归必修有结束条件

5. 有些功能必修用，比如目录拷贝

6. 递归求和

   ```java
   public class RecursionTest
   {
   	public static void main(String[] args){
   		int n = 4;
   		int retVaule = sum(n);
   		System.out.println(retVaule);
   	}
   
   	public static int sum(int n){
   		if (n == 1)
   		{
   			return 1;
   		}
   		return n + sum (n-1);
   	}
   }
   ```

### XI 面向对象

1. #### 面向对象和过程的区别

   面向过程关注实现的据图过程，因果关系

   - 优点：业务逻辑简单的程序可以快速开发，前提投入成本低

   - 缺点：很难解决复杂的业务逻辑，软件元素的“耦合度高，只要一环出问题整个环节受影响，导致软件扩展力差

   面向对象关注对象 [独立体] 能完成的哪些功能

   - 优点：耦合度低，扩展力强，适合复杂业务逻辑
   - 缺点：前期投入成本高，需要进行独立体抽取和大量系统分析设计

   C是纯面向过程的，C++是半面向对象，Java纯面向对象

   面向对象更符合人的思维方式

2. #### 面向对象的三大特征

   ==封装、继承、多态==

   所有面向对象语言都有这三个特征

3. #### 采用面向对象的方式开发一个软件，生命周期中：【整个生命周期贯穿使用OO面向对象方式】

   面向对象分析：OOA

   面向对象设计：OOD

   面向对象编程：OOP

4. #### 类和对象的概念

   1. 类是模板，概念，**抽象的结果**
   
      类代表一类事物

      现实世界a和b之间有共同特征进行抽象总结出模板成为类

   2. 对象是实际存在的个体，在现实世界实际存在
   
   3. ###### 软件开发过程
   
      观察现实世界寻找对象
   
      发现对象共同特征
   
      形成类
   
      用代码表述一个类
   
      通过类创建对象
   
      对象协作形成系统
   
   4. 类--实例化-->对象
   
   5. ###### 对象又称为实例/instance
   
   6. 对象--抽象-->类
   
   7. **类描述的是对象的共同特征（如身高）**
   
      **特征在访问的时候必须先创建对象，通过对象访问特征**
   
      *因为特征具体在对象上值不同**
   
      状态动作具体到对象上结果可能不同
   
      对象之间有共同特征，但是具体到对象上有数据差异
   
   8. 类的描述：状态+动作
   
      状态：==类的属性==（属性描述状态）
   
      动作：==类的方法==（方法描述动作）
   
   9. 类的定义【从这里开始写代码】
   
      属性通常采用定义变量来完成定义
   
      ```java
      int no;
      String name;
      boolean sex;
      int age
      ```
   
   10. 引用数据类型
   
       ```java
       String.class
       System.class
           
       User.class
       Product.class
       int age = 10;
       String username = "zhangsan";
       那我也可以：
       Students s = ???;
       ```
   
5. #### 对象的创建和使用

   1. example

      变量在类体里方法外叫成员变量

      所有学生的学号

      但是没个人学号不同，所以访问学号要先创建对象，通过对象访问学号

      学号不嫩直接通过“类访问，所以这些成员变量又叫实例变量。

      对象也被称为实例，实例变量又被称为对象变量【对象级别变量】

      创建了对象成员变量的空间才存在

   ```java
   public chass Student{
       int ....;
   }
   //通过一个类可以实例化n个对象
   //语法：new 类名();
   //new 是一个java运算符
   //运算符作用是创建对象，在JVM开辟新空间
   //方法区内存：在类加载时候，class代码片段被加载到这里
   //栈内存：执行的时候给方法分配空间
   //堆内存：new 的对象在堆内存存储
   public class Test01
   {
       //我们的 Student 是引用数据类型
       //s 是变量名
       //
   	public static void main(String[] atgs){
   		Student s = new Student();
   	}
   }
   ```

   2. ==new 在堆内存开辟的空间叫对象==

   3. **引用：引用一个变量，在变量中保存了另一个java对象的地址**

      Student s = new Student();

      可以重复 new，原来的就扔掉了

   4. 访问实例变量

      java只能通过引用访问堆内存的实例变量

      格式：

      读取：引用.变量名（引用即上面 student 后面的 s）

      修改：引用.变量名 = 值
   
   5. 引用的套娃
   
      ```java
      public class Address
      {
      	String city;
      	String no;
      }
      
      public class Student
      {
      	int no;
      	boolean sex;
      	String name;
      	Address addr;
      }
      
      public class ClassText
      {
      	public static void main(String[] args){
      		Student s = new Student();
      		s.no = 10;
      		s.sex = true;
      		s.name = "Juli";
      		s.addr = new Address();
      		s.addr.city = "BJ";
      		System.out.ptinrln(s.no);
      		System.out.ptinrln(s.sex);
      		System.out.ptinrln(s.name);
      		System.out.ptinrln(s.addr.city);
      	}
      }
      ```
   
   6. 从两条路走到city
   
      ```java
      public class Address
      {
      	String city;
      	String no;
      }
      
      public class Student
      {
      	int no;
      boolean sex;
      	String name;
      	Address addr;
      }
      
      public class ClassText
      {
      	public static void main(String[] args){
              Student s = new Student();
              s.no = 10;
              s.sex = true;
              s.name = "Juli";
              
              Address a = new Address();
              s.addr = a;
              System.out.ptinrln(s.addr.city);//null
              a.city = "BJ";
              System.out.ptinrln(s.addr.city);//BJ
              System.out.ptinrln(s.no);
              System.out.ptinrln(s.sex);
              System.out.ptinrln(s.name);
      	}
      }
      ```
   
   7. 丈夫和妻子
   
      ```java
      public class Test
      {
      	public static void main(String[] args){
      		
      		Husband xiaoMing = new Husband();
      		xiaoMing.name = "小明";
      		
      		
      		Wife xiaoHong = new Wife();
      		xiaoHong.name = "小红";
      
      		xiaoMing.w = xiaoHong;
      		xiaoHong.h = xiaoMing;
      
      		System.out.println(xiaoHong.name);
      		System.out.println(xiaoMing.w.name);
      	}
      }
      
      public class Wife
      {
      	String name;
      
      	Husband h;
      }
      
      public class Husband
      {
      	String name;
      	Wife w;
      }
      ```
   

### XII 面向对象的封装性

1. #### 封装机制

   - 封装之后，对于那个事物来说，看不到这个事物比较复杂的那一面，只能看到该事物简单的那一面。复杂性封装，对外提供简单的操作入口。照相机就是个很好的封装的案例，照相机的实现原理非常复杂，但是对于使用照相机的人来说，操作起来是非常方便的是非常便捷的。还有像电视机也是封装的，电视机内存实现非常复杂，但是对于使用者来说不需要关心内部的实现原理，只需要会操作遥控器就行。
   - 封装之后才会形成真正的“对象”,真正的“独立体”
   - 封装就意味着以后的程序可以重复使用。并且这个事物应该适应性比较强,在任何场合都可以使用。
   - 封装之后，对于事物本身，提高了安全性。[安 全级别高]

2. #### 数据私有化

   - 所有属性私有化，使用private关键字进行修饰,，修饰的所有数据只能在本类中访问。

   - 对外提供简单的操作入口,也就是说以后外部程序要想访问age属性,必须通过这些简单的入口进行访问:

     对外提供两个公开的方法,分别是 set 和 get

     想修改age属性,调用set方法

     想读取age属性,调用get方法

   - set方法的命名规范: 

     ```java
     public void setAge (int a) {
     age = a;
     }
     没有static
     ```

     

   - get方法的命名规范:

     ```java
     public int getAge () {
     return age ;
     }
     没有static
     ```

     可想一下，-一个属性通常访问的时候包括几种访问形式?
     -第一种方式:想读取这个属性的值, 读取get
     -第二种方式:想修改这个属性的值, 修改set

   - **先new对象** (以前的方法是直接调用的)

     然后用 引用.方法名 调取方法

     user.setAge();

     user.intAge
     
     ```java
     public class Customer {
     	private int age;
     	private String name;
     	public int getAge() {
     		return age;
     	}
     	public void setAge(int age) {
     		this.age = age;
     	}
     	public String getName() {
     		return name;
     	}
     	public void setName(String name) {
     		this.name = name;
     	}	
     }
     （源码--自动生成getter和setter）
     
     public class Test {
     	public static void main(String[] args) {
     		Customer c = new Customer();
     		c.setAge(23);
     		c.setName("zhang");
     		System.out.println(c.getAge());
     		System.out.println(c.getName());
     	}
     }
     
     ```
     
   
3. #### 构造方法（和类名一致）

   ###### 		创建对象，初始化实例变量内存空间，构造完了new的时候就可以给括号里面加东西了

   1. **构造方法又被称为构造==函数/构造器/Constructor==**

   2. 构造方法语法结构:
   
      ```java
      [修饰符列表] 构造方法名 (形式参数列表) {
      构造方法体;
   }
      ```

   3. 回顾普通方法的语法结构:

      ```java
      [修饰符列表] 返回值类型 方法名 (形式参数列表) {
      方法体;
      
      }
      ```

   4. 对于构造方法来说，“返回值类型"不需要指定,并且也不能写void, 只要写上void,那么这个方法就成为普通方法了。

   5. 对于构造方法来说，构造方法的方法名必须**==和类名保持一致==**。
   
   6. 构造方法的作用?
      构造方法存在的意义是，通过构造方法的调用，可以**创建对象**。
   
   7. 构造方法应该怎么调用?
   
      普通方法是这样调用的：
   
      ​	**有static**的时候：类名 . 方法名(实参列表)
      ​	**没有static**的时候：引用 . 方法名(实参列表)【先new对象（跟类名一样）然后 引用 . 方法名】
      构造方法：new构造方法名(实参列表)
   
   ```java
   //调用带有static的方法:类名.
   ConstructorTest01.doSome() ;
   doSome() ;
   
   //调用没有static的方法:引用.
   //doOther方法在Cons tructorTest01类当中，所以需要创建Cons tructorTest01对象
   //创建ConstructorTest01对象，调用无参数构造方法。
   ConstructorTest01 tttt = new ConstructorTest01(); //一个类中没有任何构造方法的话,系统默认提供一个无参数构造器
   tttt . doOther() ;|
   }
   public static void doSome () {
   System. out. println ("do some!") ;
   }
   public void doOther() {
   System. out.println("do other"); 
   }
   
   ```
   
   
   
   8. 构造方法调用执行之后，有返回值
      每一个构造方法实际上执行结束之后都有返回值，但是这个"return值;"这样的语句不需要写。构造方法结束的时候java程序自动返回值。返回值类型是构造方法所在类的类型。由于构造方法的返回值类型就是类本身，所以返回值类型不需要编写。当一个类中没有定义任何构造方法的话，系统默认给该类提供一个无参数的构造方法，这个构造方法被称为缺省构造器。
   9. 当一个类显示的将构造方法定义出来了，那么系统则不再默认为这个类提供缺省构造器。建议开发中手动的为当前类提供无参数构造方法。因为无参数构造方法太常用了。
   
   ```java
   public User(){
   	
   }
   ```
   
   10. 构造方法支持重载机制。在一个类当中编写多个构造方法，这多个构造方法显然已经构成方法重载机制。

### XIII 修饰符

1. Java语言提供了很多修饰符，主要分为以下两类：

   - ###### 访问修饰符

   - ###### 非访问修饰符

2. #### 私有访问修饰符-private

   私有访问修饰符是最严格的访问级别，所以被声明为private的方法、变量和构造方法只能被所属类访问，并且类和接口不能声明为private。

   声明为私有访问类型的变量只能通过类中公共的getter方法被外部类访问。

3. #### 公有访问修饰符-public

   被声明为public的类、方法、构造方法和接口能够被任何其他类访问。

   如果几个相互访问的public类分布在不同的包中，则需要导入相应public类所在的包。由于类的继承性，类所有的公有方法和变量**都能被其子类继承**。

4. #### 受保护的访问修饰符-protected

   被声明为protected的变量、方法和构造器能被同一个包中的任何其他类访问，也能够被不同包中的子类访问。

   Protected访问修饰符**不能修饰类和接口**，方法和成员变量能够声明为protected，但是**接口的成员变量和成员方法不能声明为protected**。

   子类能访问Protected修饰符声明的方法和变量，这样就能保护不相关的类使用这些方法和变量。

   - **父类中声明为public的方法在子类中也必须为public。**
   - **父类中声明为protected的方法在子类中要么声明为protected，要么声明为public。不能声明为private。**
   - **父类中声明为private的方法，不能够被继承。**

5. #### static修饰符

   - **静态变量：**

     static关键字用来声明独立于对象的静态变量，无论一个类实例化多少对象，它的静态变量只有一份拷贝。静态变量也被称为类变量。局部变量不能被声明为static变量。

   - **静态方法：**

     static关键字用来声明独立于对象的静态方法。**静态方法不能使用类的非静态变量**。静态方法从参数列表得到数据，然后计算这些数据。

6. #### final 修饰符

   - #### final变量

     final变量能被显式地初始化并且**只能初始化一次**（常量）。被声明为final的对象的引用不能指向不同的对象。但是final对象里的数据可以被改变。也就是说final对象的引用不能改变，但是里面的值可以改变。

   - #### final方法

     类中的Final方法可以被子类继承，但是不能被子类修改。

   - #### final类

     final类不能被继承，没有类能够继承final类的任何特性。

7. #### abstract修饰符

   - #### 抽象类

     抽象类**不能用来实例化对象**（new），声明抽象类的唯一目的是为了将来对该类进行扩充。

     一个类不能同时被abstract和final修饰。如果一个类包含抽象方法，那么该类一定要声明为抽象类，否则将出现编译错误。

     抽象类可以包含抽象方法和非抽象方法。

   - #### 抽象方法

     抽象方法是一种没有任何实现的方法，该方法的的具体实现由子类提供。抽象方法不能被声明成final和static。

     **任何继承抽象类的子类必须实现父类的所有抽象方法**，除非该子类也是抽象类。

     如果一个类包含若干个抽象方法，那么该类必须声明为抽象类。抽象类可以不包含抽象方法。

8. #### synchronized修饰符

   synchronized关键字声明的方法同一时间只能被一个线程访问。Synchronized修饰符可以应用于四个访问修饰符。

9. 。。。。

### XIV 数组

1. #### 声明数组变量

   实例

   下面是这两种语法的代码示例：

   ```java
   double[] myList;         // 首选的方法
   或
   double myList[];         //  效果相同，但不是首选方法
   ```

2. #### 创建数组

   ```java
   Java语言使用new操作符来创建数组，语法如下：
   arrayRefVar = new dataType[arraySize];
   上面的语法语句做了两件事：
   一、使用dataType[arraySize]创建了一个数组。
   二、把新创建的数组的引用赋值给变量 arrayRefVar。
   
   数组变量的声明，和创建数组可以用一条语句完成，如下所示：
   dataType[] arrayRefVar = new dataType[arraySize];
   
   另外，你还可以使用如下的方式创建数组。
   dataType[] arrayRefVar = {value0, value1, ..., valuek};
   
   public class TestArray {
      public static void main(String[] args) {
         double[] myList = {1.9, 2.9, 3.4, 3.5};
   
         // 打印所有数组元素
         for (int i = 0; i < myList.length; i++) {
             System.out.println(myList[i] + " ");
          }
          // 计算所有元素的总和
          double total = 0;
          for (int i = 0; i < myList.length; i++) {
             total += myList[i];
          }
          System.out.println("Total is " + total);
          // 查找最大元素
          double max = myList[0];
          for (int i = 1; i < myList.length; i++) {
             if (myList[i] > max) max = myList[i];
         }
         System.out.println("Max is " + max);
      }
   }
   ```

3. #### foreach循环

    JDK 1.5 引进了一种新的循环类型，被称为foreach循环或者加强型循环，它能在不使用下标的情况下遍历数组。 

   ```java
   public class TestArray {
      public static void main(String[] args) {
         double[] myList = {1.9, 2.9, 3.4, 3.5};
         // 打印所有数组元素
         for (double element: myList) {
            System.out.println(element);
         }
      }
   }
   ```

### XV 日期时间

1. ####  java.util.Date

   ```java
   import java.util.Date;
     
   public class DateDemo {
       public static void main(String args[]) {
       // 初始化 Date 对象
       Date date = new Date();
   
       // 使用 toString() 函数显示日期时间
       System.out.println(date.toString());
   
       // 初始化 Date 对象
       Date date = new Date();
   
       // 使用toString()显示日期和时间
       System.out.printf("%1$s %2$tB %2$td, %2$tY", "Due date:", date);
       System.out.println();
       System.out.println(date);
      }
   }
   ```

2. #### 使用printf格式化日期

   printf方法可以很轻松地格式化时间和日期。使用两个字母格式，它**==以t开头并且以下面表格中的一个字母结尾==**。例如：

   ```java
   import java.util.Date;
   
   public class DateDemo {
   
     public static void main(String args[]) {
        // 初始化 Date 对象
        Date date = new Date();
   
        // 使用toString()显示日期和时间
        String str = String.format("Current Date/Time : %tc", date );
   
        System.out.printf(str);
     }
   }
   ```

   | **字符** | **描述**                         | **例子**                     |
   | -------- | -------------------------------- | ---------------------------- |
   | c        | 完整的日期和时间                 | Mon May 04 09:51:52 CDT 2009 |
   | F        | ISO 8601 格式日期                | 2004-02-09                   |
   | D        | U.S. 格式日期 (月/日/年)         | 02/09/2004                   |
   | T        | 24小时时间                       | 18:05:19                     |
   | r        | 12小时时间                       | 06:05:19 pm                  |
   | R        | 24小时时间，不包含秒             | 18:05                        |
   | Y        | 4位年份(包含前导0)               | 2004                         |
   | y        | 年份后2位(包含前导0)             | 04                           |
   | C        | 年份前2位(包含前导0)             | 20                           |
   | B        | 月份全称                         | February                     |
   | b        | 月份简称                         | Feb                          |
   | n        | 2位月份(包含前导0)               | 02                           |
   | d        | 2位日子(包含前导0)               | 03                           |
   | e        | 2位日子(不包含前导0)             | 9                            |
   | A        | 星期全称                         | Monday                       |
   | a        | 星期简称                         | Mon                          |
   | j        | 3位年份(包含前导0)               | 069                          |
   | H        | 2位小时(包含前导0), 00 到 23     | 18                           |
   | k        | 2位小时(不包含前导0),  0 到 23   | 18                           |
   | I        | 2位小时(包含前导0), 01 到 12     | 06                           |
   | l        | 2位小时(不包含前导0),  1 到 12   | 6                            |
   | M        | 2位分钟(包含前导0)               | 05                           |
   | S        | 2位秒数(包含前导0)               | 19                           |
   | L        | 3位毫秒(包含前导0)               | 047                          |
   | N        | 9位纳秒(包含前导0)               | 047000000                    |
   | P        | 大写上下午标志                   | PM                           |
   | p        | 小写上下午标志                   | pm                           |
   | z        | 从GMT的RFC 822数字偏移           | -0800                        |
   | Z        | 时区                             | PST                          |
   | s        | 自 1970-01-01 00:00:00 GMT的秒数 | 1078884319                   |
   | Q        | 自 1970-01-01 00:00:00 GMT的毫妙 | 1078884319047                |

3. #### 使用SimpleDateFormat格式化日期

   SimpleDateFormat是一个以语言环境敏感的方式来格式化和分析日期的类。SimpleDateFormat允许你选择任何用户自定义日期时间格式来运行。例如

   ```java
   import java.util.*;
   import java.text.*;
   
   public class DateDemo {
      public static void main(String args[]) {
   
         Date dNow = new Date( );
         SimpleDateFormat ft = 
         new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
   
         System.out.println("Current Date: " + ft.format(dNow));
      }
   }
   ```

