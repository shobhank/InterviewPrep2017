//package org.shobhank.design.observer;
//
//
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import com.sun.jersey.api.client.Client;
//import com.sun.jersey.api.client.ClientResponse;
//import com.sun.jersey.api.client.WebResource;
//
///**
// *
// * @author shsharma
// */
//public class TestObserverPattern {
//	public static void main(String as[]){
//		WeatherData wData = new WeatherData();
//		CurrentConditionsDisplay cDisplay = new CurrentConditionsDisplay(wData);
//		Thread thread = new Thread(new Runnable(){
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				while(true){
//					try {
//						Thread.sleep(60000);
//						updateData(wData);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (ParseException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//		});
//		thread.start();
//	}
//
//	public static void updateData(WeatherData wData) throws ParseException{
//		Client client = Client.create();
//
//		WebResource webResource = client
//		   .resource("http://api.openweathermap.org/data/2.5/weather?"
//		   		+ "zip=95112,us&APPID=e1a3f17fd8b9c76c67015ec5bbd8a1aa");
//
//		ClientResponse response = webResource.accept("application/json")
//                   .get(ClientResponse.class);
//
//		if (response.getStatus() != 200) {
//		   throw new RuntimeException("Failed : HTTP error code : "
//			+ response.getStatus());
//		}
//
//		String output = response.getEntity(String.class);
//
//		JSONParser parser = new JSONParser();
//		JSONObject json = (JSONObject) parser.parse(output);
//
//		JSONObject jsonObject = (JSONObject) json.get("main");
//
//		wData.setMeasurements(Double.parseDouble(jsonObject.get("temp").toString()),
//				Double.parseDouble(jsonObject.get("humidity").toString()),
//				Double.parseDouble(jsonObject.get("pressure").toString()));
//
//	}
//}
