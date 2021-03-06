package model;

public class Locker {
	
	private String filename;
	private String filedata;
	private int id;
	
	public Locker() {
		// TODO Auto-generated constructor stub
	}

	public Locker(String filename, String filedata) {
		super();
		this.filename = filename;
		this.filedata = filedata;
	}

	public Locker(String filename) {
		super();
		this.filename = filename;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFiledata() {
		return filedata;
	}

	public void setFiledata(String filedata) {
		this.filedata = filedata;
	}

	@Override
	public String toString() {
		return "Locker [filename=" + filename + ", filedata=" + filedata + "]";
	}
	
	

}
