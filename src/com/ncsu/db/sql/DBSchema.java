package com.ncsu.db.sql;

public interface DBSchema {
	
	String createGUsers = "CREATE TABLE GUsers (" +
			"ID varchar(32)," +
			"password varchar(32)," +
			"type char(1)," +
			"primary key(ID)," +
			"CONSTRAINT chk_Type CHECK (" +
				"type='P' OR " +
				"type='S' OR " +
				"type='T'" +
			")" +
			")";
	
	String createCourses = "CREATE TABLE Courses (" +
			"token varchar(32)," +
			"name varchar(32)," +
			"startDate timestamp," +
			"endDate timestamp," +
			"profID varchar(32)," +
			"primary Key(token)," +
			"foreign key(profId) references GUsers(ID)" +
			")";
	
	String createTopics = "CREATE TABLE TOPIC (" +
			"name varchar(128)," +
			"courseID varchar(32)," +
			"primary key(name, courseID)," +
			"foreign key(courseId) references Courses(token)" +
			")";
	
	String createEnrollment = "CREATE TABLE Enrollments (" +
			"courseID varchar(32)," +
			"studentID varchar(32)," +
			"primary key(courseID, studentID)," +
			"foreign key(courseID) references Courses(token)," +
			"foreign key(studentID) references GUsers(id)" +
			")";
	
	String createCourseTA = "Create Table CourseTA (" +
			"courseID varchar(32)," +
			"TAID varchar(32)," +
			"primary key(courseID, TAID)," +
			"foreign key(courseID) references Courses(token)," +
			"foreign key(TAID) references GUsers(id)" +
			")";
	
	String createExercises = "create table Exercises (" +
			"ID varchar(32), " +
			"CourseID varchar(32), " +
			"NoOFRetries varchar(10), " +
			"StartDate timestamp, " +
			"EndDate timestamp, " +
			"NoOfPointsForCorrectAns number(1), " +
			"NoOfPointsForIncorrectAns number(1), " +
			"ScoreSelection char(1)," +
			"primary key(id)," +
			"foreign key(courseID) references Courses(token)," +
			"CONSTRAINT chk_ScoreSelection CHECK (" +
				"ScoreSelection='L' OR " +
				"ScoreSelection='M' OR " +
				"ScoreSelection='A' " +
			")" +
			")";
	
	String createQuestions = "create table questions (" +
			"ID varchar(32)," +
			"exerciseID varchar(32)," +
			"text varchar(2048)," +
			"difficultyLevel number(1)," +
			"hint varchar(2048)," +
			"completeAnswerExplanation varchar(2048)," +
			"primary key(id)," +
			"foreign key(exerciseID) references exercises(id)," +
			"CONSTRAINT chk_difficultyLevel CHECK (" +
				"difficultyLevel=1 OR " +
				"difficultyLevel=2 OR " +
				"difficultyLevel=3 OR " +
				"difficultyLevel=4 OR " +
				"difficultyLevel=5" +
				")" +
			")";
	
	String createAnswers= "Create Table Answers(" +
			"ID varchar(32)," +
		"QuestionID varchar(32)," +
		"answerText varchar(256)," +
		"resultType char(1)," +
		"explanation varchar(1024)," +
		"primary key(id)," +
		"foreign key(questionID) references questions(id)," +
		"CONSTRAINT chk_resultType CHECK (resultType='I' OR resultType='C')" +
		")";
	
	String dropAnswers = "drop table Answers";
	String dropQuestions = "drop table Questions";
	String dropExercises = "drop table Exercises";
	String dropCourseTA = "drop table CourseTA";
	String dropEnrollments = "drop table Enrollments";
	String dropTopic = "drop table Topic";
	String dropCourses = "drop table Courses";
	String dropGUsers = "drop table GUsers";
}
