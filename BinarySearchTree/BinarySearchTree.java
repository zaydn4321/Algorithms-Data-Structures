import java.util.LinkedList;

public class BinarySearchTree
{
	private TreeNode root;

	public BinarySearchTree()
	{
		root = null;
	}

public void add(Comparable val)
	{
		root = add(val, root);
	}

	private TreeNode add(Comparable val, TreeNode tree)
	{
	   if(tree == null)
			tree = new TreeNode(val);
		
		Comparable treeValue = tree.getValue();
		int dirTest = val.compareTo(treeValue);
		
		
		if(dirTest < 0)
			tree.setLeft(add(val, tree.getLeft()));
		else if(dirTest > 0)
			tree.setRight(add(val, tree.getRight()));
		
		return tree;
	}
    
    /**
     * public method to be accessed in main
     **/
   public void inOrder()
	{
		inOrder(root);
		System.out.println("\n");
	}
    
	private void inOrder(TreeNode tree)
	{
		if (tree != null) //repeat the process until there is no node remaining
		{
		    //prints left, middle, right node
			inOrder(tree.getLeft()); //follow the left node and print its value
			System.out.print(tree.getValue() + " "); //print the value of the middle (parent) node
			inOrder(tree.getRight());  //print the value and follow right node
		}
	}
    /**
     * public method to be accessed in main
     **/
	public void preOrder()
	{
	    preOrder(root);
		System.out.println("\n"); 
	}
    private void preOrder(TreeNode tree)
    {
        if(tree != null) //repeat the process until there is no node remaining
        {
            //prints middle, left, right node
            System.out.print(tree.getValue() + " "); //print the value of the middle(parent) node
            preOrder(tree.getLeft()); //follow the left node and print its value
            preOrder(tree.getRight()); //follow the right node and print its value
        }
    }
    /**
     * public method to be accessed in main
     **/
    public void postOrder()
	{
	    postOrder(root);
		System.out.println("\n");
	}
    private void postOrder(TreeNode tree)
    {
        if(tree != null) //repeat the process until you go all the way down the tree
        {
            //prints left, right, middle node
            postOrder(tree.getLeft()); //print the value of the left node and go down the left of the tree
            postOrder(tree.getRight()); //print the value of the right node and go down the right of the ree
            System.out.print(tree.getValue() + " "); //print the value of the middle (parent) node

        }
    }
    /**
     * public method to be accessed in main
     **/
    public void reverseOrder()
	{
	    reverseOrder(root);
		System.out.println("\n");
	}
    private void reverseOrder(TreeNode tree)
    {
        if(tree != null) //repeat the process until you go all the way down the tree
        {
            //prints left, right, middle node
            reverseOrder(tree.getRight()); //print the value of the right node and go down the left of the tree
            System.out.print(tree.getValue() + " "); //print the value of the middle (parent) node
            reverseOrder(tree.getLeft());//print the value of the left node and go down the right of the ree

        }
    }

    
	public int getNumLevels()
	{
		return getNumLevels(root);
	}

	private int getNumLevels(TreeNode tree)
	{
		if(tree==null)
		{
			return 0;
		}
		else if(getNumLevels(tree.getLeft())>getNumLevels(tree.getRight()))
		{
			return 1+getNumLevels(tree.getLeft());
		}
		else
		{
			return 1+getNumLevels(tree.getRight());
		}
	}
    
    
    /**
     * public method to be accessed in main
     **/
    public int getNumLeaves()
    {
        return getNumLeaves(root);
    }
    private int getNumLeaves(TreeNode tree)
	{
		if(tree==null) //if the tree has no nodes, return 0
		{
			return 0;
		}
		else if(tree.getLeft() == null && tree.getRight() == null) //if the node has no children
		{
			return 1; //return 1 since it is at the bottom of the tree
		}
		else
		{
			return getNumLeaves(tree.getLeft()) + getNumLeaves(tree.getRight()); //counts number of leaves on left and right side of tree
		}
	}
	
	/**
     * public method to be accessed in main
     **/
	public int getNumNodes()
    {
        return getNumNodes(root);
    }
    private int getNumNodes(TreeNode tree)
	{
		if(tree==null) //if tree is null count 0 nodes
		{
			return 0;
		}
		else
		{
			return  1 + getNumNodes(tree.getLeft()) + getNumNodes(tree.getRight()); //go through the method again, adding all the nodes on the left and right side eventually
		}
	}

    
	
	/**
     * public method to be accessed in main
     **/
	public boolean isFull()
    {
        return isFull(root);
    }
    private boolean isFull(TreeNode tree)
	{
	    if(tree==null) //if there is no tree return false
		{
			return false;
		}
		else if(tree.getLeft() == null && tree.getRight() == null) //if there is no more nodes below (no single children)
		{
			return true;
		}
		else if(isFull(tree.getLeft()) && isFull(tree.getRight())) //if there are two nodes below
		{
			return true;
		}
		else
		{
		    return false;   
		}
	}


    /**
     * public method to be accessed in main
     **/
	public String toString()
	{
		return toString(root);
	}

	private String toString(TreeNode tree)
	{
	    String str = ""; //stores string for output
		if (tree != null) //as long as there is still a treenode being accessed
		{
			str += toString(tree.getLeft()); //go down left side of tree and store value
			str += (tree.getValue() + " "); //store middle (parent) node value
			str += toString(tree.getRight()); //go down right side of tree and sotre value
			
		}
		return str;
	}
}