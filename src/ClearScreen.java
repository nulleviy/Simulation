public class ClearScreen {
    public static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.print("\033[0;0H");
        System.out.flush();
    }
}
