<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="./style.css">
</head>
<body>

<!-- partial:index.partial.html -->

  
  <div id="container"></div>
  <script id="template">
    <div class="flip-card" on-click="toggle('flipCard')">{{ flipCard ? 'Reset' : 'Animate' }}</div>
    <div class="contact-wrapper">
        <div class="envelope {{ flipCard ? 'active' : '' }}">
          <div class="back paper"></div>
          <div class="content">
            <div class="form-wrapper">
              <form>
                <div class="top-wrapper">
                  <div class="input">
                    <label>Nombre</label>
                    <input type="text" name="Nombre"/>
                  </div>
                  <div class="input">
                    <label>Celular</label>
                    <input type="text" name="Celular"/>
                  </div>
                  <div class="input">
                    <label>Email</label>
                    <input type="text" name="Email"/>
                  </div>
                </div>
                <div class="bottom-wrapper">
                  <div class="input">
                    <label>Correo</label>
                    <input type="text" name="Correo"/>
                  </div>
                  <div class="input">
                    <label>Mensaje</label>
                    <textarea rows="5" name="Mensaje"></textarea>
                  </div>
                  <div class="submit">
                    <div class="submit-card" on-click="toggle('flipCard')">Enviar Correo</div>
                  </div>
                </div>
              </form>
            </div>
          </div>
          <div class="front paper"></div>
        </div>
      </div>
    
  </script>
  

<!-- partial -->
  <script src='https://cdn.jsdelivr.net/npm/ractive@0.9'></script><script  src="./script.js"></script>

</body>
</body>
</html>