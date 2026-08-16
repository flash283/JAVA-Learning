# Java 基础 + 数据结构笔记

**日期：2026年7月16日**

---

## 一、Java 基础

### 1. 类与对象

- **类**：对一类事物的描述，是模板
- **对象**：根据类创建出来的具体实例
- **创建对象**：使用 `new` 关键字，在堆内存中分配空间
- **成员变量**：类中定义的属性
- **成员方法**：类中定义的行为

### 2. 封装

- **`private`**：私有化属性，外部不能直接访问
- **`getter`**：获取属性值的公开方法
- **`setter`**：设置属性值的公开方法，可加入校验逻辑
- **`this`**：指向当前对象的属性，区分成员变量和局部变量
- **好处**：保护数据安全，控制访问权限

### 3. JavaBean 类

- 属性全部 `private`
- 每个属性提供 `public` 的 `getter` 和 `setter`
- 必须有一个无参构造方法
- **作用**：专门存储和传递数据

### 4. 工具类

- 全部方法都是 `static` 静态方法
- 构造方法用 `private` 修饰，防止创建对象
- 直接通过 `类名.方法()` 调用
- **作用**：提供通用功能，不存储数据

### 5. JavaBean vs 工具类

| | JavaBean | 工具类 |
|------|---------|---------|
| 存数据 | ✅ 存数据 | ❌ 不存数据 |
| 方法类型 | getter/setter | static 方法 |
| 是否创建对象 | 要 new | 不让创建 |
| 举例 | Student、User | Arrays、Math |

---

## 二、数据结构：顺序表

### 1. 基本概念

- **线性表**：元素之间一对一关系，有前后顺序
- **顺序表**：用数组实现的线性表
- **`length`**：当前实际元素个数（会变化）
- **`data.length`**：数组最大容量（固定不变）
- **`data`** 存的是数组的引用（地址），不是数组本身

### 2. 操作分类

| 操作 | 方法 | 说明 |
|------|------|------|
| 增（末尾）| `add()` | 直接放在末尾 |
| 增（指定）| `insert()` | 元素后移，再放入 |
| 删（按位）| `removeAt()` | 元素前移覆盖 |
| 删（按值）| `removeByValue()` | 先找到位置再删除 |
| 改 | `set()` | 直接覆盖指定位置 |
| 查（按位）| `get()` | 通过下标直接访问 |
| 查（按值）| `indexOf()` | 遍历查找 |
| 判断存在 | `contains()` | 调用 indexOf |
| 判空 | `isEmpty()` | 判断 length 是否为 0 |
| 清空 | `clear()` | 只把 length 置 0，数组保留 |
| 销毁 | `destroy()` | 把 data 置 null，数组释放 |

### 3. 插入的步骤

- 检查合法性（未销毁、未满、位置正确）
- 从最后一个元素开始，依次后移一位
- 在目标位置放入新元素
- `length + 1`

### 4. 删除的步骤

- 检查合法性（未销毁、非空、位置正确）
- 保存被删除的值
- 从删除位置开始，依次前移一位
- `length - 1`

### 5. 清空 vs 销毁

| | `clear()` | `destroy()` |
|------|---------|-----------|
| 效果 | 元素逻辑删除 | 整个数组物理释放 |
| 数组还在吗 | ✅ 在 | ❌ 没了（置 null） |
| 还能继续用吗 | ✅ 能 | ❌ 不能 |
| 内存 | 空间保留 | JVM 回收 |

### 6. 关键区分

- **逻辑删除**：只改 `length`，数据还在但不可见，新数据会覆盖
- **物理释放**：把引用置 `null`，JVM 自动回收内存
- **`length`** 是实际存了多少个
- **`data.length`** 是数组最多能存多少个

### 7. 下标两种定义

| 定义方式 | 第一个元素 | 代码写法 |
|---------|-----------|---------|
| 逻辑位序（教材常用）| 第 1 个 | `data[index - 1]`，范围 `1 ~ length` |
| 物理下标（Java 习惯）| 第 0 个 | `data[index]`，范围 `0 ~ length-1` |

- 两种都可以，但**整个类里必须统一**
- Java 里推荐从 0 开始，与数组下标和 LeetCode 习惯一致

---

## 三、今日算法

### 1. 数组最大值和最小值（本地）

- **思路**：遍历数组，用两个变量记录最大值和最小值
- **初始值**：都设为 `arr[0]`
- **时间复杂度**：O(n)
- **注意**：一趟遍历就行，不需要先排序再取两端

### 2. 两数之和（LeetCode 题号 1）

- **思路**：双重 for 循环，外层从 `i=0` 到 `length-2`，内层从 `j=i+1` 到 `length-1`
- **找到目标**：`if (nums[i] + nums[j] == target)` 直接返回
- **返回数组**：`return new int[]{i, j}`
- **兜底**：循环外必须加 `return new int[]{-1, -1}`，否则编译报错
- **为什么用 `new`**：`return {i, j}` 语法不允许，必须 `new int[]{...}` 创建数组
- **时间复杂度**：O(n²)，以后学哈希表可优化到 O(n)

---

## 四、今日总结

| 分类 | 学到的内容 |
|------|-----------|
| Java 基础 | 类与对象、封装、JavaBean、工具类 |
| 数据结构 | 顺序表的定义、增删改查、清空、销毁 |
| 关键概念 | `length` vs `data.length` |
| 关键概念 | 清空（逻辑）vs 销毁（物理） |
| 关键概念 | `data` 是地址引用，`null` 是释放地址 |
| 关键概念 | 插入时元素后移，删除时元素前移 |
| 关键概念 | 逻辑位序（从1）vs 物理下标（从0） |
| 算法 | 遍历找最值、两数之和暴力解 |
| LeetCode | 提交流程、返回数组用 `new int[]{}` |

---

**日期：2026年7月17日**

---

## 一、Java 基础

### 1. 继承

- **`extends`**：子类继承父类，拥有父类所有属性和方法
- **`super`**：调用父类的构造方法或成员
- **作用**：代码复用，提取公共部分到父类
- **Java 只支持单继承**：一个子类只能有一个父类

### 2. 多态

- **方法重写（`@Override`）**：子类重新定义父类的方法，方法名和参数必须相同
- **向上转型**：父类引用指向子类对象，`Animal a = new Cat();`
- **多态的好处**：用父类类型统一操作不同子类，代码更灵活

### 3. 继承 vs 多态

| | 继承 | 多态 |
|------|------|------|
| 关键字 | `extends` | `@Override`、向上转型 |
| 作用 | 复用代码 | 统一接口，灵活调用 |
| 关系 | 多态的前提 | 继承的扩展应用 |

---

## 二、数据结构：链表

### 1. 链表是什么

- 用**节点**存储数据，每个节点指向下一个节点
- 内存中**不连续**，靠指针串联
- 相比顺序表：插入删除快（O(1)），查找慢（O(n)）

### 2. 节点结构

- **数据域**：节点存的值
- **指针域**：存下一个节点的地址（引用）

### 3. 关键概念

| 概念 | 说明 |
|------|------|
| **数据域** | 节点存的值 |
| **指针域** | 存下一个节点的地址 |
| **头节点** | 链表的第一个节点 |
| **尾节点** | `next` 为 `null` 的节点，表示链表结束 |
| **`next = null`** | 默认后面没人，构造时先空着，后面再连接 |

### 4. 节点本身没有位置属性

- 节点的代码**完全一样**
- 是头、是尾、还是中间，取决于 `next` 指向谁：
    - 被其他节点的 `next` 指着 → 不是头
    - 自己的 `next` 指向别人 → 不是尾
    - `next == null` → 尾节点

### 5. 链表 vs 顺序表

| | 顺序表 | 链表 |
|------|--------|------|
| 存储方式 | 数组，连续内存 | 节点 + 指针，分散内存 |
| 查找 | 快（下标直接访问） | 慢（从头一个个找） |
| 插入/删除 | 慢（要移动元素） | 快（改指针指向） |
| 空间 | 固定，可能浪费 | 动态，用多少占多少 |

---

## 三、今日算法

| 题目 | 方法 | 关键点 |
|------|------|--------|
| 反转数组 | 双指针，`left` 和 `right` 交换 | `while (left < right)`，O(n) |
| 移动零（LeetCode 283）| 非零元素前移，后面补 0 | `index` 指针记录非零位置，O(n) |

### 1. 反转数组思路
- [1, 2, 3, 4, 5]
- left=0, right=4 → 交换 1 和 5
- left=1, right=3 → 交换 2 和 4
- left=2, right=2 → 相遇，结束
- 结果：[5, 4, 3, 2, 1]

### 2. 移动零思路
- 遍历数组，遇到非零就放到 index 位置，index++；
遍历完后，index 到末尾全部填 0。

---

## 四、今日总结

| 分类 | 内容 |
|------|------|
| Java 基础 | 继承（`extends`、`super`）、多态（`@Override`、向上转型） |
| 数据结构 | 链表概念、节点定义、`data` 域和 `next` 域 |
| 数据结构 | `next = null` 表示尾节点或未连接 |
| 数据结构 | 顺序表 vs 链表区别 |
| 算法 | 双指针反转数组、双指针移动零 |
---

**日期：2026年7月18日**

---

## 一、Java 基础

### 1. 接口（interface）

- 用 `interface` 定义，用 `implements` 实现
- 接口里都是抽象方法（只有方法声明，没有方法体）
- 一个类可以实现**多个**接口，弥补单继承的不足
- **作用**：定义规范，统一行为

### 2. 抽象类（abstract）

- 用 `abstract` 修饰，不能被实例化（不能 `new`）
- 可以有抽象方法（没有方法体），也可以有普通方法
- 子类继承抽象类后，必须实现所有抽象方法
- **作用**：提取公共代码，强制子类实现特定方法

### 3. 枚举（enum）

- 用 `enum` 定义一组固定的常量
- 常见用法：表示状态、类型、星期、季节等
- 枚举常量的名字通常全大写

### 4. 接口 vs 抽象类

| | 接口 | 抽象类 |
|------|------|------|
| 关键字 | `interface` | `abstract class` |
| 方法 | 全部是抽象方法 | 可以有抽象方法，也可以有普通方法 |
| 多实现 | 一个类可以实现多个接口 | 一个类只能继承一个抽象类 |
| 作用 | 定义规范 | 代码复用 + 强制子类实现 |

---

## 二、数据结构：单链表（带头节点）

### 1. 带头节点的结构

```
head → [头节点 | →] → [首元节点 | →] → [第二个 | →] → ... → [尾节点 | null]
不存数据           第一个存数据的
```

### 2. 关键概念

| 概念 | 说明 |
|------|------|
| 头节点 | 不存有效数据，`head` 指向它 |
| 首元节点 | `head.next`，第一个存数据的节点 |
| 判空 | `head.next == null` |
| 表长 | 从 `head.next` 开始遍历计数，O(n) |

### 3. 带头节点 vs 不带头节点

| | 不带头节点 | 带头节点 |
|------|---------|---------|
| 初始化 | `head = null` | `head = new Node(0)` |
| 判空 | `head == null` | `head.next == null` |
| 第一个存数据的 | `head` 自己 | `head.next` |
| 头插 | 需要特殊处理 | 和中间插入一样 |
| 好处 | 省一个节点空间 | 代码统一，逻辑简单 |

### 4. 基本操作

| 操作 | 方法 | 要点 |
|------|------|------|
| 头插 | `addFirst()` | 新节点 `.next` 指向原首元，头节点指向新节点 |
| 尾插 | `addLast()` | 找到最后一个节点，其 `.next` 指向新节点 |
| 指定插入 | `insert()` | 找到第 i-1 个节点，新节点 `.next` 指向第 i 个 |
| 按位删除 | `removeAt()` | 找到第 i-1 个节点，其 `.next` 跳过第 i 个 |
| 按值删除 | `removeByValue()` | 找到目标的前一个节点，跳过它 |
| 按位查找 | `get()` | 从首元开始，走 i-1 步 |
| 按值查找 | `indexOf()` | 遍历比较，返回位置 |
| 表长 | `size()` | 遍历计数 |
| 清空 | `clear()` | `head.next = null`，保留头节点 |
| 销毁 | `destroy()` | `head = null`，全部回收 |

### 5. 链表 vs 顺序表

