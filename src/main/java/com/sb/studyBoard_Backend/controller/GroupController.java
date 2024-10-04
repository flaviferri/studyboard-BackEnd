package com.sb.studyBoard_Backend.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.sb.studyBoard_Backend.model.RoleEntity;
import com.sb.studyBoard_Backend.model.RoleEnum;
import com.sb.studyBoard_Backend.model.Group;
import com.sb.studyBoard_Backend.model.UserEntity;
import com.sb.studyBoard_Backend.model.UserGroupRole;
import com.sb.studyBoard_Backend.service.GroupService;
import com.sb.studyBoard_Backend.service.RoleService;
import com.sb.studyBoard_Backend.service.UserGroupRoleService;
import com.sb.studyBoard_Backend.service.UserService;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/group")
public class GroupController {
    private final GroupService groupService;
    private final UserService userService;
    private final RoleService roleService;
    private final UserGroupRoleService userGroupRoleService;

    @PostMapping("/add")
    public ResponseEntity<Group> createGroup(@RequestBody Group group) {

        String username = getAuthenticatedUsername();
        UserEntity user = userService.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Establecer el usuario como creador del grupo
        group.setCreatedBy(user);

        // Guardar el grupo en la base de datos
        Group createdGroup = groupService.createGroup(group);

        RoleEntity createdRole = roleService.findByRoleEnum(RoleEnum.CREATED)
            .orElseThrow(() -> new RuntimeException("CREATED role not found"));

        UserGroupRole userGroupRole = new UserGroupRole();
        userGroupRole.setUser(user);
        userGroupRole.setGroup(createdGroup);
        userGroupRole.setRole(createdRole);

        System.out.println("User: " + user.getUsername());
        System.out.println("Group: " + createdGroup.getGroupName());
        System.out.println("Role: " + createdRole.getRoleEnum());

        userGroupRoleService.save(userGroupRole);

        // Retornar la respuesta con el grupo creado
        return ResponseEntity.ok(createdGroup);
    }

    private String getAuthenticatedUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        } else {
            return principal.toString();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Group>> getAllGroups() {
        List<Group> groups = groupService.getAllGroups();
        return ResponseEntity.ok(groups);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable Long id) {
        Group group = groupService.getGroupById(id)
            .orElseThrow(() -> new RuntimeException("Group not found"));
            return ResponseEntity.ok(group);
    }
    

    // @PostMapping("/group")
    // public ResponseEntity<Group> createGroup(@RequestBody Group group) {
    // Group createdGroup = groupService.createGroup(group);
    // return new ResponseEntity<>(createdGroup, HttpStatus.CREATED);
    // }
}