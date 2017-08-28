package com.metacube.employee;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
// class to perform all operations on Employee
public class EmployeeDao implements UserDao{
	private static int id = 1;
	public JSONArray employeeArray;
	private static EmployeeDao employeeDao = null;
	private EmployeeDao() {}
	// get instance of Singleton class
	public static EmployeeDao getInstance(String path) {
		if(employeeDao == null) {
			employeeDao = new EmployeeDao();
		}
		employeeDao.employeeArray = FileUtility.getInstance().readFile(path);
		return employeeDao;
	}
	// check if employee array is empty or not
	public boolean employeeArrayIsEmpty() {
		if(employeeArray == null) {
			return true;
		}
		if(employeeArray.size() == 0) {
			return true;
		}
		return false;
	}
	// delete employee details with given ID
	@Override
	public boolean deleteEmployee(int id) {
		for(int i=0;i<employeeArray.size();i++) {
			JSONObject obj = (JSONObject) employeeArray.get(i);
			if (Integer.parseInt(obj.get("id").toString()) == id) {
				employeeArray.remove(i);
				FileUtility.getInstance().writeFile(employeeArray);
				return true;
			}
		}
		return false;		
	}
	// get details of employee with given employee id
	@Override
	public JSONObject getEmployeeDetails(int id) {
		JSONObject resultObj = new JSONObject();;
		for(int i=0;i<employeeArray.size();i++) {
			JSONObject obj = (JSONObject)employeeArray.get(i);
			if (Integer.parseInt(obj.get("id").toString()) == id) {
				resultObj = obj;
				break;
			}
		}
		return resultObj;
	}
	// take JSONObject and add it to database
	@Override
	public boolean addEmployee(JSONObject employee) {
		boolean flag = true;
		employee.putIfAbsent("id", id);
		id++;
		if(employeeArray == null) {
			employeeArray = new JSONArray();
		}
		employeeArray.add(employee);
		FileUtility.getInstance().writeFile(employeeArray);
		flag=true;
		return flag;
	}
	// update employee details in database
	@Override
	public boolean updateEmployee(int id) {
		return null;
	}
	// returns the employeeArray
	@Override
	public JSONArray getAllEmployees() {
		return this.employeeArray;
	}
	// get all employees with specific name
	@Override
	public JSONArray getAllEmployeesByName(String name) {
		JSONArray employeesWithName = new JSONArray();
		for(int i=0;i<employeeArray.size();i++) {
			JSONObject obj = (JSONObject)employeeArray.get(i);
			if((obj.get("name").toString()).equals(name)) {
				employeesWithName.add(obj);
			}
		}
		return employeesWithName;
	}
}