| | 顺序表 | 链表 |
|------|--------|------|
| 存储方式 | 数组，连续内存 | 节点 + 指针，分散内存 |
| 查找 | 快（下标直接访问）O(1) | 慢（从头遍历）O(n) |
| 插入/删除 | 慢（移动元素）O(n) | 快（改指针）O(1) |
| 空间 | 固定大小，可能浪费 | 动态，用多少占多少 |
| 获取长度 | O(1) | O(n) |

---

## 三、今日算法

| 题号 | 题目 | 方法 | 关键点 |
|------|------|------|--------|
| 344 | 反转字符串 | 双指针 | 和反转数组一样，原地交换 |
| 125 | 验证回文串 | 双指针 | 跳过非字母数字，忽略大小写 |

### 新接触的方法

| 方法 | 作用 |
|------|------|
| `s.charAt(i)` | 取字符串第 i 个字符（从 0 开始） |
| `s.length()` | 字符串长度（带括号） |
| `Character.isLetterOrDigit(ch)` | 判断是否是字母或数字 |
| `Character.toLowerCase(ch)` | 转成小写字母 |

### 反转字符串思路

```
[ h, e, l, l, o ]
left=0, right=4 → 交换
left=1, right=3 → 交换
left=2, right=2 → 停止
结果：[ o, l, l, e, h ]
```

### 验证回文串思路

```
左右双指针，跳过非字母数字，统一转小写比较，
任何一处不等就是 false，全部通过就是 true。
```

---

## 四、今日总结

| 分类 | 内容 |
|------|------|
| Java | 接口（`interface`）、抽象类（`abstract`）、枚举（`enum`） |
| 数据结构 | 带头节点单链表的增删查、表长、清空、销毁 |
| 数据结构 | 头节点 vs 首元节点的区别 |
| 数据结构 | 带头节点 vs 不带头节点的区别 |
| 算法 | 双指针反转字符串、验证回文串 |
| 新方法 | `charAt()`、`length()`、`Character` 工具类 |

**日期：2026年7月19日**

---

## 一、Java 基础：集合框架

### 1. List

- **ArrayList**：基于数组，有序可重复，查询快（O(1)），增删慢（O(n)）
- **LinkedList**：基于链表，有序可重复，增删快（O(1)），查询慢（O(n)）

**遍历方式**：
- `for` 循环 + `get(i)`
- 增强 `for` 循环（`for-each`）
- 迭代器 `Iterator`

### 2. Set

- **HashSet**：基于哈希表，无序不可重复
- 增删查都是 O(1)
- 常用方法：`add()`、`remove()`、`contains()`、`size()`

### 3. Map

- **HashMap**：键值对，键不可重复，值可重复
- 常用方法：`put(key, value)`、`get(key)`、`remove(key)`、`containsKey(key)`
- `getOrDefault(key, defaultValue)`：有就取值，没有就返回默认值

### 4. List vs Set vs Map

| | List | Set | Map |
|------|------|------|------|
| 存储 | 单个元素 | 单个元素 | 键值对 |
| 有序 | ✅ 有序 | ❌ 无序 | ❌ 无序 |
| 可重复 | ✅ 可重复 | ❌ 不可重复 | 键不可重复 |
| 实现类 | ArrayList、LinkedList | HashSet | HashMap |

---

## 二、数据结构

### 1. 循环链表

- 尾节点的 `next` 指向头节点，形成一个环
- 遍历结束条件：`p.next == head` 或 `p == head`（用 do-while）
- 判空：`head == null`

**合并两个循环链表**：
- 找链表 A 的尾节点，找链表 B 的尾节点
- A 尾接 B 头，B 尾接 A 头，形成新环

### 2. 双向链表

- 每个节点有两个指针：`prev`（前驱）和 `next`（后继）
- 可正向遍历，也可反向遍历
- 删除节点时不需要找前驱，已知节点就能自删除

**双向链表节点结构**：

| 指针 | 方向 | 作用 |
|------|------|------|
| `prev` | 指向前一个节点 | 反向遍历，删除操作 |
| `next` | 指向后一个节点 | 正向遍历 |

### 3. 双向链表 vs 单链表

| | 单链表 | 双向链表 |
|------|------|------|
| 指针 | `next` | `prev` + `next` |
| 遍历 | 只能往后 | 可前可后 |
| 删除 | 需要找前驱节点 | 已知节点就能删 |
| 空间 | 少一个指针 | 多一个 `prev` |

---

## 三、今日算法

| 题号 | 题目 | 方法 | 关键点 |
|------|------|------|--------|
| 387 | 字符串中第一个唯一字符 | 双重循环 / HashMap | 统计每个字符出现次数 |
| 14 | 最长公共前缀 | 纵向扫描 | 以第一个字符串为基准，逐位比较 |

### 387 思路

- **暴力法**：每个字符和全字符串比较，`count == 1` 就是唯一
- **HashMap 法**：第一次遍历统计频率，第二次遍历找第一个频率为 1 的
- `getOrDefault(key, 默认值)`：有就取值，没有就返回默认值

### 14 思路

- 以第一个字符串为基准
- 逐位字符和后面所有字符串比较
- 某位不相等或长度不够就返回前面匹配的部分

---

## 四、今日总结

| 分类 | 内容 |
|------|------|
| Java 集合 | ArrayList、LinkedList、HashSet、HashMap |
| Java 方法 | `getOrDefault` 用法 |
| 数据结构 | 循环链表结构 + 合并 |
| 数据结构 | 双向链表结构 + 增删查 |
| 算法 | 字符频率统计、纵向扫描 |



**日期：2026年7月20日**

---

## 一、Java 基础：异常处理

### 1. 异常体系

| 关键字 | 作用 |
|------|------|
| **try** | 包裹可能出错的代码 |
| **catch** | 捕获并处理异常 |
| **finally** | 无论是否异常都会执行（释放资源） |
| **throws** | 声明方法可能抛出的异常，交给调用者处理 |
| **throw** | 手动抛出一个异常 |

### 2. 常见异常类型

| 异常 | 触发条件 |
|------|------|
| `NullPointerException` | 用 `null` 调用方法或属性 |
| `ArrayIndexOutOfBoundsException` | 数组下标越界 |
| `ArithmeticException` | 除以 0 |

### 3. 执行流程

```
try 中的代码：
正常 → 跳过 catch → 执行 finally
出错 → 跳到对应的 catch → 执行 finally
```

`finally` 里的代码**一定会执行**，即使 try 或 catch 里有 `return`。

---

## 二、数据结构：栈

### 1. 栈的概念

- **先进后出（LIFO：Last In First Out）**
- 只能在一端操作（栈顶）
- 像一摞盘子：放的时候放最上面，取的时候从最上面取

### 2. 顺序栈实现

用数组 + `top` 指针实现：

| 操作 | 做法 | 时间复杂度 |
|------|------|------|
| `push` | `top++`，放入元素 | O(1) |
| `pop` | 取出元素，`top--` | O(1) |
| `peek` | 返回 `data[top]` | O(1) |
| 判空 | `top == -1` | O(1) |
| 判满 | `top == data.length - 1` | O(1) |

### 3. 栈 vs 顺序表

| | 顺序表 | 栈 |
|------|------|------|
| 插入 | 任意位置 | 只能栈顶 |
| 删除 | 任意位置 | 只能栈顶 |
| 访问 | 任意位置 | 只能栈顶 |
| 核心 | 随机访问 | 先进后出 |

### 4. C 语言 vs Java 实现

| | C 语言 | Java |
|------|------|------|
| 栈底 | `base` 指针 | `data[0]` |
| 栈顶 | `top` 指针 | `top` 下标 |
| 内存 | 手动分配释放 | JVM 管理，`data` 本身就是引用 |

---

## 三、今日算法

| 题号 | 题目 | 方法 | 关键点 |
|------|------|------|--------|
| 206 | 反转链表 | 三指针法 | `prev`、`curr`、`next` 逐个反转 |
| 21 | 合并两个有序链表 | 双指针 + 虚拟头节点 | 谁小谁先走，剩余直接接上 |

### 反转链表思路（三指针法）

```
原链表：1 → 2 → 3 → null

prev=null, curr=1
循环：
next = curr.next   （记住下一个）
curr.next = prev   （反转当前节点，断开旧链）
prev = curr        （prev 后移）
curr = next        （curr 后移）
结束，返回 prev
结果：3 → 2 → 1 → null
```

**不需要手动消除旧链接**，每轮 `curr.next = prev` 自动断开旧链。

### 合并两个有序链表思路

```
list1: 1 → 3 → 5
list2: 2 → 4 → 6

虚拟头节点 dummy，curr 指向 dummy

比较：1 < 2 → curr 接 1 → list1 后移
比较：3 > 2 → curr 接 2 → list2 后移
...
某个链表空了 → 把另一个直接接上
返回 dummy.next
```

---

## 四、今日总结

| 分类 | 内容 |
|------|------|
| Java | 异常处理（try-catch-finally、throws、throw） |
| 数据结构 | 栈的概念、顺序栈实现 |
| 数据结构 | 栈 vs 顺序表区别 |
| 数据结构 | C 语言双指针 vs Java 单指针实现 |
| 算法 | 三指针反转链表、虚拟头节点合并链表 |

---

**日期：2026年7月22日**
## 一、Java 基础：文件读写

### 1. File 类

- 文件和目录的操作
- `exists()`：判断是否存在
- `mkdir()`：创建目录
- 不能直接读写内容

### 2. 字符流

| 类 | 作用 | 文件不存在时 |
|------|------|------|
| **FileReader** | 读取文本文件 | ❌ 抛异常 |
| **FileWriter** | 写入文本文件 | ✅ 自动创建文件 |

### 3. 缓冲流

| 类 | 作用 |
|------|------|
| **BufferedReader** | 带缓冲的读取，`readLine()` 一次读一行 |
| **BufferedWriter** | 带缓冲的写入，效率更高 |

### 4. 读写步骤

**写文件**：`new FileWriter("文件名")` → `write()` → `close()`

**读文件**：`new FileReader("文件名")` → `new BufferedReader()` → `readLine()` → `close()`

---

## 二、数据结构：队列

### 1. 队列概念

- **先进先出（FIFO：First In First Out）**
- 像排队：先来的先服务
- 一端入队（队尾），一端出队（队头）

### 2. 顺序队列

- 用数组实现，两个指针 `front`（队头）和 `rear`（队尾）
- **假溢出**：`rear` 到数组末尾但前面还有空位，无法继续入队

### 3. 循环队列

用取模运算 `%` 解决假溢出，把数组变成环形。

### 4. 循环队列关键操作

| 操作 | 做法 |
|------|------|
| 入队 | `data[rear] = value`，`rear = (rear + 1) % length` |
| 出队 | 取 `data[front]`，`front = (front + 1) % length` |
| 判空 | `front == rear` |
| 判满 | `(rear + 1) % length == front` |
| 元素个数 | `(rear - front + length) % length` |

### 5. 为什么数组多开一个位置

如果不留空位，空和满时 `front == rear` 都一样，无法区分。多留一个位置后：
- `front == rear` → 空
- `(rear + 1) % length == front` → 满
- 数组长度 n+1，最多存 n 个元素

### 6. 栈 vs 队列

| | 栈 | 队列 |
|------|------|------|
| 进出原则 | 先进后出（LIFO） | 先进先出（FIFO） |
| 操作端 | 一端（栈顶） | 两端（队头出，队尾入） |
| 比喻 | 一摞盘子 | 排队 |
| 应用 | 括号匹配、函数调用 | 任务调度、BFS |

---

## 三、Git 基础

### 1. Git 是什么

版本控制工具，记录代码每次修改，能随时回退到历史版本。

### 2. 基本流程

```bash
git init              # 初始化本地仓库
git add .             # 把所有文件加入暂存区
git commit -m "描述"   # 提交（存档）
git push              # 推送到 GitHub
```

### 3. 与 GitHub 的关系

| Git | GitHub |
|------|------|
| 本地版本控制工具 | 云端代码托管平台 |
| 装在自己电脑上 | 网页上的仓库 |
| 管理代码历史 | 备份和分享代码 |

### 4. 首次配置

```bash
git config --global username.name "你的用户名"
git config --global username.email "你的邮箱"
```

---

## 四、今日算法

| 题号 | 题目 | 方法 | 关键点 |
|------|------|------|--------|
| 20 | 有效的括号 | 栈 | 左括号入栈，右括号和栈顶匹配 |
| 155 | 最小栈 | 双栈 | 一个存数据，一个存最小值 |

