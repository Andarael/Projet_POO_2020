// fichier par josué et Thibaut

package command;

import entity.place.Exit;
import entity.place.Place;
import world.World;

import static utils.Printer.printErr;
import static utils.Printer.printMsg;
import static world.WorldContains.isAPlace;

public interface Go {
    static void go(World world, Place currentPlace, String arg1) {

        if (!isAPlace(world, arg1)) {
            printErr(arg1 + " is not a place");
            return;
        }

        Exit destination = currentPlace.getExitByName(arg1);

        if (destination == null) {
            printErr("You can't access " + arg1 + " from here");
            return;
        }

        if (destination.goIn() == null) {
            printMsg("This door is locked");
            return;
        }

        world.setCurrentPlace(destination.getDestination());
        printMsg("You enter " + destination.getName());
        printMsg("\n");

        destination.getDestination().draw();

        Attack.checkFight(world);
    }
}
