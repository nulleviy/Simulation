import java.util.ArrayList;

public class TurnAction extends Actions{
    private nMap area;
    private int turnCount;
    private MapRender renderer;
    private boolean isPaused;
    private Object lock;
    public TurnAction(nMap area,MapRender renderer){
        this.area = area;
        this.renderer = renderer;
        isPaused = false;
        lock = new Object();
    }
    @Override
    public void perform(){
        turnCount++;
        if(!isPaused){
            for(Entity entity: new ArrayList<>(area.getEntities().values())){
                if(entity instanceof Creature){
                    Creature creature = (Creature) entity;
                    creature.makeMove();
                }
            }
            renderer.renderMap(area);
            System.out.println("turn count: "+turnCount);
        }
    }
    public void pauseSimulation(){
        isPaused=true;
    }
    public boolean isPaused(){
        return isPaused;
    }
    public void resumeSimulation(){
        isPaused=false;
        synchronized (lock){
            lock.notify();
        }
    }

}
