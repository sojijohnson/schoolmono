//package com.schoolDb.schoolDesign.model;
//
//import lombok.Getter;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//
//import javax.sound.midi.Sequence;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.List;
//import java.util.Set;
//
//import static com.schoolDb.schoolDesign.model.Permission.*;
//
//@RequiredArgsConstructor
//public enum Role {
//
//    USER(Collections.emptySet()),
//    ADMIN(Set.of(Permission.ADMIN_DELETE,
//            Permission.ADMIN_CREATE,
//            Permission.ADMIN_UPDATE,
//            Permission.ADMIN_READ,
//            MANAGER_DELETE,
//            MANAGER_CREATE,
//            MANAGER_UPDATE,
//            MANAGER_READ)),
//
//    MANAGER(Set.of(MANAGER_DELETE,
//            MANAGER_CREATE,
//            MANAGER_UPDATE,
//            MANAGER_READ));
//
//    @Getter
//    private final Set<Permission> permissions;
//
//    public List<GrantedAuthority> getAuthorities(){
//
//        var authorities= getPermissions().stream().map(permission -> new SimpleGrantedAuthority(permission.name())).toList();
//
//        return authorities;
//    }
//
//}
