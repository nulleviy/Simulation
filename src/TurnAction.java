import java.util.ArrayList;

public class TurnAction extends Actions{
    private final nMap area;
    private int turnCount;
    private final MapRender renderer;
    private boolean isPaused;
    private final Object lock;
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
                if(entity instanceof Creature creature){
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
