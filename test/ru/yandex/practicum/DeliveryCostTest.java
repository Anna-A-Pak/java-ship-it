package ru.yandex.practicum;

import org.junit.jupiter.api.*;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;
import static org.junit.jupiter.api.Assertions.*;

public class DeliveryCostTest {
    private static StandardParcel standardParcel;
    private static FragileParcel fragileParcel;
    private static PerishableParcel perishableParcel;

    @Test
    public void shouldCorrectlyCalculateValueOfStandardParcelAndWeight5() {
        standardParcel = new StandardParcel("Книги", 5, "Томск", 15);
        assertEquals(10, standardParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldCorrectlyCalculateValueOfFragileParcelAndWeight2() {
        fragileParcel = new FragileParcel("Ваза", 2, "Самара", 10);
        assertEquals(8, fragileParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldCorrectlyCalculateValueOfPerishableParcelAndWeight2() {
        perishableParcel = new PerishableParcel("Сыр", 2, "Томск", 12, 10);
        assertEquals(6, perishableParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldCorrectlyCalculateValueOfStandardParcelAndWeight10() {
        standardParcel = new StandardParcel("Книги", 10, "Томск", 15);
        assertEquals(20, standardParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldCorrectlyCalculateValueOfFragileParcelAndWeight5() {
        fragileParcel = new FragileParcel("Ваза", 5, "Самара", 10);
        assertEquals(20, fragileParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldCorrectlyCalculateValueOfPerishableParcelAndWeight6() {
        perishableParcel = new PerishableParcel("Сыр", 6, "Томск", 12, 21);
        assertEquals(18, perishableParcel.calculateDeliveryCost());
    }
}
