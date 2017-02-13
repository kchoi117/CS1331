public enum VendingItem {
    LAYS(1.50), DORITOS(1.50), COKE(2.50), RAMBLIN_RECK_TOY(180.75), 
    RUBIKS_CUBE(30.00), RAT_CAP(15.00), FASET_LANYARD(10.00), 
    GRAPHING_CALCULATOR(120.00), UGA_DIPLOMA(0.10), PIE(3.14), 
    CHEETOS(1.25), SPRITE(2.50), RED_BULL(4.75), RAMEN(3.15);

    double price;
    private VendingItem(double price) {
        // enum constructors must be private (cannot change
        // instances of the enum outside of the class, since
        // they are strictly defined in the class)
        this.price = price;
    }

    // static vs non-static methods:
    // - static methods make sense to be called even if no object
    //   for that class has been constructed yet.
    //     + e.g. convertMpgToKpl() in class "car"

    // - non-static methods make sense to be called since it's
    //   inconceivable to call the method before the object has been
    //   constructed; 
    // - non-static methods must be cast on an instance of that class
    //     + e.g. setMilage() in class "car"

    public double getPrice() {
        return price;
        // price is a double, so it must be converted to a String type first.
    }

    public String toString() {
        return name() + " : $" + price;
    }
}