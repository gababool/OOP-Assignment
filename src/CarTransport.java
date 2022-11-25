package src;
import java.awt.*;
import java.util.*;


public class CarTransport extends Car{
    
    private Flatbed platform;
    private Stack<Car> loadedCars;
    private double reasonableDistance = 2;
    
    public CarTransport(){
        super(2, Color.yellow, 300, "GamlaBettan");
        this.platform = new Flatbed();
        this.loadedCars = new Stack<Car>();
    }

    public Stack<Car> getLoadedCars() {
        return loadedCars;
    }

    public void lowerPlatform(){
        if (currentSpeed == 0) {
            platform.lowerPlatform();
        }
        
    }
    public void raisePlatform() {
        platform.raisePlatform();
    }

    public void loadCar(Car other){
        double x1 = getPosition().getX();
        double x2 = other.getPosition().getX();
        double y1 = getPosition().getY();
        double y2 = other.getPosition().getY();
        if (getPosition().calculateDistance(x1, x2, y1, y2) <= reasonableDistance && platform.isUp() == false){
            loadedCars.push(other);

            // Need to delete the car once loaded.

        }      
    }

    public void unloadCar(){
        double x = getPosition().getX();
        double y = getPosition().getY();
        if (platform.isUp() == false){
            loadedCars.pop();
          
            // Need to spawn the car once unloaded.
        }
    }

    @Override
    public double speedFactor(){
        if (platform.isUp() == true){
            return getEnginePower() * 0.01;
        }
        else {return 0.0;}
    }
    

}
