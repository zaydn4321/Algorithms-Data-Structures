public class Main
{
	public static void main(String[] args) {

		ListNode eight = new ListNode(8, null);
		ListNode seven = new ListNode(7, eight);
		ListNode six = new ListNode(6, seven);
		ListNode five = new ListNode(5, six);
		ListNode four = new ListNode(4, five);
		ListNode three = new ListNode(3, four);
		ListNode two = new ListNode(2, three);
		ListNode one = new ListNode(1, two);

        System.out.println("Printing Nodes:");
		ListOperations.print(one);
		System.out.println("Node Count:");
		System.out.println(ListOperations.nodeCount(one));
		System.out.println("Double First:");
		ListOperations.doubleFirst(one);
		ListOperations.print(one);
		System.out.println("Double Last:");
		ListOperations.doubleLast(one);
		ListOperations.print(one);
		System.out.println("Skip Every Other:");
		ListOperations.skipEveryOther(one);
		ListOperations.print(one);
		System.out.println("Set Every Xth:");
		ListOperations.setEveryXthNode(one, 2, 15);
		ListOperations.print(one);
		System.out.println("Remove Every Xth");
		ListOperations.removeEveryXthNode(one, 2);
		ListOperations.print(one);

	}
}
