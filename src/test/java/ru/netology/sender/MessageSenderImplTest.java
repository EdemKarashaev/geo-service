package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.verify;


class MessageSenderImplTest {

    GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
    LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
    MessageSenderImpl msi=new MessageSenderImpl(geoService, localizationService);

    @org.junit.jupiter.api.Test
    void send() {

        String ip = "172.168.0.1";
        String country = "RUSSIA";
        Location location = new Location(country, null, null, 0);

        Map<String, String> headers = new HashMap<String,String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);

        Mockito.when(geoService.byIp(ip)).thenReturn(location);
        Mockito.when(localizationService.locale(location.getCountry())).thenReturn("Добро пожаловать");

        msi.send(headers);

        verify(localizationService).locale(location.getCountry());
    }

}