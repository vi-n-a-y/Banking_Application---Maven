function loginCredintials(userData) {
  

    fetch('http://localhost:8080/api/bank/get', {
        method: 'POST',
        headers: {
            'Accept':'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(userData),
        
    })
    
    .then(response => {
        if (response.ok) {
            window.location.href = 'home.html';
            console.log("requst sended");
        } else {
            console.error('Login failed:', response.statusText);
            window.location.href = 'bank.html';
            console.log("request.failed"+ response.statusText);
        }
       
    })
    .catch(error => {
        console.error('Error during login:', error);       
    });
  
}

function registrationDetails(userData) {
  

    fetch('http://localhost:8080/api/bank/register', {
        method: 'POST',
        headers: {
            'Accept':'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(userData),
        
    })
    
    .then(response => {
        if (response.ok) {
            window.location.href = 'bank.html';
            console.log("requst sended");
        } else {
            console.error('Login failed:', response.statusText);
            window.location.href = 'registration.html';
            console.log("request.failed"+ response.statusText);
        }
       
    })
    .catch(error => {
        console.error('Error during login:', error);       
    });
  
}

function addingAccount(userData) {
  

    fetch('http://localhost:8080/api/bank/add/acc', {
        method: 'POST',
        headers: {
            'Accept':'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(userData),
        
    })
    
    .then(response => {
        if (response.ok) {
            window.location.href = 'home.html';
            console.log("requst sended");
        } else {
            console.error('Login failed:', response.statusText);
            window.location.href = 'addAccount.html';
            console.log("request.failed"+ response.statusText);
        }
       
    })
    .catch(error => {
        console.error('Error during login:', error);       
    });
  
}



function fetchData() {
    fetch('') // Replace with your API endpoint
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            // Update HTML fields with data from the API
            const userDataContainer = document.getElementById('userData');
            userDataContainer.innerHTML = `
                <h2>User Data</h2>
                <p>Name: ${data.name}</p>
                <p>Email: ${data.email}</p>
                <!-- Add more fields as needed -->
            `;
        })
        .catch(error => {
            console.error('Error fetching data:', error);
        });
}








