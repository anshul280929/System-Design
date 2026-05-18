package Zomato-System-Design.models;

public class Cart {
    public Cart(Restaurants restaurants, List<MenuItem> items) {
        this.restaurants = restaurants;
        this.items = items;
    }

    private Restaurants restaurants;

    private List<MenuItem> items;

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    public Restaurants getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Restaurants restaurants) {
        this.restaurants = restaurants;
    }
}
