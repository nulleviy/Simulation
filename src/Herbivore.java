public class Herbivore extends Creature {
    public Herbivore(nMap nMap, Coordinates coordinates){
        super(nMap,16,coordinates);
    }

    public boolean isTarget(Entity entityAtLocation) {
        return entityAtLocation instanceof Grass;
    }

    public void eatGrass(Coordinates coordinates){
        nMap.removeEntityAtLocation(coordinates);
        changeHealth(2);
    }
    public void performAction(Coordinates coordinates){
        Entity entity = nMap.getEntityAtLocation(coordinates);
        if(isTarget(entity)){
            eatGrass(coordinates);
        }
    }

}
