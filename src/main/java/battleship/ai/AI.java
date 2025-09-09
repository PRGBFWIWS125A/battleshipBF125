package battleship.ai;

import battleship.model.*;
import battleship.rules.*;

public interface AI {

    ShipPlacement getShipPlacement(Rules rules, Field[][] ownFields, ShipType type);

    Shot getShot(Rules rules, Field[][] opponentField);

}
