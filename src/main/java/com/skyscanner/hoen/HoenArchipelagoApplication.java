package com.skyscanner.hoen;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.skyscanner.hoen.resources.SearchResource;
import com.skyscanner.hoen.services.SearchService;

public class HoenArchipelagoApplication extends Application<HoenArchipelagoConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HoenArchipelagoApplication().run(args);
    }

    @Override
    public String getName() {
        return "Hoen Archipelago Search";
    }

    @Override
    public void initialize(final Bootstrap<HoenArchipelagoConfiguration> bootstrap) {
        // Nothing to do yet
    }

    @Override
    public void run(final HoenArchipelagoConfiguration configuration,
                    final Environment environment) {
        // Initialize the search service with data files
        final SearchService searchService = new SearchService();
        
        // Register resources
        final SearchResource searchResource = new SearchResource(searchService);
        environment.jersey().register(searchResource);
    }
}
