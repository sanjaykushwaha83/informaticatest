package com.informatica.github.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.informatica.github.model.GitHubSearchResponse;
import com.informatica.github.service.GitHubSearchService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class GitHubSearchController {

	@Autowired
	private GitHubSearchService searchService;

	@GetMapping("/githubprojects/search/{language}")
	@Operation(summary = "Search github projects by specific language, e.g rust, go, coffeescript,java,python ..etc")
	public ResponseEntity<Object> getProjects(@PathVariable String language) {
		GitHubSearchResponse response = searchService.getProjects(language);
		return response == null
				? new ResponseEntity<Object>("No github projects found for requested language.", HttpStatus.NOT_FOUND)
				: ResponseEntity.ok(response);
	}
}
