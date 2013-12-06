package datastruct;

import java.lang.Comparable;

/**
 * Class for the binary tree table
 */
public class BinaryTreeTable<E extends Comparable<E>, T> implements Table<E, T> {
//Attributes
	private Node root;
	private int size;


//Methods
	/**
	 * Constructor of the binary tree table
	 */
	public BinaryTreeTable() {
		//Initializes the size
		this.size = 0;

		//Creates the root
		this.root = new Node(null, null, null);
	}


	@Override
	public T select (E key) {
		T ret = null;

		//If the tree is empty
		if (this.size == 0) {
			ret = null;
			System.out.println("Empty Tree, cannot runs select!");
		}
		else {
			//Find the node
			Node selected = this.findNode(this.root, key);

			//If it exists
			if (selected != null) {
				//Return his data
				ret = selected.data;
			}

			//If the key doesn't exist
			else {
				ret = null;
				System.out.println("No matched key!");
			}
		}

		return ret;
	}

	
 	@Override
 	public boolean insert (E key, T data) {
 		boolean ret = false;

 		//If the tree is empty
 		if (this.size == 0) {
 			Node toInsert = new Node(null, key, data);
 			this.root = toInsert;
 			ret = true;
 			this.size++;
 		}

 		//If not empty
 		else {
 			//Seek to a father which doesn't have two sons
	 		Node father = this.seekFather(key);

	 		//Verify if it's null or not
	 		if (father == null) {
	 			ret = false;
	 		}

	 		//If not, link the new node to his father
	 		else {
	 			Node toInsert = new Node(father, key, data);

	 			//If the key of the element to insert is higher than his father, insert him to his right
	 			if (key.compareTo(father.key) > 0) {
	 				father.rSon = toInsert;
	 				this.size++;
	 				ret = true;
	 			}

	 			//If the key of the element to insert is lower than his father, insert him to his left
	 			if (key.compareTo(father.key) < 0) {
	 				father.lSon = toInsert;
	 				this.size++;
	 				ret = true;
	 			}

	 			//If another case, false
	 			else {
	 				ret = false;
	 			}
 			}
 		}

 		return ret;
 	}


 	@Override
 	public boolean delete (E key) {
 		boolean ret = false;

 		//If the tree is empty
 		if (this.size == 0) {
 			ret = false;
 		}

 		//If there's only the root
 		else if (this.size == 1) {
 			this.root = null;
 			ret = true;
 			this.size--;
 		}

 		//In all the others cases
 		else {
 			//Find the node to delete
 			Node toDelete = this.findNode(this.root, key);

 			//If the node doesn't exist
 			if (toDelete == null) {
 				ret = false;
 			}
 			else {
 				//Remove the node and its relatives
 				this.remove(toDelete);
 				ret = true;
 				this.size--;
 			}
 		}

 		return ret;
 	}


	/**
	 * Allows to have a correct display of the tree
	 * @return A String which correctly display the tree
	 */
	public String toString() {
		String ret = "";

		//If the tree is empty
		if (this.size == 0) {
			ret = "Empty Tree!";
		}
		else {
			//Just gets all the infos from the root
			ret = this.getInfoFrom(this.root);
		}

		return ret;
	}


	/**
	 * Accessor of the size of the tree
	 * @return The size of the tree
	 */
	public int getSize() {
		return this.size;
	}


	/**
	 * To know the high of the two subtrees, left and right
	 * @return A String representation of the high of subtress
	 */
	public String balanceLevel() {
		String ret = "";

		//If the tree is empty
		if (this.size == 0) {
			ret = "The tree is empty, so its high is 0.";
		}

		//If there's only one element, the root
		else if (this.size == 1) {
			ret = "The high of the tree is 1.";
		}

		//In all the other cases
		else {
			ret = "High of the left subtree: " + this.highOfNode(this.root.lSon) + "\n";
			ret = ret + "High of the right subtree: " + this.highOfNode(this.root.rSon) + "\n";
		}

		return ret;
	}


	/**
	 * Allows to know the high of a node
	 * @return The high of a node
	 */
	private int highOfNode(Node aNode) {
		int ret = 0;

		//If the node entered is null
		if (aNode == null) {
			//Do nothing
		}

		//If not
		else {
			//If there's only a left son
			if ((aNode.lSon != null) && (aNode.rSon == null)) {
				ret = highOfNode(aNode.lSon) + 1;
			}

			//If there's only a right son
			else if ((aNode.lSon == null) && (aNode.rSon != null)) {
				ret = highOfNode(aNode.rSon) + 1;
			}

			//If there are two sons
			else {
				ret = Math.max(highOfNode(aNode.lSon), highOfNode(aNode.rSon)) + 1;
			}
		}

		return ret;
	}


 	/**
	 * Allows to search the father
	 * @param key The key where you begin your research
	 * @return The father, and if the key is the father return null
	 */
	private Node seekFather (E key)	{
		Node ret = null;

		//Checks if root exists
		Node tmp = this.root;
		int comp;

		//Travels the tree
		while (tmp != null) {

			//Compare the key with the current tmp
			ret = tmp;
			comp = key.compareTo(tmp.key);

			//If the key is higher than the current tmp, go to the right
			if (comp > 0) {
				tmp = tmp.rSon;
			}

			//Here, we don't have equals because 

			//If the key is smaller than the current tmp, go to the left
			else if (comp < 0) {
				tmp = tmp.lSon;
			}

			//For all the other cases
			else {
				tmp = ret = null;
			}
		}

		//Return the father where we'll insert the element
		return ret;
	}


