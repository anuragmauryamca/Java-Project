
package p.e.manager;

import java.util.Date;


public class Expense {
    private Long expenseId=System.currentTimeMillis();
    private Long categoryId;//fk
    private Long amount;
    private Date date;
    private String remark;

    public Expense(Long categoryId,Long amount, Date date, String remark) {
        this.categoryId = categoryId;
        this.amount = amount;
        this.date = date;
        this.remark = remark;
    }

    Expense() {
          }

    Expense(Long categoryId, float f, Date toStringDate,String remark) {
       
    }


    public Long getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Long expenseId) {
        this.expenseId = expenseId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    
}
