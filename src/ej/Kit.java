package ej;

import java.util.LinkedHashSet;
import java.util.Set;

public class Kit {

    Set<IBlock> blocks = new LinkedHashSet<IBlock>();
    Set<String> keywords = new LinkedHashSet<String>();

    public Kit() {
        blocks.add(new Wall(3,2,2,true));
        blocks.add(new Wall(3,2,2,true));
        blocks.add(new Wall(2,1,2,false));
        blocks.add(new Wall(2,1,2,false));
        blocks.add(new Door(1,2,2,true));

        keywords.add("Cabin");
        keywords.add("Rampart");
    }

    public void displayKit(){
        int cpt = 0;

        System.out.println("Number of blocks in the kit: " + blocks.size());
        for (String keyword : keywords) {
            cpt++;
            System.out.println("Keyword " + cpt + " : "  + keyword);
        }
    }
}