### 有效的括号思路

```
遍历字符串：
  左括号 → 入栈
  右括号 → 栈为空？false；栈顶不匹配？false；匹配 → 出栈
遍历完，栈为空 → true
```

**不是回文判断**，不能用双指针。

### 最小栈思路

| 操作 | stack | minStack |
|------|------|------|
| push 5 | [5] | [5] |
| push 2 | [5, 2] | [5, 2] |
| push 3 | [5, 2, 3] | [5, 2] |
| pop | 出栈 3，minStack 不变 | |
| getMin | 返回 minStack 栈顶 = 2 | |

`push` 时如果 `val <= minStack.peek()` 才压入最小栈，保证 O(1) 取最小值。

---

## 五、今日总结

| 分类 | 内容 |
|------|------|
| Java | File、FileReader/Writer、BufferedReader/Writer |
| 数据结构 | 顺序队列、循环队列、假溢出问题 |
| 数据结构 | 栈 vs 队列对比 |
| 工具 | Git 安装配置、init/add/commit/push |
| 算法 | 栈应用：括号匹配、最小栈 |



**日期：2026年7月23日**

---

## 一、Java 基础：哈希表

### 1. 哈希表是什么

通过**哈希函数**把键（key）映射到数组下标，实现快速查找，时间复杂度 **O(1)**。

### 2. HashMap 底层原理

| 知识点 | 说明 |
|------|------|
| **哈希函数** | 把 key 算成数组下标 |
| **哈希冲突** | 两个 key 算出同一个下标 |
| **链表法** | 冲突时用链表把同一下标的元素串起来 |
| **红黑树** | 链表太长（>8）时转成红黑树，提高查找效率 |

### 3. HashMap vs HashSet

| | HashMap | HashSet |
|------|------|------|
| 存储 | 键值对 | 只有键，值是一个占位对象 |
| 底层 | 数组 + 链表 + 红黑树 | 基于 HashMap 实现 |
| 常用方法 | `put`、`get`、`remove` | `add`、`contains`、`remove` |

### 4. 为什么 HashMap 快

- 通过哈希函数直接算出下标，不需要遍历
- 查找：O(1)，冲突严重时退化到 O(n) 或 O(log n)

---

## 二、算法：二分查找

### 1. 二分查找前提

**数组必须有序**（从小到大排序）。

### 2. 核心思路

每次取中间值比较，缩小一半搜索范围。

```
[1, 3, 5, 7, 9], target = 5

mid = (0+4)/2 = 2, nums[2] = 5 → 找到，返回 2
```

### 3. 代码模板

```java
int low = 0;
int high = nums.length - 1;
while (low <= high) {
    int mid = (low + high) / 2;
    if (target == nums[mid]) {
        return mid;
    } else if (target > nums[mid]) {
        low = mid + 1;
    } else {
        high = mid - 1;
    }
}
return -1;  // 没找到
```

### 4. 关键细节

| 要点 | 说明 |
|------|------|
| `mid` 在循环内计算 | 每轮重新算，不能写在外面 |
| `low <= high` | 区间只剩一个元素也要判断 |
| `low = mid + 1` | 目标在右边，跳过 mid |
| `high = mid - 1` | 目标在左边，跳过 mid |

---

## 三、今日算法

| 题号 | 题目 | 类型 | 关键点 |
|------|------|------|--------|
| 704 | 二分查找 | 基础二分 | 有序数组，`while(low<=high)` |
| 35 | 搜索插入位置 | 二分变形 | 找不到返回 `low`（插入位置） |

### 704 vs 35 区别

| 题号 | 找不到时返回 |
|------|------|
| 704 二分查找 | `-1` |
| 35 搜索插入位置 | `low`（插入位置） |

---

## 四、今日总结

| 分类 | 内容 |
|------|------|
| Java | HashMap 底层原理：哈希函数、哈希冲突、链表法、红黑树 |
| Java | HashMap vs HashSet |
| 算法 | 二分查找模板、`low <= high`、`mid` 在循环内 |
| 算法 | 搜索插入位置：`return low` 而不是 `mid+1` |
---

**日期：2026年7月24日**

---

## 一、树的基础概念

### 1. 什么是树

- 一种**非线性**数据结构，节点之间有层级关系
- 像文件夹目录：根目录 → 子文件夹 → 文件

### 2. 基本术语

| 术语 | 说明 |
|------|------|
| **根节点** | 最顶层的节点，没有父节点 |
| **父节点 / 子节点** | 直接上层 / 下层节点 |
| **叶子节点** | 没有子节点的节点 |
| **深度** | 从根节点到当前节点的边数 |
| **高度** | 从当前节点到最远叶子节点的边数 |

### 3. 二叉树

每个节点**最多有两个子节点**：左子树和右子树。

### 4. 特殊二叉树

| 类型 | 条件 |
|------|------|
| **满二叉树** | 每一层都是满的 |
| **完全二叉树** | 除了最后一层，其他层都满，最后一层从左到右排列 |

### 5. 二叉树的存储

| 方式 | 做法 | 适用场景 |
|------|------|------|
| **顺序存储** | 用数组存，下标 i 的左子节点在 2i+1 | 完全二叉树 |
| **链式存储** | 节点有 `left` 和 `right` 两个指针 | 通用 |

### 6. 链式存储节点结构

```java
class TreeNode {
    int val;
    TreeNode left;   // 指向左子节点
    TreeNode right;  // 指向右子节点
}
```

### 7. 二叉树 vs 链表

| | 链表 | 二叉树 |
|------|------|------|
| 指针数量 | 1 个 `next` | 2 个 `left` + `right` |
| 结构 | 一条线 | 分叉，有左右子树 |
| 遍历 | 只能往后走 | 可以走左边或右边 |

---

## 二、二叉树的遍历（递归）

### 1. 三种遍历顺序

| 遍历方式 | 顺序 | 记忆口诀 |
|------|------|------|
| **前序遍历** | 根 → 左 → 右 | 先看自己，再看左边，最后右边 |
| **中序遍历** | 左 → 根 → 右 | 先左后中再右 |
| **后序遍历** | 左 → 右 → 根 | 先看左右，最后看自己 |

### 2. 递归代码模板

```java
// 前序
void preOrder(TreeNode root) {
    if (root == null) return;
    System.out.print(root.val);  // 根
    preOrder(root.left);         // 左
    preOrder(root.right);        // 右
}

// 中序
void inOrder(TreeNode root) {
    if (root == null) return;
    inOrder(root.left);          // 左
    System.out.print(root.val);  // 根
    inOrder(root.right);         // 右
}

// 后序
void postOrder(TreeNode root) {
    if (root == null) return;
    postOrder(root.left);        // 左
    postOrder(root.right);       // 右
    System.out.print(root.val);  // 根
}
```

### 3. 遍历结果示例

```
        1
       / \
      2   3
     / \
    4   5

前序：1 → 2 → 4 → 5 → 3
中序：4 → 2 → 5 → 1 → 3
后序：4 → 5 → 2 → 3 → 1
```

### 4. 递归的特点

- 代码简洁
- 空间复杂度 O(h)，h 为树的高度
- 递归太深可能导致栈溢出

---

## 三、今日算法

| 题号 | 题目 | 方法 | 关键点 |
|------|------|------|--------|
| 34 | 查找元素第一个和最后一个位置 | 二分找边界 | 左右边界分别二分，`nums[mid] >= target` 找左，`nums[mid] <= target` 找右 |
| 69 | x 的平方根 | 二分查找 | `mid <= x/mid` 避免溢出，记录 `ans` |

### 34 思路：两次二分

| 边界 | 条件 | 最终指针 |
|------|------|------|
| 左边界 | `nums[mid] >= target` → `high = mid - 1` | `low` 停在第一个 target |
| 右边界 | `nums[mid] <= target` → `low = mid + 1` | `high` 停在最后一个 target |

### 69 思路：二分找"平方最接近但不超过 x"

- `mid <= x / mid` → 满足条件，记录 `ans = mid`，往右试更大的
- `mid > x / mid` → 不满足，往左找

### 扩展：牛顿迭代法

公式：`r = (r + x / r) / 2`

取"当前猜测值"和"x / 猜测值"的平均数，不断逼近平方根，收敛极快。

---

## 四、今日总结

| 分类 | 内容 |
|------|------|
| 数据结构 | 树/二叉树概念、满二叉树、完全二叉树 |
| 数据结构 | 链式存储节点定义 |
| 数据结构 | 前中后序遍历（递归版） |
| 数据结构 | 二叉树 vs 链表对比 |
| 算法 | 二分查找找左右边界 |
| 算法 | 二分查找求平方根（防溢出） |
---

**日期：2026年7月25日**

---

## 一、递归

### 1. 递归三要素

| 要素 | 说明 |
|------|------|
| **终止条件** | 什么时候停止递归 |
| **递归调用** | 自己调用自己，问题规模变小 |
| **回溯计算** | 递归返回后处理结果 |

### 2. 示例：阶乘

```java
public int jiecheng(int n) {
    if (n == 0 || n == 1) return 1;   // 终止条件
    return n * jiecheng(n - 1);        // 递归调用 + 回溯计算
}
```

**注意**：0! = 1，不是 0。

### 3. 递归执行过程

```
jiecheng(4) = 4 * jiecheng(3)
            = 4 * 3 * jiecheng(2)
            = 4 * 3 * 2 * jiecheng(1)
            = 4 * 3 * 2 * 1 = 24
```

---

## 二、栈和队列的相互转换

### 1. 核心思想

**通过"倒一下"让顺序反转**。

| 栈顶 = 最新的 | 队首 = 最老的 |
|------|------|
| 入栈顺序 1→2→3，栈顶是 3 | 入队顺序 1→2→3，队首是 1 |

### 2. 栈 vs 队列

| | 栈（Stack） | 队列（Queue） |
|------|------|------|
| 添加 | `push()` | `offer()` / `add()` |
| 取出并删除 | `pop()` | `poll()` |
| 只看不删 | `peek()`（看栈顶） | `peek()`（看队首） |
| 判空 | `isEmpty()` | `isEmpty()` |

---

## 三、今日算法

### 232 用栈实现队列

**两个栈**：s1 负责入队，s2 负责出队。

| 操作 | 做法 |
|------|------|
| `push` | 直接压入 s1 |
| `pop/peek` | 如果 s2 为空，把 s1 全部倒入 s2，再从 s2 弹出 |
| `empty` | s1 和 s2 都空才是空 |

**核心**：s1 倒入 s2 后，s2 的栈顶就是最早的队首。

```
push(1,2,3)：s1=[1,2,3]，s2=[]
pop()：s1 倒入 s2 → s2=[3,2,1] → 弹出 1 ✅
```

### 225 用队列实现栈

**两个队列**：q1 存栈元素（队首就是栈顶），q2 是 push 时的临时工具。

| 操作 | 做法 |
|------|------|
| `push` | 新元素放入 q2，q1 全部倒入 q2，交换 q1 和 q2 |
| `pop` | 直接 `q1.poll()` |
| `top` | `q1.peek()` |
| `empty` | `q1.isEmpty()` |

**核心**：每次 push 后 q1 的队首永远是最后加入的元素（栈顶）。

```
push(3)：q1=[1,2] → q2=[3,1,2] → 交换 → q1=[3,1,2] → 队首=3 ✅
```

---

## 四、今日总结

| 分类 | 内容 |
|------|------|
| 递归 | 三要素：终止条件、递归调用、回溯计算 |
| 递归 | 阶乘：0! = 1 |
| 栈实现队列 | 两个栈，s2 空时倒入，s2 栈顶变队首 |
| 队列实现栈 | 两个队列，push 时新元素变队首 |
| 方法对比 | Stack：push/pop/peek，Queue：offer/poll/peek |




**日期：2026年7月26日**

---

## 一、数据结构：DFS 与 BFS 入门

### 1. 概念对比

| | DFS（深度优先搜索） | BFS（广度优先搜索） |
|------|------|------|
| 策略 | 一条路走到底，再回溯 | 一层一层往外扩 |
| 比喻 | 走迷宫，遇到死路回头 | 水波纹扩散 |
| 数据结构 | 栈（递归） | 队列 |
| 二叉树对应 | 前序/中序/后序 | 层序遍历 |

### 2. 二叉树中的应用

