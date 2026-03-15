package ru.yandex.practicum.delivery;

public abstract class Parcel {
    //добавьте реализацию и другие необходимые классы
    protected final String description;
    protected final int weight;
    protected final String deliveryAddress;
    protected final int sendDay;

    protected Parcel (String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public int getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }

    public void packageItem () {
        System.out.println("Посылка " + description + " упакована.");
    }

    public void deliver() {
        System.out.println("Посылка " + description + " доставлена по адресу " + deliveryAddress);
    }

    public abstract int calculateDeliveryCost();

}
