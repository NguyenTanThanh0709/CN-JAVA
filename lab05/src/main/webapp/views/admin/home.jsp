<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Bootstrap Table with Add and Delete Row Feature</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style>
body {
	color: #404E67;
	background: #F5F7FA;
	font-family: 'Open Sans', sans-serif;
}

.table-wrapper {
	width: 700px;
	margin: 30px auto;
	background: #fff;
	padding: 20px;
	box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
}

.table-title {
	padding-bottom: 10px;
	margin: 0 0 10px;
}

.table-title h2 {
	margin: 6px 0 0;
	font-size: 22px;
}

.table-title .add-new {
	float: right;
	height: 30px;
	font-weight: bold;
	font-size: 12px;
	text-shadow: none;
	min-width: 100px;
	border-radius: 50px;
	line-height: 13px;
}

.table-title .add-new i {
	margin-right: 4px;
}

table.table {
	table-layout: fixed;
}

table.table tr th, table.table tr td {
	border-color: #e9e9e9;
}

table.table th i {
	font-size: 13px;
	margin: 0 5px;
	cursor: pointer;
}

table.table th:last-child {
	width: 100px;
}

table.table td a {
	cursor: pointer;
	display: inline-block;
	margin: 0 5px;
	min-width: 24px;
}

table.table td a.add {
	color: #27C46B;
}

table.table td a.edit {
	color: #FFC107;
}

table.table td a.delete {
	color: #E34724;
}

table.table td i {
	font-size: 19px;
}

table.table td a.add i {
	font-size: 24px;
	margin-right: -1px;
	position: relative;
	top: 3px;
}

table.table .form-control {
	height: 32px;
	line-height: 32px;
	box-shadow: none;
	border-radius: 2px;
}

table.table .form-control.error {
	border-color: #f50000;
}

table.table td .add {
	display: none;
}
</style>
</head>
<body>



<div class="container-lg">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-8"><h2>Employee <b>Details</b></h2></div>
                    <div class="col-sm-4">
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal">
    Add new
</button>
                    </div>
                </div>
            </div>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Name</th>
							<th>Price</th>
							<th>Country</th>
							<th>FUNCTION</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="c" items="${listphone}">
                    	<tr>
                    			<td>${c.name }</td>
								<td>${c.price }</td>
								<td>${c.country }</td>
                    	<td>
    <a data-id="${c.id }" class="add" title="Add" data-toggle="tooltip"><i data-id="${c.id }"	 class="material-icons">&#xE03B;</i></a>
    <a class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
    <a data-id="${c.id }" class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
						</td>
                    	
                    	
                    	
                    	</tr>
                    </c:forEach>  
                </tbody>
            </table>
        </div>
    </div>
</div>     



<!-- Modal HTML Markup -->
<div id="modal" class="modal fade">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title">Add new product</h1>
            </div>
            <div class="modal-body">
                <form name="myForm" role="form" method="POST" action="<c:url value = "/addProduct"/>" onsubmit="return validateForm()">
                    <input type="hidden" name="_token" value="">
                    <div class="form-group">
                        <label class="control-label">ID</label>
                        <div>
                            <input type="text" class="form-control input-lg" name="id" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Name</label>
                        <div>
                            <input type="text" class="form-control input-lg" name="name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Price</label>
                        <div>
                            <input type="number" class="form-control input-lg" name="price">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Country</label>
                        <div>
                            <input type="text" class="form-control input-lg" name="country">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Image</label>
                        <div>
                            <input type="text" class="form-control input-lg" name="image">
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <div>
                            <button  id="btn_modal" type="submit" class="btn btn-success">Add</button>

                            
                        </div>
                    </div>
                </form>
                
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->




<script>

function validateForm() {
	  let x = document.forms["myForm"]["name"].value;
	  if (x == "") {
	    alert("Name must be filled out");
	    return false;
	  }
	  
	  let y = document.forms["myForm"]["id"].value;
	  if (y == "") {
	    alert("Name must be filled out");
	    return false;
	  }
	  
	  let z = document.forms["myForm"]["price"].value;
	  if (z == "") {
	    alert("Name must be filled out");
	    return false;
	  }
	  
	  let e = document.forms["myForm"]["country"].value;
	  if (e == "") {
	    alert("Name must be filled out");
	    return false;
	  }
	}


$(document).ready(function(){
	$('[data-toggle="tooltip"]').tooltip();
	var actions = $("table td:last-child").html();
	
	
	
	
	
	// Append table with add row form on add new button click
    $(".add-new").click(function(){
		$(this).attr("disabled", "disabled");
		var index = $("table tbody tr:last-child").index();
        var row = '<tr>' +
            '<td><input type="text" class="form-control" name="name" id="name"></td>' +
            '<td><input type="text" class="form-control" name="department" id="department"></td>' +
            '<td><input type="text" class="form-control" name="phone" id="phone"></td>' +
			'<td>' + actions + '</td>' +
        '</tr>';
        
    	$("table").append(row);		
		$("table tbody tr").eq(index + 1).find(".add, .edit").toggle();
        $('[data-toggle="tooltip"]').tooltip();
    });
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// Add row on add button click
	$(document).on("click", ".add", function(){
		var empty = false;
		var input = $(this).parents("tr").find('input[type="text"]');
        input.each(function(){
			if(!$(this).val()){
				$(this).addClass("error");
				empty = true;
			} else{
                $(this).removeClass("error");
            }
		});
		$(this).parents("tr").find(".error").first().focus();
		if(!empty){
			input.each(function(){
				$(this).parent("td").html($(this).val());
			});			
			$(this).parents("tr").find(".add, .edit").toggle();
			$(".add-new").removeAttr("disabled");
		}		
		var idPhone = $(this).data("id");
		var name = input[0].value;
		var price = input[1].value;
		var country = input[2].value;
		var multi = idPhone + "," + name + "," + price + "," + country;
		console.log(idPhone);
		console.log(price);
		console.log(country);
		$.ajax({
			url : "/lab06/HandleAjax?type=update",
			type : "get", //send it through get method
			data : {
				multi : multi
				
			},
			success : function(data) {

			},
			error : function(xhr) {
				//Do Something to handle error
			}
		});

		
		
    });
	
	
	
	
	
	
	
	// Edit row on edit button click
	$(document).on("click", ".edit", function(){		
        $(this).parents("tr").find("td:not(:last-child)").each(function(){
			$(this).html('<input type="text" class="form-control" value="' + $(this).text() + '">');
		});		
		$(this).parents("tr").find(".add, .edit").toggle();
		$(".add-new").attr("disabled", "disabled");
    });
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// Delete row on delete button click
	$(document).on("click", ".delete", function(){
		var idPhone = $(this).data("id");

		$.ajax({
			url : "/lab06/HandleAjax?type=delete",
			type : "get", //send it through get method
			data : {
				txt : idPhone
			},
			success : function(data) {

			},
			error : function(xhr) {
				//Do Something to handle error
			}
		});
        $(this).parents("tr").remove();
		$(".add-new").removeAttr("disabled");
    });
});


</script>
</body>
</html>