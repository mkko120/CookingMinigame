package pl.trollcraft.alvion.cookingmech.recipes.flames.flametypes;

import pl.trollcraft.alvion.cookingmech.recipes.flames.FlameType;

import java.util.ArrayList;

public class DefaultFlameTypes {

    public static ArrayList<FlameType> load() {
        ArrayList<FlameType> flameTypes = new ArrayList<>();
        flameTypes.add(new FlameType("No Flame", 0));
        flameTypes.add(new FlameType("Small Flame", 1));
        flameTypes.add(new FlameType("Medium Flame", 2));
        flameTypes.add(new FlameType("Normal Flame", 3));
        flameTypes.add(new FlameType("Big Flame", 4));
        return flameTypes;
    }
}
