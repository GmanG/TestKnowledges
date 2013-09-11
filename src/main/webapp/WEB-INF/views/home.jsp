<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<c:url value="/js/js.js" />"></script>
<link rel='stylesheet' href="<c:url value="/css/main.css" />"
	type='text/css'>

</head>

<body>
	<div id="main">
		<div id="left"></div>
		<div id="right">
			<div id="result"></div>
			<input type="button" id="bt" onclick="" value="Start Test"> <input
				type="button" id="res" onclick="" value="Show Result"
				disabled="disabled">
		</div>
	</div>
</body>
</html>
