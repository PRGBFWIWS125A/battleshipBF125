package battleship.model;

public class ShipPlacementAction extends TurnAction {

    public final ShipType shipType;
    
    public ShipPlacementAction(Player player, ShipType type) {
        super(player);
        this.shipType = type;
    }

    @Override
    public Boolean apply(EventAndState eventAndState) {
        return eventAndState.rules().shipPlacement(
            eventAndState.game(),
            shipType,
            player,
            eventAndState.event()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ShipPlacementAction) {
            ShipPlacementAction other = (ShipPlacementAction)o;
            return this.player.equals(other.player)
                && this.shipType.equals(other.shipType);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.player.hashCode() * 3 + this.shipType.hashCode() * 7;
    }
    
}
