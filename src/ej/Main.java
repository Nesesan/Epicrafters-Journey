package ej;


import ej.blocks.*;
import ej.exceptions.IllegalBlockException;
import ej.kits.StarterKit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.*;


public class Main {

    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Starting the Epicrafter's Journey program.");

        try {
            // The program begins with a Starter Kit.
            StarterKit kit = new StarterKit(constructBlockSet());
            System.out.println("You have a starter kit!");

            System.out.println(
                    "What would you like to display?" +
                            "\n\t1 - Construction ideas." +
                            "\n\t2 - The number of blocks for each type of block present in the kit."
            );

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String response = reader.readLine();

            if (response.equals("1")) {
                // Displays keywords associated with the Kit to provide ideas to the user.
                System.out.println("Here are some construction ideas with the Starter Kit:");
                Set<String> keywords = kit.getKeywords();
                keywords.forEach(System.out::println);
            } else if (response.equals("2")) {
                // Displays to the user the number of blocks per type contained in the Kit.
                System.out.println("Here is the number of blocks of each type contained in the Starter Kit:");
                Map<Type, Integer> blockQuantity = new TreeMap<>(); // TreeMap sorts entries alphabetically by key.
                kit.getBlocks().forEach((block) -> {
                    Type type = Type.valueOf(block.getClass().getSimpleName().toUpperCase());
                    int quantity = blockQuantity.getOrDefault(type, 0) + 1; // Existing quantity + 1.
                    blockQuantity.put(type, quantity);
                });
                Set<Type> types = blockQuantity.keySet();
                types.forEach((type) -> {
                    System.out.println(type.toString() + " " + blockQuantity.get(type));
                });
            } else {
                System.out.println("The entered value is invalid - type 1 or 2.");
            }
        } catch (IllegalBlockException e) {
            System.out.println("Unable to construct the Starter Kit.");
        } catch (IOException e) {
            logger.error("Unable to retrieve user input.");
        }

        logger.info("Stopping the Epicrafter's Journey program.");
    }

    private static Set<IBlock> constructBlockSet() throws IllegalBlockException {
        Set<IBlock> blocks = new LinkedHashSet<>();

        ExecutorService executorservice = Executors.newVirtualThreadPerTaskExecutor();

        Callable<IBlock> taskWall1 = () -> {
            return new Wall(3, 2, 2, true);
        };
        Callable<IBlock> taskWall2 = () -> {
            return new Wall(2, 1, 2, false);
        };
        Callable<IBlock> taskDoor = () -> {
            return new Door(1, 2, 2, true);
        };
        Callable<IBlock> taskRoof = () -> {
            return new Roof(3, 1, 1);
        };

        List<Callable<IBlock>> tasks = Arrays.asList(taskWall1, taskWall1, taskWall2, taskWall2, taskDoor, taskRoof);

        try {

            List<Future<IBlock>> results = executorservice.invokeAll(tasks);
            results.forEach((result) -> {
                try {
                    blocks.add(result.get());
                } catch (InterruptedException | ExecutionException e) {
                    logger.error("Error during the creation of parallel blocks");
                }
            });
        } catch (InterruptedException e) {
            logger.error("Error during the creation of parallel blocks");
        }
        executorservice.shutdown();
        return blocks;
    }
}

