<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Latest compiled and minified CSS -->
<!-- Latest compiled and minified CSS -->
 <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<!-- Optional: Include the jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<!-- Optional: Incorporate the Bootstrap JavaScript plugins -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
 <link rel="apple-touch-icon-precomposed" href="apple-touch-icon-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="apple-touch-icon-72x72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="apple-touch-icon-114x114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="apple-touch-icon-144x144-precomposed.png">
    <link rel="alternate" type="application/rss+xml" title="Latest snippets from Bootsnipp.com" href="http://bootsnipp.com/feed.rss" />

    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://bootsnipp.com/css/bootsnipp.min.css?ver=42f321feccec9b5774d234a7ace874c2">
<title>Project Edition Page </title>
 </head>
<body>
<div class="container">
<form class="form-horizontal" action='' method="POST">
  <fieldset>
    <div id="legend">
      <legend class="">Edit a project</legend>
    </div>
    <div class="control-group">
      <!-- Username -->
      <label class="control-label"  for="projectname">Project Name</label>
      <div class="controls ">
        <input type="text" id="projectname" name="projectname"  placeholder="${projectList.projectName}" } class="input-xlarge">
    
      </div>
    </div>
 
     <div class="control-group">
      <!-- Username -->
      <label class="control-label"  for="projectdesc">Project Description</label>
      <div class="controls">
        <input type="text" id="projectdesc" name="projectdesc" placeholder="${projectList.projectDescrition}" class="input-xlarge">
     
      </div>
    </div>
    <label class="control-label"  for="projectstatus">Status</label>
    <label class="checkbox pull-center">
                    <input type="checkbox" value="activated">
                    Activated
                </label>
    <div class="control-group">
      <!-- Button -->
      <div class="controls">
      	<br>
        <button type="button" id="Save" class="btn btn-success" onClick=updateProjectDetails() >Edit</button>
      </div>
    </div>
  </fieldset>
</form>

<div id="editstatus">

</div>
<div>
<br>
 <legend class="">People Linked to the project</legend>
<table class="table table-hover table-striped table-bordered">
<thead>
<tr>

<th>Complete Name</th>
<th>
<select class="form-control" onchange="addPeopleToProject()" id="userlist">
 <option value="">Add People to this project</option>
 <c:forEach items="${allpeople}" var="allpeople">
        <option value="${allpeople.completeName}">${allpeople.completeName}</option>
    </c:forEach>
    
</select>
  </th>

</thead>

</tr>
<c:forEach items="${people}" var="people">
<tr>
<td>${people.completeName}</a ></td>
<td>
 
<form action ="${people.firstName}/${people.lastName}/deleteuser.html">
	<button type="submit" >Remove</button>
</form>

</td>

</c:forEach>
<tbody>
</tbody>
</table>

</div>
</div>
</body> 

<script type="text/javascript">

function updateProjectDetails(){
	var projectname=$('#projectname').val();
	var projectdesc=$('#projectdesc').val();
	
		$.ajax({  
		     type : "POST",   
		     url : "updateProjectDetails.html",   
		     data : "projectname=" + projectname + "&projectdesc=" + projectdesc,
		       
		     success : function(response) {  
		    	 $("#editstatus").html(response);
		      //alert(response);   
		     },  
		     error : function(e) {  
		      alert('Error: ' + e);   
		     }  
		    });  
		
}

function addPeopleToProject(){
	
	
	var selecteuser=$( "#userlist" ).val();
	
	$.ajax({  
	     type : "POST",   
	     url : "addprojectrouser.html",   
	     data : "selecteuser=" + selecteuser,
	       
	     success : function(response) {  
	    	 
	      alert(response);   
	       location.reload() 
	     },  
	     error : function(e) {  
	      alert('Error: ' + e);   
	     }  
	    });  
}
</script>