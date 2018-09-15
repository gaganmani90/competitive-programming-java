package programs;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author gagamani
 * @date 9/15/18
 */
public class AirTicketsTest {

    @Test
    public void connectFlight(){
        Assert.assertEquals(null, AirTickets.connectFlight(new String[][]{{"bangalore","pune"},{"pune","bangalore"}}));
        Assert.assertEquals("[CDG, MUC, LHR, SJC, SFO]", AirTickets.connectFlight(new String[][]{{"MUC","LHR"},{"CDG", "MUC"},{"SFO", "SJC"},{"LHR", "SFO"}}));
    }
}
