package Zomato-System-Design.models;

import Zomato-System-Design.models.MenuItem;
import java.util.ArrayList;
import java.util.List;

public class Restaurant{
    private static int nextRestaurantId=0;
    private int restaurantId;
    private String name;
    private String location;
    private List<MenuItem> menu=new ArrayList<>();

    public Restaurant(String name,String location) {
        this.name=name;
        this.location=location;
        this.restaurantId=++nextRestaurantId;
    }
    private String getName(){
        return name;
    }
    private void setName(String n){
        name=n;
    }
    private String getLocation(){
        return location;
    }
    private void setLocation(String l){
        location=l;
    }
    public void addMenuItem(MenuItem item){
        menu.add(item);
    }

    public List<MenuItem> getMenu(){
        return menu;
    }
    
}