```
        1
       / \
      2   3
     / \
    4   5

DFS 前序：1 → 2 → 4 → 5 → 3
BFS 层序：1 → 2 → 3 → 4 → 5
```

---

## 二、栈的经典应用

### 1. 单调栈

- 栈中元素保持单调递增或递减
- 适合解决"找下一个更大/更小元素"的问题

### 2. 逆波兰表达式（后缀表达式）

- 运算符写在操作数后面：`3 4 +` 等于 `3 + 4`
- 计算机不需要括号就能直接计算

---

## 三、今日算法

### 739 每日温度

**方法**：单调栈（存下标）

| 步骤 | 操作 |
|------|------|
| 当前温度 ≤ 栈顶温度 | 当前下标入栈 |
| 当前温度 > 栈顶温度 | 弹出栈顶，计算天数差，继续比较 |

- 时间复杂度：O(n)，每个元素最多入栈出栈一次
- 不能用队列，因为需要后进的数据决定前面的结果

### 150 逆波兰表达式求值

**方法**：栈

| 步骤 | 操作 |
|------|------|
| 遇到数字 | 入栈 |
| 遇到运算符 | 弹出两个数，计算，结果入栈 |

**关键注意**：
- 先弹出的是第二个操作数 `b`，后弹出的是第一个操作数 `a`
- 减法：`a - b`，除法：`a / b`
- Java 整数除法自动向下取整

---

## 四、今日总结

| 分类 | 内容 |
|------|------|
| 数据结构 | DFS（深度优先）vs BFS（广度优先） |
| 数据结构 | 二叉树前中后序 = DFS，层序 = BFS |
| 算法 | 单调栈：找下一个更大元素 |
| 算法 | 逆波兰表达式：后缀表达式用栈求值 |
| 方法 | `Character.isDigit()` / `isLetter()` |

---

**日期：2026年7月27日**

---

## 一、MySQL 基础

### 1. 数据库概念

| 术语 | 说明 |
|------|------|
| 数据库（Database） | 存放表的容器 |
| 表（Table） | 数据以行和列的形式存储 |
| 字段（Column） | 表的列 |
| 记录（Row） | 表的一行数据 |

### 2. 基本 SQL 语法

```sql
-- 建库
CREATE DATABASE mydb;
USE mydb;

-- 建表
CREATE TABLE student (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20),
    age INT
);

-- 增
INSERT INTO student (name, age) VALUES ('张三', 18);

-- 删
DELETE FROM student WHERE id = 1;

-- 改
UPDATE student SET age = 20 WHERE name = '张三';

-- 删表
DROP TABLE student;
```

### 3. SELECT 查询

```sql
SELECT 列名 FROM 表名 WHERE 条件;
```

**常用关键字**：

| 关键字 | 作用 | 示例 |
|------|------|------|
| `DISTINCT` | 去重 | `SELECT DISTINCT name FROM student;` |
| `AS` | 别名（可省略） | `SELECT name AS 姓名 FROM student;` |
| `DESC` | 显示表结构 | `DESC student;` |

### 4. WHERE 运算符

| 类型 | 运算符 |
|------|------|
| 比较 | `=` `>` `<` `>=` `<=` `<>` `!=` |
| 逻辑 | `AND` `OR` `NOT` |
| 范围 | `BETWEEN...AND` `IN` |
| 模糊 | `LIKE` `%`（多个字符） `_`（单个字符） |
| 空值 | `IS NULL` `IS NOT NULL` |

### 5. NULL 值

- `NULL` 参与运算，结果永远是 `NULL`
- `IFNULL(列名, 默认值)` 把 NULL 替换成指定值

### 6. 着重号

- 反引号 `` ` `` 包裹表名、列名（和关键字冲突时用）
- 单引号 `' '` 包裹字符串值

### 7. 查询常数

```sql
SELECT 100, '张三', name FROM student;
-- 每行都带上这些常数值
```

---

## 二、今日算法

### 49 字母异位词分组

**方法**：HashMap + 排序

| 步骤 | 操作 |
|------|------|
| 1 | 每个单词排序作为 key |
| 2 | `map.containsKey(key)` 判断是否存在 |
| 3 | 不存在 → `put(key, new ArrayList<>())` 建新列表 |
| 4 | `map.get(key).add(s)` 添加单词 |
| 5 | `map.values()` 返回所有分组 |

**关键方法**：
- `Arrays.sort(chars)` — 字符数组排序
- `new String(chars)` — 字符数组转字符串
- `map.values()` — 获取所有 value

### 202 快乐数

**方法**：HashSet 检测循环

| 步骤 | 操作 |
|------|------|
| 1 | `getNext(n)` 计算各位数字平方和 |
| 2 | HashSet 记录出现过的数 |
| 3 | 重复出现 → `false`，变成 1 → `true` |

**getNext 方法**：
```
n % 10 → 取最后一位
n / 10 → 去掉最后一位
d * d → 累加到 sum
```

---

## 三、今日总结

| 分类 | 内容 |
|------|------|
| MySQL | 建库建表、增删改查、WHERE 运算符 |
| MySQL | DISTINCT、AS 别名、NULL、着重号 |
| 算法 | HashMap 分组（排序 key） |
| 算法 | HashSet 检测循环 |

---
**日期：2026年7月28日**

---

## 一、MySQL 单表查询进阶

### 1. ORDER BY 排序

```sql
SELECT * FROM student ORDER BY age ASC;   -- 升序（默认）
SELECT * FROM student ORDER BY age DESC;  -- 降序
```

| 关键字 | 含义 |
|------|------|
| `ASC` | 升序，从小到大 |
| `DESC` | 降序，从大到小 |

### 2. 聚合函数

| 函数 | 作用 |
|------|------|
| `COUNT(列)` | 统计行数 |
| `SUM(列)` | 求和 |
| `AVG(列)` | 平均值 |
| `MAX(列)` | 最大值 |
| `MIN(列)` | 最小值 |

**注意**：聚合函数忽略 NULL 值，`COUNT(*)` 统计所有行。

### 3. GROUP BY 分组

```sql
SELECT age, COUNT(*) FROM student GROUP BY age;
```

- 按指定列分组，通常配合聚合函数使用
- SELECT 中的列要么是分组的列，要么是聚合函数

### 4. HAVING 分组后过滤

```sql
SELECT age, COUNT(*) FROM student 
GROUP BY age 
HAVING COUNT(*) > 1;
```

| 关键字 | 作用 | 位置 |
|------|------|------|
| `WHERE` | 分组**前**过滤行 | FROM 之后 |
| `HAVING` | 分组**后**过滤组 | GROUP BY 之后 |

### 5. LIMIT 分页

```sql
SELECT * FROM student LIMIT 0, 10;  -- 从第0条开始，取10条
SELECT * FROM student LIMIT 10;     -- 取前10条
```

### 6. 单行函数（简单了解）

| 类型 | 函数 | 示例 |
|------|------|------|
| 字符串 | `CONCAT`、`LENGTH`、`SUBSTRING` | `CONCAT('a','b')` → `'ab'` |
| 日期 | `NOW()`、`DATEDIFF` | `DATEDIFF('2026-07-01','2026-06-01')` → `30` |
| 数值 | `ROUND` | `ROUND(3.1415, 2)` → `3.14` |

### 7. SQL 语句执行顺序

```
FROM → WHERE → GROUP BY → HAVING → SELECT → ORDER BY → LIMIT
```

---

## 二、今日算法

| 题号 | 题目 | 方法 | 关键点 |
|------|------|------|--------|
| 217 | 存在重复元素 | HashSet | `add()` 返回 false 表示重复 |
| 349 | 两个数组的交集 | 两个 HashSet | set1 查存在，resultSet 去重 |

### 217 思路

- 遍历数组，`set.add(num)` 失败说明元素已存在 → 有重复
- 时间复杂度 O(n)

### 349 思路

```
nums1 = [1, 2, 2, 1], nums2 = [2, 2]

set1 = {1, 2}                    // 存 nums1
遍历 nums2：
  2 → set1 有 → resultSet = {2}
  2 → set1 有，但 resultSet 已存在 → 自动去重

result = [2]
```

- 两个 HashSet，O(n+m)
- `resultSet.toArray(new int[0])` 转成 int[]

---

## 三、今日总结

| 分类 | 内容 |
|------|------|
| MySQL | ORDER BY、GROUP BY、HAVING、LIMIT |
| MySQL | 聚合函数、WHERE vs HAVING |
| MySQL | SQL 执行顺序 |
| 算法 | HashSet 判断重复、两个 HashSet 求交集 |
---

**日期：2026年7月29日**

---

## 一、MySQL 多表查询

### 1. 连接类型

| 连接类型 | 关键字 | 结果 |
|------|------|------|
| 内连接 | `INNER JOIN` | 只返回两表匹配的行 |
| 左外连接 | `LEFT JOIN` | 左表全部保留，右表匹配不上填 NULL |
| 右外连接 | `RIGHT JOIN` | 右表全部保留，左表匹配不上填 NULL |

### 2. 连接条件写法

| 写法 | 示例 | 说明 |
|------|------|------|
| `ON` | `ON s.id = sc.stu_id` | 最通用，不同名列也能用 |
| `USING` | `USING(id)` | 同名列时简化，结果只保留一列 |
| `NATURAL JOIN` | 自动匹配所有同名列 | 不推荐，表结构变化易出错 |

### 3. 等值连接 vs 非等值连接

| 类型 | 示例 | 说明 |
|------|------|------|
| 等值连接 | `ON s.id = sc.stu_id` | 用 `=` 匹配 |
| 非等值连接 | `ON score BETWEEN low AND high` | 用 `>` `<` `BETWEEN` 等 |

### 4. 表的别名

```sql
SELECT s.name, sc.grade FROM student s INNER JOIN score sc ON s.id = sc.stu_id;
```

- `student s` → `s` 是表的别名
- 简化列名书写，`s.name` 代替 `student.name`

### 5. 三种连接对比示例

```
student: id=1(张三), id=2(李四), id=3(王五)
score: stu_id=1(90), stu_id=3(85)

INNER JOIN: 张三 90，王五 85（李四不出现）
LEFT JOIN:  张三 90，李四 NULL，王五 85
RIGHT JOIN: 张三 90，王五 85，stu_id=3无对应NULL（此处王五能匹配）
```

### 6. SQL 完整执行顺序

```
FROM → ON → JOIN → WHERE → GROUP BY → HAVING → SELECT → ORDER BY → LIMIT
```

---

## 二、今日算法

| 题号 | 题目 | 方法 | 关键点 |
|------|------|------|--------|
| 290 | 单词规律 | 双 HashMap 双向映射 | `char → word` + `word → char` |
| 205 | 同构字符串 | 双 HashMap 双向映射 | `s→t` + `t→s` |

### 290 思路

```
pattern = "abba", s = "dog cat cat dog"

char → word:  a→dog, b→cat
word → char:  dog→a, cat→b

单向不够，必须双向映射：
  双向：保证每个 char 只映射一个 word，同时每个 word 只映射一个 char
```

**关键**：`split(" ")` 把字符串按空格拆成单词数组。

### 205 思路

```
s = "egg", t = "add"

s→t:  e→a, g→d
t→s:  a→e, d→g

