package com.example.rms;

import org.springframework.context.annotation.Lazy;

import jakarta.persistence.*;

@Entity
@Table(name="marks")
public class Mark {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="course")
	private String cname;
	@Column(name="grade")
	private char grade;
	
	@ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
		
	public Mark() {
		super();
	}
	public Mark(Long id,String cname, char grade) {
		super();
		this.id=id;
		this.cname = cname;
		this.grade = grade;
	}
	public Long getId() {
		return id;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
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
