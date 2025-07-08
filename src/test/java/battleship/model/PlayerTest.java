package battleship.model;

import org.testng.*;
import org.testng.annotations.Test;

public class PlayerTest {
    @Test
    public void inverseTest() {
        //Datenvorbereitung
        Player x = Player.FIRST;
        Player y = Player.SECOND;

        //Ausführung
        Player invX = x.inverse();
        Player invY = y.inverse();

        //Prüfen
        Assert.assertEquals(invX,y);
        Assert.assertEquals(invY,x);
    }
}

















//Ich war hier