
package p.e.manager;


public class Category {
    private Long categoryId=System.currentTimeMillis();
    private String name;

    public Category(String name) {
        this.name = name;
    }
    

    public Category(Long categoryId,String name) {
        this.name = name; 
        this.categoryId=categoryId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
