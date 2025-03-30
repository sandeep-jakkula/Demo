package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Node {

	@NotBlank(message = "Node id cannot be blank/ null")
	@Pattern(regexp = "^[^!@#$%^&*()]*$", message = "Node id should not contain special characters like !@#$%^&*()")
	@Id
	private String nodeId;

	@NotBlank(message = "Node Name cannot be blank/ null")
	@Pattern(regexp = "^[^!@#$%^&*()]*$", message = "Node Name should not contain special characters like !@#$%^&*()")
	private String nodeName;

	@NotBlank(message = "Description cannot be blank/ null")
	@Pattern(regexp = "^[^!@#$%^&*()]*$", message = "Description should not contain special characters like !@#$%^&*()")
	private String description;

	@NotBlank(message = "Memo cannot be blank/ null")
	@Pattern(regexp = "^[^!@#$%^&*()]*$", message = "Memo should not contain special characters like !@#$%^&*()")
	private String memo;

	@NotBlank(message = "Node Type cannot be blank/ null")
	@Pattern(regexp = "^[^!@#$%^&*()]*$", message = "Node Type should not contain special characters like !@#$%^&*()")
	private String nodeType;

	@NotBlank(message = "ParentNode GroupId cannot be blank/ null")
	@Pattern(regexp = "^[^!@#$%^&*()]*$", message = "ParentNode GroupId should not contain special characters like !@#$%^&*()")
	private String parentNodeGroupId;

	@NotBlank(message = "ParentNode GroupName cannot be blank/ null")
	@Pattern(regexp = "^[^!@#$%^&*()]*$", message = "ParentNode GroupName should not contain special characters like !@#$%^&*()")
	private String parentNodeGroupName;

	public Node() {
		super();
	}
	
	public Node(
			@NotBlank(message = "Node id cannot be blank/ null") @Pattern(regexp = "^[^!@#$%^&*()]*$", message = "Node id should not contain special characters like !@#$%^&*()") String nodeId,
			@NotBlank(message = "Node Name cannot be blank/ null") @Pattern(regexp = "^[^!@#$%^&*()]*$", message = "Node Name should not contain special characters like !@#$%^&*()") String nodeName,
			@NotBlank(message = "Description cannot be blank/ null") @Pattern(regexp = "^[^!@#$%^&*()]*$", message = "Description should not contain special characters like !@#$%^&*()") String description,
			@NotBlank(message = "Memo cannot be blank/ null") @Pattern(regexp = "^[^!@#$%^&*()]*$", message = "Memo should not contain special characters like !@#$%^&*()") String memo,
			@NotBlank(message = "Node Type cannot be blank/ null") @Pattern(regexp = "^[^!@#$%^&*()]*$", message = "Node Type should not contain special characters like !@#$%^&*()") String nodeType,
			@NotBlank(message = "ParentNode GroupId cannot be blank/ null") @Pattern(regexp = "^[^!@#$%^&*()]*$", message = "ParentNode GroupId should not contain special characters like !@#$%^&*()") String parentNodeGroupId,
			@NotBlank(message = "ParentNode GroupName cannot be blank/ null") @Pattern(regexp = "^[^!@#$%^&*()]*$", message = "ParentNode GroupName should not contain special characters like !@#$%^&*()") String parentNodeGroupName) {
		super();
		this.nodeId = nodeId;
		this.nodeName = nodeName;
		this.description = description;
		this.memo = memo;
		this.nodeType = nodeType;
		this.parentNodeGroupId = parentNodeGroupId;
		this.parentNodeGroupName = parentNodeGroupName;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public String getParentNodeGroupName() {
		return parentNodeGroupName;
	}

	public void setParentNodeGroupName(String parentNodeGroupName) {
		this.parentNodeGroupName = parentNodeGroupName;
	}

	public String getParentNodeGroupId() {
		return parentNodeGroupId;
	}

	public void setParentNodeGroupId(String parentNodeGroupId) {
		this.parentNodeGroupId = parentNodeGroupId;
	}
}
