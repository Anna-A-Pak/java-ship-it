package ru.yandex.practicum;

import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.StandardParcel;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class AddNewParcelToBoxTest {

    private static ParcelBox<StandardParcel> parcelBox;

    @BeforeEach
    public void beforeEach() {
       parcelBox = new ParcelBox<>(10);
    }

    @Test
    public void shouldBePositiveWhenMaxWeight10AndParcelWeight5() {
        StandardParcel standardParcel = new StandardParcel("Книги", 5, "Томск", 15);
        assertTrue(parcelBox.addParcel(standardParcel));
    }

    @Test
    public void shouldBePositiveWhenMaxWeight10AndParcelWeight10() {
        StandardParcel standardParcel = new StandardParcel("Книги", 10, "Томск", 15);
        assertTrue(parcelBox.addParcel(standardParcel));
    }

    @Test
    public void shouldBeNegativeWhenMaxWeight10AndParcelWeight15() {
        StandardParcel standardParcel = new StandardParcel("Книги", 15, "Томск", 15);
        assertFalse(parcelBox.addParcel(standardParcel));
    }
}
