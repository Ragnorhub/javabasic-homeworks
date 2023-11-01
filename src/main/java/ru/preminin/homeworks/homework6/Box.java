package ru.preminin.homeworks.homework6;

public class Box {
    private int length;
    private int width;
    private int height;
    private String color;
    private boolean boxIsOpen;
    private boolean boxIsEmpty;
    private String thingInBox;

    public void getThingFromBox() {
        if (boxIsEmpty && !boxIsOpen) {
            System.out.println("Коробка закрыта и в ней пусто");
            System.out.println();
        }
        if (!boxIsEmpty && !boxIsOpen) {
            System.out.println("Коробка закрыта. В ней лежит: " + thingInBox);
            System.out.println();
        }
        if (boxIsEmpty && boxIsOpen) {
            System.out.println("Коробка открыта и в ней пусто");
            System.out.println();
        }
        if (!boxIsEmpty && boxIsOpen) {
            System.out.println("Коробка открыта. Забрали из неё: " + this.thingInBox);
            System.out.println();
            this.thingInBox = "";
            boxIsEmpty = true;
        }
    }

    public void setThingInBox(String thingInBox) {
        if (!boxIsEmpty && !boxIsOpen) {
            System.out.println("Коробка закрыта. В коробке лежит: " + thingInBox);
            System.out.println();
        }
        if (boxIsEmpty && !boxIsOpen) {
            System.out.println("Коробка закрыта. Хоть и пустая, но ничего нельзя положить в неё");
            System.out.println();
        }
        if (!boxIsEmpty && boxIsOpen) {
            System.out.println("Коробка открыта. Но в ней лежит: " + thingInBox + " Коробку надо освободить, что бы что " +
                    "то положить в неё");
            System.out.println();
        }
        if (boxIsEmpty && boxIsOpen) {
            this.thingInBox = thingInBox;
            System.out.println("Коробка открыта и пустая! Положили в коробку: " + thingInBox);
            System.out.println();
            boxIsEmpty = false;
        }
    }

    public Box(int length, int width, int height, String color, boolean boxIsOpen, boolean boxIsEmpty, String thingInBox) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.color = color;
        this.boxIsOpen = boxIsOpen;
        this.boxIsEmpty = boxIsEmpty;
        this.thingInBox = thingInBox;
    }

    public boolean isBoxIsOpen() {
        return boxIsOpen;
    }

    public void switchBoxOpenClose() {
        if  (boxIsOpen) {
            boxIsOpen = false;
            System.out.println("Закрыли коробку");
            System.out.println();
        } else {
            System.out.println("Открыли коробку");
            System.out.println();
            boxIsOpen = true;
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
        if (boxIsOpen) {
            System.out.println("Коробка открыта");
        } else {
            System.out.println("Коробка закрыта");
        }
        if (thingInBox.isEmpty()) {
            System.out.println("В коробке пусто");
        } else {
            System.out.println("В коробке находится: " + thingInBox);
        }
        System.out.println();
    }
}