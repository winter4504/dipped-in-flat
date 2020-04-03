	屏蔽指针概念
	底层语言是C++
I 基本命令
	1-javac
		javac 文件名.扩展名（先进路径）

	2-java
		java 类型名

	3- 输出输入
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

II 注释
	//单行注释
	/*多行注释
	*/
	/**
	* javadoc注释
	*
	*
	*/

III public class 和 class
	
	一个java源文件可以定义多个 class 
	一般只定义一个 class
	public 的 class 不是必须
	源文件public（公开）的类只能在同名文件编译，且只能有一个
	没有主方法会出现运行错误

IV 标识符
	
	1、什么
	   -java源程序中程序员可以自己命名的
	   -黑色高亮
	   -元素
	    *类名
	    *方法名
	    *接口名
	    *常量名

	2、'命名规则
	    *数字、字母、下划线、$组成
	    *不能数字开头
	    *理论没有长度限制
	    *关键字不行
	    *严格大小写

	3、命名规范
	    *最好见名知意
	    *驼峰命名方式
	    //类名接口名：首字母大写，后面单词首字母大写
	    //变量名、方法名：首字母小写，后面单词首字母大写
	    //常量：全部大写

V 字面值
	
	*字面值：
	- 10 、 100 整数
	- 3.14 浮点
	-"abc"
	-'a'
	- ture  、 false (布尔）
	- 'A' 字符型
	-注意：
	    //所有字符串全部要双引号括起来
		//字符型要但因考括起来

VI 变量
	
	-数据类型、名、字面值
	-不同数据不同类型不同空间
	-声明+/*赋值*/才能访问
	-基本规律和C没啥区别
	-/全局位置的变量 '必须有'static int a=0;
	分类
		局部变量
		成员变量	'没有赋值系统会默认赋值
	'类体里面只能定义变量

VII 数据类型
	
	一、主要内容
		
		1 分配空间不同

		2 基本数据类型
		 整数型: byte,short,int,long
		 浮点型: float,double
		 布尔型: boolean
		 //字符型: char

		3 引用数据类型
		-类
		-接口
		-数组
		-"abc" //字符串
		-String s = "abc"
		-String --> 字符串类型
		String username = " Winter ";
		System.out.println("Welcome" + username + "come back");

		4 数据和空间和默认值
		 类型		空间	默认值	取值
		 byte(字节)	1		0		[-128~127]
		 short		2		0		[-32768~32767]
		 int		4		0		[-2147483648~2147483647]
		 long		8		0L
		 float		4		0.0
		 double		8		0.0
		 boolean	1		false
		 char		2		\u0000	[0-65535]

		 //八进制 0 开始
		 //十六进制 0x 开始

		5 字符编码ASCTT：支持英文
		 'a'-->97
		 'A'-->65
		 '0'-->48
	
		6 原码反码补码
			1100110011		原
			1011001100		反 除了符号位取负数
			1011001101		补 反+1
			正数三个码是一样的
		
	1.数据类型char
		
		1、可以存一个字符，一个中文
		 char c = 'a'
		 char k = '中'
		 char g = 43 //把一个0-65535的数字给一个char变量
		 char ch = '\u9999'  //输出一个“香”
		 
		2、 native2ascii --> 中文转编码
		 控制台输入命令回车，输入中文

	
	2.转义字符（'C'的逃逸字符）
		 \b		退格
		 \n		换行
		 \r		回车
		 \t		制表
		 \"		双引号
		 \'		单引号
		 \\		反斜杠

	3. 整数及其精度损失
		'整数字面值默认当 int' 
		//当 long 要加 L,
		//但是 byte 和 short 没有溢出可以直接写
		'所以 long = 2147483648 或以上要写 long = 2147483648L
		强制类型转换 ('变量名')变量/数字 可能会损失精度

	4. 浮点型
		float	单精度
		double	双精度
		'默认当' double
		'后面加' f/F 变 float //(没有类型转换）

		java 自带的高精度 //java.math.BigDecimal
		 *SE类库字节码：\jre\lib\rt.jar
		 *SE类库原码：\jdkx.x.x\src.zip
	
	5. boolean 布尔型
		只有两个值 true , false
		底层存储是 0 和 1 

	二、转换规则
		1、除了 boolean 都能转
		2、小到大叫自动类型转换
		3、浮点型占字节都比整数大
		4、 char 比 int 表达正整数范围更大
		5、 byte short char 混合运算，先转成int再运算
		6、 多类运算，转换成容量最大再运算
		
VIII 运算符
	//算数运算符: 
		+ - * / % ++ --

	//关系运算符: 
		> < == >= <= !=

	//逻辑运算符
		&	逻辑与		all true is true
		|	逻辑或		all false is false
		!	逻辑非
		^	逻辑异或	（两边结果不一样就是 true ）
		&&	短路非		和逻辑与运算结果一样
		||	短路或		和逻辑非运算结果一样
		两边算子都要布尔类型
		短路与存在短路现象（ 判断出 false 后后面表达式不再执行）
		短路或存在短路现象（ 判断出 true 后后面表达式不再执行）
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
	/*字符串连接运算符*/ +
		1.  加法运算
			两边都是数字
		
		2.  字符串连接运算
			只要有一边是字符串
			int i = 10;
			int y = 20;
			System.out.println( "10 + 20 = " + (i + y) );
			System.out.println( i + " + " + y + " = " + ( i + y ) ) ; 

	//三元运算符
		[ 布尔表达式 ? 表达式1 : 表达式2 ]		//这是个运算符
		true : 选择表达式1为整个表达式的执行结果
		false : 选择表达式2为整个表达式的执行结果
		boolean sex = true;
		char c;
		c = sex? 'man' : "woman"; //不能一边字符一边串赋给一个字符
		System.out.println( sex ? "man" : 'woman');//但是在 println 可以

		

	//赋值运算符
		=		+=
		*=		/=		%=
		byte x = 0;
		z += 128;// z = (int)(z+128)     
		'自动做强制类型转换，损失精度'
		不改变类型
		System.out.println( z );//-128
		String --> 字符串类型

IX. 控制语句
		1. if (布尔表达式)
			{
			}else if (布尔表达式)
				{
			}else if (布尔表达式)
				{
			}else {
			}
			一个语句完成以后就会跳出整个 if 
			从上到下判断

		//创建键盘扫面器对象
		java.util.Scanner s = new java.util.Scanner(System.in);
		//调用Scanner对象next()方法接收用户键盘输入
		String userInputContent = s.next();//对应String//程序到这里停下来等你输入
		System.out.println(userInputContent);
		//以int形式接收数字
		int number = s.nextInt();//对应int//程序到这里停下来等你输入
		System.out.println(number);

		2.	switch (int 或 String 字面值或变量)
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

		3. for ( 初始化表达式 ; 布尔表达式 ; 更新表达式 )
			可以三个都不要
			先执行初始化，并且只做一次，再判断循环更新
			先执行循环体后执行更新表达式
			内外循环变量名不能重名
			break 跳出
			continue 可以指定调到哪个循环

X. 方法(函数)
		方法的基础语法
		方法的重载机制overload
		方法是一段独立的代码片段
		'方法里面不能再定义方法'
		例子：
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

		1. 语法结构：
			[修饰符列表] 返回值类型 方法名 (形式参数列表){
				方法体
			}
			
		2. 解释：
			2.1 修饰符列表: 
				*不是必须的
				*暂时统一public static
				*方法修饰符列表有 static 的时候如何调用法
					类名.方法名(实际参数列表)

			2.2 返回值类型
					什么是返回值 (例子: 计算器)
						一个数据
					返回值类型：
						数据都是有类型的，包括基本和引用
					也可能不返回数据: void
					有 return 执行，所在方法结束

			2.3 方法名：
					合法标识符
					见名知意
					小驼峰命名方式
					最好是动词

			2.4 形式参数列表
					形式参数是局部变量： int a
					可以是 0 - n 个, 多个之间用逗号隔开
					形参名字是局部变量的名字
					形式参数和实际参数：
						数量相同
						类型对应相同

		3. 方法调用
			方法中有 static 名关键字可以省略类名
			调用其他类的方法要写类名
			调用方法的程序和方法在同一个类可以不写类名
			() 必须有
			
		4. 返回值
			public static int divide(int a, int b){
				return 1;
			}
			返回值可以不接收
			接收值的数据类型要和方法返回值一样或者可以自转
			带有 return 关键字语句只要执行，方法结束
			return 下面语句永远不执行
			void 中的 return 作用是终止方法(包括main)

		5. 方法、内存、数据结构
			5.1 方法只定义不调用不会执行，并且JVM不会给方法分配“运行所属内存空间”

			5.2 在JVM内存划分有三个主要空间
				方法区内存
				堆内存
				栈内存

			5.3 关于栈
				*栈 Stack 是一种数据结构
				*数据结构反应数据存储形态
				*数据结构是独立的学科
				*计算机专业必修数据结构 + 算法
				*java在不同精通数据结构和算法的前提下也可能进行java开发
				/*常见数据结构
					-数组
					-队列
					-链表
					-二叉树
					-哈希表/散列表
					......				*/

					|				 |
					||——————————————||
			——————> ||   栈顶元素	||
			栈帧	||——————————————||
					||				||
					||——————————————||
					||	 栈底元素	||
					||——————————————||
					|————————————————|

					1. 栈帧永远只想栈顶元素
					2. 栈顶元素处于活跃状态，其他元素静止
					3. 术语
						压栈/入栈/push
						弹栈/出栈/pop
					4. 结构特点: 
						先进后出
						后进先出

			5.4 方法执行的时候方法代码判断放在哪里？执行过程在哪里分配？
				*方法代码片段属于 class 字节码文件的一部分，字节码文件加载
				的时候把其放到方法区，所以JVM方法去内存最先有数据

				*代码片段放在方法去内存只有一份但是可以被重复调用，
				每次调用方法要给这个房费分配独立活动场所，在栈内存中分配
				

