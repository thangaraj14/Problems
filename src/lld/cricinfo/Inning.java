package lld.cricinfo;

import java.util.Date;
import java.util.List;

public class Inning {
    private int number;
    private Date startTime;
    private List<Over> overs;

    public boolean addOver(Over over) {
        return false;
    }
}
