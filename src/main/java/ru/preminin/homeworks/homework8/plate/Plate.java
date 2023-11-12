package ru.preminin.homeworks.homework8.plate;

public class Plate {
    int maxFoodAmount;
    int currentAmountOfFood;

    public Plate(int maxFoodAmount, int currentAmountOfFood) {
        this.maxFoodAmount = maxFoodAmount;
        this.currentAmountOfFood = currentAmountOfFood;
    }

    public void addFoodToAPlate(int amount) {
        if (currentAmountOfFood+ amount > maxFoodAmount) {
            System.out.println("В тарелку " + amount + " еды не влезет. Положите не больше " + (maxFoodAmount-currentAmountOfFood) + " еды.\n");
        } else {
            currentAmountOfFood += amount;
            System.out.println("Добавили в тарелку " + amount + " еды. В тарелке теперь " + currentAmountOfFood + " еды.\n");
        }
    }
    public boolean decreaseFoodToAPlate(int decreaseFood) {
        if (currentAmountOfFood - decreaseFood < 0) {
            System.out.println("Коту не хватит еды покушать. Он ушел голодный :,(\n");
            return false;
        } else {
            currentAmountOfFood -= decreaseFood;
            System.out.println("В тарелке теперь " + currentAmountOfFood + " еды.");
            return true;
        }
    }
}
