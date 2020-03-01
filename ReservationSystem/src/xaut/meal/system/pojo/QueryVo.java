package xaut.meal.system.pojo;

import java.io.UnsupportedEncodingException;

public class QueryVo {
	private String fName;
	private String fWindow;
	private String fTaste;
	private String fPrice;
	private int fId;
	private Integer page = 1;
	private Integer start;
	private Integer rows = 10;
	public String getfName() {
		
		return fName;
	}
	public void setfName(String fName) {
	
		String fname = null;
		try {
			fname = new String(fName .getBytes("iso8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		this.fName = fname;
	}
	public String getfWindow() {
		
		return fWindow;
	}
	public void setfWindow(String fWindow) {
		
		String fwindow = null;
		try {
			fwindow = new String(fWindow .getBytes("iso8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		this.fWindow = fwindow;
	}
	public String getfTaste() {
		return fTaste;
	}
	public void setfTaste(String fTaste) {
		
		String ftaste = null;
		try {
			ftaste = new String(fTaste .getBytes("iso8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		this.fTaste = ftaste;
	}
	public String getfPrice() {
		return fPrice;
	}
	public void setfPrice(String fPrice) {
		this.fPrice = fPrice;
	}
	public int getfId() {
		return fId;
	}
	public void setfId(int fId) {
		this.fId = fId;
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
