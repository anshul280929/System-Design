class User{
    public User(int userId, String name, String addr, Cart cart) {
        this.userId = userId;
        this.name = name;
        this.addr = address;
        this.cart = new Cart();
    }

    private int userId;
    private String name;
    private String addr;
    private Cart cart;

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String a) {
        address = a;
    }

    public Cart getCart() {
        return cart;
    }
}