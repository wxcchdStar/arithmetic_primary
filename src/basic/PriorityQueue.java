package basic;

import java.util.Arrays;

public class PriorityQueue {

  public int[] queue;

  public PriorityQueue() {
    this(new int[11]);
  }

  public PriorityQueue(int[] init) {
    queue = init;
    heapify();
  }

  private void heapify() {
    for (int i = (queue.length - 1) >> 1; i >= 0; i--) {
      swimDown(i);
    }
  }

  private void swimUp(int index) {
    int n = queue[index];

    int k = index;
    while (k > 0) {
      int pIndex = k >> 1;
      int parent = queue[pIndex];
      if (parent < n) {
        break;
      }
      queue[k] = parent;
      k = pIndex;
    }

    queue[k] = n;
  }

  private void swimDown(int index) {
    int n = queue[index];
    int k = index;
    int half = queue.length >> 1;

    while (k < half) {
      int lIndex = (k << 1) + 1;
      int rIndex = lIndex + 1;

      int min = queue[lIndex];
      int minIndex = lIndex;

      if (rIndex < queue.length && min > queue[rIndex]) {
        min = queue[rIndex];
        minIndex = rIndex;
      }

      if (n < min) {
        break;
      }

      queue[k] = min;
      k = minIndex;
    }

    queue[k] = n;

  }

  public static void main(String[] args) {
    int[] params = new int[]{9, 2, 7, 6, 5, 4, 14, 2, 1, 10, 12};

    PriorityQueue queue = new PriorityQueue(params);
    System.out.println(Arrays.toString(queue.queue));

    java.util.PriorityQueue<Integer> queue1 = new java.util.PriorityQueue<>(Arrays.asList(
        9, 2, 7, 6, 5, 4, 14, 2, 1, 10, 12
    ));
    System.out.println(queue1);
  }
}
