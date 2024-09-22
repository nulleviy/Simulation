import java.util.HashMap;
import java.util.Map;

public class nMap {
    private final static int HEIGHT = 25;
    private final static int WIDTH = 25;
    private HashMap<Coordinates, Entity> map = new HashMap<>();

    public nMap(){}

    public int getWidth() {
        return WIDTH;
    }
    public int getHeight(){
        return HEIGHT;
    }

    public boolean isValidPosition(Coordinates isNeighborCoordinates) {
        return isNeighborCoordinates.getX() >= 0 && isNeighborCoordinates.getX() < WIDTH && isNeighborCoordinates.getY() >= 0 && isNeighborCoordinates.getY() < HEIGHT;
    }

    public Entity getEntityAtLocation(Coordinates isNeighborCoordinates) {
        return map.get(isNeighborCoordinates);
    }

    public Map<Coordinates, Entity> getEntities() {
        return new HashMap<>(map);
    }

    public void removeEntityAtLocation(Coordinates coordinates) {
        map.remove(coordinates);
    }

    public void addEntity(Coordinates coordinates, Entity entity){
        entity.setCoordinates(coordinates);
        map.put(coordinates,entity);
    }

    public <T extends Entity> boolean hasEntity(Class<T> tClass) {
        for(Entity entity: map.values()){
            if(entity.getClass()==tClass){
                return true;
            }
        }
        return false;
    }
    public boolean hasGrass(){
        return hasEntity(Grass.class);
    }
    public boolean hasHerbivore(){
        return hasEntity(Herbivore.class);
    }
}
