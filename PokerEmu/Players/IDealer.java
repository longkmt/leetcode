package Players;


import Card.AbstractCard;

import java.util.List;

public interface IDealer {

    public abstract String getName();
    public abstract void setName(String name);

    public abstract IPlayer decideWinner(List playerList);

    public abstract AbstractCard drawCard();
}
