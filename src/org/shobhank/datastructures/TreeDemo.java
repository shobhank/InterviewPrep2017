package org.shobhank.datastructures;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by shobhanksharma on 3/12/17.
 */
/*
                30
         10                 50
       5      20        40
           15      25  35  45

 */// 20,40,50
public class TreeDemo {
    public static void main(String as[]){
//        Tree t1 = new Tree();
//        t1.insert(30);
//        t1.insert(10);
//        t1.insert(50);
//        t1.insert(20);
//        t1.insert(25);
//        t1.insert(15);
//        t1.insert(40);
//        t1.insert(45);
//        t1.insert(35);
//        t1.insert(5);
//        t1.levelOrder(t1.root);
//        System.out.println(t1.nextRightNode(t1.root, 25));
//        Tree t2 = new Tree();
//        t2.insert(30);
//        t2.insert(10);
//        t2.insert(50);
//        t2.insert(5);
//        t2.insert(15);
//        t2.insert(40);
//        t2.insert(45);
//        t2.insert(55);
//        t2.insert(60);
//        t2.boundaryTraversal(t2.root);
        Tree t3 = new Tree();
        t3.constructCompleteBinaryTree(new int[]{10,12,15,25,30,36});
        t3.levelOrder(t3.root);
        System.out.println();
        System.out.println();
        t3.printVerticalOrder(t3.root);
//        Node t4 = t3.convertToDLL(t3.root);
//        Node trav = t4;
//        while (trav!=null){
//            System.out.println(trav.info);
//            trav = trav.next;
//        }
//        t3.levelOrder(t3.root);
//        System.out.println(t2.largestIndependentSet(t2.root));
//        t2.inOrderNonRecRev(t2.root);
//        Tree.inOrderNonRecNonStack(t2.root);
//        t2.printVerticalOrder(t2.root);
//        t1.kDistantNodeFromRoot(t1.root, 2);
//        t1.levelOrder(t1.root);
//        System.out.println("----");
//        Tree.leftSideView(t1.root, 1, new Tree.MaxLevel());
//        Tree.printWithKLeaves(t1.root,2);
//        Tree.rightSideView(t1.root, 1,new Tree.MaxLevel());
//        t1.serializeTree(t1.root);
//        Tree t2 = new Tree();
//        t1.levelOrder(t1.root);
//        System.out.println("-------");
//        t1.levelOrderReverse(t1.root);
//        t2.root = t2.deserializeTree(0);
//        System.out.println();
//        t2.levelOrder(t2.root);
//        t1.levelOrder(t1.root);
//        t1.delete(t1.root, t1.root.left);
//        System.out.println();
//        t1.levelOrder(t1.root);
//        System.out.println(t1.isCompleteTree(t1.root));
//        t1.insert(5);
//        t1.insert(2);
//        t1.insert(7);
//        t1.insert(55);
//        System.out.println(t1.isCompleteTree(t1.root));
//        int pre[] = {10,5,2,7,6,15,12,11,13,17,19,18,25};
//        Tree t2 = new Tree();
//        t2.root = Tree.buildPreOrderTree(pre,0,pre.length-1);
//        t2.levelOrder(t2.root);
//        t1.printRange(t1.root, 30, 45);
//        System.out.println(t1.lca(t1.root,15,40 ).info);
//        System.out.println(t1.successor(t1.root, t1.root.right.left.left).info);
//        t1.inOrder(t1.root);
//        System.out.println();
//        System.out.println(t1.minValue(t1.root).info);
//        System.out.println(t1.countNode(t1.root));
//        System.out.println(t1.height(t1.root));
//        t1.levelOrder(t1.root);
//        System.out.println("------");
//        t1.mirror(t1.root);
//        t1.levelOrder(t1.root);
//        t1.printAllPaths(t1.root, new int[100], 0);
//        t1.bfs(t1.root);
//        System.out.println(t1.countLeaves(t1.root));
//        t1.printSpiralLevelOrder(t1.root);
//        System.out.println(t1.isHeightBalanced(t1.root));
//        t1.insert(5);
//        t1.insert(55);
//        System.out.println(t1.isHeightBalanced(t1.root));
//        t1.inOrderNonRec(t1.root);
//        t1.postOrderNonRec(t1.root);
//        System.out.println(t1.hasPathSum(t1.root,45));
//        int in[] = {5,7,10,12,15,17};
//        int pre[] = {10,5,7,15,12,17};
//        Tree t = Tree.buildTree(pre, in);
//        t.levelOrder(t.root);
//        System.out.println(t1.maxWidth(t1.root));
//        t1.levelOfNode(t1.root, 1, 20);
//        t1.printAncestors(t1.root,37);
//        t1.connectLevelNodes(t1.root);
//        System.out.println(t1.root.left.right.left.next.next.info);
//        Tree t5 = new Tree();
//        t5.insert(20);
//        t5.insert(22);
//        t5.insert(8);
//        t5.insert(12);
//        t5.insert(4);
//        t5.insert(10);
//        t5.insert(14);
//        t5.printKDistantNodesFromANode(t5.root, 8, 2, 0);
//        Tree t = new Tree();
//        t.insert(4);
//        t.insert(2);
//        t.insert(20);
//        t.insert(25);
//        t.insert(23);
//        t.insert(15);
//        t.insert(14);
//        t.insert(10);
//        t.insert(8);
//        t.insert(9);
//        t.insert(12);
//        t.insert(11);
//        t.insert(16);
//        t.insert(18);
//        t.insert(17);
//        t.levelOrder(t.root);
//        System.out.println(t.diameter(t.root));
    }
}

