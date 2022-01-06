package com.gildedrose;

class GildedRose {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
        }
    }

    private void updateItemQuality(Item item) {
        if (!item.name.equals(AGED_BRIE) && !item.name.equals(BACKSTAGE)) {
            if (!item.name.equals(SULFURAS)) {
                item.adjustQuality(-1);
            }
        } else {
            item.adjustQuality(1);
            updateBackStage(item);
        }

        item.updateSellInForRegularItems();

        item.updateQualityForOutDatedItem();
    }

    private void updateBackStage(Item item) {
        if (item.name.equals(BACKSTAGE)) {
            if (item.sellIn < 11) item.adjustQuality(1);
            if (item.sellIn < 6) item.adjustQuality(1);
        }
    }
}
