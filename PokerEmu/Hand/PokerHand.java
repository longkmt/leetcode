package Hand;

import Card.PokerCard;

import java.util.ArrayList;
import java.util.Collections;

public class PokerHand implements IHand{
    public static final int MAX_NUM_CARD = 7;
    private ArrayList<PokerCard> cardInHandArray;
    private BestPossiblePokerHand bestPossibleHand;


    public PokerHand(){
        cardInHandArray = new ArrayList<PokerCard>(MAX_NUM_CARD);
    }

    public boolean addCard(PokerCard card){
        if (cardInHandArray != null && cardInHandArray.size() < MAX_NUM_CARD){
            cardInHandArray.add(card);
            return true;
        }
        else{ //reach the limit
            return false;
        }
    }

    private void sortHand(){
        //sort the array
        cardInHandArray.sort(PokerCard.rankComparator);
    }

    private void calculateBestPossibleHand(){

        //we need to sort the array first since it will provide lot of optimization in our logic
        sortHand();

        //find out the best possible hand
        bestPossibleHand.evaluate();

    }

    public BestPossiblePokerHand getBestPossibleHand(){
        if (bestPossibleHand == null) {
            bestPossibleHand = new BestPossiblePokerHand(cardInHandArray);
            calculateBestPossibleHand();
        }

        return bestPossibleHand;
    }

    @Override
    public String toString(){
        StringBuilder strBuilder = new StringBuilder();
        for (PokerCard card: cardInHandArray){
            strBuilder.append(card.toString());
        }

        return strBuilder.toString();
    }

}
