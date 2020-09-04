package todos.model;

public class Todos {
	private String title;
	private String date;
	private int done;
	private int id;
	public Todos(int id,String title,String date,int done ){
		this.id = id;
		this.title = title;
		this.date = date;
		this.done = done;
	}
	public String getDate() {
		return date;
	}
	public String getTitle() {
		return title;
	}
	public int getDone() {
		return done;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDone(int done) {
		this.done = done;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
