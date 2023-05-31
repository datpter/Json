package com.class1;

import com.class1.model.Post;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import com.class1.controller.postController;

public class JsonManagerment {

    postController postController = new postController();


    public void readJSONFromApijsonplaceholder()throws Exception{


        try {
            String apiURL = "https://jsonplaceholder.typicode.com/posts";
            URL url = new URL(apiURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader reader= new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );
            StringBuilder response = new StringBuilder();
            String line;
            while ((line= reader.readLine())!= null){
                response.append(line);
            }
            reader.close();
            org.json.JSONArray jsonArray = new org.json.JSONArray(response.toString());
            for (int i = 0 ;i<jsonArray.length();i++){
                org.json.JSONObject post
                        = (org.json.JSONObject) jsonArray.get(i);
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                Post newPost= new Post(
                        Integer.parseInt(post.get("id").toString()),
                        Integer.parseInt(post.get("userId").toString()),
                        post.get("title").toString(),
                        post.get("body").toString()

                );
                System.out.println("Inserting.......");
                postController.insertNewapis(newPost);

            }



        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();

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
