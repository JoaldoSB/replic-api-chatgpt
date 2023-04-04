package com.mba.hackathonuniesp.service;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class MensagemService {

			
	private final String apiKey = "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";
	private final String apiUrl = "https://api.openai.com/v1/engines/text-davinci-003/completions";
    
    

	public String sendMessage(String message) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBearerAuth(apiKey);

		Map<String, Object> requestBody = new HashMap<>();
		requestBody.put("prompt", message);
		requestBody.put("max_tokens", 1000);
		requestBody.put("temperature", 0.7);

		HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

		ResponseEntity<String> responseEntity = restTemplate.postForEntity(apiUrl, requestEntity, String.class);
		return responseEntity.getBody();
	}
}
