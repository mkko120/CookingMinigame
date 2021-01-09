package pl.trollcraft.alvion.cookingmech.recipes.flames;

import pl.trollcraft.alvion.cookingmech.Storage;

public class FlameTypeController {

    /**
     * Method used for finding FlameType in registered FlameTypes.
     * @param name name of FlameType.
     * @return FlameType equivalent to name.
     */

    public FlameType find(String name) {
        for (FlameType flame : Storage.flameTypes) {
            if (flame.getType().equalsIgnoreCase(name)) {
                return flame;
            }
        }
        return null;
    }
}
