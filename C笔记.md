#include <stdio.h>, <stdbool.h>-->bool（逻辑）可用

### 数据类型

| 名          | 类型                 | scanf | printf |
| ----------- | -------------------- | ----- | :----- |
| int         | 整数                 | %d    | %d     |
| char        | 字符                 | %c    | %c     |
| char a[]    | 字符串               | %s    | %s     |
| short       | 整数                 | %hd   | %hd    |
| long        | 整数                 |       |        |
| long long   | 整数                 | %ld   | %ld    |
| float       | 浮点                 | %f    | %f,%e  |
| double      | 浮点                 | %lf   | %f,%e  |
| long double | 浮点                 |       |        |
| unsigned    | 用在名前表示纯二进制 | %u    | &u     |

```c
%7s: 读入七个字符

%e: 科学计数法

&u: 需要看成unsigned的时候

%o: 输入/输出八进制

%x: 输入/输出十六进制

%p: 地址

内部定义：

0开头：八进制

0x开头：十六进制

后面加了f：浮点数

sizeof (数据类型/变量)
```

==sizeof的括号不做运算==

### 判断和循环

```c
if (布尔表达式)
{
}else if (布尔表达式)
{
}else if (布尔表达式)
{
}else {
}
一个语句完成以后就会跳出整个 if 
从上到下判断
count = (count>20)? count - 10 : count + 10;//条件成立执行第一句，否则第二句

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

for ( 初始化表达式 ; 布尔表达式 ; 更新表达式 ){
    
}
    可以三个都不要
    先执行初始化，并且只做一次，再判断循环更新
    先执行循环体后执行更新表达式
    内外循环变量名不能重名

    break 跳出
    continue 可以指定调到哪个循环
    goto out;
...
    out:

do{
	}while ();

while (){
}

```

```C
// 是不是质数
int isPrime(int x){
	int ret = 1;
	int i;
	if (x == 1 || (x%2 == 0 && x !=2) )
		ret = 0;
	for (i = 3; i<x; i+=2){
		if (x%i == 0){
			ret = 0;
			break;
		}
	}
	return ret;
}
```



### 逃逸字符

```c
\b		退格
\n		换行
\r		回车
\t		制表
\"		双引号
\'		单引号
\\		反斜杠
```

（别看源码）

### 函数

__ func __ ：函数名

```c
//类型 名
void sum ( int a, int b )
{	//函数主体
....;
return 0;	//void不能用带值的return
}
```

### 数组

**是一种容器**

**所有数据类型都一样**

下标从 0 开始

#### 定义

- ```c
  int number[100];
  
  int number[][5] = {
  	{0,1,4,2,1},
  	{2,3,4,2,1}
  }
  
  const int a[] = {1,2,3,4,...}//只能通过初始赋值
  ```

- **二维数组必须给列**

- #### int a[100]={2,4,5,7,3,13,145, ..... , }

  后面没有给值就全都是0

- int a[100] = {0}

  全都是0的数组

  ```c
  int a [10] = {
  	[0] = 2, [2] = 3,6
  }
  ```

  用[n]在初始化数据中给出定位

  没有定位的接在前面位置的后面

  其他位置补0

  可以不给数组大小

  适合数据稀疏的数组

#### 遍历

```c
for ( i=0; i<n ; i++ )
{ 
    if (){
    printf("%d", number[i]);
    }
}
```

==注意==：**数组作为参数（传入函数）不能在 [] 给出数组大小，不能用 sizeof 计算元素个数**

如果要看数组的地址不需要取地址符

但是看某个单元的地址需要取地址符

### 指针

&：取地址运算

*：取变量运算（单目运算符）

```c
printf("%x\n", &i);
printf("%p\n", &i);
printf("%lu\n", sizeof(int));
printf("%lu\n", sizeof(&i));
```

#### 指针的定义

```C 
int *p = &i;
int *p,q;//p是指针，q是变量
```

#### 指针传入函数

```C
void f(int *p);
f(&i);
printf("p=%p\n", p);
```

#### 数组是特殊的指针

- 如果要看数组的地址不需要取地址符

  **但是数组单元表达变量，需要取地址符**

- [] 运算符可以对数组做也可以对指针做

  p[0] <==> a[0]

- *可以对指针也可以对数组

- int a[]  <==> int * const a = ...

#### 指针的const

