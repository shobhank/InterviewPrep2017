package org.shobhank.design.DeckOfCards;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shobhanksharma on 5/16/17.
 */
public class Deck {
    Card cards[];

    Deck(){
        cards = new Card[52];
        int ix = 0;
        for(int i=0;i<4;i++){
            for(int j=1;j<=13;j++){
                Card card;
                if(j==1)
                    card = new Card(true, Card.FACECARD.values()[0].getValue(), Card.COLOR.values()[i]);
                else if(j>=2 && j<=10)
                    card = new Card(false, String.valueOf(j), Card.COLOR.values()[i]);
                else
                    card = new Card(true,Card.FACECARD.values()[j%10].getValue(), Card.COLOR.values()[i]);

                cards[ix] = card;
                ix++;
            }
        }
    }

    public void display(){
        for(int i = 0; i< cards.length; i++){
            System.out.println(i+ " " + cards[i]);
        }
    }

    public void shuffle(){
        for(int i = cards.length-1; i>=0; i--){
            int randomIx = (int) (Math.random() * i);
            swap(i,randomIx);
        }
    }

    private void swap(int source, int dest){
        Card temp = cards[source];
        cards[source] = cards[dest];
        cards[dest] = temp;
    }
}
