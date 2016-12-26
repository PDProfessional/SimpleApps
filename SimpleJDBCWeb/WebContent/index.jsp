<!DOCTYPE HTML><%@page language="java"
        contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>index</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
        <form action="/SimpleJDBCWeb/SimpleServlet">
                <input type="text" name="sql" size="60" value="SELECT * FROM EMP">
                <input type="submit" name="operation" value="select">
        </form>

        <form action="/SimpleJDBCWeb/SimpleServlet">
                <input type="text" name="sql" size="60" value="UPDATE EMP SET NAME='BBB' WHERE ID=2">
                <input type="submit" name="operation" value="update">
        </form>

        <form action="/SimpleJDBCWeb/SimpleServlet">
                <input type="text" name="sql" size="60" value="INSERT INTO EMP(ID, NAME) VALUES(3,'CCC')">
                <input type="submit" name="operation" value="insert">
        </form>

        <form action="/SimpleJDBCWeb/SimpleServlet">
                <input type="text" name="sql" size="60" value="DELETE  FROM EMP WHERE ID=3">
                <input type="submit" name="operation" value="delete">
        </form>
</body>
</html>