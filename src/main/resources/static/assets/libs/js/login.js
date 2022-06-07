const baseURL = "http://localhost:8080"


document.getElementById("sign-in").addEventListener('click', function (event) {
	event.preventDefault();
    $('#error-container').empty();
    $('#error-container').append('<span class="dashboard-spinner spinner-secondary spinner-xs"></span>');
    fetch(baseURL + '/authentication', {
        method: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ username: "clf_badal", userkey: "badalPass" })
    })
        .then(response => response.json())
        .then(result => {
            if (result.status == "success") {
                localStorage.setItem("login", JSON.stringify(result.data));
                localStorage.setItem("token", JSON.stringify(result.data.token));
                window.location.replace('/CLF.html');
            } else {
                const message = "Response Status is not success";
                wrapper.innerHTML = '<span class="badge bg-danger">' + message + '</span>';
                alertPlaceholder.append(wrapper);
            }
        })
        .catch((error) => {
            console.log(error);
            $('#error-container').empty();
            $('#error-container').append('<div class="alert alert-danger" role="alert">Login Error! '+error.message+'</div>');
        });
});

$(document).ready(function () {

});