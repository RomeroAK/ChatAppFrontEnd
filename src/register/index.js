function doSearch(){
    const searchInput = document.getElementById('searchInput').value;
    console.log("search for "+searchInput)
}

function registerUser() {
    const userName = document.getElementById('usernameInput').value;
    const password = document.getElementById('passwordInput').value;
    const role = document.getElementById('roleInput').value;

    return {
        "username":userName,
        "password":password,
        "role":role
    }

}

function sendRegisterInfo(){

    fetch('http://localhost:8081/auth/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(registerUser())
    })
        .then(response => {
            if (!response.ok) {
                return response.json().then(err => {
                    throw new Error(err.message || 'Error occurred');
                });
            }
            return response.json();
        }).then(data => console.log('User registered successfully:', data))
        .catch(err => console.error('Error:', err));
}


document.getElementById('registerButton').addEventListener('click',sendRegisterInfo);
