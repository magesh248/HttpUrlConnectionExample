package com.API_Testing.Practice.Demo_APItest;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;



public class HttpUrlConnectionExample {

	public void GetAPI() throws IOException {
		//URL url =new URL("https://dummy.restapiexample.com/api/v1/employees");
		URL url =new URL("https://reqres.in/api/users?page=2");


		HttpURLConnection connection=(HttpURLConnection) url.openConnection();// typecasting to parent class

		connection.setRequestMethod("GET");
		connection.connect();

		int statuscode =connection.getResponseCode();
		System.out.println("Status code is"+ " " +statuscode);

		String status_msg =  connection.getResponseMessage();
		System.out.println("Message status"+" "+ status_msg);

		InputStream inputStream	=connection.getInputStream();

		InputStreamReader inputStreamReader= new InputStreamReader(inputStream);

		BufferedReader JsonRead =new BufferedReader(inputStreamReader);


		String lineRead; 

		StringBuffer buffer =new StringBuffer();

		while((lineRead=JsonRead.readLine())!=null) { // avoid printing in loop statement for that using buffer

			buffer.append(lineRead);

		} 
		System.out.println(buffer);


	}

	public  void PostAPI() throws IOException {

		URL url =new URL("https://dummy.restapiexample.com/api/v1/create");

		HttpURLConnection connection= (HttpURLConnection) url.openConnection();

		connection.setRequestMethod("POST");

		connection.setRequestProperty("content-Type","Aplication/json");
		connection.setDoOutput(true);//For post method have to set True// for get method it is false in default

		String jsonbody="{\"name\":\"Magesh\",\"salary\":\"2300\",\"age\":\"25\"}";
		byte[] inputJson=jsonbody.getBytes();

		OutputStream output=connection.getOutputStream();

		output.write(inputJson);

		System.out.println("statuscode"+" "+connection.getResponseCode());
		System.out.println("statusmsg"+" "+connection.getResponseMessage());


		InputStream inputStream=  connection.getInputStream();

		InputStreamReader streamRead=new InputStreamReader(inputStream);

		BufferedReader buffRead=new BufferedReader(streamRead);


		String line;
		StringBuffer buffer=new StringBuffer();

		while((line=buffRead.readLine())!=null) {

			buffer.append(line);
		}

		System.out.println(buffer);

	}
	public  void PutAPI() throws IOException {

		URL url =new URL("https://dummy.restapiexample.com/api/v1/update/1");

		HttpURLConnection connection= (HttpURLConnection) url.openConnection();

		connection.setRequestMethod("PUT");

		connection.setRequestProperty("content-Type","Aplication/json");
		connection.setDoOutput(true);//For post method have to set True// for get method it is false in default

		String jsonbody="{\"name\":\"Magesh\",\"salary\":\"20055\",\"age\":\"26\"}";
		byte[] inputJson=jsonbody.getBytes();

		OutputStream output=connection.getOutputStream();

		output.write(inputJson);

		System.out.println("statuscode"+" "+connection.getResponseCode());
		System.out.println("statusmsg"+" "+connection.getResponseMessage());


		InputStream inputStream=  connection.getInputStream();

		InputStreamReader streamRead=new InputStreamReader(inputStream);

		BufferedReader buffRead=new BufferedReader(streamRead);


		String line;
		StringBuffer buffer=new StringBuffer();

		while((line=buffRead.readLine())!=null) {

			buffer.append(line);
		}

		System.out.println(buffer);

	}

	public  void DeleteAPI() throws IOException {

		URL url =new URL("https://dummy.restapiexample.com/api/v1/delete/2");

		HttpURLConnection connection= (HttpURLConnection) url.openConnection();

		connection.setRequestMethod("DELETE");

		connection.setRequestProperty("content-Type","Aplication/json");
		connection.setDoOutput(true);//For post method have to set True// for get method it is false in default


		System.out.println("statuscode"+" "+connection.getResponseCode());
		System.out.println("statusmsg"+" "+connection.getResponseMessage());


		InputStream inputStream=  connection.getInputStream();

		InputStreamReader streamRead=new InputStreamReader(inputStream);

		BufferedReader buffRead=new BufferedReader(streamRead);


		String line;
		StringBuffer buffer=new StringBuffer();

		while((line=buffRead.readLine())!=null) {

			buffer.append(line);
		}

		System.out.println(buffer);

	}




	public static void main(String[] args) throws IOException {

		HttpUrlConnectionExample obj =new HttpUrlConnectionExample();
		obj.GetAPI();
		obj.PostAPI();
		obj.PutAPI();
		obj.DeleteAPI();
	}

}