检查：当前字符的映射是否和之前存的映射一致
```

**注意**：使用 `!=` 直接比较 `char`，不需要 `equals`。

---

## 三、今日总结

| 分类 | 内容 |
|------|------|
| MySQL | INNER JOIN / LEFT JOIN / RIGHT JOIN |
| MySQL | ON / USING / NATURAL JOIN |
| MySQL | 表的别名、等值连接 vs 非等值连接 |
| 算法 | 双 HashMap 双向映射模式 |
| 方法 | `split(" ")` 字符串分割 |

---
**日期：2026年7月30日**

---

## 一、MySQL 进阶

### 1. 子查询

SELECT 里面嵌套 SELECT：

```sql
-- 查询比平均年龄大的学生
SELECT * FROM student WHERE age > (SELECT AVG(age) FROM student);
```

子查询先执行，结果交给外层查询。

### 2. ALTER TABLE（修改表结构）

```sql
ALTER TABLE student ADD email VARCHAR(50);           -- 添加列
ALTER TABLE student DROP COLUMN email;               -- 删除列
ALTER TABLE student MODIFY name VARCHAR(50);         -- 修改列类型
ALTER TABLE student ADD PRIMARY KEY (id);            -- 添加主键
ALTER TABLE student ADD CONSTRAINT fk FOREIGN KEY (class_id) REFERENCES class(id);  -- 添加外键
```

### 3. 约束汇总

| 约束 | 关键字 | 作用 |
|------|------|------|
| 主键 | `PRIMARY KEY` | 唯一标识，非空唯一 |
| 外键 | `FOREIGN KEY ... REFERENCES` | 关联另一张表的主键 |
| 唯一 | `UNIQUE` | 值不能重复，允许 NULL |
| 非空 | `NOT NULL` | 必须有值 |
| 默认 | `DEFAULT` | 不填时的默认值 |
| 检查 | `CHECK` | 限制取值范围 |

### 4. 列级约束 vs 表级约束

| | 列级约束 | 表级约束 |
|------|------|------|
| 位置 | 跟在列定义后面 | 所有列定义之后 |
| 单列 | ✅ | ✅ |
| 多列（复合） | ❌ | ✅ 必须用表级 |

```sql
-- 表级约束（复合主键）
CREATE TABLE selection (
    stu_id INT,
    course_id INT,
    PRIMARY KEY (stu_id, course_id)
);
```

### 5. 三种表关系

| 关系 | 实现方式 | 举例 |
|------|------|------|
| 一对一 | 任一方加外键 | 用户 ↔ 用户详情 |
| 一对多 | **多方**加外键 | 班级 ↔ 学生 |
| 多对多 | 建**中间表** | 学生 ↔ 课程 |

### 6. 数据类型

| 类型 | 用途 | 注意 |
|------|------|------|
| `INT` | 整数 | |
| `VARCHAR(n)` | 可变长字符串 | 用多少占多少 |
| `CHAR(n)` | 定长字符串 | 固定长度 |
| `DECIMAL(m,n)` | 精确小数 | 金额必用，不会丢精度 |
| `FLOAT/DOUBLE` | 近似小数 | 科学计算，可能有误差 |

### 7. DELETE vs TRUNCATE vs DROP

| | DELETE | TRUNCATE | DROP |
|------|------|------|------|
| 删除内容 | 表中的行 | 表中所有数据 | 整张表 |
| 表结构 | ✅ 保留 | ✅ 保留 | ❌ 全删 |
| 可回滚 | ✅ | ❌ | ❌ |

---

## 二、数据结构：二叉树递归

### 1. 递归模板

```java
返回值 方法(TreeNode root) {
    if (root == null) return 基础值;       // 终止条件
    左结果 = 方法(root.left);              // 递归左
    右结果 = 方法(root.right);             // 递归右
    return 处理(左结果, 右结果);           // 合并
}
```

**递归不要靠"想明白"，靠"抄模板填空"。**

### 2. 今日题目

| 题号 | 题目 | 递归公式 |
|------|------|------|
| 104 | 二叉树最大深度 | `max(左深度, 右深度) + 1` |
| 101 | 对称二叉树 | `左.left==右.right && 左.right==右.left` |

### 104 思路

```
深度 = max(左子树深度, 右子树深度) + 1
空节点深度 = 0
```

### 101 思路

```
两棵树镜像 = 值相等 且 p左==q右 且 p右==q左
都为空 → 对称
一个为空 → 不对称
值不等 → 不对称
```

---

## 三、今日总结

| 分类 | 内容 |
|------|------|
| MySQL | 子查询、ALTER TABLE、约束汇总 |
| MySQL | 表关系（一对一/一对多/多对多） |
| MySQL | 数据类型（VARCHAR vs CHAR, DECIMAL vs FLOAT） |
| 数据结构 | 递归模板：终止条件 → 递归 → 合并 |
| 算法 | 二叉树递归：最大深度、对称判断 |

---

**日期：2026年7月31日**

---

## 一、MySQL 练习总结

### 1. 基本查询

```sql
SELECT name, age FROM student;                    -- 查指定列
SELECT * FROM student WHERE age > 20;             -- 条件查询
SELECT * FROM student ORDER BY age DESC;          -- 降序排列
```

### 2. 分组与过滤

```sql
SELECT c.name, COUNT(s.id) FROM class c
JOIN student s ON c.id = s.class_id
GROUP BY c.name;                                  -- 分组统计

SELECT c.name, COUNT(s.id) AS num FROM class c
JOIN student s ON c.id = s.class_id
GROUP BY c.name HAVING num >= 2;                  -- 分组后过滤
```

| 关键字 | 作用 | 位置 |
|------|------|------|
| `WHERE` | 分组**前**过滤行 | FROM 之后 |
| `HAVING` | 分组**后**过滤组 | GROUP BY 之后 |

### 3. 多表连接

```sql
-- 内连接：两表都匹配的行
SELECT s.name, c.name FROM student s
INNER JOIN class c ON s.class_id = c.id;

-- 左连接：左表全保留
SELECT s.name, sc.grade FROM student s
LEFT JOIN score sc ON s.id = sc.stu_id
WHERE sc.grade IS NULL;                           -- 查没成绩的学生
```

`ON` 后面加两表的关联条件，通常是 `外键 = 主键`。

### 4. 子查询

```sql
SELECT name, age FROM student
WHERE age > (SELECT AVG(age) FROM student);       -- 比平均年龄大
```

### 5. 分页

```sql
SELECT * FROM student LIMIT 0, 5;   -- 第1页，每页5条
SELECT * FROM student LIMIT 5, 5;   -- 第2页
```

### 6. 命令行翻页

```bash
mysql> pager less    # 开启翻页（上下箭头翻，q退出）
mysql> nopager       # 恢复默认
```

---

## 二、二叉树算法

### 226 翻转二叉树

**思路**：交换每个节点的左右子树，递归处理。

```java
public TreeNode invertTree(TreeNode root) {
    if (root == null) return null;         // 终止条件
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;                     // 交换
    invertTree(root.left);
    invertTree(root.right);                // 递归
    return root;
}
```

| 遍历顺序 | 做法 | 效果 |
|------|------|------|
| 前序 | 交换 → 递归 | 从上往下翻 |
| 后序 | 递归 → 交换 | 从下往上翻 |

结果完全相同。

### 112 路径总和

**思路**：每次减去当前节点值，到叶子判断是否刚好减完。

```java
public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) return false;
    if (root.left == null && root.right == null)   // 叶子节点
        return root.val == targetSum;
    return hasPathSum(root.left, targetSum - root.val)
        || hasPathSum(root.right, targetSum - root.val);
}
```

**关键**：`targetSum - root.val` 往下传递，到叶子时判断剩余值是否等于叶子值。

---

## 三、今日总结

| 分类 | 内容 |
|------|------|
| MySQL | 基本查询、GROUP BY + HAVING、JOIN、子查询、LIMIT |
| MySQL | ON 条件、命令行翻页 |
| 算法 | 翻转二叉树（前序/后序） |
| 算法 | 路径总和（减法思路） |
---

**日期：2026年8月1日**

---

## 一、图书管理系统

### 1. 项目结构

```
├── BookManager.BookManager.Book.java          // 实体类
├── BookManager.BookManager.java   // 管理类（增删改查）
├── BookManager.Main.java          // 主界面（菜单交互）
```

### 2. BookManager.BookManager.Book 实体类

| 属性 | 类型 | 说明 |
|------|------|------|
| id | int | 图书编号 |
| title | String | 书名 |
| author | String | 作者 |
| isbn | String | ISBN号 |
| isBorrowed | boolean | 是否已借出 |

### 3. BookManager.BookManager 功能

| 方法 | 功能 |
|------|------|
| `addBook(BookManager.BookManager.Book)` | 添加图书 |
| `deleteBook(int id)` | 按编号删除 |
| `updateBook(int id, BookManager.BookManager.Book)` | 修改图书信息 |
| `queryAll()` | 查看所有图书 |
| `queryById(int id)` | 按编号查询 |
| `queryByTitle(String)` | 按书名模糊查询 |
| `borrowBook(int id)` | 借书 |
| `returnBook(int id)` | 还书 |
| `generateId()` | 自动生成编号 |

### 4. 关键细节

| 问题 | 解决 |
|------|------|
| 遍历时删除 | 用普通 for 按下标，不能用增强 for |
| 修改列表元素 | `list.set(i, newBook)` 直接替换 |
| 字符串比较 | 用 `equals` / `contains`，不能用 `==` |
| `nextInt()` 后接 `nextLine()` | 加一行 `scan.nextLine()` 吃掉换行符 |
| 按书名查询返回 | `List<BookManager.BookManager.Book>`，因为可能有多本同名书 |

### 5. 后续改进

- 数据存到 MySQL 数据库（8月11日）
- 用 Spring Boot 改造成 Web 接口（8月中旬）

---

## 二、今日算法

### 102 二叉树的层序遍历（BFS）

**方法**：队列

| 步骤 | 操作 |
|------|------|
| 1 | 根节点入队 |
| 2 | 记下当前队列大小 `size`（当前层节点数） |
| 3 | for 循环 `size` 次，弹出节点，左右子节点入队 |
| 4 | 当前层列表加入结果，重复直到队列空 |

- `queue.offer()` 入队，`queue.poll()` 出队
- BFS 天然适合层序，DFS（递归）也可以但需要记录深度

### 100 相同的树

**方法**：递归

| 情况 | 返回值 |
|------|------|
| 两个都 null | `true` |
| 一个 null | `false` |
| 值不等 | `false` |
| 值相等 | `左相同 && 右相同` |

**关键**：最后用 `&&` 不是 `||`，左右子树都必须相同。

---

## 三、今日总结

| 分类 | 内容 |
|------|------|
| 项目 | 控制台图书管理系统完整实现 |
| Java | 增强 for 不能删元素、字符串不能用 `==`、`nextInt` 后要 `nextLine` |
| 算法 | BFS 层序遍历（队列） |
| 算法 | 递归判断相同树 |


---


**日期：2026年8月2日**

---

## 一、图书管理系统：文件存储

### 1. 文件格式

每行一本书，字段用逗号分隔：

```
1,数据结构与算法,李明,978-7-302-12345-1,false
2,计算机网络,谢希仁,978-7-302-23456-2,true
```

### 2. 启动时加载

```java
File file = new File(path);
if (file.exists()) {
    BufferedReader reader = new BufferedReader(new FileReader(path));
    String line;
    while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");
        Book b = new Book();
        b.setId(Integer.parseInt(parts[0]));
        b.setTitle(parts[1]);
        b.setAuthor(parts[2]);
        b.setIsbn(parts[3]);
        b.setBorrowed(Boolean.parseBoolean(parts[4]));
        manager.addBook(b);
    }
    reader.close();
}
```

### 3. 退出时保存

```java
BufferedWriter writer = new BufferedWriter(new FileWriter(path));
for (Book b : manager.queryAll()) {
    writer.write(b.getId() + "," + b.getTitle() + "," 
        + b.getAuthor() + "," + b.getIsbn() + "," + b.isBorrowed());
    writer.newLine();
}
writer.close();
```

### 4. 关键方法

| 方法 | 作用 |
|------|------|
| `line.split(",")` | 按逗号分隔成字符串数组 |
| `Integer.parseInt(s)` | 字符串转 int |
| `Boolean.parseBoolean(s)` | 字符串转 boolean |
| `file.exists()` | 判断文件是否存在 |

### 5. 为什么需要逗号分隔

没有分隔符无法把 `"1Java入门张三"` 拆成 id、title、author。逗号作为分隔符，`split` 还原。

---

## 二、今日算法

### 200 岛屿数量

**方法**：DFS 或 BFS

**思路**：遍历网格，遇到 '1' 就计数 +1，然后把和它相连的所有 '1' 标记为 '0'。

| 方法 | 实现 | 空间 |
|------|------|------|
| DFS | 递归，向四个方向深入 | O(h) |
| BFS | 队列，逐层扩散 | O(n) |

**方向数组**：

```java
int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
//              下      上      右      左
```

`dir[0]` 是行偏移（上下），`dir[1]` 是列偏移（左右）。

**关键**：入队/进入递归后立刻标记为 '0'，防止重复访问。

### 111 二叉树的最小深度

**方法**：递归

| 情况 | 做法 |
|------|------|
| 叶子节点 | 深度 = 1 |
| 只有一个子节点 | 走有子节点那边 |
| 两个都有 | 取较小 + 1 |

**注意**：不能简单取 `min(左, 右)`，因为 null 子节点的深度是 0，会错误地把它当成最短路径。

---

## 三、今日总结

| 分类 | 内容 |
|------|------|
| 项目 | 文件存储：启动加载 + 退出保存 |
| Java | `split`、`parseInt`、`parseBoolean`、`File.exists` |
| 算法 | 岛屿数量：DFS/BFS + 方向数组 |
| 算法 | 最小深度：注意只有一个子节点的情况 |


---


**日期：2026年8月3日**

---

## 一、图书管理系统收尾

### 1. 编号自动递增修复

**问题**：每次启动程序 `nextId` 从 1 开始，新书编号和已有数据冲突。

**解决**：启动时读取文件中最大 id，设 `nextId = maxId + 1`。

```java
// BookManager 里加方法
public void setNextId(int maxId) {
    this.nextId = maxId + 1;
}

