package xaut.meal.system.pojo;

public class OrderOutDB {
    
    private int order_id;
    private String food_id;
    private String food_name;
    private String food_sell_window;
    private String food_taste;
    private String food_price;
    private String stuName;
    private String stuCall;
    private String stuAddress;
    private String receive;
    private String order_time;
    private Integer page = 1;
    private Integer start;
    private Integer rows = 10;
    
    
    public String getFood_id() {
        return food_id;
    }
    public void setFood_id(String food_id) {
        this.food_id = food_id;
    }
    public int getOrder_id() {
        return order_id;
    }
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
    public String getFood_name() {
        return food_name;
    }
    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }
    public String getFood_sell_window() {
        return food_sell_window;
    }
    public void setFood_sell_window(String food_sell_window) {
        this.food_sell_window = food_sell_window;
    }
    public String getFood_taste() {
        return food_taste;
    }
    public void setFood_taste(String food_taste) {
        this.food_taste = food_taste;
    }
    public String getFood_price() {
        return food_price;
    }
    public void setFood_price(String food_price) {
        this.food_price = food_price;
    }
    public String getStuName() {
        return stuName;
    }
    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
    public String getStuCall() {
        return stuCall;
    }
    public void setStuCall(String stuCall) {
        this.stuCall = stuCall;
    }
    public String getStuAddress() {
        return stuAddress;
    }
    public void setStuAddress(String stuAddress) {
        this.stuAddress = stuAddress;
    }
    public String getReceive() {
        return receive;
    }
    public void setReceive(String receive) {
        this.receive = receive;
    }
    
    public String getOrder_time() {
        return order_time;
    }
    public void setOrder_time(String order_time) {
        order_time = order_time.substring(5, 16);
        this.order_time = order_time;
    }
    public Integer getPage() {
        return page;
    }
    public void setPage(Integer page) {
        this.page = page;
    }
    public Integer getStart() {
        return start;
    }
    public void setStart(Integer start) {
        this.start = start;
    }
    public Integer getRows() {
        return rows;
    }
    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
