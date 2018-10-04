package ordersystem;
import java.util.ArrayList;

public class OrderSystem {

    public static class Product {
        private String name;
        private float price;
        private String description;
        private int prepTime;
        
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
    
    public class Order {
        private Product items[];
        private int id;
        private float totalPrice;
        private int totalPrep;
        
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
                totalPrice += item.prepTime;
            }
            return totalPrep;
        }
        
        public void addToOrder(Product newItem, int itemCount) {
            for(int i = 0; i < itemCount; i ++) {
                items[i] = newItem;
            }
        }
    }
    
    
    public static void main(String[] args) {
        Product item1 = new Product("item1", (float)10.5, "Item 1 description", 5);
        Product item2 = new Product("item2", (float)9.0, "Item 1 description", 4);
        Product item3 = new Product("item3", (float)5.5, "Item 1 description", 2);
        Product item4 = new Product("item4", (float)2.5, "Item 1 description", 1);
        
        //List<Orders> orderList = new ArrayList<Orders>;        
    }
    
}
