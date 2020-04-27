package cn.leetcode.codes.simple2;


public class Simple2 {

    /*
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*/


    public static void main(String[] args) {

        Simple2 simple2 = new Simple2();


        ListNode l1 = new ListNode(2);
        ListNode l1Mid = new ListNode(4);
        ListNode l1Last = new ListNode(3);

        l1Last.next = null;
        l1Mid.next = l1Last;
        l1.next = l1Mid;


        ListNode l2 = new ListNode(5);
        ListNode l2Mid = new ListNode(6);
        ListNode l2Last = new ListNode(4);

        l2Last.next = null;
        l2Mid.next = l2Last;
        l2.next = l2Mid;



        ListNode reNode = simple2.addTwoNumbers(l1,l2);


        StringBuilder reSb = new StringBuilder();
        ListNode reNext = reNode;
        while (reNext != null){
            reSb.append(reNext.val);

            reNext = reNext.next;
        }
        System.out.println("reSb  ="+reSb);

    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        StringBuilder sb1 = new StringBuilder();
        ListNode l1Next = l1;
        while (l1Next != null){
            sb1.append(l1Next.val);

            l1Next = l1Next.next;
        }

        StringBuilder sb2 = new StringBuilder();
        ListNode l2Next = l2;
        while (l2Next != null){
            sb2.append(l2Next.val);

            l2Next = l2Next.next;
        }
        System.out.println("sb1  ="+sb1 + " sb2 = "+sb2);

        char[] chars1 = sb1.toString().toCharArray();
        StringBuilder sbRevert1 = new StringBuilder();
        for (int i = chars1.length -1 ; i >= 0;i--) {
            sbRevert1.append(chars1[i]);
        }

        char[] chars2 = sb2.toString().toCharArray();
        StringBuilder sbRevert2 = new StringBuilder();
        for (int i = chars2.length -1 ; i >= 0;i--) {
            sbRevert2.append(chars2[i]);
        }

        System.out.println("字符串翻转 ： sbRevert1  ="+sbRevert1 + " sbRevert2 = "+sbRevert2);


        int v1 = Integer.parseInt(sb1.toString());
        int v2 = Integer.parseInt(sb2.toString());

        int re = v1+v2;

        System.out.println(" re = "+re);

        char[] reChars = String.valueOf(re).toCharArray();

        // 头部
        ListNode reNode = new ListNode(reChars[reChars.length - 1]);
        for (int i = reChars.length -2 ; i >=0 ; i--) {
            if (i == 0) {
                reNode.next = null;
            }else{
                reNode.next = new ListNode(reChars[i]);
            }
        }





        return reNode;
    }






}
