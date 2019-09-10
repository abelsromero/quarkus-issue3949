package org.abelsromero.quarkus;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@Slf4j
@ApplicationScoped
public class C4pLifecycleBean {

    void onStart(@Observes StartupEvent ev) {
        logger.info("Server started: " + ev);
    }

    void onStop(@Observes ShutdownEvent ev) {
        logger.info("The application is stopping...");
    }

}
