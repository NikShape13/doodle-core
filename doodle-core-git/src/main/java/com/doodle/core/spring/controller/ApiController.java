package com.doodle.core.spring.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.compress.utils.IOUtils;
//import org.apache.tomcat.jakartaee.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.doodle.core.spring.entity.Authority;
import com.doodle.core.spring.entity.JWTEntity;
import com.doodle.core.spring.entity.MyUser;
import com.doodle.core.spring.entity.Points;
import com.doodle.core.spring.entity.ResponseContainer;
import com.doodle.core.spring.entity.Role;
import com.doodle.core.spring.entity.UserContainer;
import com.doodle.core.spring.entity.UserImage;
import com.doodle.core.spring.entity.Word;
import com.doodle.core.spring.service.AuthoritiesService;
import com.doodle.core.spring.service.JWTService;
import com.doodle.core.spring.service.PointsService;
import com.doodle.core.spring.service.RoleService;
import com.doodle.core.spring.service.UserImageService;
import com.doodle.core.spring.service.UserService;
import com.doodle.core.spring.service.WordsService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ApiController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserImageService userImageService;
	@Autowired
	private WordsService wordService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private PointsService pointsService;
	@Autowired
	private JWTService jwtService;
	
	// User's API
	
	@PostMapping("/sign_up")
	public ResponseContainer userSignUp(@RequestBody MyUser myUser)  {
		Role role = roleService.getRole(1);
		role.addUser(myUser);
		myUser.addRole(role);
		
		Integer userId = userService.saveUser(myUser);
		JWTEntity jwt = jwtService.saveJWT(userId);
		pointsService.savePoints(new Points(userId, 0));
		
        Map<String, Object> response = new HashMap<>();
        response.put("message", "MyUser registered successfully");
        response.put("user", myUser);

        return new ResponseContainer(userId, myUser, jwt.getToken());	
	}
	
	@PostMapping("/login")
	public ResponseContainer userLogin(@RequestBody @Valid UserContainer user) throws Exception {
		MyUser userSystem = userService.getUser(user.getUsername());
		
		if(userSystem==null) {
			throw new Exception("Invalid username");
		}
		
		if(!userSystem.getPassword().equals(user.getPassword())) {
			throw new Exception("Invalid password");
		}
		
		JWTEntity token = jwtService.saveJWT(userSystem.getId());
		
		return new ResponseContainer(userSystem.getId(), userSystem, token.getToken());
		
	}
	
	@PostMapping("/validate_token")
	public ResponseEntity<?> validateToken(@RequestBody ResponseContainer respCont) throws Exception {
		if(jwtService.checkJwt(respCont.getToken(), respCont.getUserid())==false) {
			throw new Exception("Invalid token");
		}
		
		HashMap resp = new HashMap();
		resp.put("info", "Valid token");
		resp.put("success", true);
		
		return ResponseEntity.ok(resp);
	}
	
	@GetMapping("/get_system_image/{imageid}")
	 public ResponseEntity<byte[]> getSystemImage(@PathVariable("imageid") String imageid) {
	        String imagePath = "/home/user/resources/images/" + imageid + ".png";
	        File imageFile = new File(imagePath);

	        if (!imageFile.exists()) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	        }

	        try {
	            byte[] imageBytes = IOUtils.toByteArray(new FileInputStream(imageFile));
	            HttpHeaders headers = new HttpHeaders();
	            headers.add("Content-Type", "image/png");

	            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
	        } catch (IOException e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	        }
	    }
	
	@GetMapping("/get_user/{id}")
	public ResponseEntity<?> getUser(@PathVariable("id") int id) throws Exception{
		MyUser user = userService.getUser(id);
		if(user==null) {
			throw new Exception("User with id: "+id+" is not exist");
		}
		return new ResponseEntity(user, HttpStatus.OK);
	}
	
	@PostMapping("/set_new_role")
	public ResponseEntity<?> setNewRole(@RequestBody Authority authority) throws Exception{
		MyUser user = userService.getUser(authority.getUserid());
		Role role = roleService.getRole(authority.getRoleid());
		
		if(user==null | role==null) {
			throw new Exception("User with id: "+authority.getUserid()+" or role with id: "+authority.getRoleid()+" doesn't exist");
		}
		
		user.addRole(role);
		role.addUser(user);
		
		userService.updateUser(user);
		
		HashMap resp = new HashMap();
		resp.put("info", "User's list of roles was updated succesfully");
		resp.put("success", true);
		
		return ResponseEntity.ok(resp);
	}
	
	// Image API
	
	@PostMapping("/save_image")
	 public ResponseEntity<?> saveImage(@RequestBody ResponseContainer respCont) throws Exception {
		if(jwtService.checkJwt(respCont.getToken(), respCont.getUserid())==false) {
			throw new Exception("Invalid token");
		}
		
		ObjectMapper mapper = new ObjectMapper();
		UserImage userImage = mapper.convertValue(respCont.getData(), UserImage.class);
		
		MyUser user = userService.getUser(userImage.getUserid());
		Word word = wordService.getWordWithDrawingUsers(userImage.getWordid());
		
		userImage.setUser(user);
		userImage.setWord(word);
	
		word.addDrawingUsers(user);
		
		wordService.updateWord(word);
		userService.updateUser(user);
		
		userImageService.saveUserImage(userImage);
		
		pointsService.awardPoints(userImage.getUserid(), 3);
		        
        HashMap resp = new HashMap();
		resp.put("info", "Image was saved successfully. You got 3 points!");
		resp.put("success", true);
		
		return ResponseEntity.ok(resp);
    }
	
	
	@GetMapping("/get_image/{imageid}")
    public ResponseEntity<byte[]> getImage(@PathVariable("imageid") String imageid) {
        String imagePath = "/home/user/resources/user_images/" + imageid + ".png";
        File imageFile = new File(imagePath);

        if (!imageFile.exists()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        try {
            byte[] imageBytes = IOUtils.toByteArray(new FileInputStream(imageFile));
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "image/png");

            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
	
    @GetMapping("/get_image_for_user/{userid}")
    public ResponseEntity<?> getImageForUser(@PathVariable("userid") int userid) throws Exception {
    	UserImage userImage = userImageService.getUserImageForUser(userid);
    	
    	if(userImage != null) {
    		return new ResponseEntity(userImage, HttpStatus.OK);
    	}
    	
    	throw new Exception("There are not any other images for you");
    }
    
    
    // Word API
    
	@PostMapping("/save_word")
	 public ResponseEntity<?> saveWord(@RequestBody ResponseContainer respCont) throws Exception {
		if(jwtService.checkJwt(respCont.getToken(), respCont.getUserid())==false) {
			throw new Exception("Invalid token");
		}
		
		
		MyUser user = userService.getUser(respCont.getUserid());
		ObjectMapper mapper = new ObjectMapper();
	    Word word = mapper.convertValue(respCont.getData(), Word.class);
	    System.out.println(word);
    
	    if(word.getWord().strip().isEmpty()) {
	    	throw new Exception("Empty word");
	    }
		
		word.setUser(user);
		wordService.saveWord(word);
		
		pointsService.awardPoints(word.getUserid(), 3);
		
		HashMap resp = new HashMap();
		resp.put("info", "Word saved successfully. You got 3 points!");
		resp.put("success", true);
		
		return ResponseEntity.ok(resp);
       
   }
	
	@GetMapping("/get_word/{id}")
	public ResponseEntity<?> getWordId(@PathVariable("id") int id) {
		Word word = wordService.getWordWithDrawingUsers(id);
		MyUser user = null;
		
		return new ResponseEntity(word, HttpStatus.OK);
	}
	
	@GetMapping("/get_word")
	public ResponseEntity<?> getWord() {
		Word word = wordService.getWordWithDrawingUsers(1);
		MyUser user = null;
		
		return new ResponseEntity(word, HttpStatus.OK);
	}
	
	@GetMapping("/get_word_for_user/{userId}")
	public ResponseEntity<?> getWordForUser(@PathVariable("userId") int userId) throws Exception{
		Word word = wordService.getWordForUser(userId);
		
		if(word!=null) {
			return ResponseEntity.ok(word);
		}
		throw new Exception("There are not any other words for you");
	}
	
	// Game API
	
	@PutMapping("/award_points")
	public ResponseEntity<?> awardPoints(@RequestBody Points points) {
		pointsService.awardPoints(points.getUserid(), points.getPoints());
		
		HashMap resp = new HashMap();
		resp.put("info", "Your points have been increased by "+points.getPoints());
		resp.put("success", true);
		
		return ResponseEntity.ok(resp);
	}
	
	@GetMapping("/get_points/{id}")
	public Points getPoints(@PathVariable("id") int id) {
		Points points = pointsService.getPoints(id);

		return points;
	}
	
	@PostMapping("/image/{imageid}/check_response")
	public ResponseEntity<?> checkImage(@RequestBody ResponseContainer respCont, @PathVariable("imageid") int imageid) throws Exception{
		if(jwtService.checkJwt(respCont.getToken(), respCont.getUserid())==false) {
			throw new Exception("Invalid token");
		}
		
		ObjectMapper mapper = new ObjectMapper();
	    Word word = mapper.convertValue(respCont.getData(), Word.class);
		Word trulyWord = wordService.getWord(word.getId());
		
		if(!trulyWord.getWord().toLowerCase().strip().equals(word.getWord().toLowerCase().strip())) {
			HashMap resp = new HashMap();
			resp.put("info", "Wrong Answer");
			return new ResponseEntity(resp, HttpStatus.BAD_REQUEST);
		}
		
		UserImage userImage = userImageService.getUserImage(imageid);
		
		if(userImage!=null) {
			pointsService.awardPoints(respCont.getUserid(), 5);
			MyUser user = userService.getUser(respCont.getUserid());
			userImage.addUser(user);
			userImageService.updateUserImage(userImage);
			userService.updateUser(user);
			pointsService.awardPoints(userImage.getUserid(), 7);
			
			HashMap resp = new HashMap();
			resp.put("info", "Good answer. You got 5 points!");
			resp.put("success", true);
			
			return ResponseEntity.ok(resp);
		}
		
		throw new Exception("There isn't image with image id: "+imageid); 
	}
	
	@GetMapping("/get_user_info/{id}")
	public ResponseEntity<?> getUserInfo(@PathVariable("id") int id) throws Exception{
		
		MyUser user = userService.getUser(id);
		Points points = pointsService.getPoints(id);
		
		HashMap resp = new HashMap();
		resp.put("user", user);
		resp.put("points", points);
		resp.put("success", true);
		
		return ResponseEntity.ok(resp);
	}
	
	@GetMapping("/get_user_images/{id}")
	public ResponseEntity<?> getUserImages(@PathVariable("id") int id) throws Exception{
		
		List<UserImage> userImages = userImageService.getAllUserImages(id);
		HashMap resp = new HashMap();
		resp.put("userImages", userImages);
		resp.put("success", true);
		
		return ResponseEntity.ok(resp);
	}
	
	@GetMapping("/get_user_words/{id}")
	public ResponseEntity<?> getUserWords(@PathVariable("id") int id) throws Exception{
		
		List<Word> words = wordService.getAllWords(id);
		
		HashMap resp = new HashMap();
		resp.put("words", words);
		resp.put("success", true);
		
		return ResponseEntity.ok(resp);
	}
	

}
