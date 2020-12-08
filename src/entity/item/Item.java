package entity.item;

import entity.Entity;

/**
 * An item is an Entity with some special values :
 * A weight and a value (in gold)
 * value can't be negative.
 * If an item is miss constructed, default values are used to avoid an ill formed item.
 * All items have a prefix to know of which type it is.
 *
 * An Item is comparable to another lexicographically.
 */
public class Item extends Entity implements Comparable<Item> {

    public static final double DEFAULT_WEIGHT = 0.1;
    public static final int DEFAULT_VALUE = 0;

    private final double weight;
    private final int value;

    public Item(String name, String description, double weight, int value) {
        super(name, description);

        // on autorise les poids négatifs, par ex pour un item qui ajout de la capacité de port
        this.weight = weight;

        // on n'autorise pas de valeur négative.
        if (value < 0)
            this.value = DEFAULT_VALUE;
        else
            this.value = value;
    }

    public Item(String name, double weight, int value) {
        this(name, null, weight, value);
    }

    public Item(String name, String description) {
        this(name, description, DEFAULT_WEIGHT, DEFAULT_VALUE);
    }

    public Item(String name) {
        this(name, null);
    }

    public double getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public String getDisplay() {
        return getPrefix() + getSimpleDisplay() +
               ", weight : " + weight +
               ", value : " + value;
    }

    public String getPrefix() {
        return "ITEM : ";
    }

    @Override
    public int compareTo(Item item) {
        if (item == null)
            return 0;
        return this.getName().compareTo(item.getName());
    }
}