- int * const p = &i;

  一旦得到了某个变量的地址不能再指向别的变量（p 是 const）

- const int *p = &i;

- 不能通过指针去修改变量（所指是 const，*p是const）

  *p = 35会报错

- **区分方法：const在 * 前还是 * 后**

- 可以把非const指针转换成const（传入函数的时候）

#### 指针的运算

- 指针表示数组

    ```C
    int a[10];
    int *p = a;
    *(p+1) --> a[1]
    ```

- *p++

  取出p的数据并移到下一个位置

  常用于数组类的连续空间操作

- void*：不知道指向什么的指针

- 指针类型转换

  ```c
  int *p = &i;
  void*q = (void*)p
  ```

#### 动态内存分配

- int *a = (int *) malloc (n *sizeof(int));
- malloc需要 #include <stdlib.h>
- free ( a ) ; 只能还申请来的首地址
- 写指针的时候可以先给个0地址

#### 指针函数

- 返回本地便利店的地址是有风险的

- 返回全局或静态本地的地址是安全的

- 返回在函数内mallloc的内存是安全的但是会有问题

- 最好是返回传入的指针

  

- 不要用全局在函数间传结果

- 避免使用全局变量

- 使用全局和静态本地的函数线程（多线程）是不安全的

### 字符串

- 字符数组和字符串

  ```c
  char word[] = {'h','e','l','l','o'};// 字符数组
  char word[] = {'h','e','l','l','o','\0'};// 字符串
  char *str = "Hello";// 不能修改内容
  char word[] = "Hello";
  char line[10] = "Hello";
  char buffer[100] = "";// 实际上是空字符串
  char buffer[] = "";// 长度只有1
  
  char a[][10];// a[0]有十个位置，a[1]有十个位置……
  char *a[];// a[0]指向某处，a[1]指向某处……
  ```

- <string.h> --有很多处理字符串的函数

- "Hello" 长度是6， 因为后面还有个0

- 相邻的字符串会自动连接起来

#### 字符串的函数

<string.h>

- int **putchar(int c)** 返回int，向标准输出一个字符

  反回写了几个字符，EOF（-1）表示写失败

- int **getchar(void)** 返回int，向 标准输入 读入一个字符

  返回int是为了返回EOF（-1）

- size_t **strlen(const char*s)** 返回字符串的长度

- int **strcmp(const char *s1, const char *s2)** 比较字符串长度

  s1 等于 s2 返回0

  s1 大于 s2 返回1

  s1 小于 s2 返回-1
  
  ```c
  int mycmp(const cahr * s1, const char* s2){
  	int idx = 0
          while( 1 ){
              if (si[idx] != s2[idx]){
                  break;
              }else if(s1[idx] == '\0'){
                  reak;
              }
              idx++
          }
      return s1[idx] - s2[idx]
  }
  ```
  
- char **strcpy**(char * restrict dst, const char * restrict src) 返回dst（可能越界）

  把 src 字符串拷贝到 dst 

  **restrict** 表明src 和dst 不重叠

  char * dst = (char*)malloc(strlen(src)+1); ==（末尾要放个0）==

  ```C
  char* mycpy(char* dst, const char* src){
      int idx = 0;
      do{
          dst[idx] = src[idx];
      }while( src[idx] );
      return dst;
  }
  ```

- char **stracat(char * restrict s1, const cahr * restrict s2)** 返回 s1（可能越界）

  把s2拷贝到s1后面接乘一个长字符串

  返回s1

  s1要有足够空间

- 安全版本：strncpy（可以拷贝n个字符）, strncat（可以连接n个字符）, strncmp（比较前n个字符长度）

  int strncmp(const char * s1, const char * s2, size _t n)

- char * **strchr(const char * s, int c);** 从左边找

- char * **strrchr(const char *s, int c);** 从右边找

- 返回指针，null表示没找到

- **strstr**

- **strcasestr**

### 枚举

- emun 枚举类型名{名0，名1，... ， 名n}

- 名的类型都是 int

  ```c 
  #include <stdio. h> 
  enum COLOR {RED， YELLOW， GREEN， NumCOLORS};
  
  int main(int argc, char const *argv[]){
      int color = -1;
      char *Co lo rNames [NumCOLORS] = {
      	"red", "yellow", "green",
      };
      char *colorName = NULL;
      printf("输入你喜欢的颜色的代码: ");
      scanf("%d", &color);
      if ( color >=0 && color < NumCOLORS ) {
      	colorName = ColorNames [color]; 
      } else {
     		colorName= "unknown" ;
      }
      printf ("你喜欢的颜色是%s\n", colorName);
      return 0;
  }
  ```

