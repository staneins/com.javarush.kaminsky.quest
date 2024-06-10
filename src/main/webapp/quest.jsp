<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Quest</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="bg-image"
     style="background-image: url('https://eskipaper.com/images/elder-scrolls-13.jpg');
            height: 200vh; display: flex; flex-direction: column; justify-content: space-between; background-repeat: no-repeat; background-size: cover;">
    <div style="display: flex; flex-direction: column; align-items: center; justify-content: center; margin-top: 50px;">
        <div class="card text-bg-secondary mb-3" style="max-width: 55rem;">
            <div class="card-header"><h1>${message}</h1></div>
            <div style="display: flex; flex-direction: row; align-items: center; justify-content: center;">
                <p><a href="/master?answer=${answerId1}" class="link-light link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover">${answer1}</a></p>
            </div>
            <div style="display: flex; flex-direction: row; align-items: center; justify-content: center;">
                <p><a href="/master?answer=${nextQuestionId2}" class="link-light link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover">${answer2}</a></p>
            </div>
            <div style="display: flex; flex-direction: row; justify-content: flex-start; align-items: flex-start; width: 100%; margin-top: 10px;">
                <p style="margin-left: 10px;">Player name: ${username}</p></br>
                <p style="margin-left: 10px;">Level: ${level}</p>
            </div>
        </div>
    </div>
</div>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>
