package pl.trollcraft.alvion.cookingmech.recipes.flames;

public class FlameType {

    private String type;
    private int power;

    public FlameType(String type, int power) {
        this.type = type;
        this.power = power;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
