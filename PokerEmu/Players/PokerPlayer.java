package Players;

import Card.PokerCard;
import Hand.PokerHand;

import java.util.Comparator;

public class PokerPlayer implements IPlayer, Comparable<PokerPlayer> {

    private String name;
    private PokerHand hand;
    private boolean isActiveHand =false;

    public static Comparator<PokerPlayer> pokerPlayerComparator = new Comparator<PokerPlayer>() {
        @Override
        public int compare(PokerPlayer o1, PokerPlayer o2) {
            return o1.compareTo(o2);
        }
    };

    public PokerPlayer(String name){
        this.name = name;
        hand = new PokerHand();
    }

    public void receiveCard(PokerCard card){
        hand.addCard(card);
    }

    public PokerHand getHand(){
        return hand;
    }

    public boolean isActiveHand() {
        return isActiveHand;
    }

    public void setActiveHand(boolean activeHand) {
        isActiveHand = activeHand;
    }


    @Override
    public String getPlayerStats() {
        StringBuilder strBuilder = new StringBuilder();

        strBuilder.append(" |Name: " + name);
        //strBuilder.append(" |Active hand: " + isActiveHand);
//        strBuilder.append(" |One pair: " + hand.getBestPossibleHand().isHasOnePair());
//        strBuilder.append(" |Two pair: " + hand.getBestPossibleHand().isHasTwoPair());
//        strBuilder.append(" |Three of a kind: " + hand.getBestPossibleHand().isHasThreeKind());
//        strBuilder.append(" |Straight: " + hand.getBestPossibleHand().isHasStraight());
//        strBuilder.append(" |Flush: " + hand.getBestPossibleHand().isHasFlush());
//        strBuilder.append(" |Full house: " + hand.getBestPossibleHand().isHasFullHouse());
//        strBuilder.append(" |Four of a kind: " + hand.getBestPossibleHand().isHasFourKind());
//        strBuilder.append(" |Straight Flush: " + hand.getBestPossibleHand().isHasStraightFlush());
//        strBuilder.append(" |Loyal Flush: " + hand.getBestPossibleHand().isHasLoyalFlush());
        strBuilder.append(" |Cards in hand: " + hand.toString());
        strBuilder.append(" |Best possible hand: " + hand.getBestPossibleHand().getBestPokerRank());
        strBuilder.append("\n");

        return strBuilder.toString();
    }

    @Override
    public int compareTo(PokerPlayer o) {
        if (this.getHand().getBestPossibleHand().getBestPokerRank().ordinal() == o.getHand().getBestPossibleHand().getBestPokerRank().ordinal()){
            return this.getHand().getBestPossibleHand().getHighCard().compareTo(o.getHand().getBestPossibleHand().getHighCard());
        }

        return Integer.compare(this.getHand().getBestPossibleHand().getBestPokerRank().ordinal(),o.getHand().getBestPossibleHand().getBestPokerRank().ordinal());
    }
}
