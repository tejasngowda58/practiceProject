package practice.OOP;

import java.util.ArrayList;
import java.util.List;

public class BirdsList {
    private List<Bird> birds;

    public BirdsList(){
        birds = new ArrayList<>();
    }

    public List<Bird> getBirds() {
        return birds;
    }

    public void setBirds(List<Bird> birds) {
        this.birds = birds;
    }
}
