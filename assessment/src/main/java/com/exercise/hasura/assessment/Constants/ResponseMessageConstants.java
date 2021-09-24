package com.exercise.hasura.assessment.Constants;

public class ResponseMessageConstants {
	
	// successful operations
	public static final String FETCH_SUCCESSFUL = "fetched successfully";
	public static final String SAVE_SUCCESSFUL = "saved successfully";
	public static final String UPDATE_SUCCESSFUL = "updated successfully";
	public static final String DELETE_SUCCESSFUL = "deleted successfully";
	
	
	// unsuccessful operations
	public static final String FETCH_UNSUCCESSFUL = "fetch unsuccessful";
	public static final String SAVE_UNSUCCESSFUL = "save unsuccessful";
	public static final String UPDATE_UNSUCCESSFUL = "update unsuccessful";
	public static final String DELETE_UNSUCCESSFUL = "delete unsuccessful";
	
	// error messages
	public static final String INCORRECT_ID_FORMAT_ERROR = "given album Id is not recognised, please ensure album id is in correct format";
	public static final String UNKNOWN_EXCEPTION = "encountered an unknown exception while trying to execute the service";
	public static final String NON_EXISITNG_ID_ERROR = "given album Id is not present in our records";
	public static final String PRE_EXISITNG_ID_ERROR = "given albumId already exists in our records, please use a unique id";
	public static final String NON_DELETED_ID_ERROR = "given album Id did not get deleted from our records";
	
}
