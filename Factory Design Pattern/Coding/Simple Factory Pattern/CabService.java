//Step 1: Create Interface
interface UBER{
    void ride();
}

//Step 2: Create concrete classes
public class CabService implements UBER{
    @Override
    public void ride(){
        System.out.println("Cab is booked with Uber");
    }
}

class AutoService implements UBER{
    @Override
    public void ride(){
        System.out.println("Auto is booked with Uber");
    }
}

class BikeService implements UBER{
    @Override
    public void ride(){
        System.out.println("Bike is booked with Uber");
    }
}

//Step 3: Create factory class
class UberFactory{
    public static UBER bookUber(String ride){
        if(ride.equals("cab")){
            return new CabService();
        }
        if(ride.equals("auto")){
            return new AutoService();
        }
        if(ride.equals("bike")){
            return new BikeService();
        }

        return null;
    }
}

class Main{
    public static void main(String[] args) {
        UBER u= new UberFactory().bookUber("bike");
        u.ride();
    }
}