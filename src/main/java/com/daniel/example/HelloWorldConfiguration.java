package com.daniel.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Each Dropwizard application has its own subclass of the Configuration class which specifies environment-specific parameters.
 * These parameters are specified in a YAML configuration file which is deserialized to an instance of your application’s configuration class and validated.
 * */

public class HelloWorldConfiguration extends Configuration{
    @NotEmpty
    private String template;
    @NotEmpty
    private String defaultName = "Stranger";

    @JsonProperty
    public String getTemplate() {
        return template;
    }
    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }
    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }
    @JsonProperty
    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }
}
