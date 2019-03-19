package com.sandeep.SpringBootDemo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	private static final String USER_AGENT = "Mozilla/5.0";
	private static final String url = "https://cricscore-api.appspot.com/csa";

    @GetMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE)
	public String welcome() throws IOException {
    	return sendGET();
	}
	
    @Scheduled(initialDelay = 1000, fixedDelay = 5000)
	public static String sendGET() throws IOException {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("Response:: " + responseCode);
		StringBuffer response = new StringBuffer();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			System.out.println(response.toString());
		} else {
			System.out.println("Request not working");
		}
		return response.toString();
	}
}
