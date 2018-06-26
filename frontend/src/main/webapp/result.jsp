
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/script.js?v=1"></script>
</head>

<link href="styles/main.css" rel="stylesheet" type="text/css">
<html>
<body>
<h5>Rate for selceted date: </h5>

<div class="grid-container">
    <div class="item1">${date}</div>
    <div class="item2">${symbol} </div>
    <div class="item3">EUR</div>
    <div class="item4">${message}</div>
</div>
<button id ="goSearchButton"><p>Select new date</p></button>

</body>
</html>