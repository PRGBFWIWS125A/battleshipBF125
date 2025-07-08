package battleship.model;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CoordinateTest {

    @DataProvider

    public Object [][] plusData(){

        return new Object[][]{
            { new Coordinate(3,3),4,Direction.EAST,new Coordinate(7,3) },
            { new Coordinate(160, 666), 420, Direction.NORTH, new Coordinate(160, 246) },
            { new Coordinate(-7, -20), 89, Direction.WEST, new Coordinate(-96,-20) },
            { new Coordinate(666, 999), -1000, Direction.SOUTH, new Coordinate(666,-1) },
            { new Coordinate(23,11), 0, Direction.SOUTH, new Coordinate(23,11) }
        };
    }

    @Test(dataProvider="plusData")

    public void plusTest(Coordinate coordinate, int length, Direction direction, Coordinate expected){

        Assert.assertEquals(coordinate.plus(length, direction), expected);
    }
}
