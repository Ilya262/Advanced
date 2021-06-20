
function myFunction() {
	// Declare variables
	var input, filter, table, tr, td, i, txtValue;
	input = document.getElementById("myInput");
	filter = input.value.toUpperCase();
	table = document.getElementById("myTable");
	tr = table.getElementsByTagName("tr");
  
	// Loop through all table rows, and hide those who don't match the search query
	for (i = 0; i < tr.length; i++) {
	  td = tr[i].getElementsByTagName("td")[0];
	  if (td) {
		txtValue = td.textContent || td.innerText;
		if (txtValue.toUpperCase().indexOf(filter) > -1) {
		  tr[i].style.display = "";
		} else {
		  tr[i].style.display = "none";
		}
	  }
	}
  }
  
  
  
  
  var buckets = null;
  
  $.get("backets", function(data) {
	  if (data !== '') {
		  buckets = data;
	  }
  }).done(function() {
  
	  var tableContent = "";
	  jQuery.each(ProductsController, function(i, value) {
  
		  tableContent += "<tr class='header'>" +
						"<tr style='width :200%;'>Name</tr>" +
						"<tr style='width :200%;'>Description</tr>"
						"<tr style='width :200%;'>Price</tr>"
						"<tr style='width :200%;'>PurchaseDate</tr>"
						"<tr style='width :200%;'>Options</tr>"
						"</tr>" 
						
						
						 tableContent += "</tr>" +
						 "<td>"+value.name+"</td>"+
						 "<td>"+value.description+"</td>"+
						 "<td>"+value.price+"</td>"+
						 "<td>"+value.PurchaseDate+"</td>"+
						 "<td>"+value.name+"</td>"+
  "<td><button onclick='deleteOrderFromBucket(" + value.bucketId + ")'>delete</button></td>"+

						 
						 
						  	"</tr>"
			  
	  });
  
	  $('#productCards').html(tableContent);
  
  });
  