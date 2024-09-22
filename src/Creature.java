import java.util.List;

public abstract class Creature extends Entity {
    protected nMap nMap;
    private int health;
    protected aStar alghorithm;
    public Creature(nMap nMap, int health, Coordinates coordinates){
        super(coordinates);
        this.nMap = nMap;
        this.health = health;
        alghorithm = new aStar();
    }
    public abstract void performAction(Coordinates coordinates);

    public void changeHealth(int amount){
        health+=amount;
    }
    public abstract boolean isTarget(Entity entityAtLocation);
    public void makeMove(){
        Coordinates currentCoordinates = getCoordinates();
        changeHealth(-2);
        if(health<=0){
            nMap.removeEntityAtLocation(currentCoordinates);
        }
        Coordinates targetCoordinates = alghorithm.findNearestEntity(this, nMap);
        if(targetCoordinates!=null){
            List<Coordinates> path = alghorithm.findPath(currentCoordinates,this, nMap);
            if(!path.isEmpty()){
                Coordinates nextPos = path.get(1);
                performAction(nextPos);
                nMap.removeEntityAtLocation(currentCoordinates);
                setCoordinates(nextPos);
                nMap.addEntity(getCoordinates(),this);
            }
        }
    }
}
