/**
*@author
*shsharma
*/
package org.shobhank.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class AdjacencyList {

    public static void main(String[] args) {
        MyGraph g = new MyGraph();
        Node n0 = new Node("0");
        Node n1 = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");
        n0.adjacenctNodes.add(n1);
        n0.adjacenctNodes.add(n2);
        n1.adjacenctNodes.add(n2);
//        n2.adjacenctNodes.add(n0);
        n2.adjacenctNodes.add(n3);
//        n3.adjacenctNodes.add(n3);
        g.nodes.add(n0);
        g.nodes.add(n1);
        g.nodes.add(n2);
        g.nodes.add(n3);
//        System.out.println(g.detectCycle(n2));
//        g.bfs(n2);
//        System.out.println();
        g.dfs(n0);
//        g.dfsStack(n2);
//        
//        
//        MyGraph dep = new MyGraph();
//        Node na = new Node("a");
//        Node nb = new Node("b");
//        Node nc = new Node("c");
//        Node nd = new Node("d");
//        Node ne = new Node("e");
//        Node nf = new Node("f");
//        Node ng = new Node("g");
//        Node nh = new Node("h");
//        na.adjacenctNodes.add(nc);
//        na.adjacenctNodes.add(nd);
//        nb.adjacenctNodes.add(nd);
//        nc.adjacenctNodes.add(ne);
//        ne.adjacenctNodes.add(nh);
//        nf.adjacenctNodes.add(ne);
//        nf.adjacenctNodes.add(ng);
//        ng.adjacenctNodes.add(nh);
//        dep.nodes.add(na);
//        dep.nodes.add(nb);
//        dep.nodes.add(nc);
//        dep.nodes.add(nd);
//        dep.nodes.add(ne);
//        dep.nodes.add(nf);
//        dep.nodes.add(ng);
//        dep.nodes.add(nh);
//        for(int i=0;i<dep.nodes.size();i++){
//            Node node = dep.nodes.get(i);
//            if(node.seen==false){
//                dep.dfs(node);
//                System.out.println();
//            }
//        }
        
//        MyGraph dep2 = new MyGraph();
//        Node j1 = new Node("Job1");
//        Node j2 = new Node("Job2");
//        Node j3 = new Node("Job3");
//        Node j4 = new Node("Job4");
//        Node j5 = new Node("Job5");
//        j3.adjacenctNodes.add(j1);
//        j3.adjacenctNodes.add(j2);
//        j4.adjacenctNodes.add(j2);
//        j5.adjacenctNodes.add(j1);
//        j5.adjacenctNodes.add(j4);
//        dep2.nodes.add(j1);
//        dep2.nodes.add(j2);
//        dep2.nodes.add(j3);
//        dep2.nodes.add(j4);
//        dep2.nodes.add(j5);
//        dep2.bfs(j5);
//        System.out.println();
//        dep2.dfs(j5);
//        for(int i=0;i<dep2.nodes.size();i++){
//            Node node = dep2.nodes.get(i);
//            System.out.println(node.data + " " + dep2.dfsStack(node));
//            dep2.setToUninstalled();
            //System.out.println();
//    }
    }
}

class MyGraph{
    static List<Node> nodes = new LinkedList<Node>();
    
    void bfs(Node s){
        Queue<Node> q = new LinkedList<Node>();
        
        s.seen = true;
        q.add(s);
        
        while(!q.isEmpty()){
            s = q.poll();
            System.out.print(s.data + "\t");
            
            for(int i=0;i<s.adjacenctNodes.size();i++){
                Node adj = s.adjacenctNodes.get(i);
                if(adj.seen == false){
                    adj.seen = true;
                    q.add(adj);
                }
            }
        }
        resetSeen();
    }
    
    void dfs(Node node){
        Stack<Node> s = new Stack<Node>();
        node.seen = true;
        s.push(node);
        System.out.print(node.data + "\t");
        while(!s.empty()){
            Node v = s.peek();
            Node w = getUnvisitedNode(v);
            if(w!=null){
                w.seen = true;
                System.out.print(w.data+"\t");
                s.push(w);
            }else{
               s.pop();
            }
        }
        resetSeen();
    }
    
    boolean detectCycle(Node node){
        Stack<Node> s = new Stack<Node>();
        node.seen = true;
        s.push(node);
    //    System.out.print(node.data + "\t");
        while(!s.empty()){
            Node v = s.peek();
            Node w = null;
            for(int i=0;i<v.adjacenctNodes.size();i++){
                w = v.adjacenctNodes.get(i);
                if(w.seen)
                    return true;
            }
            if(w!=null){
                w.seen = true;
       //         System.out.print(w.data+"\t");
                s.push(w);
            }else{
               s.pop();
            }
        }
        resetSeen();
        return false;
    }
    
    private Node getUnvisitedNode(Node v) {
        for(int i=0;i<v.adjacenctNodes.size();i++){
            Node w = v.adjacenctNodes.get(i);
            if(w.seen==false)
                return w;
        }
        return null;
    }
   
    private static void resetSeen(){
        for(int i=0;i<nodes.size();i++){
            nodes.get(i).seen = false;
        }
    }
    
    int path(Node s, String[] path, int pathlen, int maxlen){
        path[pathlen] = s.data;
        pathlen++;
        if(s.adjacenctNodes.size() == 0){
            if(pathlen > maxlen)
                return pathlen;
        }
        for(int i=0;i<s.adjacenctNodes.size();i++){
            path(s.adjacenctNodes.get(i),path,pathlen,maxlen);
        }
        return maxlen;
    }
    
    int height(Node s){
        if(s.adjacenctNodes.size()==0)
            return 0;
        else{
            int height[] = new int[s.adjacenctNodes.size()];
            for(int i=0;i<s.adjacenctNodes.size();i++){
                height[i] = height(s.adjacenctNodes.get(i));
            }
            return max(height);
        }
    }
        
    int max(int arr[]){
        int max = arr[0];
        for(int i=1;i<arr.length;i++){
            if (arr[i]>max)
                max = arr[i];
        }
        return max;
    }
}

class Node {
    public String data;
    List<Node> adjacenctNodes = new LinkedList<Node>();
    boolean seen = false;
    boolean cycRec = false;
    
    Node(String data){
        this.data = data;
    }
}


