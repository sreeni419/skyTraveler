package com.skytraveler.controller;

import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class AirportFinderController {

	@RequestMapping(value = "/airportFinderResponse")
	public String airportFinder(@RequestParam("cityName") String cityName, Model model) {

		JSONObject json = new JSONObject();

		try {

			String url = "https://cometari-airportsfinder-v1.p.rapidapi.com/api/airports/by-text?text=" + cityName;
			URL finalUrl = new URL(url);
			System.setProperty("http.agent", "Chrome");
			System.setProperty("https.agent", "Chrome");
			HttpURLConnection myURLConnection = (HttpURLConnection) finalUrl.openConnection();
			myURLConnection.setRequestProperty("Cache-Control", "max-age=0");
			myURLConnection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36");
			myURLConnection.setRequestProperty("x-rapidapi-key", "3804edb778msh4b500b2f5a5d3d4p19f9e6jsn1821e9463001");
			myURLConnection.setDoOutput(true);
			String jsonData = IOUtils.toString(myURLConnection.getInputStream(), "UTF-8");
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(jsonData);
			json.put("data", node);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(json.toString());
		model.addAttribute(json.toString());
		return json.toString();

	}

}