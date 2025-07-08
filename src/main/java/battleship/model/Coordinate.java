package battleship.model;

public record Coordinate(int column, int row) {

   public Coordinate plus(final int length, final Direction direction){
    
        switch (direction) {
            case EAST:
                return new Coordinate(column() + length, row());
              

            case SOUTH:

            return new Coordinate(column() , row()+ length);

            case NORTH:
            return new Coordinate(column(), row() - length);

            case WEST:
            return new Coordinate(column() -length, row() );

            default:
               throw new IllegalStateException("found a new direction");
        }
    }

    public  Coordinate plusColumn(final int column){
        return plus(column,Direction.EAST);
    }

    public Coordinate plusRow(final int row){
        return plus (row,Direction.SOUTH);
    }
}
