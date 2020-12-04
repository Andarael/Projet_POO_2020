package item;

public class LimitedInventory extends Inventory {

    private static final double DEFAULT_CAPACITY = 15.0;
    private final double capacity;

    public LimitedInventory() {
        this(DEFAULT_CAPACITY);
    }

    public LimitedInventory(double capacity) {
        super();
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    @Override
    public boolean addItem(Item item) {
        if (canAddItem(item)) {
            return super.addItem(item);
        }
        return false;
    }

    public boolean canAddItem(Item item) {
        double d = item.getWeight();
        return capacity > (d + getUsedCapacity());
    }

    public double getUsedCapacity() {
        return itemList.stream()
                       .mapToDouble(Item::getWeight)
                       .sum();
    }
}
