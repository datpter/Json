package com.class1;

public class Main {
    public static void main(String[] args) {
        try {
            JsonManagerment jsonManagerment = new JsonManagerment();
            jsonManagerment.readJSONFromAPI();
        jsonManagerment.readJSONperson();


        }catch (Exception e){
            e.printStackTrace();
        }




    }
}