- 可以指定值 enum COLOR{ RED = 1, YELLOW, GREEN = 5, NumCOLORS};

### 结构

#### 声明结构

- ```c
  struct date {
  	int month;
  	int day;
  	int year;
  };
  
  //struct date today = {07,31,2014};
  //struct date thismonth = {.month=7, .year=2014};
  
  struct date today;
  today.month = 04;
  today.day = 16;
  today.year = 2020;
  printf("Today's date is %i %i %i\n"
        today.year, today.month, today.day);
  
  // p1和p2是无名结构，里面都有x和y
  struct{
      int x;
      int y;
  } p1, p2;
  
  //pI和p2都是point，里面有x和y的值t
  struct point {
      int X;
      int y;
  } pl,p2;

  ```
  
- 要访问整个结构，直接用结构变量的名字

- 对于整个结构，可以做赋值、取地址，也可以传递给函数参数

- pI = (struct point){5, 10}; 相当于pI.x= 5; pl.y= 10;

- pl=p2;  相当于pl.x= p2.x;  pl.y= p2.y;

- **结构变量的名字不是结构变量的地址**（但是在 java 对象的名字打印就是地址）

#### 结构和函数、指针

- 返回结构的函数

  ```c
  struct point getStruct(){
  	struct point p;
  	p.x = 1;
  	p.y = 2;
  	return p;
  }
  ```

- 指向结构的指针

  用 **==->==** 表示所指的结构变量的成员

  ```c
  struct date {
      int month;
      int day;
      int year;
  }myday;
  
  struct date *p = &myday;
  
  (*p).month = 12;
  p->month = 12; 
  ```

#### 结构数组

- ```c
  struct time a[2] = {
  	{11,59,59}, {12,0,0}
  };
  ```

结构里面也可以是结构

### 联合

#### 类型定义

- typedef long int64_t;  最后的单词代表了 typedef 和最后一个词中间的所有东西；把中间的所有东西命名为最后一个单词

  ```c
  typedef struct ADate{
      int month;
      int day;
      int year;
  }Date;
  // 那么
  struct ADate a = {9,1,10};
  // 等价于
  Date a = {9,1,10};
  
  
  typedef struct{
      int month;
      int day;
      int year;
  }Date;
  // 结构没有名字，Date代表struct
  ```

#### 联合 union

- 存储

  所有成员共享一个空间

  同一时间只有一个成员有效

  大小是其最大成员

- 初始化

  对第一个成员初始化

### 全局变量

#### 全局变量

- 定义在函数外面
- 全局生存期和作用域
- 任何函数可以使用
- 和任何函数无关
- 没有做初始化的全局变量会得到0值
- 指针会得到NULL值
- 只能用编译时刻已知的值来初始化全局变量（==不能 g1 = g2==）
- 它们的初始化发生在main函数之前
- 函数里有同名变量全局会被隐藏

#### 静态本地变量

- static修饰
- 全局生存期，含数据部作用域
- 函数离开时候静态本地变量会继续存在和保持值
- 初始化只在刚开始进入函数的时候做，**再回去函数的时候值是上次离开保留的值**
- 实际上是特殊的全局变量

### 宏

#### 编译预处理

- #开头是编译与处理指令

- 不是c的成分

- #define PI 3.14159

- #define <名字> <值>

- 不能加分号

- **==名必须是一个单词==**

- 编译与处理会把程序中的名字换成值

- 如果一个宏值有其他宏名也会替换

- 超过一行最后一行之前的行末要加 \

  ```c
  #define PI 3.14159
  #define PI2 2*PI
  #define PRT printf("%f", PI);\
  			printf("%f", PI2)
  ```

  

- 注释不会被当成一部分

- ==宏可以没有值，拿来做条件编译==

#### 预定义的宏

 ```c
__LINE__
__FILE__
__DATE__
__TIME__
__STDC__
 ```

#### 带参数的宏

- 带参数宏定义

     ```c
      #define cube(x) ((x)*(x)*(x))
     ```

- 一切都要有括号

- 整个制要有括号

- 参数出现的地方要有括号

