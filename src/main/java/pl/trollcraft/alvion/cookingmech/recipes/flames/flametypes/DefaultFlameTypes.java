package pl.trollcraft.alvion.cookingmech.recipes.flames.flametypes;

import pl.trollcraft.alvion.cookingmech.Storage;
import pl.trollcraft.alvion.cookingmech.recipes.flames.FlameType;

import java.util.ArrayList;

public class DefaultFlameTypes {

    public static void load() {
        Storage.flameTypes.add(new FlameType("No Flame", 0));
        Storage.flameTypes.add(new FlameType("Small Flame", 1));
        Storage.flameTypes.add(new FlameType("Medium Flame", 2));
        Storage.flameTypes.add(new FlameType("Normal Flame", 3));
        Storage.flameTypes.add(new FlameType("Big Flame", 4));
    }
}