// Main 加载文件时
int maxId = 0;
while ((line = reader.readLine()) != null) {
    int id = Integer.parseInt(parts[0]);
    if (id > maxId) maxId = id;
    // ... 创建 Book
}
manager.setNextId(maxId);
```

### 2. 格式对齐

控制台查询显示用 `System.out.printf` 格式化：

| 占位符 | 含义 | 示例 |
|------|------|------|
| `%-6d` | 左对齐，占6位，整数 | `%-6d` |
| `%-22s` | 左对齐，占22位，字符串 | `%-22s` |
| `%n` | 换行 | |

中文一个字符约占两个英文字符宽度，宽度按最长内容估算。

---

## 二、今日算法

### 199 二叉树的右视图

**方法**：BFS 层序遍历，取每层最后一个节点。

```java
if (i == size - 1) {
    list.add(node.val);
}
```

**关键**：入队时用 `node.left` / `node.right`，不是 `root.left`，否则死循环。

### 637 二叉树的层平均值

**方法**：BFS 层序遍历，每层求和除以节点数。

```java
double sum = 0;
for (int i = 0; i < size; i++) {
    TreeNode node = queue.poll();
    sum += node.val;
}
list.add(sum / size);
```

**关键**：`sum` 声明为 `double`，整数除法自动转小数，不需要额外转换。

### BFS 层序遍历模板

```java
Queue<TreeNode> queue = new LinkedList<>();
queue.offer(root);
while (!queue.isEmpty()) {
    int size = queue.size();          // 当前层节点数
    for (int i = 0; i < size; i++) {  // 处理当前层
        TreeNode node = queue.poll();
        // 处理 node ...
        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
    }
    // 当前层处理完毕
}
```

---

## 三、今日总结

| 分类 | 内容 |
|------|------|
| 项目 | 编号自增修复、printf 格式对齐 |
| BFS | 层序遍历模板 |
| 算法 | 右视图 = 每层最后一个 |
| 算法 | 层平均值 = 每层 sum / size |
| 坑 | `node.left` 写成 `root.left` 会死循环 |
| 队列方法 | 刷题统一用 `offer` / `poll` |
---

**日期：2026年8月4日**

---

## 一、反转链表（LeetCode 206）

### 核心：三指针法

```java
ListNode prev = null;
ListNode curr = head;
while (curr != null) {
    ListNode next = curr.next;  // 1. 先记住下一个
    curr.next = prev;           // 2. 反转指向
    prev = curr;                // 3. prev 后移
    curr = next;                // 4. curr 后移
}
return prev;
```

### 关键顺序不能乱

| 步骤 | 操作 | 为什么 |
|------|------|------|
| ① | `next = curr.next` | 必须提前存，否则改了指向就找不到了 |
| ② | `curr.next = prev` | 反转当前节点 |
| ③ | `prev = curr` | prev 往后移 |
| ④ | `curr = next` | curr 往后移 |

### 常见错误

- 先移指针再改指向 → 丢失后续节点，形成环
- 忘记返回 `prev`（新头），错返回 `curr`（null）或 `head`（旧头）

---

## 二、二分查找（LeetCode 704）

### 标准模板

```java
int left = 0;
int right = nums.length - 1;
while (left <= right) {
    int mid = (left + right) / 2;
    if (nums[mid] == target) return mid;
    if (nums[mid] < target) left = mid + 1;
    else right = mid - 1;
}
return -1;
```

### 关键细节

| 要点 | 说明 |
|------|------|
| `left <= right` | 区间只剩一个元素也要判断 |
| `mid` 在循环内计算 | 每次循环重新算 |
| `left = mid + 1` | 跳过 mid，否则可能死循环 |
| `right = mid - 1` | 跳过 mid |

---

## 三、层序遍历（LeetCode 102）复习

### BFS 模板

```java
Queue<TreeNode> queue = new LinkedList<>();
queue.offer(root);
while (!queue.isEmpty()) {
    int size = queue.size();
    for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        // 处理 node
        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
    }
}
```

### 常见错误

- `root.left` 写成死循环 → 应该用 `node.left`
- `root == null` 返回 `null` → 应该返回空列表 `result`

---

## 四、今日总结

| 分类 | 内容 |
|------|------|
| 链表 | 反转链表三指针法，顺序不能乱 |
| 二分 | `left<=right`，`mid` 在循环内 |
| BFS | 层序遍历模板，`node.left` 不是 `root.left`
---
```markdown
# JDBC + 项目改造 + 算法笔记

**日期：2026年8月7日**

---

## 一、JDBC 基础

### 1. JDBC 是什么

Java 连接数据库的标准接口，用 Java 代码操作 MySQL。

### 2. 连接数据库步骤

| 步骤 | 代码 |
|------|------|
| 加载驱动 | `Class.forName("com.mysql.cj.jdbc.Driver")`（8.0+ 可省略） |
| 获取连接 | `DriverManager.getConnection(url, username, password)` |
| 执行 SQL | `PreparedStatement` |
| 处理结果 | `ResultSet` |
| 关闭连接 | `close()` 或 try-with-resources 自动关闭 |

### 3. 常用代码模板

```java
// 增删改
String sql = "INSERT INTO books (title, author) VALUES (?, ?)";
try (Connection conn = getConnection();
     PreparedStatement pstmt = conn.prepareStatement(sql)) {
    pstmt.setString(1, "Java入门");
    pstmt.setString(2, "张三");
    int rows = pstmt.executeUpdate();  // 返回受影响行数
}

// 查询
String sql = "SELECT * FROM books WHERE id = ?";
try (Connection conn = getConnection();
     PreparedStatement pstmt = conn.prepareStatement(sql)) {
    pstmt.setInt(1, 1);
    ResultSet rs = pstmt.executeQuery();
    while (rs.next()) {
        String title = rs.getString("title");
    }
}
```

### 4. executeUpdate vs executeQuery

| 方法 | 用于 | 返回值 |
|------|------|------|
| `executeUpdate()` | INSERT、UPDATE、DELETE | `int`，受影响行数 |
| `executeQuery()` | SELECT | `ResultSet`，结果集 |

### 5. try-with-resources

```java
try (Connection conn = getConnection();
     PreparedStatement pstmt = conn.prepareStatement(sql)) {
    // 执行 SQL
}  // 自动调用 close()，不用手动关
```

### 6. 添加 MySQL 驱动

1. 下载 `mysql-connector-j-8.0.33.jar`
2. 放项目 `lib` 文件夹
3. 右键 jar → 添加为库

---

## 二、图书管理系统改造

### 改造内容

| 原来 | 数据库版 |
|------|------|
| `ArrayList<Book>` 存数据 | MySQL `books` 表 |
| 文件读写 | JDBC 操作数据库 |
| `list.add(book)` | `INSERT INTO books` |
| `list.remove(i)` | `DELETE FROM books WHERE id=?` |
| `list.set(i, book)` | `UPDATE books SET ... WHERE id=?` |
| `list.get(i)` | `SELECT * FROM books WHERE id=?` |

### 改进点

- `Main` 类无需改动，接口不变，只换内部实现
- 修改功能支持**部分修改**，回车保留原值
- 删除文件读写代码，纯数据库版

### 关键 SQL

```sql
-- 模糊查询
SELECT * FROM books WHERE title LIKE '%关键字%'

-- 借书（防止重复借出）
UPDATE books SET is_borrowed = TRUE WHERE id = ? AND is_borrowed = FALSE

-- 还书（防止重复归还）
UPDATE books SET is_borrowed = FALSE WHERE id = ? AND is_borrowed = TRUE
```

---

## 三、今日算法

### 141 环形链表（是否有环）

**方法**：快慢指针

```java
ListNode slow = head, fast = head;
while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
    if (slow == fast) return true;  // 相遇 → 有环
}
return false;  // fast 遇到 null → 无环
```

### 142 环形链表 II（找环入口）

**方法一：快慢指针（O(1)空间）**

快慢指针相遇后，slow 回到头，两个都走一步，再次相遇 = 环入口。

**方法二：HashSet（O(n)空间，简单直观）**

```java
HashSet<ListNode> set = new HashSet<>();
ListNode p = head;
while (p != null) {
    if (set.contains(p)) return p;  // 第一次重复 = 环入口
    set.add(p);
    p = p.next;
}
return null;
```

---

## 四、今日总结

| 分类 | 内容 |
|------|------|
| JDBC | 连接数据库、PreparedStatement、executeUpdate/Query |
| 项目 | 图书管理系统改造为数据库版 |
| Java | try-with-resources 自动关闭 |
| 算法 | 快慢指针判环、找环入口 |
| 算法 | HashSet 找环入口（简单版） |

---
```markdown
# JDBC 进阶 + 算法笔记

**日期：2026年8月8日**

---

## 一、JDBC 进阶

### 1. DAO 设计模式

把数据库操作单独封装到 DAO 类中：

```
Main（界面） → BookManager（业务） → BookDAO（数据库操作）
```

| 层 | 职责 |
|------|------|
| Book.java | 实体，存数据 |
| BookDAO.java | 数据库增删改查（SQL 都在这里） |
| BookManager.java | 业务逻辑，调用 DAO |
| Main.java | 用户交互 |

**好处**：换数据库只改 DAO，业务代码不变。

### 2. SQL 注入

用户输入被当成 SQL 代码执行的安全漏洞。

- **危险**：`"SELECT * FROM username WHERE name = '" + name + "'"` 拼接字符串
- **安全**：`PreparedStatement` + `?` 占位符，自动转义

### 3. 事务

多条 SQL 要么全成功，要么全失败：

```java
conn.setAutoCommit(false);   // 开启事务
try {
    // 多条 SQL 用同一个 conn
    conn.commit();           // 全部成功
} catch (SQLException e) {
    conn.rollback();         // 有失败，回滚到事务开始前
}
```

**应用场景**：转账、下单、库存扣减、用户注册等多步操作。

**当前系统不需要事务**：每次操作只一条 SQL，各自开关连接即可。

### 4. 资源关闭

| 方式 | 做法 |
|------|------|
| 手动关闭 | `finally` 里从后往前关：`rs` → `pstmt` → `conn` |
| try-with-resources | `try(conn; pstmt; rs) {}` 自动关闭 |

**你一直用的 try-with-resources 是规范写法**，不需要手动关。

### 5. ResultSet 与事务结合

查询和后续增删改使用**同一个连接**，共享事务：

```java
conn.setAutoCommit(false);
// 1. 查询（同 conn）
// 2. 根据结果增删改（同 conn）
conn.commit();  // 或 rollback()
```

单条 SQL 各自开关连接即可，多条 SQL 需要共享连接。

### 6. AUTO_INCREMENT

删除数据后自增 ID 不回退，是数据库正常行为，不用处理。

---

## 二、今日算法

### 110 平衡二叉树

**思路**：递归求深度，深度差 > 1 返回 -1。

- `Math.abs(left - right) > 1` → 不平衡
- 用 -1 快速传递，避免无效计算

### 33 搜索旋转排序数组

**思路**：二分查找变形，每次判断哪一半有序。

- 从中间切开，至少一半有序
- 判断 target 在不在这半，缩小范围
- 时间复杂度 O(log n)，空间 O(1)

---

## 三、今日总结

| 分类 | 内容 |
|------|------|
| JDBC | DAO 分层、SQL 注入防护、事务 |
| JDBC | 资源关闭、ResultSet 与事务 |
| 算法 | 平衡二叉树（深度差 -1 标记） |
| 算法 | 旋转数组二分（判断哪一半有序） |
---
```markdown
# Maven 入门 + 算法笔记