class Tree{
    Node root;

    static List<Integer> serialize = new ArrayList<>();

    public void insert(int value){
        Node n = new Node(value);
        if(root == null){
            root = n;
            return;
        }
        Node trav = root;
        while(trav!=null){
            if(value <= trav.info){
                if(trav.left == null){
                    trav.left = n;
                    return;
                }else
                    trav = trav.left;
            }else {
                if(trav.right == null){
                    trav.right = n;
                    return;
                }else
                    trav = trav.right;
            }
        }
    }

    public void inOrder(Node n){
        if(n!=null){
            inOrder(n.left);
            System.out.print(n.info + "\t");
            inOrder(n.right);
        }
    }

    public void preOrder(Node n){
        if(n!=null){
            System.out.print(n.info + "\t");
            preOrder(n.left);
            preOrder(n.right);
        }
    }

    public void postOrder(Node n){
        if(n!=null){
            postOrder(n.left);
            postOrder(n.right);
            System.out.print(n.info + "\t");
        }
    }

    static class MinMaxHD {
        int min;
        int max;
    }

    public void printVerticalOrder(Node root){
        MinMaxHD minMaxHD = new MinMaxHD();
        findMinMaxHD(root, 0, minMaxHD);
        for(int i=minMaxHD.min;i<=minMaxHD.max;i++){
            printLine(root, i, 0);
            System.out.println();
        }
    }

    public void printLine(Node root, int line, int currLine){
        if(root==null)
            return;
        if(line == currLine)
            System.out.print(root.info + " ");
        printLine(root.left, line, currLine-1);
        printLine(root.right, line, currLine+1);
    }

    public void findMinMaxHD(Node root, int hd, MinMaxHD minMaxHD){
        if(root==null)
            return;
        if(hd<minMaxHD.min)
            minMaxHD.min = hd;
        if(hd>minMaxHD.max)
            minMaxHD.max = hd;
        findMinMaxHD(root.left, hd-1, minMaxHD);
        findMinMaxHD(root.right, hd+1, minMaxHD);
    }


    public void constructCompleteBinaryTree(int in[]){
        Queue<Node> q = new LinkedList<>();
        root = new Node(in[0]);
        Node curr = root;
        q.add(curr);
        int i=1;
        while (i<in.length){
            curr = q.poll();

            if(i <in.length ) {
                Node left = new Node(in[i]);
                curr.left = left;
                q.add(left);
                i++;
            }else
                break;

            if(i <in.length ) {
                Node right = new Node(in[i]);
                curr.right = right;
                q.add(right);
                i++;
            }else
                break;
        }
    }

    public static int nextRightNode(Node root, int key){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()){
            Node curr = q.poll();
            if(curr==null){
                if(q.isEmpty()) {
                    break;
                }else{
                    q.add(null);
                }
            }else{
                if(curr.info == key){
                    Node nextRight = q.poll();
                    return nextRight==null?-1:nextRight.info;
                }
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
        }
        return -1;
    }


