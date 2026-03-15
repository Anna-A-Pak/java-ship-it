package ru.yandex.practicum;

import org.junit.jupiter.api.*;
import ru.yandex.practicum.delivery.PerishableParcel;
import static org.junit.jupiter.api.Assertions.*;

public class IsExpiredParcelTest {
    private static PerishableParcel perishableParcel;

    @BeforeEach
    public void beforeEach() {
        perishableParcel = new PerishableParcel("Сыр", 2, "Томск", 12, 10);
    }

    @Test
    public void shouldBePositiveWhenCurrentDay25() {
        assertTrue(perishableParcel.isExpired(25));
    }

    @Test
    public void shouldBeNegativeWhenCurrentDay20() {
        assertFalse(perishableParcel.isExpired(20));
    }

    @Test
    public void shouldBeNegativeWhenCurrentDay22() {
        assertFalse(perishableParcel.isExpired(22));
    }
}