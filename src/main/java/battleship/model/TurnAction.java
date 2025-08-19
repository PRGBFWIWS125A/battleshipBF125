package battleship.model;

import java.util.function.Function;

public abstract class TurnAction implements Function<EventAndState, Boolean> {
    public final Player player;
    public TurnAction(Player player){
        this.player = player;
    }
}
