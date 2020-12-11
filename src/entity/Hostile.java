// Fichier par Josué Raad

package entity;

/**
 * An Hostile is a Being hostile toward the player
 */
public class Hostile extends Being {

    //todo check agressive value

    private final boolean agressive;

    public Hostile(String name, String shortName, String description, int hp, int power) {
        super(name, shortName, description, hp, power);
        this.agressive = true;
    }

    public Hostile(String name, String shortName, String description, int hp, int power, boolean aggr){
        super(name, shortName, description, hp, power);
        this.agressive = aggr;
    }

    public boolean isAgressive() {
        return agressive;
    }
}
