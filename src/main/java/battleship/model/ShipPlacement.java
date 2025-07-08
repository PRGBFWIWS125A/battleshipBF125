package battleship.model;
import java.util.Optional;

public class ShipPlacement extends Event{

    final ShipType type;
    final Player player;
    final Coordinate start;
    final Direction direction;

    public ShipPlacement(ShipType type, Player player, Coordinate start, Direction direction) {
        this.type = type;
        this.player = player;
        this.start = start;
        this.direction = direction;
    }

    @Override
    public boolean isShipPlacementEvent(Player player) {
        return this.player.equals(player);
    }

    @Override
    public boolean isShotEvent(Player player) {
        return false;
    }

    private static int distance(Coordinate start, Coordinate end) {
        return Math.abs(start.column() - end.column()) + Math.abs(start.row() - end.row());
    }

    private static boolean onOneLine(Coordinate start, Coordinate end) {
        return start.column() == end.column() || start.row() == end.row();
    }

    public static Optional<Direction> toDirection(ShipType type, Coordinate start, Coordinate end) {
        int verticalDistance = end.row() - start.row();
        int horizontalDistance = end.column() - start.column();

        if (verticalDistance + horizontalDistance == type.length - 1) {
            if (verticalDistance == 0) {
                if (horizontalDistance < 0) {
                    return Optional.of(Direction.WEST);
                }
                return Optional.of(Direction.EAST);
            } else if (horizontalDistance == 0) {
                if (verticalDistance < 0) {
                    return Optional.of(Direction.NORTH);
                }
                return Optional.of(Direction.SOUTH);
            } else return Optional.empty();
        }
        return Optional.empty();
    }
}
