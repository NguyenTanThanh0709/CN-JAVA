package model;

public class Sach {
	private String id;
	private String tensach;
	private float giaban;
	private int namxuatban;
	
	
	public Sach() {
		super();
	}


	public Sach(String id, String tensach, float giaban, int namxuatban) {
		super();
		this.id = id;
		this.tensach = tensach;
		this.giaban = giaban;
		this.namxuatban = namxuatban;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTensach() {
		return tensach;
	}


	public void setTensach(String tensach) {
		this.tensach = tensach;
	}


	public float getGiaban() {
		return giaban;
	}


	public void setGiaban(float giaban) {
		this.giaban = giaban;
	}


	public int getNamxuatban() {
		return namxuatban;
	}


	public void setNamxuatban(int namxuatban) {
		this.namxuatban = namxuatban;
	}
	
	
	
	
	
}
