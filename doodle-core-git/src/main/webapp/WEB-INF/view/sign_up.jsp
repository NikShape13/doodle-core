<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #E8E1E1;
            margin: 0;
        }
        .container {
            background-color: white;
            border-radius: 10px;
            color: black;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 300px;
            text-align: center;
        }
        h {
            font-size: 15px;
            margin-bottom: 10px;
            margin: 20px 0;
            color: #6D6D6D;
        }
        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: 100%;
            font-size: 24px;
            padding: 10px;
            border: none;
            margin: 10px 0;
            border-radius: 5px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #FFFFFF;
            color: black;
            font-size: 24px;
            border: 2px solid #000000;
            padding: 10px;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
        }
        input[type="submit"]:hover {
            background-color: #CECBCB;
        }
        input[type="text"]:hover,
        input[type="email"]:hover,
        input[type="password"]:hover {
            background-color: #FFFFFF;
        }
        img {
            width: 300px;
            margin-bottom: 10px;
        }
    </style>
    <script>
    function validateInput() {
        const username = document.getElementById('username').value;
        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;
        let isValid = true;

        document.getElementById('usernameError').textContent = '';
        document.getElementById('emailError').textContent = '';
        document.getElementById('passwordError').textContent = '';

        if (username.length < 5 || username.length > 10) {
            document.getElementById('usernameError').textContent = 'Username must be between 5 and 10 characters.';
            isValid = false;
        }

        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailRegex.test(email) || email.length < 10 || email.length > 50) {
            document.getElementById('emailError').textContent = 'Email must be valid and between 10 and 50 characters.';
            isValid = false;
        }

        if (password.length < 5 || password.length > 15) {
            document.getElementById('passwordError').textContent = 'Password must be between 5 and 15 characters.';
            isValid = false;
        }

        return isValid;
    }
    
        async function registerUser(event) {
            event.preventDefault(); 

            
            const userData = {
                username: document.getElementById('username').value,
                email: document.getElementById('email').value,
                password: document.getElementById('password').value,
                enabled: 1 
            };
            
            if (!validateInput()) {
                return;
            }

            
            try {
                const response = await fetch('/doodle-core/api/sign_up', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(userData)
                });

                if (response.ok) {
                    const result = await response.json();
                    console.log('API response:', result);
                    localStorage.setItem('userid', result.userid); 
                    localStorage.setItem('token', result.token);   
                    localStorage.setItem('data', JSON.stringify(result.data));

                    console.log('Sign up successful:', result);
                    window.location.href = '/doodle-core/'; 
                } else {
                    const error = await response.json();
                    console.error('Error sign up:', error);
                }
            } catch (error) {
                console.error('Error:', error);
            }
        }
    </script>
</head>
<body>
    <div class="container">
        <img src="/doodle-core/api/get_system_image/logo" alt="Logo" /> 
        <form onsubmit="registerUser(event)">
            <input type="text" id="username" name="username" placeholder="username" required />
            <div id="usernameError" class="error"></div>
            <input type="email" id="email" name="email" placeholder="email" required />
            <div id="emailError" class="error"></div>
            <input type="password" id="password" name="password" placeholder="password" required />
            <div id="passwordError" class="error"></div>
            <input type="hidden" name="enabled" value="1" />
            <input type="hidden" name="id"/>
            <input type="submit" value="sign up" />
        </form>
    </div>
</body>
</html>
