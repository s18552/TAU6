package zad1;

public class Note {
    String name;
    float number;
    public Note(String name, float number) {
        this.name = name;
        this.number = number;
    }

    public void setNumber(float number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public Float getNote() {
        return number ;
    }

    public void setName(String name) {
        this.name = name;
    }
}
