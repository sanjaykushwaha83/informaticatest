package com.informatica.github.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GitHubProject {
	private long id;
	private String name;
	private String url;
	private GitHubProjectOwner owner;
}
