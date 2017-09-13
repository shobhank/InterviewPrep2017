package org.shobhank.design.DeckOfCards;

/**
 * Created by shobhanksharma on 5/16/17.
 */
public class Card {
    enum COLOR {SPADES, HEART, DIAMOND, CLUB};
    enum FACECARD {
        A("ACE"),J("Jack"),Q("Queen"),K("King");
        String value;

        public String getValue() {
            return value;
        }

        FACECARD(String value){
            this.value = value;
        }
    };

    COLOR color;
    boolean isFaceCard;
    String rank;

    public Card(boolean isFaceCard, String rank, COLOR color) {
        this.isFaceCard = isFaceCard;
        this.rank = rank;
        this.color = color;
    }

    @Override
    public String toString() {
        return "{" + color +
                "-" + rank +
                '}';
    }
}
