

import java.awt.*;
import java.util.*;

public class CarTransport extends Truck {

    private CarStorage carStorage;

    public CarTransport(int maxCapacity) {
        super(2, Color.yellow, 300, "GamlaBettan", new Flatbed());
        this.carStorage = new CarStorage(getPosition(), maxCapacity);
    }

    public ArrayList<Car> getLoadedCars() {
        return carStorage.getLoadedCars();
    }

    public void lowerPlatform() {
        if (getCurrentSpeed() == 0) {
            platform.lowerPlatform();
        }
    }

    public void raisePlatform() {
        platform.raisePlatform();
    }

    public void loadCar(Car car) {
        if (platform.isDown()) {
            carStorage.loadCar(car);
        }
    }

    public void unloadCar(Car car) {
        if (platform.isDown()) {
            carStorage.unloadCar(car);
        }
    }

    public iPlatform getPlatform() {
        return platform;
    }

    @Override
    public double speedFactor() {
        if (platform.isUp()) {
            return getEnginePower() * 0.01;
        } else {
            return 0.0;
        }
    }
}