    /*
    Wrong
     */
    public void printKDistantNodesFromANode(Node root, int target, int k, int currentK){
        if(root==null)
            return;
        if(Math.abs(currentK) == k){
            System.out.println(root.info);
            return;
        }
        if(root.info == target){
            printKDistantNodesFromANode(root.left, target, k, -1);
            printKDistantNodesFromANode(root.right, target, k, -1);
        }else{
            printKDistantNodesFromANode(root.left, target, k, currentK<0?currentK-1:currentK+1);
            printKDistantNodesFromANode(root.right, target, k, currentK<0?currentK-1:currentK+1);
        }
    }

    public void kDistantNodeFromRoot(Node root, int k){
        if(root==null)
            return;
        if(k==0)
            System.out.println(root.info);
        kDistantNodeFromRoot(root.left, k-1);
        kDistantNodeFromRoot(root.right, k-1);
    }

    public static int printWithKLeaves(Node root, int k){
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;
        int leftKeys = printWithKLeaves(root.left, k);
        int rightKeys = printWithKLeaves(root.right, k);
        if((leftKeys+rightKeys) == k)
            System.out.println(root.info);
        return leftKeys+rightKeys;
    }

    static class MaxLevel{
        int level;
    }
    public static void rightSideView(Node root, int level, MaxLevel maxLevel){
        if(root==null) return;
        if(level>maxLevel.level){
            System.out.println(root.info);
            maxLevel.level = level;
        }
        rightSideView(root.right, level+1, maxLevel);
        rightSideView(root.left, level+1, maxLevel);
    }

    public static void leftSideView(Node root, int level, MaxLevel maxLevel){
        if(root==null) return;
        if(level>maxLevel.level){
            System.out.println(root.info);
            maxLevel.level = level;
        }
        leftSideView(root.left, level+1, maxLevel);
        leftSideView(root.right, level+1, maxLevel);
    }

    public int minPath(Node root, int pathLen){
        if(root==null)
            return -1;
        pathLen++;
        if(root.left == null && root.right == null)
            return pathLen;
        int left = minPath(root.left, pathLen);
        int right = minPath(root.right, pathLen);
        if(left==-1)
            return right;
        if(right==-1)
            return left;
        return Math.min(left, right);
    }

    public static void serializeTree(Node root){
        if(root!=null){
            serialize.add(root.info);
            serializeTree(root.left);
            serializeTree(root.right);
        }else{
            serialize.add(-1);
        }
    }

    public static Node deserializeTree(int i){
        if(i>=serialize.size() || serialize.get(i)==-1){
            i++;
            return null;
        }
        Node root = new Node(serialize.get(i));
        i++;
        root.left = deserializeTree(i);
        root.right = deserializeTree(i);
        return root;
    }

    public Node minValue(Node n){
        if(n==null)
            return null;
        if(n.left!=null){
            return minValue(n.left);
        }else{
            return n;
        }
    }

    public int countNode(Node n){
        if(n==null)
            return 0;
        return countNode(n.left) + 1 + countNode(n.right);
    }

    public boolean isSame(Node n1, Node n2){
        if(n1==null && n2==null)
            return true;
        if(n1!=null && n2!=null){
            return n1.info==n2.info && isSame(n1.left, n2.left) && isSame(n1.right, n2.right);
        }
        return false;
    }

    public int height(Node root){
        if(root==null)
            return 0;
        int lHeight = height(root.left);
        int rHeight = height(root.right);
        return lHeight>rHeight?lHeight+1:rHeight+1;
    }

    public void levelOrder(Node root){
        if(root==null)return;
        int height = height(root);
        for(int i=1;i<=height;i++){
            printLevel(root, i);
            System.out.println();
        }
    }

    public void printLevel(Node root, int level){
        if(root==null)
            return;
        if(level==1)
            System.out.print(root.info + "\t");
        printLevel(root.left, level-1);
        printLevel(root.right, level-1);
    }

    public void levelOrderReverse(Node root){
        if(root==null)return;
        int height = height(root);
        for(int i=height;i>=1;i--){
            printLevel(root, i);
            System.out.println();
        }
    }

