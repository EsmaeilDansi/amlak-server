package com.example.amalk;


import com.example.amalk.models.FileInfo;
import com.example.amalk.models.Message;

import com.example.amalk.models.User;
import com.example.amalk.repo.FileRepo;
import com.example.amalk.repo.MessageRepo;
import com.example.amalk.repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

@RestController
class Controller {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    FilesStorageService storageService;


    @Autowired
    FileRepo fileRepo;

    private final UserRepo userRepo;
    private final MessageRepo messageRepo;

    Controller(UserRepo userRepo, MessageRepo messageRepo) {

        this.userRepo = userRepo;
        this.messageRepo = messageRepo;
    }


    @GetMapping("/users")
    List<User> allUser() {
        return userRepo.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping(value = "/login/", consumes = {"application/json"}, produces = "application/json")
    String Login(@RequestBody User user) {

        String user_id = LocalDateTime.now() + ":" + user.getPhoneNumber();
        userRepo.save(new User(user_id, user.getPhoneNumber()));
        return user_id;
    }

    @GetMapping("/fileInfo/{messageId}")
    List<FileInfo> getFileInfo(@PathVariable(value = "messageId") String messageId) {
        return jdbcTemplate.query("SELECT * FROM files WHERE message_id=?",
                BeanPropertyRowMapper.newInstance(FileInfo.class), messageId);
    }


    @PostMapping(value = "/upload/{messageId}", consumes = {"multipart/form-data"})
    public ResponseEntity<String> uploadFiles(@RequestPart("file") MultipartFile file, @PathVariable(value = "messageId") String messageId) {
        try {
            String key = messageId + file.getOriginalFilename();
            storageService.save(file, key);
            fileRepo.save(new FileInfo(key, messageId));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/{uuid}")
    public @ResponseBody
    ResponseEntity<Resource> downloadFile(@PathVariable(value = "uuid") String uuid) throws IOException {
        Resource resource = storageService.load(uuid);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new InputStreamResource(new FileInputStream(resource.getFile())));
    }


    @PostMapping(value = "/setPost/", consumes = {"application/json"}, produces = "application/json")
    String setNewPost(@RequestBody Message message) {
        String id = LocalDateTime.now().toString() + ":" + message.getOwner_id();
        message.setId(id);
        messageRepo.save(message);
        return id;
    }

    @GetMapping("/getMessage/")
    List<Message> getMessage(@RequestBody String location) {
        return jdbcTemplate.query("SELECT * FROM message WHERE location=?",
                BeanPropertyRowMapper.newInstance(Message.class), location);
    }

    @GetMapping("/getMessageByValue/")
    List<Message> getMessageByValue(@RequestBody int value) {
        return jdbcTemplate.query("SELECT * FROM message WHERE value <=?",
                BeanPropertyRowMapper.newInstance(Message.class), value);
    }


    @GetMapping("/getAllMessage/")
    List<Message> getAllMessage() {
        return messageRepo.findAll();
    }

    @DeleteMapping("/deleteMessage")
    void deleteMessage(@RequestBody Long id) {
        messageRepo.deleteById(id);
    }


    @GetMapping("/getMessageByValueAndLocation/")
    List<Message> getMessageByValueAndLocation(@RequestBody String location, @RequestBody int value) {
        return jdbcTemplate.query("SELECT * FROM message WHERE value<=? AND location ILIKE ?",
                BeanPropertyRowMapper.newInstance(Message.class), value, location);
    }

}

