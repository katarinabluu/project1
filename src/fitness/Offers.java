
package fitness;


public class Offers {
  
    private String nameOffer;
    private double price;

    public Offers(String nameOffer, double price) {
        this.nameOffer = nameOffer;
        this.price=price;
    }

    public Offers() {

    }

    public String getNameOffer() {
        return nameOffer;
    }

    public void setNameOffer(String nameOffer) {
        this.nameOffer = nameOffer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%-15s%s", nameOffer,price);
    }
    
    
    
}
