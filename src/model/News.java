package model;

import java.sql.Timestamp;

public class News {
	private int id;
	private int cid;
	private String name;
	private String description;
	private String picture;
	private Timestamp date_create;
	private String cname;

	public News() {
		super();
	}

	public News(int id, int cid, String name, String description, String picture, Timestamp date_create, String cname) {
		super();
		this.id = id;
		this.cid = cid;
		this.name = name;
		this.description = description;
		this.picture = picture;
		this.date_create = date_create;
		this.cname = cname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Timestamp getDate_create() {
		return date_create;
	}

	public void setDate_create(Timestamp date_create) {
		this.date_create = date_create;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

}
