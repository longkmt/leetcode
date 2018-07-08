package Hand;

import Card.PokerCard;
import Enums.CardRank;
import Enums.CardSuit;
import Enums.PokerRank;

import java.util.ArrayList;

public class BestPossiblePokerHand {



    private PokerRank bestPokerRank;

    private boolean hasOnePair;
    private boolean hasTwoPair;
    private boolean hasThreeKind;
    private boolean hasFourKind;
    private boolean hasStraight;
    private boolean hasFlush;
    private boolean hasFullHouse;
    private boolean hasStraightFlush;
    private boolean hasLoyalFlush;

    private PokerCard cardInPairOne;
    private PokerCard cardInPairTwo;
    private PokerCard cardInThreeKind;
    private PokerCard highCard;

    private ArrayList<PokerCard> cardInHandArray;

    public BestPossiblePokerHand(ArrayList<PokerCard> cardInHandArray){
        hasOnePair = false;
        hasTwoPair = false;
        hasThreeKind =false;
        hasFourKind = false;
        hasStraight = false;
        hasFlush =  false;
        hasFullHouse = false;
        hasStraightFlush = false;
        hasLoyalFlush = false;

        this.cardInHandArray = cardInHandArray;
    }


    public void evaluate(){
        hasOnePair = checkForOnePair();

        if (hasOnePair){
            hasTwoPair = checkForTwoPair();
            hasThreeKind = checkForThreeKind();
        }

        if (hasThreeKind){
            hasFourKind = checkForFourKind();
        }

        if (hasThreeKind && hasTwoPair){
            hasFullHouse = true;
        }

        hasStraight = checkForStraight();

        hasFlush = checkForFlush();

        if (hasStraight && hasFlush){
            hasStraightFlush = true;
        }

        if (hasStraightFlush && cardInHandArray.get(0).getCardRank().getRank() == CardRank.TEN.getRank()){
            hasLoyalFlush = true;
        }

        //after we evaluate all possible hands, we determine the best possible hand.
        determineBestPockerRank();

        //get high card in case of a tie
        for (int i= cardInHandArray.size()-1; i>=0; i--){
            if (!cardInHandArray.get(i).isCommonCard()){
                highCard = cardInHandArray.get(i);
                break;
            }
        }
    }

    private void determineBestPockerRank(){
        //go from high rank to low rank
        if (hasLoyalFlush){
            bestPokerRank = PokerRank.LOYAL_FLUSH;
        }
        else if (hasStraightFlush){
            bestPokerRank = PokerRank.STRAIGHT_FLUSH;
        }
        else if (hasFourKind){
            bestPokerRank = PokerRank.FOUR_KIND;
        }
        else if (hasFullHouse){
            bestPokerRank = PokerRank.FULL_HOUSE;
        }
        else if (hasFlush){
            bestPokerRank = PokerRank.FLUSH;
        }
        else if (hasStraight){
            bestPokerRank = PokerRank.STRAIGHT;
        }
        else if (hasThreeKind){
            bestPokerRank = PokerRank.THREE_KIND;
        }
        else if (hasTwoPair){
            bestPokerRank = PokerRank.TWO_PAIR;
        }
        else if (hasOnePair){
            bestPokerRank = PokerRank.ONE_PAIR;
        }
        else{ //high card
            bestPokerRank = PokerRank.HIGH_CARD;
        }
    }

    private boolean checkForOnePair(){
        boolean result = false;
        //this logic works since we already sort the array
        for (int i=0; i< cardInHandArray.size() -1; i++){
            if (cardInHandArray.get(i).compareTo(cardInHandArray.get(i+1)) == 0){
                result = true;
                cardInPairOne = cardInHandArray.get(i+1);
                break;
            }
        }

        return result;
    }


    private boolean checkForTwoPair(){
        boolean result = false;

        for (int i=cardInHandArray.indexOf(cardInPairOne)+1; i< cardInHandArray.size() -1; i++){
            if (cardInHandArray.get(i) != null && cardInHandArray.get(i+1) !=null && cardInHandArray.get(i).compareTo(cardInHandArray.get(i+1)) ==0){
                result = true;
                cardInPairTwo = cardInHandArray.get(i+1);
                break;
            }
        }

        return result;
    }

    private boolean checkForThreeKind(){
        boolean result = false;

        if (hasOnePair){
            int indexOfPairOne = cardInHandArray.indexOf(cardInPairOne);
            if (indexOfPairOne +1 < cardInHandArray.size()
                    && cardInHandArray.get(indexOfPairOne +1) != null
                    && cardInHandArray.get(indexOfPairOne +1).compareTo(cardInPairOne) ==0 ){

                cardInThreeKind = cardInHandArray.get(indexOfPairOne +1);
                result = true;
            }
        }
        else if (hasTwoPair){
            int indexOfPairTwo = cardInHandArray.indexOf(cardInPairTwo);
            if (indexOfPairTwo +1 < cardInHandArray.size()
                    && cardInHandArray.get(indexOfPairTwo +1) != null
                    && cardInHandArray.get(indexOfPairTwo +1).compareTo(cardInPairTwo) ==0 ){

                cardInThreeKind = cardInHandArray.get(indexOfPairTwo +1);
                result = true;
            }
        }

        return result;
    }

    private boolean checkForFourKind(){
        boolean result = false;

        int indexOfThreeKind = cardInHandArray.indexOf(cardInThreeKind);
        if (indexOfThreeKind + 1 < cardInHandArray.size()
                && cardInHandArray.get(indexOfThreeKind +1) != null
                && cardInHandArray.get(indexOfThreeKind +1).compareTo(cardInThreeKind) ==0 ){

            result = true;
        }

        return result;
    }

    private boolean checkForFlush(){

        boolean result = true;

        CardSuit suit = cardInHandArray.get(0).getCardSuit();

        for (PokerCard card: cardInHandArray){
            if (card.getCardSuit().ordinal() != suit.ordinal()){
                result = false;
                break;
            }
        }
        return result;
    }

    private boolean checkForStraight(){
        boolean result = true;
        for (int i = 0; i< cardInHandArray.size() -1; i++){
            if (cardInHandArray.get(i+1).getCardRank().getRank() - cardInHandArray.get(i).getCardRank().getRank() != 1){
                result = false;
                break;
            }
        }

        return result;
    }

    public boolean isHasOnePair() {
        return hasOnePair;
    }

    public boolean isHasTwoPair() {
        return hasTwoPair;
    }

    public boolean isHasThreeKind() {
        return hasThreeKind;
    }

    public boolean isHasFourKind() {
        return hasFourKind;
    }

    public boolean isHasStraight() {
        return hasStraight;
    }

    public boolean isHasFlush() {
        return hasFlush;
    }

    public boolean isHasFullHouse() {
        return hasFullHouse;
    }

    public boolean isHasStraightFlush() {
        return hasStraightFlush;
    }

    public boolean isHasLoyalFlush() {
        return hasLoyalFlush;
    }

    public PokerRank getBestPokerRank() {
        return bestPokerRank;
    }

    public PokerCard getHighCard() {
        return highCard;
    }

}
