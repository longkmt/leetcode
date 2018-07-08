package Card;

import Enums.CardRank;
import Enums.CardSuit;

public abstract class AbstractCard {

    private CardRank cardRank;
    private CardSuit cardSuit;

    public AbstractCard(CardRank rank, CardSuit suit){
        cardRank = rank;
        cardSuit = suit;
    }

    public CardRank getCardRank(){
        return cardRank;
    }

    public CardSuit getCardSuit(){
        return cardSuit;
    }

    public abstract String toString();
}

