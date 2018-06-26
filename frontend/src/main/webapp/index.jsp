<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/script.js?v=1"></script>
</head>


<link href="styles/main.css" rel="stylesheet" type="text/css">
<html>
<body id="body">

<form action = "/date" method = "GET">
    Date (yyyy-mm-dd): <input type = "text"  name = "date" pattern="([1-2][0-9][0-9][0-9])-([0-9]{2})-([0-9]{2})">
    <input type = "submit" value = "Submit" />
    <h5 id="error">${error}</h5>
    <p id="buttonClick">click!</p>

</form>

</body>
</html>