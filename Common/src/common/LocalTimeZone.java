package common;

import java.time.ZoneId;

public class LocalTimeZone {

    public ZoneId getLocalTimeZoneId() {
        return localTimeZoneId;
    }

    ZoneId localTimeZoneId;

    public LocalTimeZone(){
        localTimeZoneId = ZoneId.of("Europe/Budapest");
    }
}
