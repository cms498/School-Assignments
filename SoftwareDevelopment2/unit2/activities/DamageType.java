package activities;

public enum DamageType {
    HEAVY ("Heavy"),
    NORMAL ("Normal"),
    ION ("ION");

    private String blaster_color;

    private DamageType(String color){
        this.blaster_color = color;
    }

    @Override
    public String toString(){
        return blaster_color;
    }
}
