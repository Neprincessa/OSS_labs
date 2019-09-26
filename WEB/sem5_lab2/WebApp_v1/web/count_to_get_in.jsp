<%--
  Created by IntelliJ IDEA.
  User: anastasia
  Date: 25.09.2019
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    body {
        background: aquamarine;
    }
    section {
        background: darkcyan;
        color: white;
        border-radius: 1em;
        padding: 1em;
        font-family: sans-serif;
        position: absolute;
        top: 50%;
        left: 50%;
        margin-right: -50%;
        transform: translate(-50%,-50%);
    }
    div {
        font-size: 60px;
    }
    p {
        font-size: 40px;
    }
</style>
<body>
<section>
    <div align="center">
        <div>
            Count the sum!
        </div>
        <p>${number1} + ${number2} = </p>
        <form method="POST">
            <input type="number" name="answer" placeholder="enter your answer" />
            <input type="hidden" name="hash" value=${hash} />
            <input type="submit" name="Go!" />
        </form>
    </div>
</section>

</body>
</html>