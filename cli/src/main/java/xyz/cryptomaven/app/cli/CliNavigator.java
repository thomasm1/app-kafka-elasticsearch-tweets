package xyz.cryptomaven.app.cli;

import java.util.*;

public class CliNavigator {
    private static Map<Integer, Location> locations = new HashMap<>();

        Map<String, Integer> options = null;

    public static void mainNavigator(String[] args) {
        Scanner scanNav;

        locations.put(0, new Location(0, "You have just quit"));
        locations.put(1, new Location(1, "[Road]: You are now standing at the end of a road in front of a bridge"));
        locations.put(2, new Location(2, "[Hill,w]: You are at the top of a hill"));
        locations.put(3, new Location(3, "[Building,e]: You are in a building, with source of water, i.e. a well"));
        locations.put(4, new Location(4, "[Valley,s]: You are in a valley beside a stream"));
        locations.put(5, new Location(5, "[Forest,n]: You are in the forest"));

//       keySet()
//       manual (for now) stage location/constrations parameters
//      Start at  road in front of Bridge
        locations.get(1).addOption("N", 5); //     =>Forest
        locations.get(1).addOption("E", 3); //    =>building
        locations.get(1).addOption("S", 4); //    =>valley/stream
        locations.get(1).addOption("W", 2); //     =>Hill
//     locations.get(1).addOption("quit", 0);

        locations.get(2).addOption("N", 5); // top of hill

        locations.get(3).addOption("W", 1); // in building => hill

        locations.get(4).addOption("N", 1); // Valley
        locations.get(4).addOption("W", 2);

        locations.get(5).addOption("S", 1); // Forest
        locations.get(5).addOption("W", 2);
        Map<String, String> vocab = new HashMap<>();
        vocab.put("quit", "Q");
        vocab.put("south", "S");
        vocab.put("north", "N");
        vocab.put("east", "E");
        vocab.put("west", "W");
        

        int loc = 1;
        while (true) {
            scanNav = new Scanner(System.in);
            System.out.println(locations.get(loc).getDescription()); //startingout
            if (loc == 0) {
                break;
            }
            Map<String, Integer> options = locations.get(loc).getOptions();

            List<String> optionList = new ArrayList<>();
            for (String option : options.keySet()) {
                optionList.add(option);
            }
            System.out.println("=== Optional Directions====");
            System.out.println(optionList.toString());
            System.out.println("=======");
            String direction = null;
            if (scanNav.hasNext()) {
                direction = scanNav.nextLine().toUpperCase();
                if(direction.length() > 1) {
                    String[] words = direction.split(" ");
                    for(String word: words) {
                        if (vocab.containsKey(word)) {
                            direction = vocab.get(word);
                            break;
                        }
                    }
                }
            }
            if (options.containsKey(direction)) {
                loc = options.get(direction);
            } else {
                System.out.println("Pathway restricted");
            }
        }
        scanNav.close();

    }

    static private class Location {
        protected final  int placeInt;
        protected final String descript;
        protected final Map<String, Integer> options;


        public Location(int placeInt, String descript ) {
            this.placeInt = placeInt;
            this.descript = descript;

            this.options = new HashMap<String, Integer>();
            this.options.put("Q", 0);

        }
        public void addOption(String direction, int location) {
            options.put(direction, location);
        }
        public int getPlaceInt(){
            return placeInt;
        }
        public String getDescription() {
            return descript;
        }
        public Map<String, Integer> getOptions() {
            return new HashMap<String, Integer>(options); // returns durable, new  options
        }
    }
}
