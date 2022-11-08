//@author: Zayd Nadir
public class Main
{
	public static void main(String[] args) {
		
		
		String full = ""; //stores message if full or not full
		BinarySearchTree t = new BinarySearchTree(); //initializing search Tree
		//adding nodes to tree
		t.add(90);
		t.add(80);
		t.add(100);
		t.add(70);
		t.add(85);
		t.add(98);
		t.add(120);
		
		
		System.out.println("IN ORDER");
		//prints tree in order
		t.inOrder();
		System.out.println("PRE ORDER");
		//prints tree in preorder
		t.preOrder();
		System.out.println("POST ORDER");
		//prints tree in postorder
		t.postOrder();
		System.out.println("REVERSE ORDER");
		//prints tree in reverseorder
		t.reverseOrder();
		//prints number of leaves
		System.out.println("Number of leaves is " + t.getNumLeaves());
		//prints number of nodes
		System.out.println("Number of nodes is " + t.getNumNodes());
		//prints number of levels
		System.out.println("Number of levels is " + t.getNumLevels());
		//prints tree as a string
		System.out.println("Tree as a string " + t);
		if(t.isFull()) //creates "is full" or "is not full" based on if the condition is true
		{
		    full = "is full.";
		}
		else
		{
		    full = "is not full.";
		}
		//states if the tree is full
		System.out.println("Tree is " + full);




	}
}
