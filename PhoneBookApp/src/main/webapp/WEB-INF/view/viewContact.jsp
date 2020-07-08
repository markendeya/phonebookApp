<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 

<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.css"/>
<style>
body{
background-color:#8bcdcd;
}
div{
width:900px;
margin:0px auto;

}
th{
padding:8px;
}
table{
width:1000px;
height:500px;
background-color:white;
text-align:center;
box-shadow:5px 10px #888888;
border:none;
}
td{

padding:5px;
}

a{
color:#1b6ca8
}
#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>
</head>

<body>
<p>${success}</p>
<div>
<a href="showForm">+Add new record</a>
<table id="customers" border="1" cellspacing="0">
<thead >
<tr>
<th>S.no</th>
<th>contact name</th>
<th>contact email</th>
<th>contact number</th>
<th></th>
<th></th>
</tr>
</thead>
<tbody>
 <c:forEach var = "contact" items="${contactList}"  varStatus="index">
<tr>
         <td><c:out value = "${index.count}"/></td>
         <td><c:out value="${contact.contactName}"></c:out></td>
          <td><c:out value="${contact.contactEmail}"></c:out></td>
          <td><c:out value="${contact.contactNumber}"></c:out></td>
          <td><a href="editForm?id=${contact.contactId}">Edit</a></td>
          <td><a href="deleteForm?id=${contact.contactId}">Delete</a></td>
</tr>
 </c:forEach>



</tbody>


</table>
</div>
<script>
$(document).ready( function () {
    $('#customers').DataTable();
    console.log("test");
} );
</script>


</body>


</html>