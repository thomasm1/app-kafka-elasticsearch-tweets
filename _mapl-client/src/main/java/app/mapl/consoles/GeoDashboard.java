package app.mapl.consoles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;


public class GeoDashboard implements Map<Integer, Location> {

    private static final Logger log =
            LoggerFactory.getLogger(GeoDashboard.class);
    //    private static Map<Integer, Location> locations = new HashMap<>();//
//        Map<String, Integer> options = null;
    private static Locations locations = new Locations();
//    InputStream inputStream = getClass().getResourceAsStream("/data/locations/json/posts.json");
    //cd C:\w\www\_groot\groot-app\src\main\java\com\friendsofgroot\app\data\locations

//    URL url = new URL("jar:file:/absolute/location/of/yourJar.jar!/1.txt");
//    InputStream is = url.openStream();
//    BufferedReader br = new BufferedReader(new InputStreamReader(is));
//    String line = null;
//    while ((line = br.readLine()) != null) {
//        System.out.println(line);
//    }

    public GeoDashboard() throws IOException {
    }

    public static void console(String args) throws SQLException, IOException, ClassNotFoundException {

        Scanner scanNav = new Scanner(System.in);
        Locations.mainLocationsTXT(new String[]{});
        Locations.mainLocationsDAT(new String[]{});
        Locations.mainLocationsBIN(new String[]{});


        Map<String, String> vocab_ = new HashMap<String, String>();
        vocab_.put("QUIT", "Q");
        vocab_.put("NORTH", "N");
        vocab_.put("SOUTH", "S");
        vocab_.put("WEST", "W");
        vocab_.put("EAST", "E");

        int loc = 1;
//        int loc = 64;
        while (true) {
            scanNav = new Scanner(System.in);
            System.out.println(locations.get(loc).getDescription()); //startingout
            if (loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanNav.nextLine().toUpperCase();
            if (direction.length() > 1) {
                String[] words = direction.split(" ");
                for (String word : words) {
                    if (vocab_.containsKey(word)) {
                        direction = vocab_.get(word);
                        break;
                    }
                }
            }

            if (exits.containsKey(direction)) {
                loc = exits.get(direction);

            } else {
                System.out.println("You cannot go in that direction");
            }
        }
        MainDashboard.console(new String[]{});
    }

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
