package cn.leetcode.codes.simple155

import cn.leetcode.codes.out
import java.util.*
import kotlin.math.min


fun main() {

    val minStack = MinStack()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)

    out(minStack.getMin())//   --> 返回 -3.
    minStack.pop()

    out(minStack.top())  //      --> 返回 0.
    out(minStack.getMin()) //   --> 返回 -2.

}

/*
155. 最小栈
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) —— 将元素 x 推入栈中。
pop() —— 删除栈顶的元素。
top() —— 获取栈顶元素。
getMin() —— 检索栈中的最小元素。


示例:

输入：
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

输出：
[null,null,null,null,-3,null,0,-2]

解释：
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.


提示：

pop、top 和 getMin 操作总是在 非空栈 上调用。
 */

class MinStack() {

    private val minStack = LinkedList<Int>().also {
        it.push(Int.MAX_VALUE)
    }
    private val numStack = LinkedList<Int>()

    fun push(x: Int) {
        numStack.push(x)
        minStack.push(min(minStack.peek(), x))
    }

    fun pop() {
        numStack.pop()
        minStack.pop()
    }

    fun top(): Int {
        return numStack.peek()
    }

    fun getMin(): Int {
        return minStack.peek()
    }

}