<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina Test</title>
</head>
<body>
	<h1>Este es un Ejemplo de HTML</h1>
	<h2>Este es un subtitulo</h2>
	<p>Este es un tag de un parrafo puede acepter instrucciones</p>
	<br>
	<p>
		Usuario: <input type="text" name="usuario" value="alex"><br>
		Password: <input type="password" name="password" value="alex"><br>
		Campo Oculto: <input type="hidden" name="oculto" value="alex"><br>
	</p>
	<br>
	<h1>Ejemplo de Tabla</h1>
	<br>
	<table style="border: dotted" border="1">
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Calificacion</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Nombre 1</td>
				<td>Apellido 1</td>
				<td>Calific. 1</td>
			</tr>
			<tr>
				<td>Nombre 2</td>
				<td>Apellido 2</td>
				<td>Calific. 2</td>
			</tr>
			<tr>
				<td>Nombre 3</td>
				<td>Apellido 3</td>
				<td>Calific. 3</td>
			</tr>
		</tbody>
	</table>

	<img src="Imagenes/Koala.jpg" alt="Este es un Koala" width="200"
		height="200" align="left">
	<img src="Imagenes/Koala.jpg" alt="Este es un Koala" width="200"
		height="200" align="right">

	<br>
	<h1>Tabla con Imagenes</h1>
	<br>

	<table style="border: dotted" border="1">
		<thead>
			<tr>
				<th>Pinguinos</th>
				<th>Tulipanes</th>
				<th>Desierto</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><img src="Imagenes/Penguins.jpg" alt="Este es un Pinguino"
					width="200" height="200" align="center"></td>
				<td><img src="Imagenes/Tulips.jpg" alt="Este es un Tulipan"
					width="200" height="200" align="center"></td>
				<td><img src="Imagenes/Desert.jpg" alt="Este es un Desierto"
					width="200" height="200" align="center"></td>
			</tr>
		</tbody>
	</table>

</body>
</html>