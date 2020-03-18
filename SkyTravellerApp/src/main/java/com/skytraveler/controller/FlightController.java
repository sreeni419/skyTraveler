package com.skytraveler.controller;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class FlightController {

	@RequestMapping(value = "/flight")
	public String viewFlightDetails(@RequestParam("departure_code") String depCode,
			@RequestParam("arrival_code") String arrCode) {
		JSONObject json = new JSONObject();
		try {
			Date today = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(today);
			int day = cal.get(Calendar.DAY_OF_MONTH); // 17
			int month = cal.get(Calendar.MONTH) + 1; // 5
			int year = cal.get(Calendar.YEAR); // 2016

			String url = "https://api.flightstats.com/flex/schedules/rest/v1/json/from/" + depCode + "/to/" + arrCode
					+ "/departing/" + year + "/" + month + "/" + day;

			URL finalUrl = new URL(url);
			System.setProperty("http.agent", "Chrome");
			System.setProperty("https.agent", "Chrome");
			HttpURLConnection myURLConnection = (HttpURLConnection) finalUrl.openConnection();
			myURLConnection.setRequestProperty("Cache-Control", "max-age=0");
			myURLConnection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36");
			myURLConnection.setRequestProperty("appId", "7eb3bd10");
			myURLConnection.setRequestProperty("appKey", "8f3d9f0e7a8396f9b7de89544d5d0897");
			myURLConnection.addRequestProperty("Content-Type", "application/json");
			myURLConnection.setDoOutput(true);
			System.out.println("Response********");
			String jsonData = IOUtils.toString(myURLConnection.getInputStream(), "UTF-8");
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(jsonData);
			json.put("data", node);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return json.toString();
	}

}
