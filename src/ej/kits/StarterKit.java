package ej.kits;


import ej.blocks.IBlock;
import ej.exceptions.IllegalBlockException;

import java.util.LinkedHashSet;
import java.util.Set;

public class StarterKit {

    Set<IBlock> blocks = new LinkedHashSet<IBlock>();
    Set<String> keywords = new LinkedHashSet<String>();

    public Set<IBlock> getBlocks() {
        return blocks;
    }

    public Set<String> getKeywords() {
        return keywords;
    }

    public StarterKit(final Set<IBlock> blocks) throws IllegalBlockException {
        this.blocks.addAll(blocks);

        keywords.add("Cabin");
        keywords.add("Rampart");
        keywords.add("House");
    }

    public void displayKit() {
        int cpt = 0;

        System.out.println("Number of blocks in the kit: " + blocks.size());
        for (String keyword : keywords) {
            cpt++;
            System.out.println("Keyword " + cpt + " : " + keyword);
        }
    }
}
