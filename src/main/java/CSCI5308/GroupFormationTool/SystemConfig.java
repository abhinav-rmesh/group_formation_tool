//package CSCI5308.GroupFormationTool;
//
//import CSCI5308.GroupFormationTool.Security.*;
//
//import CSCI5308.GroupFormationTool.Survey.ISurveyPersistence;
//import CSCI5308.GroupFormationTool.Survey.SurveyDB;
//import CSCI5308.GroupFormationTool.AccessControl.*;
//import CSCI5308.GroupFormationTool.Database.*;
//import CSCI5308.GroupFormationTool.GroupFormation.GroupFormationPolicyDB;
//import CSCI5308.GroupFormationTool.GroupFormation.GroupFormationService;
//import CSCI5308.GroupFormationTool.GroupFormation.IGroupFormationPolicyPersistence;
//import CSCI5308.GroupFormationTool.GroupFormation.IGroupFormationService;
//import CSCI5308.GroupFormationTool.Survey.ISurveyResponsePersistence;
//import CSCI5308.GroupFormationTool.Survey.SurveyResponseDB;
//import CSCI5308.GroupFormationTool.Questions.IQuestionPersistence;
//import CSCI5308.GroupFormationTool.Questions.QuestionDB;
//import CSCI5308.GroupFormationTool.Courses.*;
//
///*
// * This is a singleton, we will learn about these when we learn design patterns.
// * 
// * The single responsibility of this singleton is to store concrete classes
// * selected by the system for use in the rest of the system. This will allow
// * a form of dependency injection in places where we cannot use normal
// * dependency injection (for example classes that override or extend existing
// * library classes in the framework).
// */
//public class SystemConfig {
//	private static SystemConfig uniqueInstance = null;
//
//	private IPasswordEncryption passwordEncryption;
//	private IUserPersistence userDB;
//	private IDatabaseConfiguration databaseConfiguration;
//	private ICoursePersistence courseDB;
//	private IPasswordPolicyPersistence passwordPolicyDBObj;
//	private ICourseUserRelationshipPersistence courseUserRelationshipDB;
//	private IQuestionPersistence questionDB;
//	private IUserPasswordRelationshipPersistence userPasswordRelationshipDB;
//	private ISurveyPersistence surveyDBObj;
//	private IGroupFormationPolicyPersistence groupFormationPolicyObj;
//	private IGroupFormationService groupFormationServiceObj;
//	private ISurveyResponsePersistence surveyResponseDB;
//	private ISurveyPersistence surveyDB;
//
//	// This private constructor ensures that no class other than System can allocate
//	// the System object. The compiler would prevent it.
//	private SystemConfig() {
//		// The default instantiations are the choices that would be used in the
//		// production application. These choices can all be overridden by test
//		// setup logic when necessary.
//		passwordEncryption = new BCryptPasswordEncryption();
//		userDB = new UserDB();
//		databaseConfiguration = new DefaultDatabaseConfiguration();
//		courseDB = new CourseDB();
//		passwordPolicyDBObj = new PasswordPolicyDB();
//		courseUserRelationshipDB = new CourseUserRelationshipDB();
//		questionDB = new QuestionDB();
//		userPasswordRelationshipDB = new UserPasswordRelationshipDB();
//		surveyDBObj = new SurveyDB();
//		groupFormationPolicyObj = new GroupFormationPolicyDB();
//		groupFormationServiceObj = new GroupFormationService();
//		surveyResponseDB=new SurveyResponseDB();
//		surveyDB = new SurveyDB();
//	}
//
//	public ISurveyResponsePersistence getSurveyResponseDB() {
//		return surveyResponseDB;
//	}
//
//	public void setSurveyResponseDB(ISurveyResponsePersistence surveyResponseDB) {
//		this.surveyResponseDB = surveyResponseDB;
//		
//		surveyDB = new SurveyDB();
//	}
//
//
//	// This is the way the rest of the application gets access to the System object.
//	public static SystemConfig instance() {
//		// Using lazy initialization, this is the one and only place that the System
//		// object will be instantiated.
//		if (null == uniqueInstance) {
//			uniqueInstance = new SystemConfig();
//		}
//		return uniqueInstance;
//	}
//
//	public IGroupFormationService getGroupFormationServiceObj() {
//		return groupFormationServiceObj;
//	}
//
//	public void setGroupFormationServiceObj(IGroupFormationService groupFormationServiceObj) {
//		this.groupFormationServiceObj = groupFormationServiceObj;
//	}
//
//	public IGroupFormationPolicyPersistence getGroupFormationPolicyObj() {
//		return groupFormationPolicyObj;
//	}
//
//	public void setGroupFormationPolicyObj(IGroupFormationPolicyPersistence groupFormationPolicyObj) {
//		this.groupFormationPolicyObj = groupFormationPolicyObj;
//	}
//
//	public ISurveyPersistence getSurveyDBObj() {
//		return surveyDBObj;
//	}
//
//	public void setSurveyDBObj(ISurveyPersistence surveyDBObj) {
//		this.surveyDBObj = surveyDBObj;
//	}
//
//	public IUserPasswordRelationshipPersistence getUserPasswordRelationshipDB() {
//		return userPasswordRelationshipDB;
//	}
//
//	public void setUserPasswordRelationshipDB(IUserPasswordRelationshipPersistence userPasswordRelationshipDB) {
//		this.userPasswordRelationshipDB = userPasswordRelationshipDB;
//	}
//
//	public IPasswordEncryption getPasswordEncryption() {
//		return passwordEncryption;
//	}
//
//	public void setPasswordEncryption(IPasswordEncryption passwordEncryption) {
//		this.passwordEncryption = passwordEncryption;
//	}
//
//	public IUserPersistence getUserDB() {
//		return userDB;
//	}
//
//	public void setUserDB(IUserPersistence userDB) {
//		this.userDB = userDB;
//	}
//
//	public IDatabaseConfiguration getDatabaseConfiguration() {
//		return databaseConfiguration;
//	}
//
//	public void setDatabaseConfiguration(IDatabaseConfiguration databaseConfiguration) {
//		this.databaseConfiguration = databaseConfiguration;
//	}
//
//	public void setCourseDB(ICoursePersistence courseDB) {
//		this.courseDB = courseDB;
//	}
//
//	public ICoursePersistence getCourseDB() {
//		return courseDB;
//	}
//
//	public void setCourseUserRelationshipDB(ICourseUserRelationshipPersistence courseUserRelationshipDB) {
//		this.courseUserRelationshipDB = courseUserRelationshipDB;
//	}
//
//	public ICourseUserRelationshipPersistence getCourseUserRelationshipDB() {
//		return courseUserRelationshipDB;
//	}
//
//	public void setQuestionDB(IQuestionPersistence questionDB) {
//		this.questionDB = questionDB;
//	}
//
//	public IQuestionPersistence getQuestionDB() {
//		return questionDB;
//	}
//	
//	public void setSurveyDB(ISurveyPersistence surveyDB) {
//		this.surveyDB = surveyDB;
//	}
//
//	public ISurveyPersistence getSurveyDB() {
//		return surveyDB;
//	}
//
//	public PasswordPolicy getPasswordPolicyObj() {
//		return PasswordPolicy.instance(passwordPolicyDBObj);
//	}
//
//	public IPasswordPolicyPersistence getPasswordPolicyDBObj() {
//		return passwordPolicyDBObj;
//	}
//
//}
