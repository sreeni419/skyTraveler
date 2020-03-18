package com.skytraveler.controller;

import java.io.IOException;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.bind.JAXB;
import javax.xml.rpc.ServiceException;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.registration.soap.service.RegisterUserTO;
import com.registration.soap.service.RegistrationServiceAPI;
import com.registration.soap.service.RegistrationServiceImplementaionService;
import com.registration.soap.service.RegistrationServiceImplementaionServiceLocator;
import com.registration.soap.service.ResponseClass;

@Controller
public class AuthenticateController {

	@RequestMapping(value = "/signupService")
	public String registerService(@RequestParam(value = "firstName") String firstName,
			@RequestParam(value = "lastName") String lastName, @RequestParam(value = "userId") String userId,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "repeatPassword") String repeatPassword) throws RemoteException, ServiceException {

		RegistrationServiceImplementaionService authService = new RegistrationServiceImplementaionServiceLocator();
		RegistrationServiceAPI registrationService = authService.getRegistrationServiceImplementaionPort();
		RegisterUserTO user = new RegisterUserTO();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setUserID(userId);
		user.setPassword(password);
		user.setRepeatPassword(repeatPassword);
		registrationService.registerUser(user);
		System.out.println("*******entered into register Service****************");
		return "login";
	}

	@RequestMapping(value = "/loginService")
	public String loginService(@RequestParam(value = "userId") String userId,
			@RequestParam(value = "password") String password) throws ServiceException, IOException {
		System.out.println("****entered into loginservice");
		
			/*http://localhost:8085/RESTtypeAuthenticationService/authenticatationservice/{id}/{password)/authenticateuser
*/
			String url = "http://localhost:8085/RESTtypeAuthenticationService/authenticatationservice/" + userId + "/" + password
					+ "/authenticateuser";

			URL finalUrl = new URL(url);
			System.setProperty("http.agent", "Chrome");
			System.setProperty("https.agent", "Chrome");
			HttpURLConnection myURLConnection = (HttpURLConnection) finalUrl.openConnection();
			myURLConnection.addRequestProperty("Content-Type", "application/xml");
			myURLConnection.setDoOutput(true);
			System.out.println("Response********");
			String xmlData = IOUtils.toString(myURLConnection.getInputStream(), "UTF-8");
		 ResponseClass responseData=JAXB.unmarshal(new StringReader(xmlData), ResponseClass.class);
		System.out.println(responseData.getMessage());
		if(responseData.getMessage().equals("valid user")) {
		return "airport_finder";
	}else 
		return "login";

}}
