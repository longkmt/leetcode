package Test;

import Card.PokerCard;
import Enums.CardRank;
import Enums.CardSuit;
import Players.PokerDealer;
import Players.PokerPlayer;

public class PokerHandTest {
    static PokerPlayer player;
    static PokerDealer dealer;
    public static void setUp(){
        player = new PokerPlayer("Test player");
        dealer = new PokerDealer("Test dealer");

        player.receiveCard((PokerCard)dealer.drawCard());
        player.receiveCard((PokerCard)dealer.drawCard());
        player.receiveCard((PokerCard)dealer.drawCard());
        player.receiveCard((PokerCard)dealer.drawCard());
        player.receiveCard((PokerCard)dealer.drawCard());
    }

    public static void main(String[] args){
//        PockerHandTest.setUp();
//        System.out.println(player.getPlayerStats());

        PokerCard card1 = new PokerCard(CardRank.QUEEN, CardSuit.SPADE);
        PokerCard card2 = new PokerCard(CardRank.JACK, CardSuit.HEART);
        PokerCard card3 = new PokerCard(CardRank.TEN, CardSuit.SPADE);
        PokerCard card4 = new PokerCard(CardRank.QUEEN, CardSuit.DIAMOND);
        PokerCard card5 = new PokerCard(CardRank.JACK, CardSuit.CLUB);

        PokerPlayer player = new PokerPlayer("Test player");
        player.receiveCard(card1);
        player.receiveCard(card2);
        player.receiveCard(card3);
        player.receiveCard(card4);
        player.receiveCard(card5);

        System.out.println(player.getPlayerStats());
//
//        System.out.println(card1.equals(card2));

    }
}
