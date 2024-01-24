package homework1.task2;

public class Product {
    private Integer cost;
    private String title;
    public Product(Integer cost, String title) {
        this.cost = cost;
        this.title = title;
    }
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", title, cost);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (getCost() != (product.getCost())) return false;
        return getTitle().equals(product.getTitle());
    }

    @Override
    public int hashCode() {
        int result = getCost();
        result = 31 * result + getTitle().hashCode();
        return result;
    }
}
