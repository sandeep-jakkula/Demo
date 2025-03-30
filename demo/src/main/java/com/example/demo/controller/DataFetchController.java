package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Node;
import com.example.demo.model.NodeWrapper;
import com.example.demo.service.DemoService;

@Controller
public class DataFetchController {
	
	@Autowired
	private DemoService demoService;

    @GetMapping("/result")
    public String showResult(Model model) throws Exception {
    	NodeWrapper	nodeWrapper = (NodeWrapper) demoService.getAllNodesService();
    	
        List<Node> nodes = nodeWrapper.getResultsData();

        // Store nodes in session to access in GET request
        model.addAttribute("nodes", nodes);
		return "results";
    }
    
}
