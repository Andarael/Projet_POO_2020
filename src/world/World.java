// Fichier par Florian Portrait, Josué Raad, et Thibaud Devemy

package world;

import entity.*;
import entity.item.Item;
import entity.place.Place;
import game.MasterListEntity;

import java.util.Set;

import static game.MasterListEntity.*;

public class World {

    private final Player player;
    private boolean win;
    private Place currentPlace;
    private boolean end;

    private final Set<Entity> entities;
    private final Set<Item> items;
    private final Set<Place> places;
    private final Set<Hostile> hostiles;
    private final Set<Passive> passives;
    private final Set<Container> containers;


    public World(int difficulty) {
        if (difficulty < 0 || difficulty > 2)
            difficulty = 1;

        // difficulty formula
        int baseHp = (3 - difficulty) * 10;

        this.player = new Player(baseHp);
        this.end = false;
        this.win = false;
        this.currentPlace = null;

        entities = MasterListEntity.entityMasterList;

        items = getItems();
        places = getPlaces();
        hostiles = getHostiles();
        passives = getPassives();
        containers = getContainers();

    }


    public World() {
        this(1);
    }

    public Player getPlayer() {
        return player;
    }


    public boolean haveEntity(Entity e) {
        return entities.contains(e);
    }

    public boolean haveItem(Item item) {
        return items.contains(item);
    }

    public boolean havePlace(Place place) {
        return places.contains(place);
    }

    public boolean isCurrentPlace(Place place) {
        return currentPlace.equals(place);
    }

    public boolean haveHostile(Hostile hostile) {
        return hostiles.contains(hostile);
    }

    public boolean havePassive(Passive passive) {
        return passives.contains(passive);
    }

    public boolean isHere(Container container) {
        return false;
    }

    public boolean playerHaveItem(Item item) {
        return player.contains(item);
    }

    public boolean ContainerHaveItem(Container container, Item item) {
        return false;
    }


    public boolean isEnd() {
        return end;
    }

    public void end() {
        end = true;
    }

    public int size() {
        return places.size();
    }

    public boolean hasWin() {
        return win;
    }

    public void addPlace(Place place) {
        places.add(place);
    }

    public Place getAPlace(Place place) {
        return places.stream()
                     .filter(x -> x.equals(place))
                     .findFirst()
                     .orElse(null);
    }

    public Place getPlace(String str) {
        return getAPlace(new Place(str));
    }

    public Place getCurrentPlace() {
        return this.currentPlace;
    }

    public void setCurrentPlace(Place place) {
        this.currentPlace = place;
    }

    public void setCurrentPlace(String str) {
        Place place = getPlace(str);

        if (place != null)
            setCurrentPlace(place);
    }

    @Override
    public String toString() {
        return "World {" + "\n" +
               player + "\n" +
               ", placeList=" + places + "\n" +
               ", currentPlace=" + currentPlace + "\n" +
               ", end=" + end + "\n" +
               ", win=" + win + "\n" +
               '}';
    }
}
