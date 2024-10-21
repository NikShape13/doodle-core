<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Doodle Core</title>

    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    
    <style>

        body {
            font-family: 'Roboto', sans-serif;
            background-color: #E8E1E1;
            margin: 40px;
            padding: 0;
        }

        .container {
            display: flex;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
		    flex-direction: row; 
		    max-width: 1080px;
		    margin: 0 auto;
		    padding: 15px;
		    height: auto; 
        }

        header.left-section {
		    display: flex;
		    flex-direction: column;
		    align-items: flex-start;
		    margin-bottom: 40px; 
		    width: 600px; 
		}

        header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
        }

        .logo {
            height: 60px;
            max-width: auto;
        }
        .left-section .logo {
		    margin-bottom: 40px; 
		}

       nav ul {
	    list-style-type: none;
	    padding: 0;
	    width: 100%; 
		}
		
		nav ul li {
		    margin-bottom: 10px;
		}
		
		
		nav ul li a {
		    text-decoration: none;
		    color: #333;
		    font-size: 24px;
		    display: block; 
		    width: 100%;
		}
		
		.horizontal-list {
		    display: flex; 
		    gap: 20px; 
		    list-style-type: none; 
		    padding: 0;
		    margin-left: 0px;
		}
		
		.horizontal-list li {
			margin-top: 50px;
			
		}
		
		.horizontal-list a {
		    text-decoration: none;
		    color: #333;
		    font-size: 18px;
		}
		
		.horizontal-list2 a {
			text-decoration: none;
		    color: #333;
		    font-size: 18px;
			margin-left: 0px;
		}
		.horizontal-list2 li {
			margin-top: 0px;
			margin-bottom: 75px;
		}
		
        .right-section {
            width: 80%; 
            padding: 20px;
        }
        .right-section .content {
		    text-align: left; 
		}
        .left-section {
		    width: 20%; 
		    padding: 20px;
		    display: flex;
		    flex-direction: column;
		    justify-content: flex-start; 
		}

        .content {
            text-align: center;
        }

        .tabs {
            display: flex;
            justify-content: flex-start;
            font-size: 24px;
            gap: 30px;
            margin-bottom: 20px;
            margin-top: 20px;
            padding: 0px;
            width: 100%; 
        }
		
        .tabs span {
            cursor: pointer;
            padding-bottom: 5px;
            border-bottom: 3px solid transparent;
        }
        .tab-pane {
        	margin-top: 60px;
		    display: none;
		}
		
		.tab-pane.active, .word-section.active {
		    display: block;
		}

        .tabs span.active {
            border-bottom: 3px solid #333;
        }


        .tab-pane ul {
		    list-style-type: none;
		    padding: 0; 
	   
		}
		
		.tab-pane li {
		    font-size: 48px; 
		    margin-bottom: 30px; 
		}
		input[type="text"] {
		    width: 60%; 
		    padding: 10px;
		    border: 2px solid #000000; 
		    border-radius: 10px; 
		    font-size: 24px; 
		    margin-bottom: 20px; 
		    margin-top: 20px; 
		}
		
		button {
		    flex: 1; 
		    padding: 10px; 
		    font-size: 18px; 
		    cursor: pointer; 
		    border-radius: 10px; 
		    background-color: #f4f4f4;
		    color: black;
		    text-align: center; 
		    border: 2px solid #000000; 
		    margin-top: 20px; 
		    width: 30%
		}
		
		button:hover {
		    background-color: #CECBCB;
		}
        .buttons {
            gap: 20px;
            display: flex;
		    justify-content: space-between; 
        }

        button {
            flex: 1; 
		    padding: 10px 0; 
		    font-size: 24px;
		    cursor: pointer;
		    border: none;
		    border-radius: 10px;
		    background-color: #f4f4f4;
		    color: black;
		    text-align: center;
		    border: 2px solid #000000;
        }

        button:hover {
            background-color: #CECBCB;
        }
        .modal-overlay {
		    position: relative;
		    display: inline-block;
		}
		
		.modal-text {
		    position: absolute;
		    top: 75%;
		    left: 50%; 
		    transform: translate(-50%, -50%);
		    color: black;
		    font-size: 32px;
		    text-align: center;
		    padding: 10px;
		    border-radius: 8px;
		}
        .modal {
            display: flex;
            display: none;
            justify-content: center;
            align-items: center;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5);
        }

        .modal-content {
            position: relative;
            display: inline-block;
        }

        .modal-content img {
            max-width: 100%;
            height: auto;
            display: block;
        }

        .close-btn {
            position: absolute;
            top: 20px;
            right: 20px;
            background-color: transparent;
            border: none;
            cursor: pointer;
            width: 50px;
            height: 50px;
            opacity: 0;
        }
        .project-repo {
		    position: absolute;
		    bottom: 10px; 
		    left: 20px; 
		    font-size: 18px; 
		    display: flex;
		}
		
		.project-repo a {
		    text-decoration: none;
		    color: #333; 
		}
		
		.project-repo a:hover {
		    color: #000; 
		}
		.left-section {
		    position: relative; 
		    width: 20%; 
		    padding: 20px;
		}
        
    </style>
