package com.contrader.react.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.contrader.react.dto.AziendaDTO;
import com.contrader.react.service.AziendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.contrader.react.dto.UserDTO;
import com.contrader.react.service.UserService;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = {"/users"})

public class UserController {
    
    private final UserService userService;
    private final AziendaService aziendaService;
    private HttpSession session;
    
    @Autowired
    public UserController(UserService userService, AziendaService aziendaService) {
        this.userService = userService;
        this.aziendaService = aziendaService;
    }
    
    @GetMapping
    public List<UserDTO> getAll(){
        return userService.getListaUserDTO();
    }
    @GetMapping({"/{id}"})
    public UserDTO getOne(@PathVariable("id") Integer id){
        return userService.getOne(id);
    }
    @PostMapping
    public boolean create (@RequestBody UserDTO newUserDTO) {
        return userService.addUser(newUserDTO);
    }
    @PutMapping("/{id}")
    public boolean update(@PathVariable("id") Integer id, @RequestBody UserDTO updateUserDTO){
        return userService.modifyUser(id,updateUserDTO);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable ("id") Integer id){
        userService.deleteUser(id);
    }
    /*
    private void visualUser(HttpServletRequest request){
        List<UserDTO> allUser = this.userService.getListaUserDTO();
        request.setAttribute("allUserDTO", allUser);
    }
    
    @RequestMapping(value = "/userManagement", method = RequestMethod.GET)
    public String userManagement(HttpServletRequest request) {
        visualUser(request);
        return "homeUser";
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        this.userService.deleteUserById(id);
        visualUser(request);
        return "homeUser";
        
    }
    
    @RequestMapping(value = "/crea", method = RequestMethod.GET)
    public String insert(HttpServletRequest request) {
        visualUser(request);
        request.setAttribute("option", "insert");
        return "creaUser";
        
    }
    
    @RequestMapping(value = "/cercaUser", method = RequestMethod.GET)
    public String cercaUser(HttpServletRequest request) {

        final String content = request.getParameter("search");

        List<UserDTO> allUser = this.userService.findUserDTOByUsername(content);
        request.setAttribute("allUserDTO", allUser);

        return "homeUser";

    }
    
    @RequestMapping(value = "/creaUser", method = RequestMethod.POST)
    public String insertUser(HttpServletRequest request) {
        String username = request.getParameter("username").toString();
        String password = request.getParameter("password").toString();
        String ruolo = request.getParameter("ruolo").toString();

        UserDTO userObj = new UserDTO(0, username, password, ruolo,"");
        
        userService.insertUser(userObj);

        visualUser(request);
        return "homeUser";
    }
    */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public UserDTO registerControl(@RequestParam("username")String username,@RequestParam("password")String password,@RequestParam("email")String email, @RequestParam("azienda")Integer idAzienda){
        AziendaDTO aziendaDTO = aziendaService.getById(idAzienda);
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(username);
        userDTO.setPassword(password);
        userDTO.setEmail(email);
        userDTO.setRuolo("USER");
        userDTO.setAziendaDTO(aziendaDTO);
        userService.addUser(userDTO);
        return  userDTO;
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public UserDTO loginControl(@RequestParam("username") String username, @RequestParam("password") String password) {
        
      
        final UserDTO userDTO = userService.getByUsernameAndPassword(username, password);
       
        return userDTO;
    }
}
