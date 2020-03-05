<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<form action="students" method="POST">
    <label>NAME:
        <input type="text" name="name"></label>
        <br>
        <label>ROLL_NO.:
            <input type="text" name="rollno"></label>
            <br>
            <label>UNIVERSITY:
                <input type="text" name="university"></label>
                <br>
                <input type="submit" value="register"/>
                <br>
                <br>
                <br>
                <br>

</form>
<form action="getID" method="GET">
   <label> Get details of ID:
                <input type="text" name="searchroll"></label>
                <input type="submit" value="search"/>
</form>

</body>
</html>