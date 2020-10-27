package concepts.dagger;

import com.google.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = VehicleModule.class)
public interface VehicleComponent {
    Car buildCar();
}