**日期：2026年8月9日**

---

## 一、Maven 入门

### 1. Maven 是什么

项目构建和依赖管理工具，自动下载 jar 包、编译、打包。不用手动放 `lib` 文件夹，在 `pom.xml` 写几行，Maven 自动从中央仓库下载。

### 2. pom.xml

Maven 项目的核心配置文件：

```xml
<groupId>com.example</groupId>          <!-- 组织名 -->
<artifactId>bookmanager</artifactId>    <!-- 项目名 -->
<version>1.0-SNAPSHOT</version>        <!-- 版本号 -->

<dependencies>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <version>8.0.33</version>       <!-- 去 mvnrepository.com 查 -->
    </dependency>
</dependencies>
```

`groupId` + `artifactId` + `version` 三者唯一定位一个 jar 包，这些值由发布者定义，不是自己编的。

### 3. 项目结构

```
bookmanager-maven/
├── src/main/java/      ← 放 Java 代码
├── src/test/java/      ← 放测试代码
└── pom.xml             ← Maven 配置
```

### 4. 依赖范围（scope）

| scope | 含义 |
|------|------|
| `compile`（默认） | 编译、运行、打包都可用 |
| `provided` | 编译运行可用，打包不包括 |
| `runtime` | 编译不需要，运行时需要 |
| `test` | 只在测试时可用 |

MySQL 驱动用默认 `compile`，不用写 `scope`。

### 5. 图书管理系统 Maven 化

- 删掉 `lib` 文件夹
- 在 `pom.xml` 加 MySQL 依赖
- 右键 `pom.xml` → `Maven` → `重新加载项目`

### 6. 相关概念

| 术语 | 说明 |
|------|------|
| jar 包 | Java 程序压缩包 |
| XML | 存数据的标记语言，Maven 配置用 |
| GBK / UTF-8 | 字符编码，UTF-8 支持全球语言，推荐 |
| Archetype | Maven 项目模板 |

---

## 二、今日算法

### 415 字符串相加

**方法**：模拟竖式加法，从个位开始逐位加，处理进位。

```java
StringBuilder sb = new StringBuilder();
int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
while (i >= 0 || j >= 0 || carry != 0) {
    int a = i >= 0 ? num1.charAt(i) - '0' : 0;
    int b = j >= 0 ? num2.charAt(j) - '0' : 0;
    int sum = a + b + carry;
    sb.append(sum % 10);
    carry = sum / 10;
    i--; j--;
}
return sb.reverse().toString();
```

| 关键点 | 说明 |
|------|------|
| `charAt(i) - '0'` | 字符转数字 |
| `carry != 0` | 最高位有进位时要继续循环 |
| `StringBuilder` | 可变字符串，`append` + `reverse` |

### 1047 删除相邻重复项

**方法**：用 `StringBuilder` 当栈，遍历字符，和栈顶相同就弹出，不同就压入。

```java
StringBuilder sb = new StringBuilder();
for (char c : s.toCharArray()) {
    if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) {
        sb.deleteCharAt(sb.length() - 1);
    } else {
        sb.append(c);
    }
}
return sb.toString();
```

**为什么不用双重循环**：时间复杂度 O(n²)，栈解法 O(n) 一次过。

---

## 三、今日总结

| 分类 | 内容 |
|------|------|
| Maven | pom.xml、依赖管理、项目结构 |
| 项目 | 图书管理系统 Maven 化 |
| 算法 | 字符串相加（模拟加法） |
| 算法 | 栈消消乐（删除相邻重复项） |
---
```markdown
# HTTP 基础 + 算法笔记

**日期：2026年8月10日**

---

## 一、HTTP 基础

### 1. 什么是 HTTP

浏览器和服务器之间通信的协议，规定了请求（Request）和响应（Response）的格式。

### 2. 请求（Request）

客户端发给服务器，包含三部分：

| 部分 | 示例 |
|------|------|
| 请求行 | `GET /api/books HTTP/1.1` |
| 请求头 | `Content-Type: application/json` |
| 请求体 | `{"title":"Java入门"}`（POST 时使用） |

### 3. 响应（Response）

服务器返回给客户端：

| 部分 | 示例 |
|------|------|
| 状态行 | `HTTP/1.1 200 OK` |
| 响应头 | `Content-Type: application/json` |
| 响应体 | `[{"id":1, "title":"Java入门"}]` |

### 4. 请求方法

| 方法 | 作用 | 你的图书管理系统对应 |
|------|------|------|
| **GET** | 获取数据 | 查看图书列表 |
| **POST** | 新增数据 | 添加一本新书 |
| **PUT** | 更新数据 | 修改图书信息 |
| **DELETE** | 删除数据 | 删除一本书 |

### 5. 常见状态码

| 状态码 | 含义 |
|------|------|
| **200** | 请求成功 |
| **201** | 创建成功 |
| **400** | 请求参数有误 |
| **404** | 资源不存在 |
| **500** | 服务器内部错误 |

记忆：**2xx 成功，4xx 你写错了，5xx 服务器炸了。**

### 6. URL 结构

```
http://localhost:8080/api/books?id=5

http://        → 协议
localhost      → 主机（域名）
8080           → 端口
/api/books     → 路径
?id=5          → 查询参数
```

### 7. GET vs POST

| | GET | POST |
|------|------|------|
| 用途 | 获取数据 | 提交数据 |
| 参数位置 | URL 后面 `?id=5` | 请求体里 |
| 安全性 | 参数暴露在 URL | 相对安全 |

### 8. 相关概念

| 概念 | 说明 |
|------|------|
| **API** | 应用程序接口，不同软件互相调用的桥梁 |
| **Web** | 万维网，浏览器访问的所有内容 |
| **RESTful API** | 用 URL 表示资源，HTTP 方法表示操作的接口风格 |

---

## 二、今日算法

### 559 N叉树的最大深度

**方法**：递归，和二叉树最大深度完全一样，遍历所有子节点取最大值。

```java
public int maxDepth(Node root) {
    if (root == null) return 0;
    int max = 0;
    for (Node child : root.children) {
        max = Math.max(max, maxDepth(child));
    }
    return max + 1;
}
```

### 239 滑动窗口最大值

**方法**：双端队列（`Deque`），O(n)。

**四个步骤**：

| 步骤 | 操作 |
|------|------|
| 1 | 移除窗口外的下标 |
| 2 | 从队尾移除所有比当前元素小的 |
| 3 | 当前元素下标入队尾 |
| 4 | 窗口满了，队首就是最大值 |

**关键思想**：队首永远放最大值下标，比自己小的踢掉（它们永远不会是最大值），比自己小的保留（等大的过期后替补）。

---

## 三、今日总结

| 分类 | 内容 |
|------|------|
| HTTP | 请求/响应结构、GET/POST、状态码、URL |
| 概念 | API、Web、RESTful |
| 算法 | N叉树递归（和二叉树一样） |
| 算法 | 滑动窗口 + 双端队列 |
---
```markdown
# Web 基础 + 算法笔记

**日期：2026年8月11日**

---

## 一、Web 分层概念

### 1. 三层架构

```
Controller（接收 HTTP 请求）→ Service（业务逻辑）→ DAO（数据库操作）
```

| 层 | 对应你现有的 | 职责 |
|------|------|------|
| Controller | 新增 | 接收请求，返回响应 |
| Service | `BookManager` | 业务逻辑，不变 |
| DAO | `BookDAO` | 数据库操作，不变 |
| Entity | `Book` | 实体类，不变 |

**Web 版只是把 Main 换成 Controller，里面不动。**

### 2. 接口对应关系

| 控制台操作 | Web 接口 |
|------|------|
| 查看所有图书 | `GET /api/books` |
| 按编号查询 | `GET /api/books/{id}` |
| 按书名查询 | `GET /api/books?title=xxx` |
| 添加图书 | `POST /api/books` |
| 修改图书 | `PUT /api/books/{id}` |
| 删除图书 | `DELETE /api/books/{id}` |
| 借书 | `PUT /api/books/{id}/borrow` |
| 还书 | `PUT /api/books/{id}/return` |

---

## 二、URL 结构

```
http://localhost:8080/api/books?id=5

http://        → 协议
localhost      → 主机（Host）
8080           → 端口
/api/books     → 路径
?id=5          → 查询参数
```

### 符号说明

| 符号 | 作用 | 示例 |
|------|------|------|
| `?` | 查询参数起始符 | `/books?title=Java` |
| `&` | 连接多个参数 | `/books?title=Java&author=张三` |
| `/` | 路径层级分隔 | `/api/books/5` |

---

## 三、请求与响应

### 1. 请求体

客户端向服务器提交数据时放在里面，GET 没有，POST/PUT 有。

```json
{
    "title": "Java入门",
    "author": "张三",
    "isbn": "123-456"
}
```

### 2. Content-Type

告诉服务器请求体数据格式，`application/json` 表示 JSON 格式。

### 3. JSON

前后端通信的数据格式，花括号 `{}` 包对象，方括号 `[]` 包数组。

---

## 四、今日算法

### 454 四数相加 II

**方法**：HashMap，O(n²)

- 前两个数组：双层循环算 `a+b`，存到 Map，统计出现次数
- 后两个数组：双层循环算 `-(c+d)`，去 Map 里查，累加次数

### 162 寻找峰值

**方法**：二分查找，往高处走

```java
while (left < right) {
    int mid = (left + right) / 2;
    if (nums[mid] > nums[mid + 1]) {
        right = mid;      // 下降坡，峰值在左边
    } else {
        left = mid + 1;   // 上升坡，峰值在右边
    }
}
return left;  // left == right 就是峰值
```

**关键**：`nums[-1]` 和 `nums[n]` 视为负无穷，两端天然有峰值倾向。

---

## 五、今日总结

| 分类 | 内容 |
|------|------|
| Web | 三层架构：Controller/Service/DAO |
| Web | URL 结构、路径参数 vs 查询参数 |
| Web | 请求体、Content-Type、JSON |
| 算法 | HashMap 分组统计 |
| 算法 | 二分找峰值（往高处走） |
---
```markdown
# Spring Boot 入门 + 算法笔记

**日期：2026年8月12日**

---

## 一、Spring Boot 入门

### 1. Spring Boot 是什么

快速开发 Java Web 应用的框架，封装了 Spring，开箱即用。不用手写 XML 配置，不用手动部署 Tomcat。

### 2. 创建项目

IDEA → 新建 → Spring Boot → 勾选依赖：
- **Spring Web**（写接口）
- **MySQL Driver**（连数据库）

### 3. 项目结构

```
src/main/java/.../
├── Book.java              ← 实体类
├── BookDAO.java           ← 数据库操作（@Component）
├── BookManager.java       ← 业务逻辑（@Component）
└── controller/
└── BookController.java ← 接口层（@RestController）
```

### 4. 核心注解

| 注解 | 作用 | 加在谁身上 |
|------|------|------|
| `@SpringBootApplication` | 标记主类，启动项目 | 主类 |
| `@RestController` | 标记接口类，返回 JSON | Controller |
| `@RequestMapping("/api/books")` | 指定接口路径前缀 | Controller |
| `@GetMapping` | 处理 GET 请求 | 方法 |
| `@PostMapping` | 处理 POST 请求（新增） | 方法 |
| `@PutMapping` | 处理 PUT 请求（修改） | 方法 |
| `@DeleteMapping` | 处理 DELETE 请求（删除） | 方法 |
| `@PathVariable` | 取 URL 路径参数 `/{id}` | 方法参数 |
| `@RequestParam` | 取 URL 查询参数 `?title=xxx` | 方法参数 |
| `@RequestBody` | 取请求体 JSON 转对象 | 方法参数 |
| `@Autowired` | 自动注入对象 | 字段 |
| `@Component` | 标记类交给 Spring 管理 | Service/DAO |

### 5. 数据库配置

`application.properties`：

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=你的密码
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

Spring Boot 自动读取配置并创建数据库连接，不需要手写 `getConnection()`。

### 6. 图书管理系统 Web 化

| 控制台操作 | Web 接口 |
|------|------|
| 查看所有图书 | `GET /api/books` |
| 按编号查询 | `GET /api/books/{id}` |
| 按书名查询 | `GET /api/books/search?title=xxx` |
| 添加图书 | `POST /api/books` |
| 修改图书 | `PUT /api/books/{id}` |
| 删除图书 | `DELETE /api/books/{id}` |
| 借书 | `PUT /api/books/{id}/borrow` |
| 还书 | `PUT /api/books/{id}/return` |

### 7. 测试工具

- 浏览器：只能测 GET
- **Postman**：测试所有请求方式（GET/POST/PUT/DELETE）

---

## 二、今日算法

### 114 二叉树展开为链表

**方法**：后序遍历递归

1. 递归展开左右子树
2. 左子树移到右边，左子节点置 null
3. 找到新右子树最右边，接上原右子树

```
    1
   / \
  2   5
 / \   \
