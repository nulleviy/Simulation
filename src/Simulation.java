import java.util.Scanner;

public class Simulation {

     private nMap area;
     private MapRender render;
     private TurnAction turnAction;
     private Scanner scanner;

     public Simulation(){
         area = new nMap();
         render = new MapRender();
         turnAction = new TurnAction(area,render);
         scanner = new Scanner(System.in);
     }

    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        InitAction initAction = new InitAction(simulation.area);
        initAction.perform();
        simulation.startSimulation();
    }


     public void nextTurn(){
         turnAction.perform();
     }

     public void startSimulation(){
         Thread simulationThread = new Thread(() -> {
             while (area.hasGrass() && area.hasHerbivore()) {
                 if (!turnAction.isPaused()) {
                     ClearScreen.clear();
                     nextTurn();
                 }

                 try {
                     Thread.sleep(100);
                 } catch (InterruptedException e) {
                     break;
                 }
             }
         });
         simulationThread.start();

         String input;

         System.out.println("Симуляция запущенна. Нажмите 'p' для паузы или 'r' для продолжения или 'q' для выхода...");

         while (true) {
             input = scanner.nextLine();

             if (input.equalsIgnoreCase("p")) {
                 turnAction.pauseSimulation();
                 System.out.println("Симуляция запущенна. Нажмите 'r' для продолжения или 'q' для выхода...");
             } else if (input.equalsIgnoreCase("r")) {
                 turnAction.resumeSimulation();
                 System.out.println("Симуляция остановленна");
             } else if (input.equalsIgnoreCase("q")) {
                 System.exit(0);
             }

             if (!area.hasGrass() || !area.hasHerbivore()) {
                 break;
             }
         }
         scanner.close();
     }
}