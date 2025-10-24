<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Travoldata</title>

<style>
  html, body {
    margin: 0;
    padding: 0;
    height: 100%;
    overflow: hidden;
    font-family: Arial, sans-serif;
    color: white;
    text-align: center;
  }

  body {
    background-image: url('assets/images/404.gif'); /* Chemin vers ton gif */
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
  }

  .message {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    background-color: rgba(0, 0, 0, 0.5);
    padding: 30px 40px;
    border-radius: 15px;
  }

  h1 {
    font-size: 48px;
    margin: 0 0 10px 0;
  }

  p {
    font-size: 20px;
    margin: 0;
  }
</style>
</head>

<body>
<div>

<audio id="music1" src="assets/audios/meow-meow-meow-tiktok.mp3" autoplay loop></audio>
</div>
  <div class="message">
    <p>(╯°□°)╯︵ ┻━┻.</p>
  </div>
</body>
</html>
