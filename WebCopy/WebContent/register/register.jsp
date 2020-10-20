<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
   <head>
        <meta charset="ISO-8859-1">
        <title>Insert title here</title>

        <link rel="stylesheet" href="//stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

  <link rel="stylesheet" href="//stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
   	     <style type="text/css">
   	     
   	     	body {background-color: #239641;
   	     	}
   	     	.container{
   	     	overflow: hidden;
   	     	}
   	     	h1 {color:white}
   	     	label {color:white}
   	     	
   	     	
   	     	.glow-on-hover {
			    width: 220px;
			    height: 50px;
			    border: none;
			    outline: none;
			    color: #fff;
			    background: #111;
			    cursor: pointer;
			    position: relative;
			    z-index: 0;
			    border-radius: 10px;
			}
			
			.glow-on-hover:before {
			    content: '';
			    background: linear-gradient(45deg, #ff0000, #ff7300, #fffb00, #48ff00, #00ffd5, #002bff, #7a00ff, #ff00c8, #ff0000);
			    position: absolute;
			    top: -2px;
			    left:-2px;
			    background-size: 400%;
			    z-index: -1;
			    filter: blur(5px);
			    width: calc(100% + 4px);
			    height: calc(100% + 4px);
			    
			    animation: glowing 20s linear infinite;
			    opacity: 0;
			    transition: opacity .3s ease-in-out;
			    border-radius: 10px;
			}
			
			.glow-on-hover:active {
			    color: #000
			}
			
			.glow-on-hover:active:after {
			    background: transparent;
			}
			
			.glow-on-hover:hover:before {
			    opacity: 1;
			}
			
			.glow-on-hover:after {
			    z-index: -1;
			    content: '';
			    position: absolute;
			    width: 100%;
			    height: 100%;
			    background: #111;
			    left: 0;
			    top: 0;
			    border-radius: 10px;
			}
			
			@keyframes glowing {
			    0% { background-position: 0 0; }
			    50% { background-position: 400% 0; }
			    100% { background-position: 0 0; }
			}
   	     </style>

    </head>
    <body>
        <jsp:include page="../common/header.jsp"></jsp:include>
        <div class="container">

            <h2>User Register Form</h2>
            <div class="col-md-6 col-md-offset-3">
                <div class="alert alert-success center" role="alert">
                    <p>${NOTIFICATION}</p>
                </div>

                <form action="<%=request.getContextPath()%>/register" method="post">

                    <div class="form-group">
                        <label for="uname">First Name:</label> <input type="text" class="form-control" id="uname" placeholder="First Name" name="firstName" required>
                    </div>

                    <div class="form-group">
                        <label for="uname">Last Name:</label> <input type="text" class="form-control" id="uname" placeholder="last Name" name="lastName" required>
                    </div>

                    <div class="form-group">
                        <label for="uname">User Name:</label> <input type="text" class="form-control" id="username" placeholder="User Name" name="username" required>
                    </div>

                    <div class="form-group">
                        <label for="uname">Password:</label> <input type="password" class="form-control" id="password" placeholder="Password" name="password" required>
                    </div>

                    <button type="submit" class="btn btn-primary glow-on-hover">Submit</button>

                </form>
            </div>
        </div>
        <jsp:include page="../common/footer.jsp"></jsp:include>
    </body>

    </html>