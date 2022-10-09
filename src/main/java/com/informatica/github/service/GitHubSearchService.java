package com.informatica.github.service;

import org.springframework.stereotype.Component;

import com.informatica.github.model.GitHubSearchResponse;

@Component
public interface GitHubSearchService {

	/**
	 * Get All Github projects by language
	 * 
	 * @param language like java, python.
	 * @return List of projects
	 */
	public GitHubSearchResponse getProjects(String language);
}
