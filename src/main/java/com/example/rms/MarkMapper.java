package com.example.rms;

public class MarkMapper {
	public static MarkDto mapToMarkDto(Mark mark) {
		return new MarkDto(mark.getId(),mark.getCname(),mark.getGrade());
	}
	
	public static Mark mapToMark(MarkDto markDto) {
		return new Mark(markDto.getId(),markDto.getCname(),markDto.getGrade());
	}
}
