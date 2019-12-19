package leetcode;

import java.util.Arrays;

/**
 * 622. 设计循环队列
 * <p>
 * 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
 * <p>
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
 * <p>
 * 你的实现应该支持如下操作：
 * <p>
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。
 *  
 * <p>
 * 示例：
 * <p>
 * MyCircularQueue circularQueue = new MycircularQueue(3); // 设置长度为 3
 * <p>
 * circularQueue.enQueue(1);  // 返回 true
 * <p>
 * circularQueue.enQueue(2);  // 返回 true
 * <p>
 * circularQueue.enQueue(3);  // 返回 true
 * <p>
 * circularQueue.enQueue(4);  // 返回 false，队列已满
 * <p>
 * circularQueue.Rear();  // 返回 3
 * <p>
 * circularQueue.isFull();  // 返回 true
 * <p>
 * circularQueue.deQueue();  // 返回 true
 * <p>
 * circularQueue.enQueue(4);  // 返回 true
 * <p>
 * circularQueue.Rear();  // 返回 4
 *  
 *  
 * <p>
 * 提示：
 * <p>
 * 所有的值都在 0 至 1000 的范围内；
 * 操作数将在 1 至 1000 的范围内；
 * 请不要使用内置的队列库。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-circular-queue
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No622 {

  public static void main(String[] args) {
    MyCircularQueue circularQueue = new MyCircularQueue(3);

    System.out.println(circularQueue.enQueue(2));
    System.out.println(circularQueue.Rear());
    System.out.println(circularQueue.Front());
    System.out.println(circularQueue.deQueue());
    System.out.println(circularQueue.Front());
    System.out.println(circularQueue.deQueue());
    System.out.println(circularQueue.Front());
    System.out.println(circularQueue.enQueue(4));
    System.out.println(circularQueue.enQueue(2));
    System.out.println(circularQueue.enQueue(2));
    System.out.println(circularQueue.enQueue(3));
  }

  static class MyCircularQueue {
    private int front;
    private int rear;
    private int capacity;
    private int[] arr;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
      capacity = k + 1;
      arr = new int[capacity];

      // 在 front 出队，故设计在数组的头部，方便删除元素
      // 删除元素的时候，只索引 +1（注意取模）
      front = 0;

      // 在 rear 入队，故设计在数组的尾部，方便插入元素
      // 插入元素的时候，先赋值，后索引 +1（注意取模）
      rear = 0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
      if (isFull()) {
        return false;
      }
      arr[rear] = value;
      rear = (rear + 1) % capacity;
      return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
      if (isEmpty()) {
        return false;
      }
      front = (front + 1) % capacity;
      return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
      if (isEmpty()) {
        return -1;
      }
      return arr[front];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
      if (isEmpty()) {
        return -1;
      }
      return arr[(rear - 1 + capacity) % capacity];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
      return front == rear;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
      // 注意：这是这个经典设计的原因
      return (rear + 1) % capacity == front;
    }
  }

}
