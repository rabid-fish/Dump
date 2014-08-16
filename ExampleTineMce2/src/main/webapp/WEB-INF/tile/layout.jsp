<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE>
<html>
<head>
<title><tiles:insertAttribute name="title" /></title>
<script type="text/javascript" src="/ExampleTinyMce/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript">
/* Loading page-specific javascript code */
<tiles:insertAttribute name="script" />
</script>
</head>

<body>

	<h1>Welcome</h1>
	<tiles:insertAttribute name="body" />

</body>
</html>
