package ej.kits;


import ej.blocks.IBlock;
import ej.exceptions.IllegalBlockException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class StarterKit {

    Logger logger = LogManager.getLogger(StarterKit.class);

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
        System.out.println("Number of blocks in the kit: " + blocks.size());
        System.out.println("List of keywords: ");
        keywords.forEach(System.out::println);
    }

    public void save() {
        StringBuilder builder = new StringBuilder();
        builder.append("StarterKit\n");
        keywords.forEach((keyword) -> builder.append("\t" + keyword + "\n"));

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("StarterKit.txt"));
            writer.write(builder.toString());
            writer.close();
        } catch (IOException e) {
            logger.error("Unable to write in the file");
        }
    }

}

