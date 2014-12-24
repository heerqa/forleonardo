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
        <input type="text" id="projectname" name="projectname"  placeholder="${projectList.projectName}" } class="input-xlarge" required>
    
      </div>
    </div>
 
     <div class="control-group">
      <!-- Username -->
      <label class="control-label"  for="projectdesc">Project Description</label>
      <div class="controls">
        <input type="text" id="projectdesc" name="projectdesc" placeholder="${projectList.projectDescrition}" class="input-xlarge" required>
     
      </div>
    </div>
    <label class="control-label"  for="projectstatus">Status</label>
    <label class="checkbox pull-center">
                    <input type="checkbox" id="activecheckbox" data-toggle="modal" data-target="#myModal"  value="activated" checked >
                    Activated
                </label>
    <div class="control-group">
    	<div id="activestatus">

		</div>
      <!-- Button -->
      <div class="controls">
      	<br>
        <button type="button" id="Save" class="btn btn-primary" onClick=updateProjectDetails() >Edit</button>
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
	<button type="submit" class="btn btn-primary"  >Remove</button>
</form>

</td>

</c:forEach>
<tbody>
</tbody>
</table>

</div>
</div>

</body> 

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">deactivate</h4>
      </div>
      <div class="modal-body">
        This project won’t be listed in main page, are you sure you want to deactivated this project?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" onClick="selectCheckbox()">NO</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal" onClick="deactivateProject()" >Yes</button>
      </div>
    </div>
  </div>
</div>


<script type="text/javascript">

function updateProjectDetails(){
	var validate=validateFiles();
	if (validate!=false) {
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
}

function addPeopleToProject(){
	
	
	var selecteuser=$( "#userlist" ).val();
	
	$.ajax({  
	     type : "POST",   
	     url : "addprojectrouser.html",   
	     data : "selecteuser=" + selecteuser,
	       
	     success : function(response) {  
	    	 
	      //alert(response); 
	      alert(response);
		
	       location.reload() 
	     },  
	     error : function(e) {  
	      alert('Error: ' + e);   
	     }  
	    });  
}

function deactivateProject(){
	
	$.ajax({  
	     type : "POST",   
	     url : "deactivateproject.html",   
	    
	       
	     success : function(response) {  
	    	 
	    	 $("#activestatus").html(response);  
	      
	     },  
	     error : function(e) {  
	      alert('Error: ' + e);   
	     }  
	    });  
}

function selectCheckbox(){
	$('#activecheckbox').prop('checked', true);
	
}
function validateFiles(){
	var name=$('#projectname').val();
	
	var desc=$('#projectdesc').val();
	
	
	if (name==""||desc==""||name==null ||desc==null ) {
		alert("Please enter values in all fields"); 	
		return false;
	}
}


</script>