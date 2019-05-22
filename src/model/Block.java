package model;

public class Block {
	private int id;
	private int pid;
	private String pname;
	private String blockname;

	public Block() {
		super();
	}

	public Block(int id, int pid, String pname, String blockname) {
		super();
		this.id = id;
		this.pid = pid;
		this.pname = pname;
		this.blockname = blockname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getBlockname() {
		return blockname;
	}

	public void setBlockname(String blockname) {
		this.blockname = blockname;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}
}
