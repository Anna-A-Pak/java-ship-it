package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Parcel> allParcels = new ArrayList<>();
    private static final ParcelBox<StandardParcel> standardParcelsBox = new ParcelBox<>(15);
    private static final ParcelBox<FragileParcel> fragileParcelsBox = new ParcelBox<>(7);
    private static final ParcelBox<PerishableParcel> perishableParcelsBox = new ParcelBox<>(10);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    showContentBox();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 - Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        System.out.println("Выберите тип посылки:");
        System.out.println("1 — Стандартная");
        System.out.println("2 — Хрупкая");
        System.out.println("3 — Скоропортящаяся");
        int choice = Integer.parseInt(scanner.nextLine());

        System.out.print("Укажите краткое описание: ");
        String description = scanner.nextLine();

        System.out.print("Укажите вес: ");
        int weight = Integer.parseInt(scanner.nextLine());
        if (weight <= 0) {
            System.out.println("Вес посылки должен быть больше нуля!");
            return;
        }

        System.out.print("Укажите адрес места назначения: ");
        String deliveryAddress = scanner.nextLine();

        System.out.print("Укажите день месяца, в который посылка была отправлена: ");
        int sendDay = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                StandardParcel standardParcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
                if (standardParcelsBox.addParcel(standardParcel)) {
                    allParcels.add(standardParcel);
                }
                break;
            case 2:
                FragileParcel fragileParcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
                if (fragileParcelsBox.addParcel(fragileParcel)) {
                    allParcels.add(fragileParcel);
                }
                break;
            case 3:
                System.out.print("Укажите срок в днях, за который посылка не испортится: ");
                int timeToLive = Integer.parseInt(scanner.nextLine());
                PerishableParcel perishableParcel = new PerishableParcel(description, weight, deliveryAddress,sendDay,
                        timeToLive);
                if (perishableParcelsBox.addParcel(perishableParcel)) {
                    allParcels.add(perishableParcel);
                }
                break;
            default:
                System.out.println("Неверный выбор.");
        }
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        if (!allParcels.isEmpty()) {
            for (Parcel parcel : allParcels) {
                parcel.packageItem();
                parcel.deliver();
            }
        } else {
            System.out.println("Нет добавленных посылок!");
        }
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        int sumCosts = 0;
        if (!allParcels.isEmpty()) {
            for (Parcel parcel : allParcels) {
                sumCosts+= parcel.calculateDeliveryCost();
            }
            System.out.println("Стоимость всех доставок составила: " + sumCosts);
        } else {
            System.out.println("Нет добавленных посылок!");
        }
    }

    private static void showContentBox() {
        System.out.println("Выберите тип коробки:");
        System.out.println("1 — Коробка стандартных посылок");
        System.out.println("2 — Коробка хрупких посылок");
        System.out.println("3 — Коробка скоропортящихся посылок");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                standardParcelsBox.getAllParcels();
                break;
            case 2:
                fragileParcelsBox.getAllParcels();
                break;
            case 3:
                perishableParcelsBox.getAllParcels();
                break;
            default:
                System.out.println("Неверный выбор.");
        }
    }
}