</head>
<body>
    <div class="container">
        <header class="left-section">
            <img src="/doodle-core/api/get_system_image/logo" alt="Doodle Core Logo" class="logo"> 
            <nav>
                <ul>
                    <li><a href="/doodle-core/">game</a></li>
                    <li><a href="/doodle-core/profile">my profile</a></li>
                    <nav>
					    <ul class="horizontal-list" id="auth-buttons">

					        <li><a href="/doodle-core/sign_up" id="signUpBtn">sign up</a></li>
					        <li><a href="/doodle-core/loginPage" id="loginBtn">log in</a></li>

					    </ul>
					    	<nav>
					    		<ul class="horizontal-list2" id="auth-buttons">
					    			<li><a href="#" id="logoutBtn" style="display: none;">log out</a></li> 
					    		</ul>
					    	</nav>
					</nav> 
					<li class="project-repo"><a href="https://github.com/NikShape13/doodle-core.git" target="_blank">Project repository</a></li> 
                </ul>
            </nav>
        </header>
        <main class="right-section">
            <div class="content">
                <div class="tabs">
				    <span id="userInfoTab" class="active">user info</span>
				    <span id="myImagesTab">my images</span>
				    <span id="myWordsTab">my words</span>
				</div>
				
				
				<div id="userInfoSection" class="tab-pane active">
				    <div class="userInfo-section">
				        <h2 id="usernameDisplay"> </h2>
				        <h2 id="emailDisplay"> </h2>
				        <h2 id="pointsDisplay"> </h2>
				    </div>
				    
				</div>
				
				<div id="myImagesSection" class="tab-pane"> 
				    <div class="my-images-section">

				    </div>
				</div>
				
				<div id="myWordsSection" class="tab-pane"> 
				
					<div class="myWordsSection tab-pane"> 
					    <h2 id="wordDisplay"> </h2>
					    <ul id="wordsList"></ul>
					</div>
				   
				</div>
				
				

            </div>
            
            <div class="modal" id="imageModal">
                <div class="modal-content">
                    <div class="modal-overlay">
			            <img src="/doodle-core/api/get_system_image/not_logged_in" alt="Please log in to save your drawing">
			            <div class="modal-text" id="modalMessage"></div> 
			        </div>
                    <button class="close-btn" id="closeBtn"></button>
                </div>
            </div>
            
            <div class="modal" id="imageModalPos">
                <div class="modal-content">
                    <div class="modal-overlay">
			            <img src="/doodle-core/api/get_system_image/positive" alt="">
			            <div class="modal-text" id="modalMessagePos"></div>
			        </div>
                    <button class="close-btn" id="closeBtn1"></button>
                </div>
            </div>

        </main>
    </div>

    

    <script>
	    document.addEventListener('DOMContentLoaded', () => {
	        const signUpBtn = document.getElementById('signUpBtn');
	        const loginBtn = document.getElementById('loginBtn');
	        const logoutBtn = document.getElementById('logoutBtn');
	
	        const manageAuthButtons = async () => {
	            const token = localStorage.getItem('token');
	            const userId = localStorage.getItem('userid');
	            
	            if (!token || !userId) {
	                signUpBtn.style.display = 'inline-block';
	                loginBtn.style.display = 'inline-block';
	                logoutBtn.style.display = 'none';
	                return; 
	            }
	
	            try {
	                const validationResponse = await validateToken(token, userId);
	
	                if (validationResponse && validationResponse.success) {
	                    signUpBtn.style.display = 'none';
	                    loginBtn.style.display = 'none';
	                    logoutBtn.style.display = 'inline-block';
	                } else {
	                    signUpBtn.style.display = 'inline-block';
	                    loginBtn.style.display = 'inline-block';
	                    logoutBtn.style.display = 'none';
	
	                    localStorage.removeItem('token');
	                    localStorage.removeItem('userid');
	                }
	            } catch (error) {
	                console.error('Error validating token:', error);
	                signUpBtn.style.display = 'inline-block';
	                loginBtn.style.display = 'inline-block';
	                logoutBtn.style.display = 'none';
	
	                localStorage.removeItem('token');
	                localStorage.removeItem('userid');
	            }
	        };
	
	        manageAuthButtons();
	
	        logoutBtn.addEventListener('click', () => {
	            localStorage.removeItem('token');
	            localStorage.removeItem('userid');
	
	            window.location.href = '/doodle-core/';
	        });
	    });

    
	    async function validateToken(token, userid) {
	        const response = await fetch('/doodle-core/api/validate_token', {
	            method: 'POST',
	            headers: {
	                'Content-Type': 'application/json'
	            },
	            body: JSON.stringify({
	                userid: userid,
	                data: {}, 
	                token: token
	            })
	        });
	
	        if (!response.ok) {
	            throw new Error("Token validation failed");
	        }
	
	        return await response.json(); 
	    }
        function showModal(customMessage) {
		    const modal = document.getElementById('imageModal');
		    const modalText = document.getElementById('modalMessage');
		
		    modalText.textContent = customMessage;
		    
		    modal.style.display = 'flex'; 
		
		    document.getElementById('closeBtn').addEventListener('click', function() {
		        modal.style.display = 'none';
		    });
		}
        
        
        async function getUserInfo() {
            try {
                let userid = localStorage.getItem('userid');

                const response = await fetch('/doodle-core/api/get_user_info/'+userid);
                if (response.ok) { 
                    const data = await response.json();
                    const user = data.user;
                    const points = data.points.points;

                    localStorage.setItem('username', user.username);
                    localStorage.setItem('email', user.email);
                    localStorage.setItem('points', points);
                } else {
                    console.error('Error fetching user:', response.statusText);
                    showModal('User could not be retrieved.');
                }

                const response2 = await fetch('/doodle-core/api/get_user_images/'+userid);
                if (response2.ok) {
                    const data = await response2.json();
                    const images = data.userImages;

                    localStorage.setItem('images', JSON.stringify(images)); 
                } else {
                    console.error('Error fetching images:', response2.statusText);
                    showModal('Images could not be retrieved.');
                }

                const response3 = await fetch('/doodle-core/api/get_user_words/'+userid);
                if (response3.ok) {
                    const data = await response3.json();
                    const words = data.words;

                    localStorage.setItem('words', JSON.stringify(words)); 
                } else {
                    console.error('Error fetching words:', response3.statusText);
                    showModal('Words could not be retrieved.');
                }

            } catch (error) {
                console.error('Error:', error);
                showModal('Error occurred while fetching user data.');
            }
        }

        
        
        document.addEventListener('DOMContentLoaded', async () => {
        	await getUserInfo();
            const userInfoSection = document.getElementById('userInfoSection');
            const myImagesSection = document.getElementById('myImagesSection');
            const myWordsSection = document.getElementById('myWordsSection');

            const userInfoTab = document.getElementById('userInfoTab');
            const myImagesTab = document.getElementById('myImagesTab');
            const myWordsTab = document.getElementById('myWordsTab');

            let userid = localStorage.getItem('userid');

            function switchTab(tab) {
                userInfoTab.classList.remove('active');
                myImagesTab.classList.remove('active');
                myWordsTab.classList.remove('active');

                userInfoSection.classList.remove('active');
                myImagesSection.classList.remove('active');
                myWordsSection.classList.remove('active');

                tab.classList.add('active');

                if (tab === userInfoTab) {
                    userInfoSection.classList.add('active');
                } else if (tab === myImagesTab) {
                    myImagesSection.classList.add('active');
                } else if (tab === myWordsTab) {
                    myWordsSection.classList.add('active');
                }
            }

            userInfoTab.addEventListener('click', () => switchTab(userInfoTab));
            myImagesTab.addEventListener('click', () => switchTab(myImagesTab));
            myWordsTab.addEventListener('click', () => switchTab(myWordsTab));

            const images = JSON.parse(localStorage.getItem('images')) || [];
            const words = JSON.parse(localStorage.getItem('words')) || [];

            const username = localStorage.getItem('username');
            const email = localStorage.getItem('email');
            const points = localStorage.getItem('points');

            const usernameDisplay = document.getElementById('usernameDisplay');
            const emailDisplay = document.getElementById('emailDisplay');
            const pointsDisplay = document.getElementById('pointsDisplay');

            if (username) {
                usernameDisplay.textContent = 'Username: '+username;
            }
            if (email) {
                emailDisplay.textContent = 'Email: '+email;
            }
            if (points) {
                pointsDisplay.textContent = 'Points: '+points;
            }

            const myImagesContainer = document.querySelector('.my-images-section');
            images.forEach(image => {
                const img = document.createElement('img');
                img.src = image.imagedata;
                img.alt = 'User image';
                img.style.width = '100%';
                myImagesContainer.appendChild(img);
            });

            const wordsList = document.createElement('ul');
            words.forEach(word => {
                const listItem = document.createElement('li');
                listItem.textContent = word.word;
                wordsList.appendChild(listItem);
            });
            myWordsSection.appendChild(wordsList);
        });

        
        
    </script>
</body>
</html>
