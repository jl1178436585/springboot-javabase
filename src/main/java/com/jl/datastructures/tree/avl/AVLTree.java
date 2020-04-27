/*
 * @(#)AVLTree.java  
 */
package com.jl.datastructures.tree.avl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.sun.org.apache.bcel.internal.generic.BALOAD;

/**
 * <p>
 * 平衡二叉树的实现：对比二分搜索树
 * </p>
 * 
 * @author: jl
 * @date: 2018/07/23
 * @version: v1.0
 */
public class AVLTree<K extends Comparable<K>, V> {

	private class Node {
		private K key;
		private V value;
		private Node left, right;
		public int height;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			left = null;
			right = null;
			height = 1;// 叶子节点高度为1，默认新创建的节点时叶子结点
		}
	}

	private int size;

	private Node root;

	public AVLTree() {
		root = null;
		size = 0;
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 判断当前树是否是二分搜索树
	 * 中序遍历结果是顺序排列
	 * 
	 * @return
	 */
	public boolean isBST() {
		List<K> inOrder = inOrder();
		for (int i = 1; i < inOrder.size(); i++) {
			if(inOrder.get(i-1).compareTo(inOrder.get(i)) > 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 判断当前树是否是平衡二叉树： 对于任意一个节点，左子树和右子树的高度差不能超过1	
	 * 
	 * @return
	 */
	public boolean isBlanced() {
		return isBlanced(root);
	}
	
	private boolean isBlanced(Node node) {
		if(node == null) {
			return true;
		}
		
		int blanceFactor = getBlanceFactor(node);
		if(Math.abs(blanceFactor) > 1) {
			return false;
		}
		
		return isBlanced(node.left) && isBlanced(node.right);
	}

	/**
	 * 中序遍历二分搜索树：深度优先遍历
	 * <p>先访问节点的左子树，再访问当前节点，然后访问节点的右子树，对于每一个子节点也是这样</p>
	 * <p> 中序遍历的结果是元素的从小到大排序的结果 </p>
	 * <p> 非递归实现实际使用不多 </p>
	 */
	public List<K> inOrder() {
		List<K> keys = new ArrayList<K>();
		inOrder(getRoot(),keys);
		return keys;
	}
	
	/**
	 * 中序遍历以node为根节点的二分搜索树
	 * @param node
	 */
	private void inOrder(Node node,List<K> keys) {
		if(node == null) {
			return ;
		}
		
		inOrder(node.left,keys);
		keys.add(node.key);
		inOrder(node.right,keys);
	}
	
	/**
	 * 返回节点node的高度值
	 * 
	 * @param node
	 * @return
	 */
	public int getHeight(Node node) {
		if (node == null) {
			return 0;
		}

		return node.height;
	}

	/**
	 * 返回节点的平衡因子:
	 * 
	 * @param node
	 * @return
	 */
	public int getBlanceFactor(Node node) {
		if (node == null) {
			return 0;
		}

		return getHeight(node.left) - getHeight(node.right);
	}

    // 对节点y进行向右旋转操作，返回旋转后新的根节点x,T4一定是叶子节点，否则y就不会出现不平衡，T3高度不受影响
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)          z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2
	private Node rightRotate(Node y) {
		Node x = y.left;
		Node t3 = x.right;
		
		//向右旋转的过程
		x.right = y;
		y.left = t3;
		
		//更新节点的height,只有x和y需要更新
		y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
		x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
		
		return x;
		
	}
	
	
	 // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)         y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
	/**左旋转
	 * 
	 * @param y
	 * @return
	 */
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node T2 = x.left;

        // 向左旋转过程
        x.left = y;
        y.right = T2;

        // 更新height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }
	
	public void add(K key, V value) {
		root = addNode(root, key, value);
	}

	/**
	 * 向以Node为根节点的树种添加节点，递归算法，返回插入新节点后的二分搜索树的根
	 * 
	 * @param node
	 * @param key
	 * @param value
	 * @return
	 */
	private Node addNode(Node node, K key, V value) {
		if (node == null) {
			size++;
			return new Node(key, value);
		}
		if (key.compareTo(node.key) < 0) {
			node.left = addNode(node.left, key, value);
		} else if (key.compareTo(node.key) > 0) {
			node.right = addNode(node.right, key, value);
		} else {// 相等
			node.value = value;
		}

		// 更新父节点高度:1+左右子树中最大的高度
		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

		// 计算平衡因子
		int blanceFactor = getBlanceFactor(node);
		if (Math.abs(blanceFactor) > 1) {// 不再是平衡二叉树
//			System.out.println("不是平衡二叉树，需要进行平衡操作" + blanceFactor);
		}
		
		//平衡维护
		//LL,右旋转:插入的元素在不平衡节点的左侧的左侧
		if(blanceFactor > 1 && getBlanceFactor(node.left) >= 0) {
			return rightRotate(node);//返回到上一层
		} 
		
		//RR,左旋转:插入的元素在不平衡节点的右侧的右侧
		if(blanceFactor < -1 && getBlanceFactor(node.right) <= 0) {
			return leftRotate(node);//返回到上一层
		}
		
		//LR
		if(blanceFactor > 1 && getBlanceFactor(node.left) <= 0) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}
		
		//RL
		if(blanceFactor < -1 && getBlanceFactor(node.right) >= 0) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		return node;

	}

	public V remove(K key) {

        Node node = getNode(root, key);
        if(node != null){
            root = remove(root, key);
            return node.value;
        }
        return null;
	}
	
	private Node remove(Node node, K key) {
		if(node == null) {
			return null;
		}
		
		Node resultNode ;
		if(key.compareTo(node.key) < 0) {
			node.left = remove(node.left, key);
			resultNode = node;
		}else if(key.compareTo(node.key) > 0) {
			node.right = remove(node.right, key);
			resultNode = node;
		}else {
			if(node.left == null) {
				Node right = node.right;
				node.right = null;
				size--;
				resultNode =  right;
			}
			
			else if(node.right == null) {
				Node left = node.left;
				node.left = null;
				size--;
				resultNode = left;
			}
			
			//左右子树均不为空
			else {
				Node successor = minimum(node.right);
				successor.left = node.left;
				//removeMin()里面没有维护平衡的操作，因此此函数有可能破坏平衡,但是因为remove(Node,Key)维护了平衡，因此直接调用这个函数;
//				successor.right = removeMin(node.right);
				successor.right = remove(node.right, successor.key);
				
				node.left = node.right = null;
				resultNode = successor;
			}
			
		}
		
		if(resultNode == null) {//删除的是叶子结点，避免下面的空指针
			return null;
		}
		
		
		//更新高度
		resultNode.height = 1 + Math.max(getHeight(resultNode.left), getHeight(resultNode.right));
		
		//计算平衡因子
		int blanceFactor = getBlanceFactor(resultNode);
		
		//平衡维护
		//LL
		if(blanceFactor > 1 && getBlanceFactor(resultNode.left) >= 0) {
			return rightRotate(resultNode);
		}
		
		//RR
		if(blanceFactor < -1 && getBlanceFactor(resultNode.right) <= 0) {
			return leftRotate(resultNode);
		}
		
		//LR
		if(blanceFactor > 1 && getBlanceFactor(resultNode.left) <= 0) {
			resultNode.left = leftRotate(resultNode.left);
			return rightRotate(resultNode);
		}
		
		//RL
		if(blanceFactor < -1 && getBlanceFactor(resultNode.right) >= 0) {
			resultNode.right = rightRotate(resultNode.right);
			return leftRotate(resultNode);
		}
		
		return resultNode;
		
	}
	
	public boolean contains(K key) {
		return getNode(root, key) != null;
	}

	public V get(K key) {
		Node node = getNode(root, key);
		return node == null ? null : node.value;
	}
	
	 /**
	  * 返回以node为根节点的二分搜索树中，key所在的节点
	  * @param node
	  * @param key
	  * @return
	  */
    private Node getNode(Node node, K key){

        if(node == null)
            return null;

        if(key.equals(node.key))
            return node;
        else if(key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else // if(key.compareTo(node.key) > 0)
            return getNode(node.right, key);
    }
    
    /**
     * 更新Node的key对应的value
     * @param key
     * @param newValue
     */
    public void set(K key, V newValue){
        Node node = getNode(root, key);
        if(node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");

        node.value = newValue;
    }

    /**
     * 返回以node为根的二分搜索树的最小值所在的节点
     * 
     * @param node
     * @return
     */
    private Node minimum(Node node){
        if(node.left == null)
            return node;
        return minimum(node.left);
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

	private Node getRoot() {
		return root;
	}


	public static void main(String[] args) {

		System.out.println("Pride and Prejudice");

		ArrayList<String> words = new ArrayList<>();
		if (FileOperation.readFile("D:\\repst\\eclipse_repo\\javaBase\\src\\com\\jl\\datastructures\\tree\\pride-and-prejudice.txt", words)) {
			System.out.println("Total words: " + words.size());

			AVLTree<String, Integer> map = new AVLTree<>();
			for (String word : words) {
				if (map.contains(word))
					map.set(word, map.get(word) + 1);
				else
					map.add(word, 1);
			}

			System.out.println("Total different words: " + map.getSize());
			System.out.println("Frequency of PRIDE: " + map.get("pride"));
			System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
			
			boolean bst = map.isBST();
			System.out.println(bst);
		}

		System.out.println();
		
//		test();
	}
	
	@Test
	public static void test() {
		AVLTree<Integer,Integer> avl = new AVLTree<>();
		int[] arr = {50,25,60,15,30,12,19,27};
		for (int i = 0; i < arr.length; i++) {
			avl.add(arr[i], arr[i]);
		}
		
		List<Integer> inOrder = avl.inOrder();
		System.out.println(inOrder);
		
	}
	

	

}
