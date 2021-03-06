package gg.warcraft.monolith.api;

import com.google.inject.Injector;
import com.google.inject.Module;

import java.util.ArrayList;
import java.util.List;

/**
 * Monolith is the gateway to all other implementations. It allows you to retrieve the injector used to provide all
 * injectable instances.
 * <p>
 * The Monolith plugin will instantiate an instance and give it the injector, all you have to do
 * is grab the instance via the static method and use the injector to instantiate your top level classes or create a
 * child injector if you have modules to add of your own.
 */
public class Monolith {
    private static final List<Module> modules = new ArrayList<>();

    private static Monolith instance;

    public static Monolith getInstance() {
        return instance;
    }

    public static List<Module> getModules() {
        return new ArrayList<>(modules);
    }

    public static void registerModule(Module module) {
        modules.add(module);
    }

    private final Injector injector;

    public Monolith(Injector injector) {
        this.injector = injector;
        if (Monolith.instance == null) {
            Monolith.instance = this;
        } else {
            throw new IllegalStateException("Monolith can not be instantiated twice. Use the static getInstance method instead.");
        }
    }

    public Injector getInjector() {
        if (injector == null) {
            throw new IllegalStateException("Monolith injector was requested without being initialized. Did Monolith load correctly?");
        }
        return injector;
    }
}
