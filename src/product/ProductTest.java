package product;

public class ProductTest {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        manager.addProduct(new Product("TV",12000000,1));
        manager.addProduct(new Product("Camera",2500000,2));
        manager.addProduct(new Product("Book",69000,3));
        manager.addProduct(new Product("Laptop",30000000,4));
        manager.displayProduct();
        System.out.println("\n");
        manager.removeProduct(1);
        manager.displayProduct();
        System.out.println(manager.searchByName("camera"));
        manager.sortByPrice();
        manager.updateProduct(0);
        manager.updateProduct(1);
        manager.updateProduct(3);
    }
}
