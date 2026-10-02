import java.util.Arrays;

public class Solution {

  public static void main(String[] args) {
    System.out.println("Example 1");
    // example 1: [2,4,3] and [5,6,4]
    // expected: [7,0,8]
    ListNode e1_l1 = build(2,4,3);
    ListNode e1_l2 = build(5,6,4);
    print(e1_l1);
    print(e1_l2);
    print(addTwoNumbers(e1_l1, e1_l2));

    System.out.println("\nExample 2");
    // example 2: [0] and [0]
    // expected: [0]
    ListNode e2_l1 = build(0);
    ListNode e2_l2 = build(0);
    print(e2_l1);
    print(e2_l2);
    print(addTwoNumbers(e2_l1, e2_l2));
    
    System.out.println("\nExample 3");
    // example 3: [9,9,9,9,9,9,9] and [9,9,9,9]
    // expected: [8,9,9,9,0,0,0,1]
    ListNode e3_l1 = build(9,9,9,9,9,9,9);
    ListNode e3_l2 = build(9,9,9,9);
    print(e3_l1);
    print(e3_l2);
    print(addTwoNumbers(e3_l1, e3_l2));

    System.out.println("\nExample 4");
    // example 4: [0] and [1]
    // expected: [1]
    ListNode e4_l1 = build(0);
    ListNode e4_l2 = build(1);
    print(e4_l1);
    print(e4_l2);
    print(addTwoNumbers(e4_l1, e4_l2));

    System.out.println("\nExample 5");
    // example 5: [9] and [1,9,9,9,9,9,9,9,9,9]
    // expected: [0,0,0,0,0,0,0,0,0,0,1]
    ListNode e5_l1 = build(9);
    ListNode e5_l2 = build(1,9,9,9,9,9,9,9,9,9);
    print(e5_l1);
    print(e5_l2);
    print(addTwoNumbers(e5_l1, e5_l2));
    
    System.out.println("\nExample 6");
    // example 6: [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1] and [5,6,4]
    // expected: ?
    ListNode e6_l1 = build(1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1);
    ListNode e6_l2 = build(5,6,4);
    print(e6_l1);
    print(e6_l2);
    print(addTwoNumbers(e6_l1, e6_l2));
  }

  static final boolean DEBUG = false;

  static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int rest = 0;
    int[] result = new int[]{};
    int idx = 0;

    do {
      int left = 0;
      if (l1 != null) left = l1.val;
      int right = 0;
      if (l2 != null) right = l2.val;
      int sum = left + right + rest;
      if (sum > 9) {
        rest = sum / 10;  //sum - 10;
        sum -= 10;
      } else {
        rest = 0;
      }
      result = Arrays.copyOf(result, result.length + 1);
      result[idx++] = sum;

      // goes to next, if has next
      if (l2 != null) {
        l2 = l2.next;
      }
      if (l1 != null) {
        l1 = l1.next;
      } 
    } while (l1 != null || l2 != null || rest != 0);

    // build result
    ListNode node = new ListNode();
    ListNode lastNode = node;
    for (int i=0; i<result.length; i++) {
      lastNode.next = new ListNode(result[i]);
      lastNode = lastNode.next;
    }

    return node.next;
  }

  static ListNode build (int... digits) {
    ListNode dummy = new ListNode();
    ListNode tail = dummy;
    for (int  d : digits) {
      tail.next = new ListNode(d);
      tail = tail.next;
    }
    return dummy.next;
  }

  static void print(ListNode n) {
    System.out.print("[");
    do {
      if (n != null) {
        System.out.print(n.val);
        if (n.next != null) {
          System.out.print(",");
        }
      }
      n = n.next;
    } while (n != null);
    System.out.println("]");
  }
}

class ListNode {
  int val;
  ListNode next;
  
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }

  @Override
  public String toString() { return String.format("{\"val\":%d, \"hasNext\":%b}", this.val, this.next != null); }
}

