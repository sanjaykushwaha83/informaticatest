package com.informatica.github.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.informatica.github.model.GitHubSearchResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * GitHub search service implementation to call github search api and transform response.
 * 
 * @author Sanjay.Kushwaha
 *
 */
@Slf4j
@Component
public class GitHubSearchServiceImpl implements GitHubSearchService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${github.search.repo.url}")
	private String githubSearchUrl;
	@Value("${github.access.token}")
	private String githubAccesToken;

	/**
	 * Get All Github projects by language
	 * 
	 * @param language like java, python.
	 * @return List of projects
	 */
	@Override
	public GitHubSearchResponse getProjects(String language) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/vnd.github+json");
		headers.set("Authorization", "Bearer " + githubAccesToken);
		HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
		GitHubSearchResponse projects = null;
		try {
			ResponseEntity<GitHubSearchResponse> response = restTemplate.exchange(githubSearchUrl, HttpMethod.GET,
					requestEntity, GitHubSearchResponse.class, language);
			projects = response.getBody();
		} catch (RestClientException e) {
			log.error("RestClientException:" + e.getMessage());
			if (e instanceof HttpStatusCodeException) {
				String errorResponse = ((HttpStatusCodeException) e).getResponseBodyAsString();
				log.error("errorResponse:" + errorResponse);
			}
		}
		return projects;
	}

}
