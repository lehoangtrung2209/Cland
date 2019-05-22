package model;

public class Project {
	private int id;
	private String name;
	private String cid;
	private String cname;
	private String overview;
	private String place;

	public Project() {
		super();
	}

	public Project(int id, String name, String cid, String cname, String overview, String place) {
		super();
		this.id = id;
		this.name = name;
		this.cid = cid;
		this.cname = cname;
		this.overview = overview;
		this.place = place;
	}

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

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	
}
