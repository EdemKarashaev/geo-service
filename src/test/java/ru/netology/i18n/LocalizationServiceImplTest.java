package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    LocalizationServiceImpl local=new LocalizationServiceImpl();

    @Test
    void locale() {
        String ret=local.locale(Country.BRAZIL);
        String pref="Welcome";
        Assertions.assertEquals(ret, pref);
    }
}