package com.metacube.employee;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
//Base Class for Employee
public interface UserDao {
	boolean deleteEmployee(int id);
	JSONObject getEmployeeDetails(int id);
	JSONObject addEmployee(JSONObject employee);
	JSONArray updateEmployee(int id);
	JSONArray getAllEmployees();
	JSONArray getAllEmployeesByName(String name);
}

