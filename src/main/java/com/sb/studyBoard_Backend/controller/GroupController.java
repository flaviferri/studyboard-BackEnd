package com.sb.studyBoard_Backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sb.studyBoard_Backend.model.Group;
import com.sb.studyBoard_Backend.model.UserEntity;
import com.sb.studyBoard_Backend.service.GroupService;
import com.sb.studyBoard_Backend.service.UserService;
import org.springframework.security.core.Authentication;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/group")
public class GroupController {
    private final GroupService groupService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<Group> createGroup(@RequestParam Long userId, @RequestBody Group group) {
        // Buscar el usuario por userId
        UserEntity user = userService.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Establecer el usuario como creador del grupo
        group.setCreatedBy(user);

        // Guardar el grupo en la base de datos
        Group createdGroup = groupService.createGroup(group);

        // Retornar la respuesta con el grupo creado
        return ResponseEntity.ok(createdGroup);
    }

    // @PostMapping("/group")
    // public ResponseEntity<Group> createGroup(@RequestBody Group group) {
    // Group createdGroup = groupService.createGroup(group);
    // return new ResponseEntity<>(createdGroup, HttpStatus.CREATED);
    // }
}