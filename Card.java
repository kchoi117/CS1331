public abstract class Card {
    String name;
    String description;
    public Card(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    //check with @Override
    public boolean equals() {
        return false;
    }

    public String toString() {
        return "test";
    }
}