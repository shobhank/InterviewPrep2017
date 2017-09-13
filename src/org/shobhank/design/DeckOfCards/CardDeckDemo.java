package org.shobhank.design.DeckOfCards;

/**
 * Created by shobhanksharma on 5/16/17.
 */
public class CardDeckDemo {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        deck.display();
//        generateRandom();
    }

    public static void generateRandom(){
        String in[] = {"A","B","C","D","E"};
        for(int i=in.length-1;i>=0;i--){
            int randomIx = (int) (Math.random() * i);
            String temp = in[i];
            in[i] = in[randomIx];
            in[randomIx] = temp;
        }
        for(String str: in){
            System.out.println(str);
        }
    }
}
