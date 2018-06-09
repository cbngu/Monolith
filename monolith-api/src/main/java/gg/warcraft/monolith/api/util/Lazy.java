package gg.warcraft.monolith.api.util;

import java.util.function.Supplier;

public class Lazy<T> implements Supplier<T> {
    private Supplier<T> supplier;

    private Supplier<T> lazySupplier = () -> {
        T value = supplier.get();
        lazySupplier = () -> value;
        supplier = null;
        return value;
    };

    public Lazy(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    @Override
    public T get() {
        return lazySupplier.get();
    }
}
