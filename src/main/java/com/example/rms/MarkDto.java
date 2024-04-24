package com.example.rms;

public class MarkDto {
	private Long id;
    private String cname;
    private char grade;
	public MarkDto(Long id, String cname, char grade) {
		super();
		this.id = id;
		this.cname = cname;
		this.grade = grade;
	}
	public MarkDto() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	
}
