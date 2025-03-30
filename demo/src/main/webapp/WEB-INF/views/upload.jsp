<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Upload File</title>
</head>
<body>
    <h2>Upload a File</h2>
    <form method="post" action="/upload" enctype="multipart/form-data">
        <input type="file" name="file" />
        <br><br>
        <input type="submit" value="Upload" />
    </form>
</body>
</html>
