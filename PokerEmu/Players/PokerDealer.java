package Players;

import Card.AbstractCard;
import Deck.PokerDeck;
import Hand.BestPossiblePokerHand;

import java.util.List;

public class PokerDealer implements IDealer{

    private String name;
    private PokerDeck deck;

    public PokerDealer(String name){
        this.name = name;
        deck = new PokerDeck();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public IPlayer decideWinner(List playerList) {
        for (Object o : playerList){
            PokerPlayer player = (PokerPlayer)o;
            player.getHand().getBestPossibleHand(); //invoke this to get best possible hand for each player
        }

        playerList.sort(PokerPlayer.pokerPlayerComparator);

        return (PokerPlayer) playerList.get(playerList.size() -1);
    }

    @Override
    public AbstractCard drawCard() {
        return deck.drawCard();
    }


    public PokerDeck getDeck() {
        return deck;
    }
}
