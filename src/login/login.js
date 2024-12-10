function getLogin(){

    const username = document.getElementById("usernameInput").value;
    const password = document.getElementById("passwordInput").value;

    return {
        "username":username,
        "password":password
    }
}


function sendLoginInfo(){
    fetch('http://localhost:8081/auth/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(getLogin())
    }).then(response => {
        if (!response.ok) {
            return response.json().then(err => {
                throw new Error(err.message || 'Error occurred');
            });
        }
        return response.json();
    }).then(data => console.log('Login successful', data))
        .catch(err => console.error('Error:', err));
}

document.getElementById('loginButton').addEventListener('click',sendLoginInfo);