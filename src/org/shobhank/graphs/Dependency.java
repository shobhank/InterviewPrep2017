package org.shobhank.graphs; /**
 *@author
 *shsharma
 */

import java.util.*;

public class Dependency {

    public static void main(String[] args) {
//        NodeDep j1 = new NodeDep("Job1");
//        NodeDep j2 = new NodeDep("Job2");
//        NodeDep j3 = new NodeDep("Job3");
//        NodeDep j4 = new NodeDep("Job4");
//        NodeDep j5 = new NodeDep("Job5");
//        j3.adjacenctNodes.add(j1);
//        j3.adjacenctNodes.add(j2);
//        j4.adjacenctNodes.add(j2);
//        j5.adjacenctNodes.add(j4);
//        j5.adjacenctNodes.add(j1);
//        GraphDep g = new GraphDep();
//        g.nodes.add(j5);
//        g.nodes.add(j4);
//        g.nodes.add(j3);
//        g.nodes.add(j2);
//        g.nodes.add(j1);
//        g.displayDependency();
        DependencyJob dependencyJob = new DependencyJob();

        NodeDep aNode = new NodeDep("A");
        NodeDep bNode = new NodeDep("B");
        NodeDep cNode = new NodeDep("C");
        NodeDep dNode = new NodeDep("D");
        NodeDep eNode = new NodeDep("E");
        NodeDep fNode = new NodeDep("F");
        NodeDep gNode = new NodeDep("G");
        NodeDep hNode = new NodeDep("H");
        NodeDep iNode = new NodeDep("I");

        dependencyJob.nodes.add(aNode);
        aNode.adjacenctNodes.add(bNode);
        bNode.adjacenctNodes.add(dNode);
        bNode.adjacenctNodes.add(cNode);


        dependencyJob.nodes.add(hNode);
        hNode.adjacenctNodes.add(bNode);
        hNode.adjacenctNodes.add(eNode);
        eNode.adjacenctNodes.add(iNode);
        iNode.adjacenctNodes.add(cNode);

        dependencyJob.nodes.add(fNode);
        fNode.adjacenctNodes.add(gNode);

//        dNode.adjacenctNodes.add(aNode);

//        System.out.println(dependencyJob.jobOrder());
        System.out.println(dependencyJob.detectCyclicDependency(aNode));
    }

}

class DependencyJob{
    List<NodeDep> nodes = new ArrayList<>();
    Set<NodeDep> visited = new HashSet<>();

    List<NodeDep> jobOrder(){
        List<NodeDep> out = new ArrayList<>();
        for(int i=0;i<nodes.size();i++){
            if(!visited.contains(nodes.get(i))){
                out.addAll(getJobOrder(nodes.get(i)));
            }
        }
        return out;
    }

    List<NodeDep> getJobOrder(NodeDep root){
        List<NodeDep> out = new ArrayList<>();
        Stack<NodeDep> stack = new Stack<>();
        NodeDep curr = root;
        while (!stack.isEmpty() || curr!=null){
            while (curr!=null){
                stack.push(curr);
                curr = getUnvisitedAdjacent(curr);
            }
            curr = stack.pop();
            out.add(curr);
            visited.add(curr);
            if(stack.isEmpty())
                break;
            curr = stack.pop();
        }
        return out;
    }

    NodeDep getUnvisitedAdjacent(NodeDep root){
        List<NodeDep> adjacents = root.adjacenctNodes;
        for(NodeDep adj: adjacents){
            if(!visited.contains(adj))
                return adj;
        }
        return null;
    }

    boolean detectCyclicDependency(NodeDep root){
        Set<NodeDep> inStack = new HashSet<>();
        Stack<NodeDep> stack = new Stack<>();
        NodeDep curr = root;
        while(!stack.isEmpty() || curr!=null){
            while (curr!=null){
                if(inStack.contains(curr)){
                    System.out.println("Detected cycle " + curr.data);
                    return true;
                }
                stack.push(curr);
                inStack.add(curr);
                curr = getUnvisitedAdjacent(curr);
            }
            curr = stack.pop();
            inStack.remove(curr);
            visited.add(curr);
            if(stack.isEmpty())
                break;
            curr = stack.pop();
            inStack.remove(curr);
        }
        return false;
    }
}



    
    // Depth First Search



class NodeDep {
    public String data;
    LinkedList<NodeDep> adjacenctNodes = new LinkedList<NodeDep>();
    boolean seen = false;

    @Override
    public String toString() {
        return "NodeDep{" +
                "data='" + data + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NodeDep nodeDep = (NodeDep) o;

        return data.equals(nodeDep.data);

    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }

    NodeDep(String data){
        this.data = data;
    }
}
