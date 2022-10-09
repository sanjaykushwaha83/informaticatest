package com.informatica.github.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureWebMvc
@AutoConfigureMockMvc
public class GitHubSearchControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void withLanguageHaveProjects() throws Exception {
		this.mockMvc.perform(get("/githubprojects/search/{language}", "java")).andDo(print()).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty());
	}

	@Test
	public void withLanguageHaveNoProjects() throws Exception {
		this.mockMvc.perform(get("/githubprojects/search/{language}", "sanjay")).andDo(print())
				.andExpect(status().is4xxClientError())
				.andExpect(MockMvcResultMatchers.jsonPath("$").value("No github projects found for requested language."));
	}

}
