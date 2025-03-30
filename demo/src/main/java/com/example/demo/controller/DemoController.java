package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Node;
import com.example.demo.service.DemoService;

@Validated
@RestController
public class DemoController {

	@Autowired
	DemoService demoService;

	@GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
	public String sayhello() {
		return "Hello World!";
	}

	@PostMapping(value = "/addNodes", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object addNodes(@RequestBody List<@Valid Node> nodes) {
		demoService.addNodesService(nodes);
		return ResponseEntity.status(HttpStatus.OK).body("Nodes data created successfully!!");
	}

	@GetMapping(value = "/nodes", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getAllNodes() throws Exception {
		return demoService.getAllNodesService();
	}
}
