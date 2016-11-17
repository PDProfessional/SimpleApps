<!DOCTYPE HTML><%@page language="java"
        contentType="text/html; charset=windows-31j" pageEncoding="windows-31j"%>
<html>
<head>
<title>index</title>
<meta http-equiv="Content-Type" content="text/html; charset=windows-31j">
</head>
<body>
        <form action="/SimpleJMSWeb/SimpleServlet"><input type="submit" name="get" value="get">
        </form>

        <form method="post" action="/SimpleJMSWeb/SimpleServlet">
                <input type="submit" name="put" value="put"><input type="text" name="message" size="20" value="Hello SimpleJMS">
        </form>
</body>
</html>