package problemSolving;


import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Given an bunch of airline tickets with [from, to],
 * for example
 * [MUC, LHR],
 * [CDG, MUC],
 * [SFO, SJC],
 * [LHR, SFO], please reconstruct the itinerary in order,
 * for example: [ CDG, MUC, LHR, SFO, SJC ]
 * @author gagamani
 * @date 9/15/18
 */
public class AirTickets {

    /**
     * @param itinerary
     * @return
     */
    public static String connectFlight(String[][] itinerary){
        List<String> connection = new ArrayList<>();
        Map<String, String> connect = arrayToMap(itinerary);
        String start = findStartCity(connect);

        if(StringUtils.isEmpty(start)){
            return null;
        }
        connection.add(start);
        //Now that we got start city, keep connecting the remaining
        //keep moving start pointer
        for(Map.Entry<String, String> currTravel : connect.entrySet()){
            connection.add(connect.get(start));
            start = currTravel.getValue();

        }

        return connection.toString();
    }

    private static Map<String, String> arrayToMap(String[][] itinerary) {
        Map<String, String> connect = new HashMap<>();

        for (int i = 0; i < itinerary.length; i++) {
            connect.put(itinerary[i][0], itinerary[i][1]);
        }
        return connect;
    }

    /**
     * Ideally there should be only one city which is not in destination list.
     * @param connect
     * @return
     */
    private static String findStartCity(Map<String, String> connect){
        String start = StringUtils.EMPTY;
        for(Map.Entry<String, String> entry : connect.entrySet()){
            String startCity = entry.getKey();
                if(!connect.containsValue(startCity)){
                    start = startCity;
                    break;
                }
        }
        return start;
    }
}
