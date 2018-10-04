package ordersystem;
import java.util.ArrayList;

public class OrderSystem {

    public static class Product {
        public String name;
        public float price;
        public String description;
        public int prepTime;
        
        public Product(String itemName, float itemPrice, String desc, int time) {
            name = itemName;
            price = itemPrice;
            description = desc;
            prepTime = time;
        }
        
        public void editName(String newName) {
            name = newName;
        }
        
        public void editPrice(float newPrice) {
            price = newPrice;
        }
        
        public void editDesc(String newDesc) {
            description = newDesc;
        }
        
        public void editTime(int newTime) {
            prepTime = newTime;
        }
    }
    
    public static class Order {
        public ArrayList<Product> items = new ArrayList<>();
        public int id;
        public float totalPrice;
        public int totalPrep;
        
        public Order(int newId) {
            id = newId;
        }
        
        public float getPrice() {
            for (Product item : items) {
                totalPrice += item.price;
            }
            return totalPrice;
        }
        
        public float getTime() {
            for (Product item : items) {
                totalPrep += item.prepTime;
            }
            return totalPrep;
        }
        
        public void addToOrder(Product newItem, int itemCount) {
            for(int i = 0; i < itemCount; i ++) {
                items.add(newItem);
            }
        }
    }
    
    
    public static void main(String[] args) {
        Product item1 = new Product("item1", (float)10.5, "Item 1 description", 5);
        Product item2 = new Product("item2", (float)9.0, "Item 2 description", 4);
        Product item3 = new Product("item3", (float)5.5, "Item 3 description", 2);
        Product item4 = new Product("item4", (float)2.5, "Item 4 description", 1);
        
        //List<Orders> orderList = new ArrayList<Orders>;   
        
        Order order1 = new Order(1);
        order1.addToOrder(item1, 1);
        System.out.print("Price: " + order1.getPrice());
        System.out.print(" || Time: " + order1.getTime());
    }
    
}
