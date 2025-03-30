<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>CSV Upload Result</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2>Data</h2>

    <c:if test="${not empty nodes}">
        <table>
            <thead>
                <tr>
                    <th>Node ID</th>
                    <th>Node Name</th>
                    <th>Description</th>
                    <th>Memo</th>
                    <th>Node Type</th>
                    <th>Parent Node Group ID</th>
                    <th>Parent Node Group Name</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="node" items="${nodes}">
                    <tr>
                        <td>${node.nodeId}</td>
                        <td>${node.nodeName}</td>
                        <td>${node.description}</td>
                        <td>${node.memo}</td>
                        <td>${node.nodeType}</td>
                        <td>${node.parentNodeGroupId}</td>
                        <td>${node.parentNodeGroupName}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty nodes}">
        <p>No data available to display.</p>
    </c:if>

</body>
</html>
