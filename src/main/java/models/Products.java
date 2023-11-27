
package models;   

    public class Products {
    private int id;
    private String name;
    private String state;        
    private String internal_code;        
    private double price;
    private String unit_of_measure;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getInternal_code() {
        return internal_code;
    }

    public void setInternal_code(String internal_code) {
        this.internal_code = internal_code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnit_of_measure() {
        return unit_of_measure;
    }

    public void setUnit_of_measure(String unit_of_measure) {
        this.unit_of_measure = unit_of_measure;
    }
    
    
}
