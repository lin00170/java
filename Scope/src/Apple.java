
public class Apple {
private double weight;
private static final double max_weight=300;
private static int instanceCount;

public Apple() {
	instanceCount++;
}
public double getWeight() {
	return weight;
}
public void setWeight(double weight) {
	this.weight=weight;
	
}
public static int getInstanceCount() {
	return instanceCount;
}
}

