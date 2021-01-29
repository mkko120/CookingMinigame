package pl.trollcraft.alvion.cookingmech.recipes.flames;

public class FlameTime {

    private final int min;
    private final int max;

    /**
     * Parameter in Recipe responsible for:
     * @param min minimal time of cooking
     * @param max maximal time of cooking
     */

    public FlameTime(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return this.min;
    }

    public int getMax() {
        return this.max;
    }
}
