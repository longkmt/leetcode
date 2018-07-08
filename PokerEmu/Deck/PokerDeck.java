package Deck;

import Card.AbstractCard;
import Card.PokerCard;
import Enums.CardRank;
import Enums.CardSuit;
import Utils.PokerUtils;

import java.util.ArrayList;
import java.util.Collections;

public class PokerDeck extends AbstractDeck {

    public PokerDeck(){
        super();
    }

    @Override
    protected void initialize() {

        if (cardList == null){
            cardList = new ArrayList<AbstractCard>(); //choose array list since I think read operations will be more than write
        }

        if (utils == null){
            utils = new PokerUtils();
        }

        for (CardRank rank: CardRank.values()){
            for (CardSuit suit: CardSuit.values()){
                PokerCard card = new PokerCard(rank, suit);
                cardList.add(card);
            }
        }
    }

    @Override
    public void shuffleDeck() {
        Collections.shuffle(cardList);
    }

    @Override
    public AbstractCard drawCard() {
        while (true){
            PokerCard card = (PokerCard)cardList.get(utils.randomInt(cardList.size()));

            if (!card.isDrawn()){
                card.setDrawn(true);
                return card;
            }

        }
    }
}