    public void mirror(Node root){
        if(root==null)
            return;
        if(root.left==null && root.right==null)
            return;
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirror(root.left);
        mirror(root.right);
    }

    public boolean isSymmetric(Node root) {
        if(root==null)
            return true;
        return isSymmetricUtil(root.left, root.right);
    }

    public boolean isSymmetricUtil(Node a, Node b){
        if(a == null && b == null)
            return true;
        else if(a!=null && b!=null)
            return (a.info == b.info) && isSymmetricUtil(a.left,b.right) && isSymmetricUtil(a.right,b.left);
        else
            return false;
    }

    public void printAllPaths(Node root, int path[], int pathLen){
        if(root==null)
            return;
        path[pathLen++] = root.info;
        if(root.left==null && root.right==null)
            printPath(path, pathLen);
        printAllPaths(root.left, path, pathLen);
        printAllPaths(root.right, path, pathLen);
    }

    public void printPath(int path[], int pathLen){
        for(int i=0;i<pathLen;i++){
            System.out.print(path[i] + "\t");
        }
        System.out.println();
    }

    public void bfs(Node root){
        Queue<Node> q = new LinkedList<Node>();
        Node node = root;
        q.add(node);
        q.add(null);
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr == null){
                if(q.isEmpty())
                    break;
                System.out.println();
                q.add(null);
                continue;
            }
            System.out.print(curr.info + "\t");
            if(curr.left!=null){
                q.add(curr.left);
            }else{
                if(q.isEmpty())
                    break;
            }

