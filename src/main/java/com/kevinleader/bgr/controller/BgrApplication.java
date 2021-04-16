package com.kevinleader.bgr.controller;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Application for the BGR API
 */
@ApplicationPath("/api")

public class BgrApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(BgrApplication.class );
        return h;
    }
}