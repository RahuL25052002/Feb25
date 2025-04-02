import java.util.*;

class BT{
	static Node root;
	static class Node{

		int data;
		Node left;
		Node right;
		Node(int d){
			data=d;
			left=null;
			right=null;
		}
	}
	BT(){
		root=null;
	}
	BT(int d){
		root=new Node(d);
	}
	static void display(Node root){
		if(root==null){
			return ;
		}
		System.out.println(root.data);
		if(root.left!=null){
			display(root.left);
		}
		if(root.right!=null){

			display(root.right);
		}
	}
	static void preOrder(Node n){
		if(n==null){
			return;
		}
		System.out.print(n.data+" ");
		preOrder(n.left);
		preOrder(n.right);
	}
	static void InOrder(Node n){
                if(n==null){
                        return;
                }
                InOrder(n.left);
                System.out.print(n.data+" ");
                InOrder(n.right);
        }
	static void postOrder(Node n){
                if(n==null){
                        return;
                }
                postOrder(n.left);
                postOrder(n.right);
		System.out.print(n.data+" ");
        }

	public void prettyDisplay(){
        	prettyDisplay(root,0);
    	}	

	static void prettyDisplay(Node node,int level){
        	if(node==null){
            		return ;
        	}
        	prettyDisplay(node.right,level+1);
        	if(level!=0){
            		for(int i=0;i<level-1;i++){
                		System.out.print("|\t\t");
            		}
            		System.out.println("|--------------->"+node.data);
        	}else{
            		System.out.println(node.data);
        	}
        	prettyDisplay(node.left,level+1);
       

	}
	//insertion in BST
	static Node insertData(Node root,int d){
		//Node newNode=new Node(d);
		if(root==null){
			root=new Node(d);
			return root;
		}
		if(root.data>=d){
			root.left=insertData(root.left,d);
		}
		if(root.data<=d){
			root.right=insertData(root.right,d);
		}
		return root;
	}
	void insert(int d){
		root=insertData(root,d);
	}

	static int minvalue(Node root){
		int x=root.data;
		while(root.left!=null){
			x=root.left.data;
			root=root.left;
		}
		return x;
	}
	static Node deleteNode(Node root,int k){
		if(root==null){
			return root;
		}
		if(k<root.data){
			root.left=deleteNode(root.left,k);
		}else if(k> root.data){

			root.right=deleteNode(root.right,k);
		}else{

			if(root.left==null)
				return root.right;
			if(root.right==null)
				return root.left;

			root.data=minvalue(root.right);
			root.right=deleteNode(root.right,root.data);

		}
		return root;
	}
	public static void main(String[]args){
		/*BT  t1=new BT();
		t1.root=new Node(10);
		t1.root.left=new Node(20);
		t1.root.right=new Node(30);
		t1.root.left.left=new Node(40);
		t1.root.left.right=new Node(50);
		t1.root.right.left=new Node(60);
                t1.root.right.right=new Node(70);
	

		t1.display(t1.root);
		System.out.println();
		t1.preOrder(t1.root);
		System.out.println();
		t1.postOrder(t1.root);
		System.out.println();
		t1.InOrder(t1.root);
		System.out.println();
		System.out.println();
		t1. prettyDisplay();*/

		BT t1=new BT();
		Scanner obj=new Scanner(System.in);
		for(int i=0;i<7;i++){
			int d=obj.nextInt();
			t1.insert(d);
		}

		t1. prettyDisplay();

		System.out.println("===================================================");
		t1.root=deleteNode(t1.root,30);
		t1. prettyDisplay();
					

	}

}
