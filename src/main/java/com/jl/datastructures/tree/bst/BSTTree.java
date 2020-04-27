/*
 * @(#)BST.java  
 */
package com.jl.datastructures.tree.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


/**
 *<p>二分搜索树：Binary Search Tree</p>
 *
 * <p> 因为二分搜索树中存储的数据必须具有可比较性，所以里面的元素E必须是Comparable的子类 </p>
 *
 * @author: jl
 * @date: 2018/05/26
 * @version: v1.0
 */
public class BSTTree<E extends Comparable<E>> {

	private class Node{
		public E e;
		public Node left;
		public Node right;
		
		public Node(E e) {
			this.e = e;
			this.left = null;
			this.right = null;
		}
	}
	//根节点
	private Node root;
	//元素个数
	private int size;
	
	public BSTTree() {
		this.root = null;
		this.size = 0;
	}
	
	public BSTTree(Node root) {
		this.root = root;
	}
	
	public Node getRoot() {
		return root;
	}
	
	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return root==null || size == 0;
	}
	
	/**
	 * 向二分搜索树中添加新的元素
	 * 
	 * @param e
	 */
	public void add(E e) {
		
		//1.方法一
		/*if(root == null) {
			root = new Node(e);
			size++;
		}else {
			add(getRoot(), e);
		}*/
		
		//2.方法二
		root = addWithRoot(getRoot(), e);
	}
	
	/**
	 * 需要特殊处理根节点<br>
	 * 
	 * 向node指向的二分搜索树中添加元素e,递归<br>
	 * @param node
	 * @param e
	 */
	private void add(Node node,E e) {
		//1.递归终止条件
		if(node.e.equals(e)) {//若果已经存在，则忽略
			return ;
		}else if(e.compareTo(node.e) < 0 && node.left == null) {//e < node.e并且左子树为null,往左子树插入
			node.left = new Node(e);
			size++;
			return ;
		}else if(e.compareTo(node.e) > 0 && node.right == null) {
			node.right = new Node(e);
			size++;
			return ;
		}
		
		if(e.compareTo(node.e) < 0) {
			add(node.left,e);
		}else {
			add(node.right,e);
		}
	}
	
	/**
	 * 不需要特殊处理根节点
	 * 
	 * 向node指向的二分搜索树中添加元素e,递归,<br>
	 * 返回新插入节点后的二分搜索树的根<br>
	 * @param node
	 * @param e
	 */
	private Node addWithRoot(Node node,E e) {
		//1.递归终止条件
		if(node == null) {
			size++;
			return new Node(e);
		}
		
		if(e.compareTo(node.e) < 0) {
			node.left = addWithRoot(node.left,e);
		}else if(e.compareTo(node.e) > 0) {
			node.right = addWithRoot(node.right,e);
		}
		return node;
	}
	
	/**
	 * 查询二分搜索树中是否包含元素e
	 * @param e
	 * @return
	 */
	public boolean contains(E e) {
		return contains(getRoot(), e);
	}
	
	private boolean contains(Node node,E e) {
		if(node == null) {
			return false;
		}
		
		if(e.compareTo(node.e) == 0) {
			return true;
		}else if(e.compareTo(node.e) < 0) {//往左侧插查找
			return contains(node.left, e);
		}else {
			return contains(node.right, e);
		}
	}

	/**
	 * 二分搜索树的前序遍历：深度优先遍历
	 * <p>先访问当前节点，再访问节点的左子树，然后访问节点的右子树，对于每一个子节点也是这样</p>
	 * 
	 */
	public void preOrder() {
		preOrder(getRoot());
	}
	
	/**
	 * 前序遍历以node为根节点的二分搜索树
	 * @param node
	 */
	private void preOrder(Node node) {
		if(node == null) {
			return ;
		}
		
		System.out.println(node.e);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	/**
	 * 二分搜索树的前序遍历：非递归算法 ,用栈实现，
	 */
	public void preOrderNoRecursion() {
		Stack<Node> stack = new Stack<>();
		stack.push(getRoot());
		
		while(!stack.isEmpty()) {
			Node curr = stack.pop();//出栈的时候，不要忘记把左右子树入栈
			System.out.println(curr.e);

			//注意，因为栈是先进后出的，前序遍历是先访问左子树再访问右子树，所以先把右子树入栈
			if(curr.right != null) {
				stack.push(curr.right);
			}
			if(curr.left != null) {
				stack.push(curr.left);
			}
		}
		
	}
	
	
	/**
	 * 中序遍历二分搜索树：深度优先遍历
	 * <p>先访问节点的左子树，再访问当前节点，然后访问节点的右子树，对于每一个子节点也是这样</p>
	 * <p> 中序遍历的结果是元素的从小到大排序的结果 </p>
	 * <p> 非递归实现实际使用不多 </p>
	 */
	public void inOrder() {
		inOrder(getRoot());
	}
	
	/**
	 * 中序遍历以node为根节点的二分搜索树
	 * @param node
	 */
	private void inOrder(Node node) {
		if(node == null) {
			return ;
		}
		
		inOrder(node.left);
		System.out.println(node.e);
		inOrder(node.right);
	}
	
	/**
	 * 后序遍历二分搜索树：深度优先遍历
	 * <p>先访问节点的左子树，然后访问节点的右子树，再访问当前节点，对于每一个子节点也是这样</p>
	 * <p> 非递归实现实际使用不多 </p>
	 */
	public void postOrder() {
		postOrder(getRoot());
	}
	
	/**
	 * 后序遍历以node为根节点的二分搜索树
	 * @param node
	 */
	private void postOrder(Node node) {
		if(node == null) {
			return ;
		}
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.e);
	}
	
	/**
	 * 返回二分搜索树的深度
	 * <p> 找到所有叶子节点的深度，求最大值 </p>
	 * 
	 * @return
	 */
	public int getDepath() {
		List<Integer> list = new ArrayList<>();
		getDepath(getRoot(),1,list);
		int max = 0;
		for (Integer dep : list) {
			if(dep > max) {
				max = dep;
			}
		}
		return max;
	}
	
	private void getDepath(Node node,int depth,List<Integer> list) {
		if(node == null) {
			return ;
		}
		
		if(isLeaf(node)) {
			list.add(depth);
			return ;
		}
		
		getDepath(node.left, depth+1, list);
		getDepath(node.right, depth+1, list);
	}
	
	/**
	 * 层序遍历：广度优先遍历
	 * <p> 需要借助队列实现</p>
	 */
	public void levelOrder() {
		Queue<Node> q = new LinkedList<>();
		q.add(getRoot());
		while(!q.isEmpty()) {
			Node curr = q.remove();
			System.out.println(curr.e);
			if(curr.left != null) {
				q.add(curr.left);
			}
			if(curr.right != null) {
				q.add(curr.right);
			}
		}
	}
	
	/**
	 * 判断node是否是叶子节点
	 * @param node
	 * @return
	 */
	public boolean isLeaf(Node node) {
		if(node == null) {
			return false;
		}
		return node.left == null && node.right == null;
	}
	
	@Override
	public String toString() {
		
	  //打印出来的没有树形结构，只有层级结构
		StringBuilder sb = new StringBuilder();
		generateBstString(getRoot(),0,sb);
		return sb.toString();		
		
	/*	StringBuilder sb = new StringBuilder();
		int maxDepath = getDepath();
		generateBstStringWithLevel(getRoot(),maxDepath,0,sb);
		return sb.toString();		*/
	}

	/**
	 * 生成以node为根节点，深度为depth的二叉树的描述字符串
	 * 
	 * @param root2
	 * @param depth
	 * @param sb
	 */
	private void generateBstString(Node node, int depth, StringBuilder sb) {
		if(node == null) {
			sb.append(generateDepathString(depth) + "null \n");
			return ;
		}
		
		sb.append(generateDepathString(depth) + node.e +" \n");
		generateBstString(node.left, depth+1, sb);
		generateBstString(node.right, depth+1, sb);
	}

	private String generateDepathString(int depth) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			sb.append("-");
		}
		return sb.toString();
	}
	
	
	public String getString() {
		StringBuilder sb = new StringBuilder();
		Queue<Node> queue = new LinkedList<>();
		int maxDepath = getDepath();
		int level = 0;
		queue.add(getRoot());
		while(!queue.isEmpty()) {
			Node curr = queue.remove();
			sb.append(generateDepathString(maxDepath - level) + curr.e);
			System.out.println(curr.e);
			
			if(curr.left != null) {
				queue.add(curr.left);
			}
			if(curr.right != null) {
				queue.add(curr.right);
			}
		}
		
		return "";
	}
	
	/**
	 * 寻找二分搜索树中的最小元素
	 * 
	 */
	public E getMin() {
		if(size == 0) {
			throw new IllegalArgumentException("二分搜索树为空！");
		}
		return getMin(getRoot()).e;
	}
	
	private Node getMin(Node node) {
		if(node.left == null) {
			return node;
		}
		return getMin(node.left);
		
	}
	
	/**
	 * 寻找二分搜索树中的最大元素
	 * 
	 */
	public E getMax() {
		if(size == 0) {
			throw new IllegalArgumentException("二分搜索树为空！");
		}
		return getMax(getRoot()).e;
	}
	
	private Node getMax(Node node) {
		if(node.right == null) {
			return node;
		}
		return getMax(node.right);
	}
	
	/**
	 * 从二分搜索树种删除最小元素，返回最小元素
	 * @return
	 */
	public E removeMin() {
		E ret = getMin();
		//需要把返回的结果赋值给root
		root = removeMin(getRoot());
		return ret;
	}

	/**
	 * 删除以node为根的二分搜索树种最小的节点
	 * 返回删除最小节点后的二分搜索树的根节点
	 * @param node
	 */
	private Node removeMin(Node node) {
		if(node.left == null) {//要删除的节点
			Node rightNode = node.right;
			node.right = null;
			size--;
			return rightNode;//注意return的是rightNode
		}
		node.left = removeMin(node.left);
		return node;
	}
	
	
	/**
	 * 从二分搜索树种删除最大元素，返回最大元素
	 * @return
	 */
	public E removeMax() {
		E ret = getMax();
		removeMax(getRoot());
		return ret;
	}

	/**
	 * 删除以node为根的二分搜索树种最大的节点
	 * 返回删除最大节点后的二分搜索树的根节点
	 * @param node
	 */
	private Node removeMax(Node node) {
		if(node.right == null) {//要删除的节点
			Node leftNode = node.left;
			node.left = null;
			size--;
			return leftNode;//注意return的是leftNode
		}
		node.right = removeMax(node.right);
		return node;
	}
	
	/**
	 * 从二分搜索树中删除元素e
	 * @param e
	 */
	public void remove(E e) {
		root = remove(root,e);
	}

	/**
	 * 递归删除元素e:分成三种情况
	 * 1：要删除的节点只有左子树：右子树为空
	 * 2：要删除的节点只有右子树：左子树为空
	 * 3：要删除的节点有左子树和右子树：：左右子树都不为空
	 * @param root2
	 * @param e
	 * @return 返回删除后新的二分搜索树的根
	 */
	private Node remove(Node node, E e) {
		if(node == null) {
			return null;
		}
		if(e.compareTo(node.e) < 0) {
			node.left = remove(node.left,e);
			return node;
		}else if(e.compareTo(node.e) > 0) {
			node.right = remove(node.right,e);
			return node;
		}else {//e==node.e
			
			//待删除的节点左子树为空
			if(node.left == null) {
				Node rightNode = node.right;
				node.right = null;
				size--;
				return rightNode;
			}
			
			//待删除的节点右子树为空
			if(node.right == null) {
				Node leftNode = node.left;
				node.left = null;
				size--;
				return leftNode;
			}
			//待删除的节点左右子树均不为空的情况：找到比但删除节点大的最小的节点，
			//(我们可以选择左儿子中的最大元素或者右儿子中的最小元素放到待删除节点的位置，就可以保证结构的不变)
			//即待删除节点右子树的最小节点，用这个节点顶替待删除节点的位置
			Node successor = getMin(node.right);//待删除元素的后继节点
			successor.right = removeMin(node.right);//里面有size--所以不需要再调用size--
			successor.left = node.left;
			
			node.left = node.right = null;//与二分搜索树脱离关系
			return successor;
			
		}
		
	}
	
}
