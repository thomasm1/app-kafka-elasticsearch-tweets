package app.mapl.util.methods;


import app.mapl.logger.CliLogger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class ParseDynamicJson {
    public static void parseObject(JSONObject json, String key) {
        System.out.println(": Key: " + key+ json.containsKey(key));
        System.out.println(": Key: " + json.get(key));
    };
    public static void getKey(JSONObject json, String key) {
        boolean exists = json.containsKey(key);
        Iterator<?> keys;
        String nextKeys;

        if (!exists) {
            System.out.println("Key does not exist");
            keys=json.keySet().iterator();

            while(keys.hasNext()) {
                nextKeys = (String) keys.next();
                System.out.println("Key: " + nextKeys);
                try {
                    if(json.get(nextKeys) instanceof JSONObject) {
                        if(exists==false) {
                            System.out.println("Key: " + nextKeys + " is a JSONObject");
//                            parseObject(json, key);
//                        parseObject((JSONObject) json.get(nextKeys), key);
                        getKey((JSONObject) json.get(nextKeys), key);
                        }
                    }
                    else if (json.get(nextKeys) instanceof JSONArray) {
                        System.out.println("Key: " + nextKeys + " is a JSONArray");
                        JSONArray jsonArray = (JSONArray) json.get(nextKeys);
                        for (int i = 0; i < jsonArray.size(); i++) {
                            String jsonArrayString = jsonArray.get(i).toString();
                            System.out.println("Key: " + nextKeys + " is a JSONArray: " + jsonArrayString);
                            JSONObject INNERjsonObject = new JSONObject();
                            INNERjsonObject.put(nextKeys, jsonArrayString);

                            if (exists ==false) {
                                getKey(INNERjsonObject, key);
                            }
                        }

                        System.out.println("Key: " + nextKeys + " is not a JSONObject");
                    }
                } catch (Exception e) {
                    System.out.println("Key: " + nextKeys + " is not a JSONObject");
                }


            }

        } else {
            System.out.println("Key exists");
            parseObject(json, key);
        }
    }

//    private  static CliLogger cliLogger = (CliLogger)  CliLogger.getInstance( );

    private static final Logger log =
            LoggerFactory.getLogger(ParseDynamicJson.class);

    private  static Logger logger = LoggerFactory.getLogger(ParseDynamicJson.class);
    public static void main(String[] args) throws ParseException { //ParseDynamicJson

        JSONObject json = new JSONObject();
        String json2 = "{\"name\":\"foo\", \"num\":100, \"balance\":1000.21, \"is_vip\":true}";

        JSONObject inputJSONOBject;
        inputJSONOBject = new JSONObject();
        getKey(inputJSONOBject, "name");
        getKey(inputJSONOBject, "num");
        getKey(inputJSONOBject, "balance");


        json.put("name", "foo");
        json.put("num", Integer.valueOf(100));
        getKey(json, "name");
        getKey(json, "num");
        getKey(json, "balance");

        JSONObject json3 = new JSONObject();
        json.put("balance",   Double.valueOf(1000.21));
        json.put("is_vip", Boolean.valueOf(true));
        getKey(json, "is_vip");
        getKey(json, "foo");

        HashMap<String, String> gsonHashMap = new JSONObject();
               gsonHashMap.put(json3.toString(), String.valueOf(HashMap.class));
        for (Map.Entry<String, String> itr : gsonHashMap.entrySet()) {

//            LoggerImpl.loggerInstance(new String[] { "CliApplication.main()" });
            CliLogger.getInstance().info("Key: " + itr.getKey() + " Value: " + itr.getValue());
            log.info("Key: " + itr.getKey() + " Value: " + itr.getValue());
            logger.info("Key: " + itr.getKey() + " Value: " + itr.getValue());
        }
        CliLogger.getInstance().info("Program CliLogger.getInstance()___________ended");
        //15:07:37.712 [main] INFO app.mapl.util.logger.CliLogger - Program ended


        String jsonString= "{\"name\":\"foo\", \"num\":100, \"balance\":1000.21, \"is_vip\":true}";
        JSONParser parser = new JSONParser();
        JSONObject jsonObj = (JSONObject) parser.parse(jsonString);
        JSONObject inputJSONOBject2 = new JSONObject(jsonObj );
        getKey(inputJSONOBject2, "name");   // Key exists
        logger.info("Program logger___________ended");
    }
}
