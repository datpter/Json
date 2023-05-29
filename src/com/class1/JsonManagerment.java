package com.class1;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class JsonManagerment {
    public void readJSONFromAPI() throws Exception {
        try {
            String apiUrl = " https://api.apify.com/v2/key-value-stores/EaCBL1JNntjR3EakU/records/LATEST?disableRedirect=true.";
            URL url = new URL(apiUrl);

            // Create connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Read response
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            System.out.println(response.toString());

            org.json.JSONArray jsonArray = new org.json.JSONArray(response.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                org.json.JSONObject product
                        = (org.json.JSONObject) jsonArray.get(i);
                int id = Integer.parseInt(product.get("id").toString());
                String title = product.get("title").toString();
                String imageurl = product.get("imageurl").toString();
                String category = product.get("category").toString();
                float price =  Float.parseFloat(product.get("price").toString());

                System.out.println(id+","+ title +","+imageurl+
                        " , "+category+" , "+price);
            }

            conn.disconnect();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void readJSONperson()throws Exception{
        try {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader("Person.json"));
            JSONObject jsonObject = (JSONObject) obj;
            Person person = new Person();
            int id = Integer.parseInt(jsonObject.get("id").toString());
            String firstName = jsonObject.get("firstName").toString();
            String lastName = jsonObject.get("lastName").toString();
            String email = jsonObject.get("email").toString();
            String department = jsonObject.get("department").toString();
            String position= jsonObject.get("position").toString();
            int salary = Integer.parseInt(jsonObject.get("salary").toString());
            String hireDate= jsonObject.get("hireDate").toString();

            boolean active = Boolean.parseBoolean(jsonObject.get("active").toString());
            person.setId(id);
            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setEmail(email);
            person.setDepartment(department);
            person.setPosition(position);
            person.setSalary(salary);
            person.setHireDate(hireDate);
            person.setActive(active);
            System.out.println(person.toString());

            Map mapAddress = (Map) jsonObject.get("address");
            String streetAddress = mapAddress.get("streetAddress").toString();
            String city = mapAddress.get("city").toString();
            String state = mapAddress.get("state").toString();
            String postalCode = mapAddress.get("postalCode").toString();

            System.out.println(streetAddress);
            System.out.println(city);
            System.out.println(state);
            System.out.println(postalCode);


        }catch (Exception e){
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

}
