package concepts.annotations;

import java.time.LocalDate;

public class ClientTest {
    @DateFormat("yyyy/MM/xd")
    private LocalDate date;
}