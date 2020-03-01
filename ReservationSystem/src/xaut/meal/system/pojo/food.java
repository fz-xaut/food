package xaut.meal.system.pojo;

import java.io.Serializable;

public class food implements Serializable{
	//食物的售卖窗口
	private String food_sell_window;
	//食物的唯一ID
	private int food_id;
	//食物的名字
	private String food_name;
	//食物的口味
	private String food_taste;
	//食物的价格
	private float food_price;
	public String getFood_sell_window() {
		return food_sell_window;
	}
	public void setFood_sell_window(String food_sell_window) {
		this.food_sell_window = food_sell_window;
	}
	public int getFood_id() {
		return food_id;
	}
	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public String getFood_taste() {
		return food_taste;
	}
	public void setFood_taste(String food_taste) {
		this.food_taste = food_taste;
	}
	public float getFood_price() {
		return food_price;
	}
	public void setFood_price(float food_price) {
		this.food_price = food_price;
	}
}
