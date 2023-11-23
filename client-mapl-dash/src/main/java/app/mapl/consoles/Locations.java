package app.mapl.consoles;


import app.mapl.util.ParseDynamicJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;


public class Locations implements Map<Integer, Location> {

    private  static Logger logger = LoggerFactory.getLogger(ParseDynamicJson.class);
    private static String L_DIR = "./src/main/resources/data/locations/";// "/data/locations/";

//    InputStream in = getClass().getResourceAsStream(L_DIR);
//    BufferedReader input = new BufferedReader(new InputStreamReader(in));

    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();
//    FileWriter locFile = new FileWriter(L_DIR+ "locations.txt")
    public static void mainLocationsTXT(String[] args) throws IOException {
        logger.info("BufferedWriter___________________mainLocationsTXT()");
        try(BufferedWriter locFile = new BufferedWriter(new FileWriter(L_DIR+ "locations_big_wr.txt"));
            BufferedWriter dirFile = new BufferedWriter(new FileWriter(L_DIR+ "directions_big_wr.txt"))) {
            for(Location location : locations.values()) {
                locFile.write(location.getLocationID() + "," + location.getDescription() + "__________\n");
                for(String direction : location.getExits().keySet()) {
                    dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "=========\n");
                }
            }
        }
    }
    public static void mainLocationsDAT(String[] args) throws IOException {
        logger.info("DataOutputStream___________________mainLocationsDAT()");
        try(DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(L_DIR+ "locations_big.dat")));
            DataOutputStream dirFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(L_DIR+ "directions_big.dat")))) {
            for(Location location : locations.values()) {
                locFile.writeInt(location.getLocationID());
                locFile.writeUTF(location.getDescription());
                System.out.println("Writing location " + location.getLocationID() + ": " + location.getDescription());
                System.out.println("Writing " + (location.getExits().size() - 1) + " exits.");
                locFile.writeInt(location.getExits().size() - 1);
                for(String direction : location.getExits().keySet()) {
                    if(!direction.equalsIgnoreCase("Q")) {
                        System.out.println("\t\t" + direction + ", " + location.getExits().get(direction));
                        dirFile.writeUTF(direction);
                        dirFile.writeInt(location.getExits().get(direction));
                    }
                }
            }
        }
    }
    public static void mainLocationsBIN(String[] args) throws IOException {
        logger.info("ObjectOutputStream___________________mainLocationsBIN()");
        try(ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(L_DIR+ "locations_big.bin")));
            ObjectOutputStream dirFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(L_DIR+ "directions_big.bin")))) {
            for(Location location : locations.values()) {
                locFile.writeObject(location);
            }
        }
    }

    static {

        File directory = new File(L_DIR);  // src/main/resources/data/locations/
        System.out.println("Current _________directory C:\\w\\www\\_groot\\groot-app\\src\\main\\resources\\data\\locations: " + directory.getAbsolutePath());
        File currDir = new File("./");
        System.out.println("Current _________currDir C:\\w\\www\\_groot\\groot-app\\.: " + currDir.getAbsolutePath());

        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(L_DIR+"locations_big.txt")))) {
            scanner.useDelimiter(",");
            while(scanner.hasNextLine()) {
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
//                System.out.println("READING FROM LOCATIONS_BIG.TXT: " + loc + ": " + description);
                Map<String, Integer> tempExit = new HashMap<>();
                locations.put(loc, new Location(loc, description, tempExit));
            }
        } catch (IOException io) {
            System.out.println("IO Exception: " + io.getMessage());
        }

        // READ EXIT DIRECTIONS
        try(BufferedReader dirFile =  new BufferedReader(new FileReader(L_DIR+"directions_big.txt"))) {
            String input;
            while( (input = dirFile.readLine()) != null) {
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);

//                System.out.println("READING FROM LOCATIONS_BIG.TXT: " + loc + ": " + direction + ": " + destination);
//                System.out.println(loc + ": " + direction + ": " + destination);
                Location location = locations.get(loc);
                location.addExit(direction, destination);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } ;
    }

//        Map<String, Integer> tempExit = new HashMap<String, Integer>();
//        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java",null));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("W", 2);
//        tempExit.put("E", 3);
//        tempExit.put("S", 4);
//        tempExit.put("N", 5);
//        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building",tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("N", 5);
//        locations.put(2, new Location(2, "You are at the top of a hill",tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("W", 1);
//        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring",tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("N", 1);
//        tempExit.put("W", 2);
//        locations.put(4, new Location(4, "You are in a valley beside a stream",tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("S", 1);
//        tempExit.put("W", 2);
//        locations.put(5, new Location(5, "You are in the forest",tempExit));


    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();

    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
