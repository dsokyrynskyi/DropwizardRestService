package com.daniel.example;

import com.daniel.example.health.TemplateHealthCheck;
import com.daniel.example.resources.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HelloWorldApplication extends Application<HelloWorldConfiguration>{

    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public void run(HelloWorldConfiguration helloWorldConfiguration, Environment environment) throws Exception {
        //
        HelloWorldResource helloWorldResource = new HelloWorldResource( helloWorldConfiguration.getTemplate(),
                                                                        helloWorldConfiguration.getDefaultName() );
        environment.jersey().register(helloWorldResource);
        //
        TemplateHealthCheck templateHealthCheck = new TemplateHealthCheck(helloWorldConfiguration.getTemplate());
        environment.jersey().register(templateHealthCheck);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        //
    }
}
