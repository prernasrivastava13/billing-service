<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri='/WEB-INF/tlds/template.tld' prefix='template' %>
<html>
<head><title><template:get name='title'/></title></head>
<body background='graphics/background.jpg'>
<div style="border: 1px solid #ccc; padding: 5px; margin-bottom: 20px;">

    <c:

    <h1>Your Facebook Email is -${user.getFirstName()} </h1>
    <h1>Your Facebook First Name is - </h1>
    <h1>Your Facebook Last Name is - </h1>

</div>
</body>
</html>