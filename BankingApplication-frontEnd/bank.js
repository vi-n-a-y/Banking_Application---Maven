function loginCredintials(userData) {
    fetch('http://localhost:8080/api/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(userData),
    })
    .then(response => {
        if (response.ok) {
            window.location.href = 'home.html';
        } else {
            console.error('Login failed:', response.statusText);
            window.location.href = 'bank.html';
        }
    })
    .catch(error => {
        console.error('Error during login:', error);       
    });
}