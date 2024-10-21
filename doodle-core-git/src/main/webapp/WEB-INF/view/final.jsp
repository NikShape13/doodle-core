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
            gap: 50px;
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
		    display: none;
		}
		
		.tab-pane.active, .word-section.active {
		    display: block;
		}

        .tabs span.active {
            border-bottom: 3px solid #333;
        }

        .word-section {
            margin-bottom: 20px;
        }

        canvas {
        	width: 100;
		    border: 2px solid #333;
		    border-radius: 15px; 
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
		    top: 70%; 
		    left: 50%; 
		    transform: translate(-50%, -50%);
		    color: black;
		    font-size: 24px;
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
            top: 6px;
            right: 25px;
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
                    <li><a href="#" id="profileLink">my profile</a></li>
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
				    <span id="drawWordTab" class="active">draw a word</span>
				    <span id="guessImageTab">guesse image</span>
				    <span id="suggestWordTab">suggest word</span>
				</div>
				
				<div id="drawSection" class="tab-pane active">
				    <div class="word-section">
				        <h2 id="wordDisplay">Word: </h2>
				        <canvas id="drawingCanvas" width="600" height="400"></canvas>
				    </div>
				    <div class="buttons">
				        <button id="clearBtn">clean</button>
				        <button id="saveBtn">save</button>
				    </div>
				</div>
				
				<div id="guessSection" class="tab-pane"> 
				    <div class="guess-image-section">
						<img id="imageToGuess" src="" alt="Image to Guess" width="400" ; display: none;">
				        <input type="text" id="guessInput" placeholder="Enter your guess">
				        <button id="submitGuessBtn">submit guess</button>
				    </div>
				</div>
				
				<div id="suggestSection" class="tab-pane"> 
				    <input type="text" id="suggestWordInput" placeholder="Enter a word">
				    <button id="submitWordBtn">suggest word</button>
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
	    function checkUserStatus() {
	        const userId = localStorage.getItem('userid');
	        const token = localStorage.getItem('token');
	
	        const profileLink = document.getElementById('profileLink');
	        const logoutBtn = document.getElementById('logoutBtn');
	        const loginBtn = document.getElementById('loginBtn');
	        const signUpBtn = document.getElementById('signUpBtn');
	
	        if (!userId || !token) {
	            profileLink.addEventListener('click', function(event) {
	                event.preventDefault(); 
	                showModal('Please login or sign up first'); 
	            });
	
	            logoutBtn.style.display = 'none';
	            loginBtn.style.display = 'block';
	            signUpBtn.style.display = 'block';
	        } else {
	            profileLink.href = '/doodle-core/profile';
	            logoutBtn.style.display = 'block';
	            loginBtn.style.display = 'none';
	            signUpBtn.style.display = 'none';
	        }
	    }
	
	
	    document.addEventListener('DOMContentLoaded', checkUserStatus);
    
    
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
	
	            window.location.reload();
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
        
        function showModalPositive(customMessage) {
		    const modal = document.getElementById('imageModalPos');
		    const modalText = document.getElementById('modalMessagePos');
		
		    modalText.textContent = customMessage;
		    
		    modal.style.display = 'flex'; 
		
		    document.getElementById('closeBtn1').addEventListener('click', function() {
		        modal.style.display = 'none';
		    });
		}
        
        
        async function fetchWord() {
            try {
            	let userid = localStorage.getItem('userid');
            	if(userid==null){
            		userid = 1;
            	}
                const response = await fetch('/doodle-core/api/get_word_for_user/'+userid);
                if (response.ok) {
                    const data = await response.json();
                    currentWord = data.word; 
                    currentWordId = data.id;
                    wordDisplay.textContent = 'Word: '+currentWord; 
                    
                } else {
                    console.error('Error fetching word:', response.statusText);
                    showModal('Word could not be retrieved.');
                }
            } catch (error) {
                console.error('Error:', error);
                wordDisplay.textContent = 'Error occurred while fetching the word.';
            }
        }

        window.addEventListener('load', () => {
            const canvas = document.getElementById('drawingCanvas');
            const ctx = canvas.getContext('2d');
            
            let painting = false;

            function startPosition(e) {
                painting = true;
                draw(e);
            }

            function endPosition() {
                painting = false;
                ctx.beginPath();
            }

            function draw(e) {
                if (!painting) return;
                ctx.lineWidth = 5;
                ctx.lineCap = 'round';
                ctx.strokeStyle = 'black';
                
                ctx.lineTo(e.clientX - canvas.offsetLeft, e.clientY - canvas.offsetTop);
                ctx.stroke();
                ctx.beginPath();
                ctx.moveTo(e.clientX - canvas.offsetLeft, e.clientY - canvas.offsetTop);
            }

            canvas.addEventListener('mousedown', startPosition);
            canvas.addEventListener('mouseup', endPosition);
            canvas.addEventListener('mousemove', draw);
        });

        document.getElementById('saveBtn').addEventListener('click', async () => {
            const canvas = document.getElementById('drawingCanvas');
            const ctx = canvas.getContext('2d');
            
            const imageData = ctx.getImageData(0, 0, canvas.width, canvas.height);
            let isCanvasEmpty = true;
            
            for (let i = 0; i < imageData.data.length; i += 4) {
                if (imageData.data[i + 3] !== 0) {
                    isCanvasEmpty = false;
                    break;
                }
            }

            if (isCanvasEmpty) {
                showModal('Cannot save an empty drawing.');
                return;
            }

            const jwtToken = localStorage.getItem('token');
            const userId = localStorage.getItem('userid');
            
            if (!jwtToken || !userId) {
                showModal('You cant save images. Please log in or sign up.');
                return;
            }
            
            await validateToken(jwtToken, userId);

            const xhr = new XMLHttpRequest();
            xhr.open('POST', '/doodle-core/api/save_image', true);
            xhr.setRequestHeader('Content-Type', 'application/json');
            xhr.setRequestHeader('Authorization', 'Bearer '+jwtToken);

            const params = JSON.stringify({
                userid: userId,
                data: {
                    userid: userId,
                    wordid: currentWordId, 
                    imagedata: canvas.toDataURL()
                },
                token: jwtToken
            });

            xhr.onload = function() {
                if (xhr.status === 200) {
                    showModalPositive('Drawing saved successfully. You got 3 points!');
                    
                    const context = canvas.getContext('2d');
                    context.clearRect(0, 0, canvas.width, canvas.height);
                    
                    fetchWord();
                } else {
                    showModal('Failed to save drawing');
                }
            };

            xhr.send(params);
        });

        
        document.addEventListener('DOMContentLoaded', async () => {
            const drawSection = document.getElementById('drawSection');
            const guessSection = document.getElementById('guessSection');
            const suggestSection = document.getElementById('suggestSection');

            const drawWordTab = document.getElementById('drawWordTab');
            const guessImageTab = document.getElementById('guessImageTab');
            const suggestWordTab = document.getElementById('suggestWordTab');

            function switchTab(tab) {
                drawWordTab.classList.remove('active');
                guessImageTab.classList.remove('active');
                suggestWordTab.classList.remove('active');

                drawSection.classList.remove('active');
                guessSection.classList.remove('active');
                suggestSection.classList.remove('active');

                tab.classList.add('active');
                
                if (tab === drawWordTab) {
                    drawSection.classList.add('active');
                } else if (tab === guessImageTab) {
                    guessSection.classList.add('active');
                } else if (tab === suggestWordTab) {
                    suggestSection.classList.add('active');
                }
            }

            drawWordTab.addEventListener('click', () => switchTab(drawWordTab));
            guessImageTab.addEventListener('click', () => switchTab(guessImageTab));
            suggestWordTab.addEventListener('click', () => switchTab(suggestWordTab));
        });

        document.addEventListener('DOMContentLoaded', async () => {
            const imageElement = document.getElementById('imageToGuess');
            const guessInput = document.getElementById('guessInput');
            const submitGuessBtn = document.getElementById('submitGuessBtn');
            const modal = document.getElementById('modal'); 
            const modalMessage = document.getElementById('modalMessage'); 

            const userId = localStorage.getItem('userid') || '1';
            const jwtToken = localStorage.getItem('token');

            const loadNewImage = async () => {
                try {
                    console.log('Fetching image for user:', userId);
                    const imageResponse = await fetch('/doodle-core/api/get_image_for_user/'+userId);
                    const imageData = await imageResponse.json();

                    console.log('Image Data:', imageData); 

                    if (imageData && imageData.imagedata) {
                        localStorage.setItem('image_for_guessing_id', imageData.id);
                        localStorage.setItem('word_id', imageData.wordid);
                        imageElement.src = imageData.imagedata; 
                        imageElement.style.display = 'block'; 
                    } else {
                        console.error('No image data received');
                        showModal('Failed to load image data.');
                        guessInput.style.display = 'none';
                        submitGuessBtn.style.display = 'none';
                    }
                } catch (error) {
                    console.error('Error fetching image:', error);
                    showModal('Failed to load the image. Please try again.');
                    guessInput.style.display = 'none';
                    submitGuessBtn.style.display = 'none';
                }
            };

            await loadNewImage();

            submitGuessBtn.addEventListener('click', async () => {
                const guess = guessInput.value;
                const jwtToken = localStorage.getItem('token');
                const userId = localStorage.getItem('userid');
                const imageId = localStorage.getItem('image_for_guessing_id');
                const wordId = localStorage.getItem('word_id');

                if (!jwtToken) {
                    showModal('Please log in or sign up');
                    return;
                }

                await validateToken(jwtToken, userId);
                console.log('Validation correct, image id: ' + imageId);

                try {
                    const response = await fetch('/doodle-core/api/image/'+imageId+'/check_response', {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/json',
                        },
                        body: JSON.stringify({
                            userid: userId,
                            data: {
                                id: wordId,
                                word: guess
                            },
                            token: jwtToken
                        })
                    });

                    const result = await response.json();

                    if (result.success) {
                        showModalPositive('Correct Guess! Well done! You gor 5 points');
                        
                        guessInput.value = '';

                        await loadNewImage();
                    } else {
                        showModal('Wrong Guess. Try again!');
                    }
                } catch (error) {
                    console.error('Error:', error);
                    showModal('An error occurred. Please try again.');
                }
            });
        });

            document.getElementById('submitWordBtn').addEventListener('click', async () => {
                const suggestWordInput = document.getElementById('suggestWordInput').value;
				
                const userId = localStorage.getItem('userid');
			    const jwtToken = localStorage.getItem('token');
                
                if (!jwtToken) {
                    showModal('You cannt suggest new word, please log in or sign up');
                    return;
                }
                
                await validateToken(jwtToken, userId);

                try {
                    const response = await fetch('/doodle-core/api/save_word', {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        body: JSON.stringify({userid: userId, 
                        	data: {
                        		userid: userId,
                        		word: suggestWordInput
                        	},
                        	token: jwtToken
                        })
                    });

                    const result = await response.json();
                    
                    if(result.success){
                    	showModalPositive('Word submitted successfully! You got 3 points!');
                    	document.getElementById('suggestWordInput').value = '';
                    } else {
                    	showModal('Word submission failed.');
                    }
                } catch (error) {
                    console.error('Error:', error);
       
                    showModal('An error occurred. Please try again.');
                }
            });


        document.getElementById('clearBtn').addEventListener('click', () => {
            const canvas = document.getElementById('drawingCanvas');
            const ctx = canvas.getContext('2d');
            ctx.clearRect(0, 0, canvas.width, canvas.height);
        });
        
        fetchWord();
    </script>
</body>
</html>
