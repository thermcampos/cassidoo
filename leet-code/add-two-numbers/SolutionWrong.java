import java.util.Arrays;

public class Solution {

  public static void main(String[] args) {
    // example 1: [2,4,3] and [5,6,4]
    // expected: [7,0,8]
    /*ListNode e1_l1 = build(2,4,3);
    ListNode e1_l2 = build(5,6,4);
    print(e1_l1);
    print(e1_l2);
    addTwoNumbers(e1_l1, e1_l2);*/

    // example 2: [0] and [0]
    // expected: [0]
    /*ListNode e2_l1 = build(0);
    ListNode e2_l2 = build(0);
    print(e2_l1);
    print(e2_l2);
    addTwoNumbers(e2_l1, e2_l2);*/
    
    // example 3: [9,9,9,9,9,9,9] and [9,9,9,9]
    // expected: [8,9,9,9,0,0,0,1]
    /*ListNode e3_l1 = build(9,9,9,9,9,9,9);
    ListNode e3_l2 = build(9,9,9,9);
    print(e3_l1);
    print(e3_l2);
    addTwoNumbers(e3_l1, e3_l2);*/

    // example 4: [0] and [1]
    // expected: [1]
    /*ListNode e4_l1 = build(0);
    ListNode e4_l2 = build(1);
    print(e4_l1);
    print(e4_l2);
    addTwoNumbers(e4_l1, e4_l2);*/
    
    // example 5: [9] and [1,9,9,9,9,9,9,9,9,9]
    // expected: [0,0,0,0,0,0,0,0,0,0,1]
    /*ListNode e5_l1 = build(9);
    ListNode e5_l2 = build(1,9,9,9,9,9,9,9,9,9);
    print(e5_l1);
    print(e5_l2);
    addTwoNumbers(e5_l1, e5_l2);*/
    
    // example 6: [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1] and [5,6,4]
    // expected: ?
    ListNode e6_l1 = build(1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1);
    ListNode e6_l2 = build(5,6,4);
    print(e6_l1);
    print(e6_l2);
    addTwoNumbers(e6_l1, e6_l2);
  }

  static final boolean DEBUG = false;

  static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int[] l1_numbers = new int[]{};
    int[] l2_numbers = new int[]{};
    // build array in order
    do {
      if (l1.next != null) {
        l1_numbers = Arrays.copyOf(l1_numbers, l1_numbers.length + 1);
        l1_numbers[l1_numbers.length-1] = l1.val;
        l1 = l1.next;
      }
      // last node
      if (l1.next == null) {
        l1_numbers = Arrays.copyOf(l1_numbers, l1_numbers.length + 1);
        l1_numbers[l1_numbers.length-1] = l1.val;
      }
    } while (l1.next != null);

    do { 
      if (l2.next != null) {
        l2_numbers = Arrays.copyOf(l2_numbers, l2_numbers.length + 1);
        l2_numbers[l2_numbers.length-1] = l2.val;
        l2 = l2.next;
      }
      // last node
      if (l2.next == null) {
        l2_numbers = Arrays.copyOf(l2_numbers, l2_numbers.length + 1);
        l2_numbers[l2_numbers.length-1] = l2.val;
      }
    } while (l2.next != null);

    // reverse it
    int l1_size = l1_numbers.length;
    String l1_ordered = "";
    for (int i=0; i<l1_size; i++) {
      l1_ordered += Integer.toString(l1_numbers[l1_size - 1 - i]);
    }
    if (DEBUG) {
      System.out.println("l1 array is " + l1_ordered);
    }

    int l2_size = l2_numbers.length;
    String l2_ordered = "";
    for (int i=0; i<l2_size; i++) {
      l2_ordered += Integer.toString(l2_numbers[l2_size - 1 - i]);
    }

    if (DEBUG) {
      System.out.println("l2 array is " + l2_ordered);
    }

    // sum both
    long left = 0;
    if (l1_ordered.length() > 0) {
      left = Long.parseLong(l1_ordered);
    }
    long right = 0;
    if (l2_ordered.length() > 0) {
      right = Long.parseLong(l2_ordered);
    }
    long result = left + right;
    if (DEBUG) {
      System.out.println("sum result is " + result);
    }

    // recreate nodes to return
    String result_str = Long.toString(result);
    int result_len = result_str.length();
    if (DEBUG) {
      System.out.println("result_len is " + result_len);
    }
    ListNode node = null;
    ListNode lastNode = null;
    for (int i=0; i<result_len; i++) {
      int val = (int) (result_str.charAt(i) - 48);
      if (DEBUG) {
        System.out.println("current from result is " + val);
      }

      if (i == 0) { 
        node = new ListNode(val);
        lastNode = node;

        if (DEBUG) {
          System.out.println("last element is " + val + " and node is " + node);
        }
      }
      else {
        node = new ListNode(val, lastNode);
        lastNode = node;
        if (DEBUG) {
          System.out.println("BEFORE last element is " + val + " and node is " + node);
        }
      }
    }
    print(node);
    return node;
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

