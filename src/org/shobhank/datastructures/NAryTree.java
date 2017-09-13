/**
*@author
*shsharma
*/
package org.shobhank.datastructures;

import java.util.ArrayList;

public class NAryTree {

    static NodeNary root = null;
    
    public static void main(String[] args) {
        int pre[] = {1,2,3,4,5,6,7,8,9};
        int post[] = {3,4,2,6,5,9,8,7,1};
        root = buildTree(pre,post);
    }
    
    
    public static NodeNary buildTree(int[] preOrder, int[] postOrder){
        if(preOrder == null || postOrder == null){
            throw new NullPointerException();
        }
        if(preOrder.length != postOrder.length){
            throw new IllegalArgumentException();
        }
        return buildTree(preOrder, 0, preOrder.length-1, postOrder, 0, postOrder.length -1);
    }

    private static NodeNary buildTree(int[] preOrder, int preMin, int preMax, int[] postOrder, int postMin, int postMax){
        //construct the root;
        NodeNary root = new NodeNary();
        root.data = preOrder[preMin];
        
        //construct the child branches
        int preIndex = preMin + 1;
        int postIndex = postMin;
        while(preIndex <= preMax &&  postIndex <= postMax -1){
            //preOrder[preIndex] is now the root of the next child branch
            //find where preOrder[preIndex] occurs in postOrder
            int shift = 0;
            while(postOrder[postIndex + shift] != preOrder[preIndex]){
                shift++;
            }
            NodeNary child = buildTree(preOrder, preIndex, preIndex + shift, postOrder, postMin, postMin + shift);
            root.children.add(child);
            shift++;
            preIndex += shift;
            postIndex += shift;
        }
        return root;
    }

}

class NodeNary{
    int data;
    ArrayList<NodeNary> children = new ArrayList<NodeNary>();
}




