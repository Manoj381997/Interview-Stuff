package com.manoj.oodesign.LogisticSystem.domain;

public class Item {
    private String name;
    private int price;
    private int volume;
    private int weight;

    public Item(String name, int price, int volume, int weight) {
        this.name = name;
        this.price = price;
        this.volume = volume;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
