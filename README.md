# doodle-core ([link](http://84.201.152.11:8080/doodle-core/))

# [Game](http://84.201.152.11:8080/doodle-core/) 

This project is a web-based game where users have three main tasks: drawing, guessing, and suggesting words. The goal is to draw an image based on a word suggested by another user. If another user guesses what was drawn, both users earn points. You can also guess the content of someone else’s drawing to earn points or suggest a new word for other users to draw. The game consists of three main modules available on the home page (`/`) and accessible only to registered users:

### Draw a Word
In this module, you are given a word to draw on a canvas. You can either save or clear your drawing. Notably, users won’t be assigned a word they have previously drawn or suggested.

### Guess an Image
Here, you are presented with a picture and must guess what it depicts by typing your answer into an input field. Users won’t receive images they’ve already guessed or drawn themselves.

### Suggest a Word
In this module, users can suggest new words. If a word is accepted, others can draw pictures based on it and attempt to guess those images.

# [Profile](http://84.201.152.11:8080/doodle-core/profile)

Once registered, users can access the `/profile` page, which includes the following modules:

### User Info
This section displays information about the user, including their total points earned through gameplay.

### My Images
A list of images that the user has drawn is displayed here.

### My Words
A list of words that the user has suggested is shown in this section.

# [Login](http://84.201.152.11:8080/doodle-core/loginPage)/[SignUp](http://84.201.152.11:8080/doodle-core/sign_up)

These modules handle user authentication and registration. Upon successful data validation, the user’s JWT token is updated, which is required for accessing and modifying certain resources through API requests (POST requests). This ensures that only registered users can make changes to the system or access restricted resources.

# Tech Stack

The project is built using the following technologies:
- Apache Tomcat
- Spring Framework
- Hibernate
- PostgreSQL
