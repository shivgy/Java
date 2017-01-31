public class BinaryTree{
	
	public static void main(String[] args){
		new BinaryTree().run();
	}
	
	static class Node{
		Node left;
		Node right;
		int data;
		
		public Node(int data){
			this.data = data;
		}
	}
	
	public void run(){
		Node root = new Node(5);
		
		System.out.println(root.data + " ");
		
		insert(root, 1);
		insert(root, 8);
		insert(root, 6);
		insert(root, 3);
		insert(root, 9);
		
		System.out.println("Traversing Tree InOrder");
		inOrder(root);
		
	}
	
	public void insert(Node node, int data){
		if(data < node.data){
			if(node.left != null){
				insert(node.left, data);
			}
			else{
				node.left = new Node(data);
			}
		}
		else if(data > node.data){
			if(node.right != null){
				insert(node.right, data);
			}
			else{
				node.right = new Node(data);
			}
		}
	}
	
	public void inOrder(Node node){
		if(node != null){
			inOrder(node.left);
			System.out.println(node.data);
			inOrder(node.right);
		}
	}
}
