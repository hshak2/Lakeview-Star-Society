package com.LakeviewStarSociety.quickstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/nasa")
@CrossOrigin(origins = "*") //allows requests from any domain

@SpringBootApplication
public class LakeviewStarSocietyApplication {
	@Value("${nasa.api.key}")
	private String apiKey;

	@GetMapping("/picture")
	public ResponseEntity<?>
	getNasaPicture(@RequestParam String date) {
		String url =
				String.format("https://api.nasa.gov/planetary/apod?api_key=%s&date=%s", apiKey, date);
		RestTemplate restTemplate = new RestTemplate();
		Map<String, Object> response = restTemplate.getForObject(url, HashMap.class);
		return ResponseEntity.ok(response);
	}

	public static void main(String[] args) {
		SpringApplication.run(LakeviewStarSocietyApplication.class, args);
	}

}