- 最后不要带份好

- 部分宏会被inline取代（检查参数类型）

### 大程序结构

#### 多个源码文件

- 新建项目把几个源码文件加入进去
- 所有源码都编译后连接起来
- 有的IDE有编译和构建两个按钮

#### 头文件

- #include "max.h" （里面有一个函数的定义）

- #include有两种形式来指出要插入的文件

  “ ” 要求编译器首先在当前目录(.c文件所在的目录)寻找这个文件，如果没有，到编译器指定的目录去找

  < > 让编译器只在指定的目录去找

- 编译器自己知道自己的标准库的头文件在哪里

- 环境变量和编译器命令行参数也可以指定寻找头文件的目录

- 一般自己的用双引号，系统的用尖括号

- 在使用和定义一个函数的地方都应该 #include 头文件

- 标准头文件格式

  ```c
  #ifndef _MAX_H_ // 如果没有定义_MAX_H_（__名字_H__）
  #define _MAX_H_ // 那就定义_MAX_H_
  ......
  #endif
  ```

  

#### 不对外的函数

- **==在函数签名加上 static 使得他只能在所编译单元被使用，全局变量同理==**

#### 声明

- 全局变量声明，放在头文件

  extern int gALL

- 声明不产生代码

### 格式化的输入输出

#### printf

% [flag] [width] [.prec] [hlL] type

| Flag      | 含义          |
| --------- | ------------- |
| -         | 左对齐        |
| +         | 前面放 + 或 - |
| （space） | 正数留空      |
| 0         | 0留空         |

| width或prec | 含义                       |
| ----------- | -------------------------- |
| number      | 最小字符数                 |
| *           | 下一个参数是字符数         |
| . number    | 小数点后的位数             |
| . *         | 下一个参数是小数点后的位数 |

| 类型修饰（）HlL | 含义        |
| --------------- | ----------- |
| hh              | 单个字节    |
| h               | short       |
| l               | long        |
| ll              | long long   |
| L               | long double |

| type     | 用于            |
| -------- | --------------- |
| i 或者 d | int             |
| u        | unsigned        |
| o        | 八进制          |
| x        | 16进制          |
| f / F    | float           |
| e / E    | 指数            |
| g / G    | float           |
| a / A    | 十六进制浮点    |
| c        | char            |
| s        | 字符串          |
| p        | 指针            |
| n        | 读入/写出的个数 |

n ：printf 做到这个地方已经输出的字符数填到后面的变量里面

#### scanf

% [flag] type

| flag       | 含义                      |
| ---------- | ------------------------- |
| *          | 调过                      |
| 数字       | 最大字符数                |
| hh         | char                      |
| h          | short                     |
| ll         | long，double              |
| ll         | long long                 |
| L          | long double               |
| d          | int                       |
| i          | 整数，可以16进制可以8进制 |
| u          | unsign int                |
| o，x       | 八进制，16进制            |
| a，e，f，g | float                     |
| c          | char                      |
| s          | 字符串（单词）            |
| [...]      | 所允许的字符              |
| p          | 指针                      |

### 文件输入输出

- FILE* fopen(const char * restrict path, const char * restrict mode);

- int fclose(FIL .E * stream);

- fscanf (FILE *, ...)

- fprintf (FILE *, ...)

  ```c
  FILE* fp = fopen("file","r"); 
  if(fp){
      fscaf(fp...);
      fclose(fp);
  } else {
  ...
  }
  ```

  | r    | 打开只读                                           |
  | ---- | -------------------------------------------------- |
  | r +  | 打开读写，从文件头开始                             |
  | w    | 打开只写。如果不存在则新建，如果存在则清空         |
  | w +  | 打开读写。如果不存在则新建，如果存在则清空         |
  | a    | 打开追加。如果不存在则新建，如果存在则从文件尾开始 |
  | .. x | 只新建，如果文件已存在则不能打开                   |

### 按位运算

& | ~ ^ << >>

- 最低位变成 0：x & 0xFE
- 取一个数的一段：x & 0xFF
- 某个位为1：x | 0x01
- 把两个数拼起来：0x00FF | 0xFF00

## 链表

### 可变数组

可能在足够内存空间的时候无法申请

### 链表

- 节点：数组+指针

- ```c
  typedef struct _node{
  	int value;
  	struct _node *next;
  } Node;
  ```

  

