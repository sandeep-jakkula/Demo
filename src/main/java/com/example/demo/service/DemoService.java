package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Node;
import com.example.demo.model.NodeWrapper;
import com.example.demo.repository.NodeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class DemoService {

	@Autowired
	private NodeRepository nodeRepository;

	@Autowired
	private NodeWrapper nodeWrapper;

	public Object addNodesService(List<Node> nodes) {
		// Logic to persist the node data in the database
		return nodeRepository.saveAll(nodes);
	}

	public Object getAllNodesService() throws JsonMappingException, JsonProcessingException {
		nodeWrapper = new NodeWrapper();
		List<Node> resultsData = nodeRepository.findAll();

		nodeWrapper.setResultsData(resultsData);
		nodeWrapper.setTotalNumberofResults(resultsData.size());
		return nodeWrapper;
	}

}
