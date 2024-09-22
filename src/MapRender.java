public class MapRender {
    public static final String ANSI_PREDATOR = "\uD83D\uDC15"; //"\uD83D\uDC3A";
    public static final String ANSI_HERBIVORE = "\uD83D\uDC11"; //"\uD83D\uDC11";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GRASS = "\uD83C\uDF31"; //"\uD83C\uDF3F";
    public static final String ANSI_ROCK = "\uD83C\uDFD4"; //"\u26F0";
    public static final String ANSI_TREE = "\uD83C\uDF32"; //"\uD83C\uDF33";
    public static final String ANSI_BACKGROUND = "\uD83C\uDFFE";//"\u2B1B";

    public void renderMap(nMap area) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        for (int x = 0; x < area.getHeight(); x++) {
            for (int y = 0; y < area.getWidth(); y++) {
                Coordinates coordinates = new Coordinates(x, y);
                Entity entity = area.getEntityAtLocation(coordinates);
                if (entity != null) {
                    String symbol;
                    if (entity instanceof Predator) {
                        symbol = ANSI_PREDATOR;
                    } else if (entity instanceof Herbivore) {
                        symbol = ANSI_HERBIVORE;
                    } else if (entity instanceof Grass) {
                        symbol = ANSI_GRASS;
                    } else if (entity instanceof Rock) {
                        symbol = ANSI_ROCK;
                    } else if (entity instanceof Tree) {
                        symbol = ANSI_TREE;
                    } else {
                        symbol = "";
                    }
                    System.out.print(symbol + ANSI_RESET);
                } else {
                    System.out.print(ANSI_BACKGROUND);
                }
            }

            System.out.println();
        }
    }
    }
