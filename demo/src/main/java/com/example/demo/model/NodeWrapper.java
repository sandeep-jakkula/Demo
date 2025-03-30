package com.example.demo.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

@Component
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class NodeWrapper {
	private long totalNumberofResults;
	private ErrorResponse errorResponse;
	private List<Node> resultsData;

	public long getTotalNumberofResults() {
		return totalNumberofResults;
	}

	public void setTotalNumberofResults(long totalNumberofResults) {
		this.totalNumberofResults = totalNumberofResults;
	}

	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(ErrorResponse errorResponse) {
		this.errorResponse = errorResponse;
	}

	public List<Node> getResultsData() {
		return resultsData;
	}

	public void setResultsData(List<Node> resultsData) {
		this.resultsData = resultsData;
	}

}
