package ru.preminin.homeworks.homework6;

public class Box {
    private final int length;
    private final int width;
    private final int height;
    private String color;
    private boolean IsOpen;
    private String thingInBox;

    public void getThingFromBox() {
        if (!IsOpen) {
            System.out.println("Коробка закрыта.Что бы что то достать из неё, коробку надо открыть\n");
            return;
        }
        if (thingInBox.equals("пусто")) {
            System.out.println("В коробке пусто. Ничего не достать.\n");
        } else {
            System.out.println("Достали из коробки: " + thingInBox + " Теперь в коробке пусто\n");
            thingInBox = "пусто";
        }
    }

    public void setThingInBox(String thingInBox) {
        if (!IsOpen) {
            System.out.println("Коробка закрыта.Что бы что то положить в неё, коробку надо открыть\n");
            return;
        }
        if (!thingInBox.equals("пусто")) {
            this.thingInBox = thingInBox;
            System.out.println("Положили в коробку: " + thingInBox + "\n");
            return;
        } else {
            System.out.println("В коробке уже находится: " + this.thingInBox + " Новое не положить\n");
        }
    }

    public Box(int length, int width, int height, String color, boolean IsOpen, String thingInBox) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.color = color;
        this.IsOpen = IsOpen;
        this.thingInBox = thingInBox;
    }

    public boolean isBoxIsOpen() {
        return IsOpen;
    }

    public void switchBoxOpenClose() {
        if (IsOpen) {
            IsOpen = false;
            System.out.println("Закрыли коробку\n");
        } else {
            System.out.println("Открыли коробку\n");
            IsOpen = true;
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
        if (IsOpen) {
            System.out.println("Коробка открыта");
        } else {
            System.out.println("Коробка закрыта");
        }
        if (thingInBox.equals("пусто")) {
            System.out.println("В коробке пусто");
        } else {
            System.out.println("В коробке находится: " + thingInBox);
        }
        System.out.println();
    }
}