            if(curr.right!=null){
                q.add(curr.right);
            }else{
                if(q.isEmpty())
                    break;
            }
        }
    }

    public int countLeaves(Node root){
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;
        return countLeaves(root.left) + countLeaves(root.right);
    }

    public void printSpiralLevelOrder(Node root){
        if(root==null)
            return;
        int height = height(root);
        boolean flag = true;
        for(int i=1;i<=height;i++){
            printSpiralLevel(root, i, flag);
            System.out.println();
            flag = flag ^ true;
        }
    }

    public void printSpiralLevel(Node root, int level, boolean flag){
        if(root==null)
            return;
        if(level == 1)
            System.out.print(root.info + "\t");
        if(flag){
            printSpiralLevel(root.left, level-1,flag);
            printSpiralLevel(root.right, level-1, flag);
        }else{
            printSpiralLevel(root.right, level-1, flag);
            printSpiralLevel(root.left, level-1, flag);
        }
    }

    public boolean childrenSum(Node root){
        if(root==null)
            return true;
        if(root.left==null && root.right==null)
            return true;
        else if(root.left==null && root.right!=null)
            return root.info==root.right.info && childrenSum(root.right);
        else if(root.right==null && root.left!=null)
            return root.info==root.left.info && childrenSum(root.left);
        else
            return root.info==(root.left.info + root.right.info) && childrenSum(root.left) && childrenSum(root.right);
    }

    public int diameter(Node root){
        if(root==null)
            return 0;
        int lHeight = height(root.left);
        int rHeight = height(root.right);
        int lDia = diameter(root.left);
        int rDia = diameter(root.right);
        return Math.max(Math.max(lDia, rDia),lHeight+rHeight+1);
    }

    public boolean isHeightBalanced(Node root){
        if(root==null || (root.left==null && root.right==null))
            return true;
        int lHeight = height(root.left);
        int rHeight = height(root.right);
        return Math.abs(lHeight-rHeight)<=1 && isHeightBalanced(root.left) && isHeightBalanced(root.right);
    }

    public void inOrderNonRec(Node root){
        Stack<Node> s = new Stack<>();
        Node node = root;
        while(!s.isEmpty() || node!=null){
            while(node!=null){
                s.push(node);
                node = node.left;
            }
            node = s.pop();
            System.out.print(node.info + "\t");
            node = node.right;
        }
    }

    public void inOrderNonRecRev(Node root){
        Stack<Node> s = new Stack<>();
        Node node = root;
        while(!s.isEmpty() || node!=null){
            while(node!=null){
                s.push(node);
                node = node.right;
            }
            node = s.pop();
            System.out.print(node.info + "\t");
            node = node.left;
        }
    }

    public void preOrderNonRec(Node root){
        Stack<Node> s = new Stack<>();
        Node node = root;
        s.push(node);
        while(!s.isEmpty()){
            node = s.pop();
            System.out.print(node.info + "\t");
            if(node.right!=null)
                s.push(node.right);
            if(node.left!=null)
                s.push(node.left);
        }
    }

    public void postOrderNonRec(Node root){
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root);
        Node node = root;
        while(!s1.isEmpty()){
            node = s1.pop();
            s2.push(node);
            if(node.left!=null)
                s1.push(node.left);
            if(node.right!=null)
                s1.push(node.right);
        }
        while(!s2.isEmpty()){
            System.out.print(s2.pop().info + "\t");
        }
    }

    public boolean hasPathSum(Node root, int sum){
        if(root==null)
            return sum==0;
        if(root.left==null && root.right==null)
            return sum-root.info == 0;
        return hasPathSum(root.left, sum-root.info) || hasPathSum(root.right, sum-root.info);
    }

    public static Tree buildTree(int pre[], int in[]){
        Tree t = new Tree();
        t.root = buildTreeUtil(pre,in,0,0,in.length-1);
        return t;
    }

    private static Node buildTreeUtil(int pre[], int in[], int preIx, int inStrt, int inEnd){
        if(inStrt > inEnd)
            return null;

        Node tNode = new Node(pre[preIx]);

        if(inStrt == inEnd)
            return tNode;

        int inIndex = findInInOrder(in,tNode.info,inStrt, inEnd);

        tNode.left = buildTreeUtil(pre,in,preIx+1, inStrt,inIndex-1);
        tNode.right = buildTreeUtil(pre,in,preIx+(inIndex-inStrt)+1, inIndex+1,inEnd);

        return tNode;
    }

    private static int findInInOrder(int in[], int value, int s, int e){
        for(int i=s;i<=e;i++){
            if(in[i] == value)
                return i;
        }
        return -1;
    }

    public void doubleTree(Node n){
        if(n==null)
            return;
        doubleTree(n.left);
        doubleTree(n.right);
        Node temp = new Node(n.info);
        temp.left = n.left;
        n.left = temp;
    }

    public int maxWidth(Node root){
        int maxNodes = Integer.MIN_VALUE;
        for(int i=1;i<=height(root);i++){
            int nodes = nodesAtLevel(root, i);
            if(nodes>maxNodes)
                maxNodes = nodes;
        }
        return maxNodes;
    }

    public int nodesAtLevel(Node root, int level){
        if(root==null)
            return 0;
        if(level==1)
            return 1;
        return nodesAtLevel(root.left, level-1) + nodesAtLevel(root.right, level-1);
    }

    public boolean isStructuralMirror(Node n1, Node n2){
        if(n1==null && n2==null)
            return true;
        else if(n1!=null && n2!=null)
            return isStructuralMirror(n1.left,n2.right) && isStructuralMirror(n1.right, n2.left);
        else
            return false;
    }

    public void levelOfNode(Node root, int level, int key){
        if(root==null)
            return;
        if(root.info == key) {
            System.out.print(level);
        }
        levelOfNode(root.left, level+1, key);
        levelOfNode(root.right, level+1, key);
    }

    public boolean printAncestors(Node root, int key){
        if(root==null)
            return false;
        if(root.info == key)
            return true;
        if(printAncestors(root.left, key) || printAncestors(root.right,key)){
            System.out.print(root.info + "\t");
            return true;
        }else
            return false;
    }

    public boolean isSumTree(Node root){
        if(root==null || (root.left==null && root.right==null))
            return true;
        if(root.info==(getSumSubTree(root.left) + getSumSubTree(root.right)))
            return isSumTree(root.left) && isSumTree(root.right);
        else
            return false;
    }

    public int makeSumTree(Node root){
        if(root == null)
            return 0;
        int left = makeSumTree(root.left);
        int right = makeSumTree(root.right);
        int temp = root.info;
        root.info = left+right;
        return temp;
    }

    public int getSumSubTree(Node root){
        if(root==null)
            return 0;
        return getSumSubTree(root.left) + root.info + getSumSubTree(root.right);
    }

    public boolean isSubtree(Node tree, Node subTree){
        if(subTree==null && tree!=null)
            return true;
        if(tree==null)
            return false;
        if(isSame(tree, subTree))
            return true;
        return isSubtree(tree.left, subTree) || isSubtree(tree.right, subTree);
    }

    public void connectLevelNodes(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node node;
        Node lastNode = null;
        while(!q.isEmpty()){
            node = q.poll();
            if(node!=null){
                if(lastNode!=null)
                    lastNode.next = node;
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
                lastNode = node;
            }else{
                if(q.isEmpty())
                    break;
                else
                    q.add(null);
                lastNode = null;
            }
        }
    }

    public void connectInOrderSuccessor(Node n,Node nextNode){
        if(n!=null){
            connectInOrderSuccessor(n.right,nextNode);
            n.next = nextNode;
            nextNode = n;
            connectInOrderSuccessor(n.left,nextNode);
        }
    }

    public static Node buildPreOrderTree(int pre[], int s, int e){
        if(s<=e){
            Node n = new Node(pre[s]);
            if(s==e)
                return n;
            int smallerIx = findSmallerIndex(pre,s,e,n.info);
            int greaterIx = findGreaterIndex(pre,s,e,n.info);
            if(smallerIx!=-1)
                n.left = buildPreOrderTree(pre,smallerIx,greaterIx==-1?e:greaterIx-1);
            if(greaterIx!=-1)
                n.right = buildPreOrderTree(pre,greaterIx,e);
            return n;
        }
        return null;
    }

    public static int findSmallerIndex(int a[], int s, int e, int key){
        for(int i=s;i<=e;i++){
            if(a[i]<key)
                return i;
        }
        return -1;
    }

    public static int findGreaterIndex(int a[], int s, int e, int key){
        for(int i=s;i<=e;i++){
            if(a[i]>key)
                return i;
        }
        return -1;
    }

    public void joinAdjacent(Node n){
        if(n==null)
            return;
        if(n.left!=null)
            n.left.next = n.right;
        if(n.right!=null && n.next!=null){
            if(n.next.left!=null)
                n.right.next = n.next.left;
            else if(n.next.right!=null)
                n.right.next = n.next.right;
        }
        joinAdjacent(n.left);
        joinAdjacent(n.right);
    }

    public static Node arrayToBST(int a[],int p,int q){
        if(p<=q){
            int m = (p+q)/2;
            Node n = new Node(a[m]);
            n.left = arrayToBST(a,p,m-1);
            n.right = arrayToBST(a,m+1,q);
            return n;
        }else{
            return null;
        }
    }

    public boolean isCompleteTree(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean hasHalfNode = false;
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.left!=null){
                if(hasHalfNode)
                    return false;
                q.add(curr.left);
            }else{
                hasHalfNode = true;
            }
            if(curr.right!=null){
                if(hasHalfNode)
                    return false;
                q.add(curr.right);
            }else{
                hasHalfNode = true;
            }
        }
        return true;
    }

    public Node successor(Node root, Node key){
        if(key.right!=null){
            return minValue(key.right);
        }
        Node trav = root;
        Node succ = trav;
        while(trav!=null){
            if(trav.info > key.info){
                succ = trav;
                trav = trav.left;
            }else{
                trav = trav.right;
            }
        }
        return succ;
    }

    public Node lca(Node root, int n1, int n2){
        if(root == null)
            return null;
        if(root.info==n1 || root.info==n2)
            return root;
        Node leftLCA = lca(root.left, n1, n2);
        Node rightLCA = lca(root.right, n1, n2);
        if(leftLCA!=null && rightLCA!=null)
            return root;
        return leftLCA!=null?leftLCA:rightLCA;
    }

    public void printRange(Node root, int a, int b){
        if(root==null)
            return;
        if(root.info >=a && root.info <=b) {
            System.out.print(root.info + "\t");
            printRange(root.left, a,b);
            printRange(root.right, a,b);
        }
        else if(root.info < a){
            printRange(root.right, a, b);
        }
        else if(root.info > b){
            printRange(root.left, a,b);
        }
    }

    public boolean isBST(Node root, int min, int max){
        if(root==null)
            return true;
        if(min!=-1 && root.info<min)
            return false;
        if(max!=-1 && root.info>max)
            return false;
        return isBST(root.left,min,root.info) && isBST(root.right,root.info,max);
    }

    public Node delete(Node root, Node key){
        if(root==null)
            return null;
        if(key.info < root.info)
            root.left = delete(root.left, key);
        else if(key.info > root.info)
            root.right = delete(root.right, key);
        else{
            if(root.right == null)  return root.left;
            if(root.left == null)   return root.right;
            Node minNode = minValue(root.right);
            root.info = minNode.info;
            root.right = delete(root.right, minNode);
        }
        return root;
    }

    /**
     * Check again??????
     * @param root
     * @return
     */
    public MinMax maxBST(Node root){
        if(root == null) {
            MinMax p = new MinMax();
            p.isBST = true;
            return p;
        }
        MinMax left = maxBST(root.left);
        MinMax right = maxBST(root.right);
        MinMax m = new MinMax();
        if(!left.isBST || !right.isBST || root.info < left.max || root.info > right.min){
            m.isBST = false;
            m.size = Math.max(left.size, right.size);
            return m;
        }else{
            m.size = left.size + right.size + 1;
            m.isBST = true;
            m.min = root.left==null?root.info:left.min;
            m.max = root.right==null?root.info:right.max;
            return m;
        }
    }

    boolean isCompleteUtil(Node root, int index, int number_nodes)
    {
        // An empty tree is complete
        if(root == null)
            return true;

        // If index assigned to current node is more than
        // number of nodes in tree, then tree is not complete
        if(index >= number_nodes)
            return false;

        // Recur for left and right subtrees
        return isCompleteUtil(root.left, 2*index+1, number_nodes) &&
                isCompleteUtil(root.right, 2*index+2, number_nodes);

    }

    /**
     * Called Morris traversal
     * @param root
     */
    public static void inOrderNonRecNonStack(Node root){
        Node curr = root;
        while(curr!=null){
            if(curr.left==null){
                // print and move to right
                System.out.println(curr.info);
                curr = curr.right;
            }else{
                // find predecessor
                Node pred = curr.left;
                while (pred.right!=null && pred.right!=curr)
                    pred = pred.right;

                // and point it to current node
                // to remember the current node
                if(pred.right==null){
                    pred.right = curr;
                    curr = curr.left;
                }else{
                    // remove the link we created
                    pred.right = null;
                    System.out.println(curr.info);
                    curr = curr.right;
                }
            }

        }
    }

    public static int  largestIndependentSet(Node root){
        if(root==null)
            return 0;
        int sizeExcludingRoot = largestIndependentSet(root.left) + largestIndependentSet(root.right);
        int sizeIncludingRoot = 1;
        if(root.left!=null)
            sizeIncludingRoot += (largestIndependentSet(root.left.left) + largestIndependentSet(root.left.right));
        if(root.right!=null)
            sizeIncludingRoot += (largestIndependentSet(root.right.left) + largestIndependentSet(root.right.right));
        return Math.max(sizeIncludingRoot, sizeExcludingRoot);
    }

    public static void printLeaves(Node root){
        if(root==null)
            return;
        if(root.left==null && root.right==null)
            System.out.print(root.info + "\t");
        printLeaves(root.left);
        printLeaves(root.right);
    }

    public static void printLeftBoundary(Node root){
        if(root==null || (root.left==null && root.right==null))
            return;
        System.out.print(root.info + "\t");
        printLeftBoundary(root.left);
    }

    public static void printRightBoundary(Node root){
        if(root==null || (root.left==null && root.right==null))
            return;
        printRightBoundary(root.right);
        System.out.print(root.info + "\t");
    }

    public static void boundaryTraversal(Node root){
        if(root==null)
            return;
        System.out.print(root.info + "\t");
        printLeftBoundary(root.left);
        printLeaves(root.left);
        printLeaves(root.right);
        printRightBoundary(root.right);
        // traverse right
    }

    public static Node convertToDLL(Node root){
        Node head = null;
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        Node last = null;
        while(curr!=null || !stack.isEmpty()){
            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(last==null){
                head = curr;
            }else{
                curr.prev = last;
                last.next = curr;
            }
            last = curr;
            curr = curr.right;
        }
        return head;
    }
}

class MinMax {
    boolean isBST;
    int min;
    int max;
    int size;
}

class Node{
    int info;
    Node left;
    Node right;
    Node next;
    Node prev;

    public Node(int info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Node{" +
                "info=" + info +
                '}';
    }
}
