package com.example.rms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private MarkRepo markRepo;
	

	public StudentServiceImpl(StudentRepository studentRepository, MarkRepo markRepo) {
		super();
		this.studentRepository = studentRepository;
		this.markRepo = markRepo;
	}

	@Override
	public StudentDto createStudent(StudentDto studentDto) {
		Student student=StudentMapper.mapToStudent(studentDto);
		List<Mark> marks=new ArrayList<>();
		for(MarkDto m:studentDto.getMarks()) {
			Mark mark=new Mark(m.getId(),m.getCname(),m.getGrade());
			mark.setStudent(student);
			marks.add(mark);
		}
		student.setMarks(marks);
		Student savedStudent= studentRepository.save(student);
		return StudentMapper.mapToStudentDto(savedStudent);
	}

	@Override
	public StudentDto getStudentById(Long studentId) {
		Student student = studentRepository.findById(studentId).orElseThrow(()->new ResourceNotFoundException("Student is not exist with the given Student ID :"+studentId));
		return StudentMapper.mapToStudentDto(student);
	}

	@Override
	public List<StudentDto> getAllStudents() {
		List<Student> students=studentRepository.findAll();		
		return students.stream().map((student)->StudentMapper.mapToStudentDto(student)).collect(Collectors.toList());
	}

	@Override
	public StudentDto updateStudent(Long studentId, StudentDto updatedStudent) {
		Student student=studentRepository.findById(studentId).orElseThrow(()-> new ResourceNotFoundException("Student is not exist with the given Student ID :"+studentId));
		student.setName(updatedStudent.getName());
		student.setRollno(updatedStudent.getRollno());
		student.setEmail(updatedStudent.getEmail());
		List<Mark> marks=student.getMarks();
		int i=0;
		for(MarkDto m:updatedStudent.getMarks()) {
			marks.get(i).setCname(m.getCname());
			marks.get(i).setGrade(m.getGrade());
			i++;
		}
		student.setMarks(marks);
		Student upStudent= studentRepository.save(student);
		return StudentMapper.mapToStudentDto(upStudent);
	}

	@Override
	public void deleteStudent(Long studentId) {
		Student student=studentRepository.findById(studentId).orElseThrow(()-> new ResourceNotFoundException("Student is not exist with the given Student ID :"+studentId));
		studentRepository.deleteById(studentId);
	}

	@Override
	public StudentDto getStudentByRollno(String rollno) {
		Student student = studentRepository.findByRollno(rollno).orElseThrow(()->new ResourceNotFoundException("Student is not exist with the given RollNo :"+rollno));
		return StudentMapper.mapToStudentDto(student);
	}
}
