<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Fest-Burger</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
    body {
        margin: 0;
        font-family: Arial, Helvetica, sans-serif;
        background-color: #121212;
        color: white;
    }

    .topnav {
        position: -webkit-sticky;
        position: sticky;
        top: 0px;
        overflow: hidden;
        background-color: #333;
    }

    .topnav a {
        float: left;
        color: #f2f2f2;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
        font-size: 17px;
    }

    .topnav a:hover {
        background-color: #ddd;
        color: black;
    }

    .topnav a.active {
        background-color: #04AA6D;
        color: white;
    }

    .topnav-right {
        float: right;
    }
</style>
</head>
<body>

<div class="topnav">
    <a class="active" href="/">Strona główna</a>
    <a href="menu">Menu</a>
    <a href="contact">Kontakt</a>
    <div class="topnav-right">
        <a href="login">Zaloguj się</a>
        <a href="registration">Utwórz nowe konto</a>
        <a href="profile">Profil</a>
    </div>
</div>