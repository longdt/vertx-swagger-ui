package net.vinid.vertx.swagger.generator;

import java.lang.reflect.Type;

public class Property {
    private String name;
    private Type type;

    public Property(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Property{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
