package com.gildedrose;

import java.util.Objects;

public class Item {
    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return sellIn == item.sellIn && quality == item.quality && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sellIn, quality);
    }

    void adjustQuality(int adjustment) {
        int newQuality = quality + adjustment;
        boolean isInRange = newQuality <= 50 && newQuality > 0;
        if (isInRange) quality = newQuality;
    }

    void updateSellInForRegularItems() {
        if (!name.equals(GildedRose.SULFURAS)) sellIn = sellIn - 1;
    }

    void updateQualityForOutDatedItem() {
        if (sellIn < 0) {
            if (!name.equals(GildedRose.AGED_BRIE)) {
                if (!name.equals(GildedRose.BACKSTAGE)) {
                    if (!name.equals(GildedRose.SULFURAS)) {
                        adjustQuality(-1);
                    }
                } else quality = 0;
            } else adjustQuality(1);
        }
    }
}
