// Fichier par Florian Portrait, Josué Raad, et Thibaud Devemy

package world;

import entity.*;
import entity.item.Item;
import entity.item.Key;
import entity.place.Place;
import game.MasterListEntity;

import java.util.Set;

import static game.MasterListEntity.*;
import static utils.Col.RED;

public class World implements WorldContains {

    // todo check victoire

    private final Player player;
    private boolean win;
    private Place currentPlace;
    private boolean end;

    public final Set<Entity> entities;
    public final Set<Item> items;
    public final Set<Place> places;
    public final Set<Hostile> hostiles;
    public final Set<Passive> passives;
    public final Set<Container> containers;


    public World(int difficulty) {
        if (difficulty < 0 || difficulty > 2)
            difficulty = 1;

        // difficulty formula
        int baseHp = (3 - difficulty) * 10;

        this.player = new Player(baseHp);
        this.end = false;
        this.win = false;
        this.currentPlace = null;

        entities = entityMasterList;

        items = getItems();
        places = getPlaces();
        hostiles = getHostiles();
        passives = getPassives();
        containers = getContainers();

        initPlayer(player);

/*        System.out.println(entities);
        System.out.println(items);
        System.out.println(places);
        System.out.println(hostiles);
        System.out.println(passives);
        System.out.println(containers);*/

    }


    public World() {
        this(1);
    }

    public Player getPlayer() {
        return player;
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

    public Place getPlace(String str) {
        return places.stream()
                     .filter(x -> x.isSameStr(str))
                     .findFirst()
                     .orElse(null);
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
        return "World { " + "\n" +
               "placeList = " + places + "\n" +
               ", currentPlace = " + currentPlace + "\n" +
               ", end = " + end + "\n" +
               ", win = " + win + "\n" +
               "player = " + player + "\n" +
               '}';
    }
}
