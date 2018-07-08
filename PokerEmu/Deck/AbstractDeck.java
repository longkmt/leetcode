package Deck;

import Card.AbstractCard;
import Utils.IUtils;

import java.util.List;

public abstract class AbstractDeck {

    //what should a deck has?

    //a util
    protected IUtils utils;

    //a list of cards (typical 52 cards, but it depends on the subclass)
    protected List<AbstractCard> cardList;

    public AbstractDeck(){
        initialize();
    }

    //initialize the deck
    protected abstract void initialize();

    //ability to shuffle the deck
    public abstract void shuffleDeck();

    //ability to draw a card from the deck
    public abstract AbstractCard drawCard();



}
