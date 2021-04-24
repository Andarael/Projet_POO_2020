// fichier par josué Raad

package model.command;

import model.entity.Entity;
import model.entity.place.Place;

import static model.utils.Printer.printErr;

public interface Look {
    static void look(Place currentPlace) {
        currentPlace.look();
    }

    static void look(Place currentPlace, String arg1) {
        Entity entity = currentPlace.getContainerByName(arg1);
        if (entity != null) {
            entity.look();
        } else {
            printErr("You can't look at " + arg1 + " from here");
        }
    }
}