3   4   6

展开后：1 → 2 → 3 → 4 → 5 → 6
```

### 509 斐波那契数

**方法**：动态规划，O(n)，O(1)

```java
int a = 0, b = 1;
for (int i = 2; i <= n; i++) {
    int sum = a + b;
    a = b;
    b = sum;
}
return b;
```

递归会超时（大量重复计算），用滚动数组优化。

---

## 三、今日总结

| 分类 | 内容 |
|------|------|
| Spring Boot | 项目创建、三层架构、核心注解 |
| Spring Boot | 数据库配置、接口开发 |
| 项目 | 图书管理系统 Web 化完成 |
| 算法 | 后序遍历展开二叉树 |
| 算法 | 动态规划斐波那契 |


---
```markdown
# Spring Boot 完善 + 算法笔记

**日期：2026年8月13日**

---

## 一、Spring Boot 完善

### 1. 统一返回格式 Result

```java
public class Result<T> {
    private int code;    // 200 成功，500 失败
    private String msg;  // 提示信息
    private T data;      // 数据

    public static <T> Result<T> success(T data) {
        return new Result<>(200, "成功", data);
    }

    public static <T> Result<T> error(String msg) {
        return new Result<>(500, msg, null);
    }
}
```

- `Result` 类**不需要注解**，只是数据包装类
- Controller 返回 `Result.success(data)` 或 `Result.error("失败")`
- 前端拿到统一格式：`{"code":200, "msg":"成功", "data":[...]}`

### 2. 泛型 `<T>`

| 写法 | 含义 |
|------|------|
| `Result<T>` | 声明类用到泛型 |
| `public static <T> Result<T>` | 声明泛型方法 |
| `Result<Book>` | T 具体化为 Book |
| `Result<List<Book>>` | T 具体化为图书列表 |

### 3. 注入（DI）

**注入**：Spring 自动创建对象并放到你要用的地方，不用自己 `new`。

```java
@Autowired
private BookManager bookManager;  // Spring 自动 new 好并赋值
```

**需要被 Spring 管理的类**：
- Controller（`@RestController`）
- Service（`@Service`）
- DAO（`@Repository`）

**不需要管理的类**：
- 实体类（`Book`）
- 工具类/数据包装类（`Result`）

### 4. Controller 返回统一格式示例

```java
@GetMapping
public Result<List<Book>> queryAll() {
    return Result.success(bookManager.queryAll());
}

@DeleteMapping("/{id}")
public Result<String> deleteBook(@PathVariable int id) {
    if (bookManager.deleteBook(id)) {
        return Result.success("删除成功");
    }
    return Result.error("删除失败");
}
```

---

## 二、今日算法

### 130 被围绕的区域

**思路**：从边界 O 出发 DFS 标记，剩下的 O 改成 X。

| 步骤 | 操作 |
|------|------|
| 1 | 从四条边界 DFS，把相连 O 标记为 `#` |
| 2 | 遍历网格，`O` → `X`，`#` → `O` |

**关键**：边界上的 O 不被包围，最后要改回来。

### 695 岛屿的最大面积

**思路**：DFS 算每个岛屿面积，取最大值。

```java
int area = 1;
area += dfs(grid, i + 1, j);
area += dfs(grid, i - 1, j);
area += dfs(grid, i, j + 1);
area += dfs(grid, i, j - 1);
return area;
```

**坑**：
- `int[][]` 比较用 `== 1`，不是 `== '1'`
- `++count` 传参不会累加，要用 `area += dfs(...)` 累加返回值
- `max` 要 `Math.max(max, area)`，不是 `Math.max(0, area)`

### 二维数组行列

| 表达式 | 含义 |
|------|------|
| `grid.length` | 行数 |
| `grid[0].length` | 列数 |

---

## 三、今日总结

| 分类 | 内容 |
|------|------|
| Spring Boot | 统一返回格式 Result、泛型、注入概念 |
| 算法 | 边界 DFS 标记法 |
| 算法 | DFS 求面积（累加返回值） |
---
```markdown
# MyBatis 入门 + 算法笔记

**日期：2026年8月14日**

---

## 一、MyBatis 入门

### 1. MyBatis 是什么

简化数据库操作的框架，用接口 + 注解写 SQL，替代手写 JDBC。

### 2. 对比

| JDBC | MyBatis |
|------|------|
| 手动获取连接 | 自动管理连接 |
| `pstmt.setString(1, title)` | `#{title}` 自动赋值 |
| 手写 while 循环取结果 | 自动返回 List |
| SQL 写在字符串里 | SQL 写在注解里 |

### 3. 添加依赖

```xml
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>3.0.3</version>
</dependency>
```

### 4. Mapper 接口

```java
@Mapper
public interface BookMapper {
    @Select("SELECT * FROM books")
    List<Book> queryAll();

    @Select("SELECT * FROM books WHERE id = #{id}")
    Book queryById(int id);

    @Insert("INSERT INTO books (title, author, isbn, is_borrowed) VALUES (#{title}, #{author}, #{isbn}, #{isBorrowed})")
    void addBook(Book book);

    @Update("UPDATE books SET title=#{title}, author=#{author}, isbn=#{isbn} WHERE id=#{id}")
    int updateBook(Book book);

    @Delete("DELETE FROM books WHERE id = #{id}")
    int deleteBook(int id);
}
```

**注解对应**：

| 注解 | 作用 |
|------|------|
| `@Mapper` | 标记 Mapper 接口，交给 MyBatis 管理 |
| `@Select` | 查询 |
| `@Insert` | 插入 |
| `@Update` | 修改 |
| `@Delete` | 删除 |

### 5. Service 注入 Mapper

```java
@Service
public class BookManager {
    @Autowired
    private BookMapper mapper;
}
```

### 6. 常见问题

| 问题 | 解决 |
|------|------|
| Mapper 找不到 | 主类加 `@MapperScan("包路径")` |
| `sqlSessionFactory required` | Spring Boot 4.x 和 MyBatis 不兼容，降级到 3.3.5 |
| 依赖版本缺失 | 手动加 `<version>3.3.5</version>` |

---

## 二、今日算法

### 70 爬楼梯

**方法**：动态规划，滚动数组

```
f(n) = f(n-1) + f(n-2)
```

和斐波那契完全一样。O(n) 时间，O(1) 空间。递归会超时。

### 50 Pow(x, n)

**方法**：快速幂，O(log n)

```java
while (N > 0) {
    if (N % 2 == 1) result *= x;  // 二进制位为1，乘入结果
    x *= x;                        // 底数平方
    N /= 2;                        // 指数折半
}
```

**思路**：指数二分，偶数 `x^n = (x²)^(n/2)`，奇数多乘一个 x。暴力 O(n) 会超时。

---

## 三、今日总结

| 分类 | 内容 |
|------|------|
| MyBatis | Mapper 接口 + 注解写 SQL |
| MyBatis | `#{}` 自动赋值 |
| 版本 | Spring Boot 4.x 不兼容 MyBatis，降级 3.3.5 |
| 算法 | 滚动数组（爬楼梯） |
| 算法 | 快速幂（二分指数） |
---
```markdown
# Spring Boot 进阶 + 算法笔记

**日期：2026年8月15日**

---

## 一、Spring Boot 进阶

### 1. 参数校验

**步骤**：

| 步骤 | 操作 |
|------|------|
| 1 | pom.xml 加 `spring-boot-starter-validation` 依赖 |
| 2 | `Book` 类字段加校验注解 |
| 3 | Controller 方法参数加 `@Valid` |

**示例**：

```java
public class Book {
    private int id;

    @NotBlank(message = "书名不能为空")
    private String title;

    @NotBlank(message = "作者不能为空")
    private String author;
}

@PostMapping
public Result<String> addBook(@Valid @RequestBody Book book) {
    ...
}
```

**`@Valid` 作用**：检查 `@RequestBody` 对象的校验注解，不合格直接拦截。

### 2. 全局异常处理

```java
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        return Result.error(e.getMessage());
    }
}
```

| 注解 | 作用 |
|------|------|
| `@RestControllerAdvice` | 全局异常处理器 |
| `@ExceptionHandler` | 指定处理哪种异常 |

---

## 二、今日算法

### 105 从前序与中序遍历构造二叉树

**思路**：前序第一个是根，中序找根分左右，递归。

```
前序：[3, 9, 20, 15, 7]
中序：[9, 3, 15, 20, 7]

根 = 3（前序第一个）
中序找 3：左边 [9] 左子树，右边 [15,20,7] 右子树
```

**递归条件**：区间为空返回 null。

### 113 路径总和 II

**方法**：DFS + 回溯

```java
path.add(root.val);
if (root.left == null && root.right == null && targetSum == root.val) {
    result.add(new ArrayList<>(path));
}
dfs(root.left, targetSum - root.val, path, result);
dfs(root.right, targetSum - root.val, path, result);
path.remove(path.size() - 1);  // 回溯
```

**回溯**：每次递归返回前删掉当前节点，保证路径列表只存当前分支。

**为什么递归能回溯多次**：递归是栈结构，每层返回执行一次 `remove`，返回多少层就清理多少次。

---

## 三、今日总结

| 分类 | 内容 |
|------|------|
| Spring Boot | 参数校验 @Valid + @NotBlank |
| Spring Boot | 全局异常处理 @RestControllerAdvice |
| 算法 | 前序+中序构造二叉树（前序找根，中序分左右） |
| 算法 | 路径总和 II（DFS + 回溯） |
---
```markdown
# Spring Boot 登录注册 + 算法笔记

**日期：2026年8月16日**

---

## 一、登录注册功能

### 1. 数据库建表

```sql
CREATE TABLE `user` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);
```

`user` 是 MySQL 关键字，加反引号。

### 2. 分层结构

| 层 | 类 | 作用 |
|------|------|------|
| 实体 | `User` | id、username、password |
| Mapper | `UserMapper` | 注册、按用户名查询 |
| Service | `UserService` | 业务逻辑（查重、校验密码） |
| Controller | `UserController` | 注册、登录接口 |

### 3. 接口

| 接口 | 地址 | 请求体 |
|------|------|------|
| 注册 | `POST /api/user/register` | `{"username":"zhangsan","password":"123456"}` |
| 登录 | `POST /api/user/login` | 同上 |

### 4. UserMapper 注解

```java
@Insert("INSERT INTO `user` (username,password) VALUES (#{username},#{password})")
void register(User user);

@Select("SELECT * FROM `user` WHERE username = #{username}")
User findByUsername(String username);
```

### 5. 关键点

- `@Mapper` 接口不用实现，MyBatis 自动生成代理对象并注入
- `username` 字段名要和数据库、`#{username}` 一致
- 密码暂时明文存储，实际项目要加密（大二学）

---

## 二、今日算法

### 844 比较含退格的字符串

**方法**：StringBuilder 当栈

- 遇字符 → `append`
- 遇 `#` → 删最后一个字符

```java
private String build(String str) {
    StringBuilder sb = new StringBuilder();
    for (char c : str.toCharArray()) {
        if (c == '#') {
            if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(c);
        }
    }
    return sb.toString();
}
```

### 1441 用栈操作构建数组

**方法**：模拟，`index` 指向 target 当前位置

```java
for (int i = 1; i <= n && index < target.length; i++) {
    result.add("Push");
    if (target[index] == i) {
        index++;           // 匹配上，看下一个
    } else {
        result.add("Pop"); // 不匹配，Push 后马上 Pop
    }
}
```

不需要真的用栈，`index` 记录匹配位置即可。

---

## 三、今日总结

| 分类 | 内容 |
|------|------|
| Spring Boot | 用户表 + 注册登录接口 |
| MyBatis | `@Insert`、`@Select`、`#{}` |
| 算法 | 栈模拟退格 |
| 算法 | 模拟构建数组 |
---