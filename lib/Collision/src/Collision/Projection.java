package Collision;

public class Projection {

    private final double min;
    private final double max;

    public Projection(double min, double max) {
        this.min = min;
        this.max = max;
    }
	
    public boolean overlaps(Projection proj) {
        return !(this.min > proj.max || proj.min > this.max);
    }
}
