package product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ProductManager extends Product implements Comparator<Product>{
    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(int id) {
        if (getProductByID(id)==null){
            System.out.println("\nId does not exist!\n");
            return;
        }
        System.out.println("\nWhat change ?\n1. Name\n2. Price");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                System.out.println("Enter new name: ");
                String newName = scanner.next();
                getProductByID(id).setName(newName);
                break;
            case 2:
                System.out.println("Enter new price: ");
                int newPrice = scanner.nextInt();
                getProductByID(id).setPrice(newPrice);
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
        displayProduct();
    }

    public Product getProductByID(int id) {
        for (Product p: products) {
            if (p.getId()==id){
                return p;
            }
        }
        return null;
    }

    public Product removeProduct(int id) {
        if (getProductByID(id)==null){
            System.out.println("Product does not exist!");
            return null;
        }
        Product deletedProduct = getProductByID(id);
        products.remove(deletedProduct);
        return deletedProduct;
    }

    public void displayProduct() {
        for (Product p: products) {
            System.out.println("Name: "+p.getName()+", Price: "+(int)p.getPrice());
        }
    }

    public int searchByName(String name){
        for (int i=0;i<products.size();i++){
            if (products.get(i).getName().equalsIgnoreCase(name)){
                System.out.println("Product founded.");
                return i;
            }
        }
        return -1;
    }



    public void sortByPrice() {
        products.sort(this::compare);
        displayProduct();
}

    @Override
    public int compare(Product o1, Product o2) {
        return Double.compare(o1.getPrice(),o2.getPrice());
    }
}
