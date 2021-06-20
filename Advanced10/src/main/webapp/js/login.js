


function loginRegisterSwitch() {
	$('form').animate({
		height: "toggle",
		opacity: "toggle"
	}, "slow");
}
function showAlertAfterRegistration() {
	$('div.alert.alert-success').show();
}

$('.message a').click(function() {
	loginRegisterSwitch();
});

$("button.register").click(function() {

	let name = $("form.register-form input.name").val();
	let lastname = $("form.register-form input.last-name").val();
	let email = $("form.register-form input.email").val();
	let password = $("form.register-form input.password").val();
	let confirmPassword = $("form.register-form input.confirm-password").val();

	if (name == '' || lastname == '' || email == '' || password == '') {

		alert("Please fill all fields...!!!!!!");

	}
	else if ((password.length) < 8) {

		alert("Password should atleast 8 character in length...!!!!!!");
	}
	else if (!password.match(confirmPassword)) {

		alert("Your passwords don't match. Try again?");
	}

	else {
		let userRegistration = {

			name: name,
			lastname: lastname,
			email: email,
			password: password
		};

		$.post("Registration", userRegistration,
			function(data) {
				if (data == 'Success') {
					$("form")[0].reset();
					$("form")[1].reset();
					loginRegisterSwitch();
					showAlertAfterRegistration();
				}
			});
	};

});
$("button.login").click(function() {
	let email = $("form.login-form input.email").val();
	let password = $("form.login-form input.password").val();

	if (email == '' || password == '') {
		alert("Please fill login form!");
	} else {
		let userLogin = {
			email: email,
			password: password
		};

		$.post("Login", userLogin, function(data) {

			if (data !== "") {

				let customUrl = "";
				let urlContent = window.location.href.split("/");
				for (i = 0; i < urlContent.lenght - 1; i++) {

					customUrl += urlContent[i] + "/"


				}
				customUrl += data.destinationUrl;
				window.location = customUrl;
			}
			$("form")[1].reset();

		});
	}
});






