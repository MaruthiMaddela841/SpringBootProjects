<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Details</title>
</head>
<body>
<h2>Books details stored are::</h2>
 <table>
            <tr>
                <td>Book Name:</td>
                <td>${bo.bname}</td>
            </tr>
            <tr>
                <td>Author Name:</td>
                <td>${bo.authorName}</td>
            </tr>
            <tr>
                <td>Price:</td>
                <td>${bo.price}</td>
            </tr>
        </table>
        <a href="loadingform">RELOAD FORM</a>
</body>
</html>