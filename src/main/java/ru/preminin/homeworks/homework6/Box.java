package ru.preminin.homeworks.homework6;

public class Box {
    private final int length;
    private final int width;
    private final int height;
    private String color;
    private boolean isOpen;
    private String thingInBox;

    public void getThingFromBox() {
        if (!isOpen) {
            System.out.println("Коробка закрыта.Что бы что то достать из неё, коробку надо открыть\n");
        }
        if (thingInBox.equals("пусто")) {
            System.out.println("В коробке пусто. Ничего не достать.\n");
        } else {
            System.out.println("Достали из коробки: " + thingInBox + " Теперь в коробке пусто\n");
            thingInBox = "пусто";
        }
    }

    public void setThingInBox(String thingInBox) {
        if (!isOpen) {
            System.out.println("Коробка закрыта.Что бы что то положить в неё, коробку надо открыть\n");
        }
        if (this.thingInBox.equals("пусто")) {
            System.out.println("Положили в коробку: " + thingInBox + "\n");
            this.thingInBox = thingInBox;
        } else {
            System.out.println("В коробке уже находится: " + this.thingInBox + " Новое не положить\n");
        }
    }

    public Box(int length, int width, int height, String color, boolean IsOpen, String thingInBox) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.color = color;
        this.isOpen = IsOpen;
        this.thingInBox = thingInBox;
    }

    public boolean isBoxIsOpen() {
        return isOpen;
    }

    public void switchBoxOpenClose() {
        if (isOpen) {
            isOpen = false;
            System.out.println("Закрыли коробку\n");
        } else {
            isOpen = true;
            System.out.println("Открыли коробку\n");
        }
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void info() {
        System.out.println("Размеры коробки: Длина: " + length + " Ширина: " + width + " Высота: " + height);
        System.out.println("Цвет коробки: " + color);
        if (isOpen) {
            System.out.println("Коробка открыта");
        } else {
            System.out.println("Коробка закрыта");
        }
        if (thingInBox.equals("пусто")) {
            System.out.println("В коробке пусто\n");
        } else {
            System.out.println("В коробке находится: " + thingInBox + "\n");
        }
    }
}