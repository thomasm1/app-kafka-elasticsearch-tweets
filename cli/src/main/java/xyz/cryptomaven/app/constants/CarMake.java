package xyz.cryptomaven.app.constants;

public enum CarMake {

    TESLA("Tesla"),  //0
    JEEP("Jeep"),  //1
    FORD("Ford"),  //2
    CHEVROLET("Chevrolet"),  //3
    TOYOTA(""),  //4
    HONDA(""),  //5
    RAM("");  //6


    private CarMake (String make) {
        this.make = make;
    }
    private String make;
    public String getCarMake() {
        return make;
    }

}
