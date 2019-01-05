import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.TotodileWatcher;
import managers.TotodileWatchersManager;
import io.javalin.Javalin;

import java.util.List;

//todo: null handling right now handled in manager, consider if needed different approach
public class TotodileMain {

    //todo: consider moving to swagger on top of dropwizard
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static TotodileWatchersManager watchersManager = null;

    public static void main(String[] args) {

        Javalin javalin = Javalin.create();

        javalin.post("/configuration", ctx -> {
            try {
                List<TotodileWatcher> watcherList = objectMapper.readValue(ctx.body(),
                        new TypeReference<List<TotodileWatcher>>() {});
                stop();
                watchersManager = new TotodileWatchersManager(watcherList);
                boolean result = watchersManager.startAllWatchers();
                if (result) {
                    ctx.status(200);
                }
            } catch (Throwable ex) {
                ex.printStackTrace();
                ctx.status(500);
            }
        });

        javalin.post("/stop", ctx -> {
            stop();
        });

        javalin.post("/restart", ctx -> {
            restart();
        });


        javalin.start(7575);

    }

    private static void restart() {
        stop();
        watchersManager.startAllWatchers();
    }

    private static void stop() {
        if (watchersManager != null) {
            watchersManager.stopAllWatchers();
        }
    }

}
