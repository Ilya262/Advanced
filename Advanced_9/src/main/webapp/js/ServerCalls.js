$("button.createProduct").click(function() {

	let name = $("form.createProduct input.productName").val();
	let description = $("form.createProduct input.productDescription").val();
	let price = $("form.createProduct input.productPrice").val();



	let products = {

		name: name,
		description: description,
		price: price,

	};

	$.post("ProductController", products,
		function(data) {
			if (data == 'Success') {

				alert("Success")
			}
		});

	});

	$("button.buy-product").click(function() {
		var productId = jQuery(this).attr('product-id');
		
		
		$.post("BacketController", {'productId':productId},
				function(data) {
					if (data == 'Success') {
					
						$("[data-dismiss=modal]").trigger({type:"click"});
						alert('Success');
					}
				});
	});