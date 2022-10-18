package constants;

public enum CarMake {

    TESLA("Tesla"),
    JEEP("Jeep"),
    FORD("Ford"),
    CHEVROLET("Chevrolet");

    private CarMake (String make) {
        this.make = make;
    }
    private String make;
    public String getCarMake() {
        return make;
    }

}
