package Utils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class inputdata {
	
	private String name;
    private String age;
    private String gender;

    // Getters for fields
    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "{name='" + name + "', age=" + age + ", gender='" + gender + "'}";
    }
	
	public static String tabledata()
	{
		return "[{\"name\" : \"Bob\", \"age\" : 20, \"gender\": \"male\"}, {\"name\": \"George\", \"age\" : 42, \"gender\": \"male\"}, {\"name\":\r\n"
				+ "\"Sara\", \"age\" : 42, \"gender\": \"female\"}, {\"name\": \"Conor\", \"age\" : 40, \"gender\": \"male\"}, {\"name\":\r\n"
				+ "\"Jennifer\", \"age\" : 42, \"gender\": \"female\"}]";
	}
	
	
	
	public static List<inputdata> expecteddata()
	{
		Gson gson = new Gson();
        String jsonData = tabledata();

        // Define the type for List<Person>
        Type personListType = new TypeToken<List<inputdata>>() {}.getType();

        // Convert JSON to List<Person>
        List<inputdata> personList = gson.fromJson(jsonData, personListType);
        
        return personList;
       
	}
	
	public Map<String, Object> toMap()
	{
        Map<String, Object> personMap = new HashMap<>();
        personMap.put("name", name);
        personMap.put("age", age);
        personMap.put("gender", gender);
        return personMap;
    }
	


}
