package concepts.dagger;

import com.google.inject.Inject;

public class Car {
    private Engine engine;
    private Brand brand;

    @Inject
    public Car(Engine engine, Brand brand) {
        this.engine = engine;
        this.brand = brand;
    }
}

class Engine {

}

class Brand {

}
