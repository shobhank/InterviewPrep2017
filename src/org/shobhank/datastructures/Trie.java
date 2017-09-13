package org.shobhank.datastructures;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    private Node root = new Node();
    private static int NUM_OF_CHAR = 256;
    static class Node{
        Node[] child = new Node[NUM_OF_CHAR];
        boolean isWord;
    }
    
    public void insert(char[] str){
        
        Node start = root;
        for(char ch : str){
            if(start.child[ch] != null){
                start = start.child[ch];
            }else{
                start.child[ch] = new Node();
                start = start.child[ch];
            }
        }
        start.isWord = true;
    }
    
    public void delete(char[] str){
        
        deleteRecursively(root, str, 0);
    }
    
    public boolean deleteRecursively(Node root,char[] str,int pos){
        
        if(pos == str.length){
            if(root.isWord){
                root.isWord = false;
                boolean hasChild = hasAnyOtherChild(root);
                if(!hasChild){
                    return true;
                }
            }
            return false;
        }
        
        if(root == null){
            return false;
        }
        
        boolean r = deleteRecursively(root.child[str[pos]], str, pos+1);
        if(r == false){
            return false;
        }
        root.child[str[pos]] = null;
        
        boolean hasChild = hasAnyOtherChild(root);
        return !hasChild && !root.isWord;
    }
    
    public boolean hasAnyOtherChild(Node root){
        for(int i=0; i < NUM_OF_CHAR; i++){
            if(root.child[i] != null){
                return true;
            }
        }
        return false;
    }
    
    public boolean search(char[] key){
        
        Node start = root;
        for(char ch : key){
            if(start.child[ch] == null){
                return false;
            }
            start = start.child[ch];
        }
        
        return true;
    }
    
    private void displayTrie(Node root){
        Node start = root;
        System.out.println(root.isWord);
        for(int i=0; i < NUM_OF_CHAR ; i++){
            if(start.child[i] != null){
                System.out.println((char)i);
                displayTrie(start.child[i]);
            }
        }
    }

    public void typeAhead(String prefix){
        List<String> out = new ArrayList<>();
        Node curr = root;
        for(int i=0;i<prefix.length();i++){
            if(curr.child[prefix.charAt(i)] == null)
                return;
            curr = curr.child[prefix.charAt(i)];
        }
        List<String> result = new ArrayList<>();
        allPaths(curr, new StringBuilder(), result, prefix);
        System.out.println(result);
    }

    public void allPaths(Node root, StringBuilder s, List<String> result, String prefix){
        Node start = root;
        if(start.isWord) {
            result.add(prefix + s.toString());
        }
        for(int i=0; i < NUM_OF_CHAR ; i++){
            if(start.child[i] != null){
                s.append((char)i);
                allPaths(start.child[i],s,result,prefix);
            }
        }
    }
    
    public static void main(String args[]){
        Trie t = new Trie();
//        t.insert("a".toCharArray());
//        t.insert("tushar".toCharArray());
//        t.insert("tusharroy".toCharArray());
//        t.insert("anisweta".toCharArray());
//        t.insert("aniswetas".toCharArray());
        t.insert("captain".toCharArray());
        t.insert("capital".toCharArray());
//        t.insert("caption".toCharArray());
        t.typeAhead("ca");
        t.displayTrie(t.root);
//        t.delete("TusharRoy".toCharArray());
//        t.displayTrie(t.root);
    }
    
}
