package ordersystem;
import java.util.*;
import java.util.Scanner;

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
        
        public int getTime() {
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
        
        ArrayList<Order> orderList = new ArrayList<>();
        ArrayList<Product> allProducts = new ArrayList<>();
        
        Product item1 = new Product("item1", (float)10.5, "Item 1 description", 5);
        allProducts.add(item1);
        Product item2 = new Product("item2", (float)9.0, "Item 2 description", 4);
        allProducts.add(item2);
        Product item3 = new Product("item3", (float)5.5, "Item 3 description", 2);
        allProducts.add(item3);
        Product item4 = new Product("item4", (float)2.5, "Item 4 description", 1);
        allProducts.add(item4);
        
        Scanner scan = new Scanner(System.in);
        
        int decider = 0;
        int orderId = 1;
        while(decider != 3){
            System.out.print("1. New Order \n2. New Product \n3. End Session \n");
            decider = scan.nextInt();
            
            if(decider == 1){
                Order newOrder = new Order(orderId);
                orderId++;
                
                int deciderO = 0;
                while(deciderO != 2) {
                    System.out.print("1. Add Item \n2. Finish Order \n");
                    deciderO = scan.nextInt();
                    
                    if (deciderO == 1) {
                        int i = 1;
                        for(Product item : allProducts) {
                            System.out.print(i+". "+item.name+"\n");
                            i++;
                        }
                        int nextItem = scan.nextInt();
                        
                        System.out.print("Enter the Quantity: ");
                        int quantity = scan.nextInt();
                        
                        switch(nextItem) {
                            case 1: newOrder.addToOrder(item1, quantity);
                                    break;
                            case 2: newOrder.addToOrder(item2, quantity);
                                    break;
                            case 3: newOrder.addToOrder(item3, quantity);
                                    break;
                            case 4: newOrder.addToOrder(item4, quantity);
                                    break;
                        }
                    }
                }
                orderList.add(newOrder);
                System.out.print("Order: " + newOrder.id);
                System.out.print(" || Price: " + newOrder.getPrice());
                System.out.print(" || ETA: " + newOrder.getTime() + "\n");
            }
            if(decider == 2){
                System.out.print("Enter the product name: ");
                String newName = scan.next();
                System.out.print("Enter the product price: ");
                float newPrice = scan.nextFloat();
                System.out.print("Enter the product description: ");
                String newDesc = scan.next();
                System.out.print("Enter the product preparation time: ");
                int newPrep = scan.nextInt();
                Product newProduct = new Product(newName, newPrice, newDesc, newPrep);
                allProducts.add(newProduct);
                System.out.print("Product added \n");
            }
        } 
    } 
}
