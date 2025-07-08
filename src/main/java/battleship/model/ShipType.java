package battleship.model;

public enum ShipType {
    BATTLESHIP("Schlachtschiff",4),
    CANNON_BOAT("Kanonenboot",1),
    CARRIER("Flugzeugträger",5),
    CRUISER("Kreuzer",3),
    DESTROYER("Zerstörer",2),
    SUBMARINE("U-Brot",3);

    public final String name;
    public final int length;

    private ShipType(String name, int length) {
        this.name = name;
        this.length = length;
    }
}