	/**
	 * Allows to get all the info about a node and all its branches
	 * @param aNode The node where we'll begin; if all the tree is needed, place here the root
	 * @return A String representing all the nodes to its left, itself and then all the nodes to its right
	 */
	private String getInfoFrom(Node aNode) {
		String dataLeftNode = "";
		String dataRightNode = "";
		String dataNode = "";
		String ret = "";

		//It will be recursive because we'll use the same method in itself
		if (aNode != null) {
			//Getting all the informations from the left subtree
			dataLeftNode = this.getInfoFrom(aNode.lSon);

			//Getting all the informations from the right subtree
			dataRightNode = this.getInfoFrom(aNode.rSon);

			//Getting the informations of this node
			dataNode = "\n" + "Key: " + aNode.key.toString() + "\n" + "Data: " + aNode.data.toString() + "\n";

			ret = dataLeftNode + dataNode + dataRightNode;
		}

		//If there's no subbranches
		else {
			ret = "";
		}

		return ret;
	}


	/**
	 * Allows to find a Node associated with a key enterred
	 * @param theNode The node where we'll begin the research
	 * @param key The key of the Node to research
	 * @return The Node associated to this key
	 */
	private Node findNode(Node theNode, E key) {
		//Begins from the node enterred
		Node tmp = theNode;
		Node ret = null;

		//If the node entered is null!
		if (theNode == null) {
			System.out.println("Node entered null!");
		}

		//If not, begin the comparaisons
		else {
			//Compare the keys
			int res = key.compareTo(tmp.key);

			//If the key is higher than the key of the current node, go to the right
			if (res > 0) {
				tmp = tmp.rSon;

				//Verify if there's a right son
				if (tmp != null) {
					ret = this.findNode(tmp, key);
				}
			}

			//If the key is lower than the key of the current node, go to the left
			else if (res < 0) {
				tmp = tmp.lSon;

				//Verify if there's a left son
				if (tmp != null) {
					ret = this.findNode(tmp, key);
				}
			}

			//If the keys are equals
			else {
				ret = theNode;
			}
		}
		
		return ret;
	}

	/**
	 * Allows to remove correctly a node, used in the delete method
	 * @param nodeToRmv The node that we want to remove
	 */
	private void remove(Node nodeToRmv) {
		Node tmpLeft;
		Node tmpRight;

		//If it has no sons
		if ((nodeToRmv.lSon == null) && (nodeToRmv.rSon == null)) {
			
			//If it's the right son
			if (nodeToRmv.father.rSon == nodeToRmv) {
				nodeToRmv.father.rSon = null;
			}

			//If it's the left son
			else {
				nodeToRmv.father.lSon = null;
			}
		}

		//If it has only a left son
		else if ((nodeToRmv.lSon != null) && (nodeToRmv.rSon == null)) {
			//We'll use a temp to save its left son
			Node tmp = nodeToRmv.lSon;

			//If it's the root! Sensible case!
			if (this.root == nodeToRmv) {
				this.root = tmp;
			}

			//In the others cases
			else {

				//If it's the right son
				if (nodeToRmv.father.rSon == nodeToRmv) {
					//Just replace the node to remove by its left son
					nodeToRmv.father.rSon = tmp;
				}

				//If it's the left son
				else {
					//Just replace the node to remove by its left son
					nodeToRmv.father.lSon = tmp;
				}
			}
		}

		//If it has only a right son
		else if ((nodeToRmv.lSon == null) && (nodeToRmv.rSon != null)) {
			//We'll use a temp to save its right son
			Node tmp = nodeToRmv.rSon;

			//If it's the root! Sensible case!
			if (this.root == nodeToRmv) {
				this.root = tmp;
			}

			//In the others cases
			else {

				//If it's the right son
				if (nodeToRmv.father.rSon == nodeToRmv) {
					//Just replace the node to remove by its left son
					nodeToRmv.father.rSon = tmp;
				}

				//If it's the left son
				else {
					//Just replace the node to remove by its left son
					nodeToRmv.father.lSon = tmp;
				}
			}
		}

		//If it has two sons!
		else {
			//Research of the node which has the highest key
			Node theGNode = nodeToRmv.lSon;

			//The biggest key in the left subtree is the one which is at the right of it
			while (theGNode.rSon != null) {
				theGNode = theGNode.rSon;
			}

			//Now, we'll replace ONLY the informations of the node to delete
			nodeToRmv.data = theGNode.data;
			nodeToRmv.key = theGNode.key;

			//Then delete the GNode
			this.remove(theGNode);
		}
	}


	/*
	 * Allows to get all data contained in a node and its relatives
	 * @return A String object containing all data found
	 */
	/* 
	private String getString () {
		String ret = data.toString();
		if (lSon != null) {
			ret = lSon.getString() + ret;
		}
		if (rSon != null) {
			ret = rSon.getString() + ret;
		}
		return ret;
	}*/
	


 	/*########################################### Inner Classes ###########################################*/

 	/**
 	 * Class for the nodes contained in the binary tree
 	 */
 	private class Node {
	// Attributes
		Node father;
		Node lSon;
		Node rSon;
		T data;
		E key;


	//Methods
		/**
		 * Constructor of Node
		 * @param father His father
		 * @param val The value contained in it
		 * @param key His key
		 */
		Node(Node father, E key, T val) {
			this.father = father;
			this.data = val;
			this.key = key;
		}
	}
}