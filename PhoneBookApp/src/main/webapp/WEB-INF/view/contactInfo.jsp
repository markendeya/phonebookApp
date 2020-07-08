<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 

<html>
<head>
<style type="text/css">
h4{
text-align:center;
}
div{
width:200px;
height:400px;
margin-left:40px;
border:1px solid black;
padding:10px;
}
input{
margin-bottom:15px;

}
input.submit{
margin-left:60px;
margin-top:20px
display:block;
}
a{
display:block;
}
</style>

</head>

<body>
<div>
<h4>${sucess }</h4>
<h4 style="text-decoration:underline">Contact Info</h4>
<form:form action="processForm" modelAttribute="contact">
<label>Name:</label>
<form:input type="text" value="" path="contactName"/><br/>

<label>Email:</label>
<form:input type="text" value="" path="contactEmail"/><br/>
<label>Phno:</label>
<form:input type="text"  path="contactNumber"/><br/>

<input type="submit" value="Submit" class="submit" name="submit"/>

<a href="showContact">view all contacts</a>
</form:form>


</div>
</body>


</html>