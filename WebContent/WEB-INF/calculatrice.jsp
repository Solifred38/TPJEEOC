<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculatrice</title>

</head>
<body>

	<p>${ !empty param1 || !empty param2 ? 'le resultat de l operation est :' : '' }
		${!empty param1 || !empty param2 ? resultat:''}</p>
	<form method="post">
		<input type="number" name="param1"> <input list="operations"
			type="text" id="choix_operation">
		<datalist id="operations">
			<option value="+"><option value="-">
  
			<option value="/">
  
			<option value="%">

		</datalist> 
<input type="number" name="param2">
				<input type="submit" style="height: 50px; width: 100px"
					value="Envoyer" name="envoyer">
	
			</form>
</body>
</html>