<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">
 
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
 <header>
  <nav class="navbar navbar-expand-md navbar-dark"
   style="background-color: 26883f">
   <div>
    <a href="" class="navbar-brand"> Todo
     App</a>
   </div>

   <ul class="navbar-nav">
    <li><a href="<%=request.getContextPath()%>/list"
     class="nav-link">Todos</a></li>
   </ul>

   <ul class="navbar-nav navbar-collapse justify-content-end">
    <li><a href="<%=request.getContextPath()%>/logout"
     class="nav-link">Logout</a></li>
   </ul>
  </nav>
 </header>
 <div class="container col-md-5">
  <div class="card">
   <div class="card-body">
    <c:if test="${todo != null}">
     <form action="update" method="post">
    </c:if>
    <c:if test="${todo == null}">
     <form action="insert" method="post">
    </c:if>

    <caption>
     <h2>
      <c:if test="${todo != null}">
               Edit Todo
              </c:if>
      <c:if test="${todo == null}">
               Add New Todo
              </c:if>
     </h2>
    </caption>

    <c:if test="${todo != null}">
     <input type="hidden" name="id" value="<c:out value='${todo.id}' />" />
    </c:if>

    <fieldset class="form-group">
     <label>Todo Title</label> <input type="text"
      value="<c:out value='${todo.title}' />" class="form-control"
      name="title" required="required" minlength="5">
    </fieldset>

    <fieldset class="form-group">
     <label>Todo Decription</label> <input type="text"
      value="<c:out value='${todo.description}' />" class="form-control"
      name="description" minlength="5">
    </fieldset>

    <fieldset class="form-group">
     <label>Todo Status</label> <select class="form-control"
      name="isDone">
      <option value="false">In Progress</option>
      <option value="true">Complete</option>
     </select>
    </fieldset>

    <fieldset class="form-group">
     <label>Todo Target Date</label> <input type="date"
      value="<c:out value='${todo.targetDate}' />" class="form-control"
      name="targetDate" required="required">
    </fieldset>

    <button type="submit" class="btn btn-success glow-on-hover">Save</button>
    </form>
   </div>
  </div>
 </div>

 <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>