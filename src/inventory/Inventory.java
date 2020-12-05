package inventory;

import item.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory implements InventoryManagement {
    protected final List<Item> itemList;

    public Inventory() {
        this.itemList = new ArrayList<>();
    }

    @Override
    public int getNbItems() {
        return itemList.size();
    }

    @Override
    public boolean isEmpty() {
        return itemList.isEmpty();
    }

    @Override
    public Item getItem(String s) {
        return itemList.stream()                            // stream de la liste d'items
                       .filter(x -> x.getName().equals(s))  // on filtre les items du même nom
                       .findAny()                           // on en retourne un
                       .orElse(null);                 // si rien alors null
    }

    @Override
    public Item getFirstItem() {
        return itemList.stream()
                       .findFirst()
                       .orElse(null);
    }

    @Override
    public boolean addItem(Item item) {
        itemList.add(item);
        return true;
    }


    @Override
    public boolean removeItem(Item item) {
        if (!this.contains(item))
            return false;

        itemList.remove(item);
        return true;
    }

    @Override
    public boolean removeItem(String s) {
        return this.removeItem(this.getItem(s));
    }

    @Override
    public void removeAllItems() {
        itemList.clear();
    }

    @Override
    public boolean contains(Item item) {
        return itemList.contains(item);
    }

    @Override
    public boolean contains(String s) {
        return contains(getItem(s));
    }

    @Override
    public int getQuantity(Item item) {
        return (int) itemList.stream()
                             .filter(x -> x.equals(item))
                             .count();
    }

    @Override
    public int getQuantity(String s) {
        return getQuantity(getItem(s));
    }

    @Override
    public String toString() {
        return "Inventory{" +
               "itemList=" + itemList +
               ", nbItems=" + itemList.size() +
               '}';
    }
}
