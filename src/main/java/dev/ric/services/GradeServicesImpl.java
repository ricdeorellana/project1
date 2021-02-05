package dev.ric.services;

import java.util.List;

import dev.ric.models.Grade;
import dev.ric.repositories.GradeRepositoryImpl;

public class GradeServicesImpl {
	public static GradeRepositoryImpl grep = new GradeRepositoryImpl();
	
	public Grade getGrade(int id) {
		return grep.getGrade(id);
	}
	
	public List<Grade> getAllGrades() {
		return grep.getAllGrades();
	}
}
