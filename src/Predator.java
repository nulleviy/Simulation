public class Predator extends Creature {
    public Predator(nMap nMap, Coordinates coordinates){
        super(nMap,30,coordinates);
    }
    public void performAction(Coordinates coordinates){
        Entity entity = nMap.getEntityAtLocation(coordinates);
        if(isTarget(entity)){
            eatHerbivore(coordinates);
        }
    }

    public boolean isTarget(Entity entityAtLocation) {
        return entityAtLocation instanceof Herbivore;
    }
    public void eatHerbivore(Coordinates coordinates){
        nMap.removeEntityAtLocation(coordinates);
        changeHealth(3);
    }

}
