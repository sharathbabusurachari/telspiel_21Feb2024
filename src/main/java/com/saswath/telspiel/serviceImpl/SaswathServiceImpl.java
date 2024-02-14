package com.saswath.telspiel.serviceImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.saswath.telspiel.module.Telspiel;
import com.saswath.telspiel.service.SaswathService;

@Service
public class SaswathServiceImpl implements SaswathService {

	@Autowired
	RestTemplate restTemplate;

	@Override
	public String getSaswathStatus(Telspiel telspiel) {
		try {
			String baseURL = "https://api.telsp.in/pushapi/sendbulkmsg";
			//String urlString = "https://api.telsp.in/pushapi/sendbulkmsg?username=SwatApi&dest=8123632216&apikey=uhEqWZKRPDOVmUB91K1VgegFg6pgTuqW&signature=SASWTF&msgtype=PM&msgtxt=Dear%20Rahul%2C%20Welcome%20to%20Saswat.%20Your%20application%20ID%20%3A%20A0932123%20and%20customer%20ID%20%3A%20CID0012001.%20If%20you%20have%20any%20questions%20reach-out%20to%20your%20sales%20officer.%20-Saswat%20Finance&entityid=1101415480000073106&templateid=1107170263205300040";

			String username = telspiel.getUsername();
			String dest = telspiel.getDest();
			String apikey = telspiel.getApikey();
			String signature = telspiel.getSignature();
			String msgtype = telspiel.getMsgtype();
			//String msgtxt = telspiel.getMsgtxt();
			String entityid = telspiel.getEntityid();
			String templateid = telspiel.getTemplateid();
			
			String msgtxt = "Dear%20Rahul%2C%20Welcome%20to%20Saswat.%20Your%20application%20ID%20%3A%20A0932123%20and%20customer%20ID%20%3A%20CID0012001.%20If%20you%20have%20any%20questions%20reach-out%20to%20your%20sales%20officer.%20-Saswat%20Finance";

		    //String encodedMsgtxt = URLEncoder.encode(msgtxt, "UTF-8");
		    String fullURL = String.format(

					"%s?username=%s&dest=%s&apikey=%s&signature=%s&msgtype=%s&msgtxt=%s&entityid=%s&templateid=%s",

					baseURL, username, dest, apikey, signature, msgtype, msgtxt, entityid, templateid);

			//String responseEntity = restTemplate.getForObject(fullURL, String.class);

			//return responseEntity;

			URL url = new URL(fullURL);

			// Open connection
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// Set request method
			connection.setRequestMethod("POST");

			// Get response code
			int responseCode = connection.getResponseCode();
			System.out.println("Response Code: " + responseCode);

			// Read response
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuilder response = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// Print response
			System.out.println("Response: " + response.toString());

			// Close connection
			connection.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

}
