package Games;

import Card.PokerCard;
import Players.IDealer;
import Players.PokerDealer;
import Players.PokerPlayer;

import java.util.LinkedList;
import java.util.List;

public class PokerGame implements IGame {

    private IDealer dealer;
    private List<PokerPlayer> playersList;
    private int numPlayer;

    public PokerGame(int numPlayer){
        this.numPlayer = numPlayer;
        initialize();
    }

    @Override
    public void initialize() {
        dealer = new PokerDealer("Pocker Dealer");
        playersList = new LinkedList<PokerPlayer>();

        for (int i=1; i<= numPlayer; i++){
            PokerPlayer player = new PokerPlayer("Player " + i);
            playersList.add(player);
        }
    }

    @Override
    public String getGameStats() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("\n=== Players Stats ===\n");
        for (PokerPlayer player : playersList){
            strBuilder.append(player.getPlayerStats());
        }

        return strBuilder.toString();
    }

    public void start() {

        //give each player 2 cards to begin with
        for (PokerPlayer player : playersList){
            player.receiveCard((PokerCard)dealer.drawCard());
            player.receiveCard((PokerCard)dealer.drawCard());
        }

        //betting rounds

        //dealer then draw 3 cards
        PokerCard card1 = (PokerCard)dealer.drawCard();
        PokerCard card2 = (PokerCard)dealer.drawCard();
        PokerCard card3 = (PokerCard)dealer.drawCard();
        PokerCard card4 = (PokerCard)dealer.drawCard();
        PokerCard card5 = (PokerCard)dealer.drawCard();

        //since they are common card to be shared among the players
        card1.setCommonCard(true);
        card2.setCommonCard(true);
        card3.setCommonCard(true);
        card4.setCommonCard(true);
        card5.setCommonCard(true);

        //add those card to the player's hands
        for (PokerPlayer player : playersList){
            player.receiveCard(card1);
            player.receiveCard(card2);
            player.receiveCard(card3);
            player.receiveCard(card4);
            player.receiveCard(card5);
        }

        //now all players have 5 cards, we need to determine who is the winner.
        PokerPlayer winner = (PokerPlayer) dealer.decideWinner(playersList);

        //announce the winner and show game stats
        System.out.println(getGameStats());

        System.out.println("And the winner is: \n");
        System.out.println(winner.getPlayerStats());



    }
}
