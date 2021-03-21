package concepts.annotations;

import java.time.LocalDate;

public class Client {
    @DateFormat("yyyy/MM/xd")
    private LocalDate date;
}