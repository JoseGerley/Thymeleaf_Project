package com.example.demo.delegate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.TsscGame;
import com.example.demo.model.TsscStory;
import com.example.demo.model.TsscTopic;


@Component
public class TsscGameDelegate {
	 @Autowired
	 private RestTemplate restTemplate;
	 
	 @Value("${resource.games}")
	 private String resource;
	 
	 @Value("${resource.games}/{id}")
	 private String idResource;
	 
	 @Value("${resource.games}/{id}/topic")
	 private String topicResource;
	
	 @Value("${resource.games}/{id}/stories")
	 private String storiesResource;
	 
	 public List<TsscGame> findAll() {
		return Arrays.stream(restTemplate.getForObject(resource, TsscGame[].class)).collect(Collectors.toList());
	 }
	 
	 public TsscGame findById(long id) {
		return restTemplate.getForObject(idResource, TsscGame.class, id);
	 }
	 
	 public TsscTopic findTopic(long id) {
		return restTemplate.getForObject(topicResource, TsscTopic.class, id);
	 }
	 
	 public List<TsscStory> findStories(long id) {
		return Arrays.stream(restTemplate.getForObject(storiesResource, TsscStory[].class, id)).collect(Collectors.toList());
	 }
	  
	 public void save(TsscGame game) {
		restTemplate.postForObject(resource, game, TsscGame.class);
	 }
	 
	 public void update(long id, TsscGame game) {
		restTemplate.exchange(idResource, HttpMethod.PUT, new HttpEntity<>(game), TsscGame.class, id).getBody();
	 }
	 
	 public void delete(long id) {
		restTemplate.delete(idResource, id);
	 }
	 public String getIdResource() {
		 return idResource;
	 }


}
