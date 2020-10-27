package concepts.dagger;

import com.google.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class VehicleModule {
    @Provides
    public Engine provideEngine() {
        return new Engine();
    }

    @Provides
    @Singleton
    public Brand provideBrand() {
        return new Brand();
    }
}
