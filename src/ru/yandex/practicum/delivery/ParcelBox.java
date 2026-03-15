package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public class ParcelBox <T extends Parcel> {
    private final int maxWeight;
    private final ArrayList<T> parcels = new ArrayList<>();
    private int sumWeight;

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public boolean addParcel(T parcel) {
        sumWeight+=parcel.getWeight();

        if (sumWeight > maxWeight) {
            System.out.println("Максимальный вес превышен. Посылка в коробку не добавлена!");
            return false;
        } else {
            parcels.add(parcel);
            return true;
        }
    }

    public void getAllParcels () {
        if (!parcels.isEmpty()) {
            for (T parcel : parcels) {
                System.out.println(parcel.getDescription());
            }
        } else {
            System.out.println("В коробке нет посылок!");
        }
    }
}
