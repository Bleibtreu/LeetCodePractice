import java.util.*;
import java.util.stream.Collectors;

/**
 * 请判断一个链表是否为回文链表。
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * <p>
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 * <p>
 * 进阶：
 * 你能否用O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * @author bleibtreu
 * @date 2020/10/23 9:28
 */
public class IsPalindrome {

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        System.out.println(isPalindrome.isPalindrome2(listNode));
    }

    public boolean isPalindrome1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        list = ConvertList(head, list);
        System.out.println(list);
        if (list.size() == 0 || list.size() == 1) {
            return true;
        }
        List<Integer> list1;
        List<Integer> list2;
        int half = list.size() / 2;
        if (list.size() % 2 == 0) {
            list1 = list.subList(0, half);
            list2 = list.subList(half , list.size());
            Collections.reverse(list2);
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i).intValue() != list2.get(i).intValue()) {
                    return false;
                }
            }
            return true;
        } else {
            list1 = list.subList(0, half);
            list2 = list.subList(half + 1, list.size());
            Collections.reverse(list2);
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i).intValue() != list2.get(i).intValue()) {
                    return false;
                }
            }
            return true;
        }
    }

    public List ConvertList(ListNode listNode, List list) {
        if (listNode == null)
            return new ArrayList();
        list.add(listNode.val);
        if (listNode.next != null) {
            ConvertList(listNode.next, list);
        }
        return list;
    }

    public boolean isPalindrome2(ListNode head) {
        // 要实现 O(n) 的时间复杂度和 O(1) 的空间复杂度，需要翻转后半部分
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 根据快慢指针，找到链表的中点
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverse(slow.next);
        while(slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head){
        // 递归到最后一个节点，返回新的新的头结点
        if (head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
