import java.util.Map;
import java.util.Random;

public class InitAction extends Actions {
    private nMap map;
    private Random random = new Random();
    public InitAction(nMap map){
        this.map = map;
    }
    @Override
    public void perform(){
        setRandomEntities(4,12,15,6,5);
    }

    private void setRandomEntities(int numPredators, int numHerbivores, int numGrass, int numRocks, int numTrees) {
        for (int i = 0; i < numPredators; i++) {
            Coordinates coordinates = generateRandomPosition();
            map.addEntity(coordinates, new Predator(map,coordinates));
        }

        for (int i = 0; i < numHerbivores; i++) {
            Coordinates coordinates = generateRandomPosition();
            map.addEntity(coordinates, new Herbivore(map,coordinates));
        }

        for (int i = 0; i < numGrass; i++) {
            Coordinates coordinates = generateRandomPosition();
            map.addEntity(coordinates, new Grass(coordinates));
        }

        for (int i = 0; i < numRocks; i++) {
            Coordinates coordinates = generateRandomPosition();
            map.addEntity(coordinates, new Rock(coordinates));
        }

        for (int i = 0; i < numTrees; i++) {
            Coordinates coordinates = generateRandomPosition();
            map.addEntity(coordinates, new Tree(coordinates));
        }
    }

    private Coordinates generateRandomPosition() {
        Coordinates coordinates;
        Map<Coordinates,Entity> entities = map.getEntities();
        do{
            int x = random.nextInt(map.getWidth());
            int y = random.nextInt(map.getHeight());
            coordinates = new Coordinates(x,y);
        }while(entities.containsKey(coordinates));
        return coordinates;
    }
}
