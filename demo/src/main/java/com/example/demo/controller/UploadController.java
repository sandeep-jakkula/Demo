package com.example.demo.controller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Node;
import com.example.demo.service.DemoService;

@Controller
public class UploadController {
	
	@Autowired
	private DemoService demoService;

	@RequestMapping("/")
	public String index() {
		return "upload"; // Return the upload.jsp page
	}

	@PostMapping("/upload")
	public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload.");
			return "redirect:/";
		}

		try {
			Path uploadDir = Files.createTempDirectory("uploads");
			// Save the file on the server
			String uplaodedFilePath = uploadDir + file.getOriginalFilename();
			file.transferTo(new File(uplaodedFilePath));
			
			// Read and parse the CSV file
            List<Node> nodes = parseCsvFile(uplaodedFilePath);
            demoService.addNodesService(nodes);
            

			redirectAttributes.addFlashAttribute("message",
					"You successfully uploaded '" + file.getOriginalFilename() + "'!");
		} catch (IOException e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("message",
					"Failed to upload '" + file.getOriginalFilename() + "' due to " + e.getMessage());
		}
		System.out.println("File uploaded successfully");
		return "redirect:/";
	}
	
	private List<Node> parseCsvFile(String filePath) {
        List<Node> nodes = new ArrayList<>();

        try (
            Reader reader = new FileReader(filePath);
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
        ) {
            for (CSVRecord csvRecord : csvParser) {
                // Assuming your CSV columns are "id", "name", "value"
            	
            	String nodeId = csvRecord.get("Node ID");
            	String nodeName = csvRecord.get("Node name");
            	String description = csvRecord.get("Description");
            	String memo = csvRecord.get("Memo");
            	String nodeType = csvRecord.get("Node type");
            	String parentNodeGroupId = csvRecord.get("Parent node group ID");
            	String parentNodeGroupName = csvRecord.get("Parent node group name");
            	
                Node node = new Node(nodeId, nodeName, description, memo, nodeType, parentNodeGroupId, parentNodeGroupName);
                nodes.add(node);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return nodes;
    }
}
