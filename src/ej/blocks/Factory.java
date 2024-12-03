package ej.blocks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class Factory {

    private static ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
    private static Logger logger = LogManager.getLogger(Factory.class);

    private static Set<IBlock> createBlock(final Callable<IBlock> task, final int quantity){
        Set<IBlock> blocks = new LinkedHashSet<IBlock>();
        List<Callable<IBlock>> tasks = new ArrayList<Callable<IBlock>>();

        for (int i = 0; i < quantity; i++) {
            tasks.add(task);
        }

        try{
            List<Future<IBlock>> results = executorService.invokeAll(tasks);
            results.forEach((result) -> {

                try {
                    blocks.add(result.get());
                }catch (InterruptedException | ExecutionException e){
                    logger.error("Error during the creation of parallel blocks");
                }
            });
        }catch (InterruptedException e){
            logger.error("Error during the creation of parallel blocks");
        }
        return blocks;
    }
}
