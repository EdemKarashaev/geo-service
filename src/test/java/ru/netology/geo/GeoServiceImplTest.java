package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {


    public static final String ipTest="172.0.16.1";
    GeoServiceImpl geoS= new GeoServiceImpl();


    @Test
    void byIp() {
       Location loc= geoS.byIp(ipTest);
       String exp=loc.getCity();
       String pref="Moscow";
        Assertions.assertEquals(exp, pref);
    }
}