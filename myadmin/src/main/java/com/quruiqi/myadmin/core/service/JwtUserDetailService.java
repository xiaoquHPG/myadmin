package com.quruiqi.myadmin.core.service;

import com.quruiqi.myadmin.common.exception.EntityNotFoundException;
import com.quruiqi.myadmin.common.utils.ValidationUtil;
import com.quruiqi.myadmin.core.security.JwtUser;
import com.quruiqi.myadmin.system.domain.Permission;
import com.quruiqi.myadmin.system.domain.Role;
import com.quruiqi.myadmin.system.domain.User;
import com.quruiqi.myadmin.system.repository.PermissionRepository;
import com.quruiqi.myadmin.system.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Lenovo
 * @Date 2023/9/28 13:57
 **/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
@RequiredArgsConstructor
public class JwtUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    private final PermissionRepository permissionRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = null;
        if (ValidationUtil.isEmail(s)) {
            user = userRepository.findByEmail(s);
        }else{
            user = userRepository.findByUsername(s);
        }

        if (ObjectUtils.isEmpty(user)) {
            throw new EntityNotFoundException(User.class, "username", s);
        }

        return create(user);
    }

    private UserDetails create(User user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getAvatar(),
                user.getEmail(),
                user.getEnabled(),
                user.getLastPasswordResetTime(),
                mapToGrantedAuthorities(user.getRoles(), permissionRepository)
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(Set<Role> roles, PermissionRepository permissionRepository) {

        Set<Permission> permissions = new HashSet<>();
        for (Role role : roles) {
            Set<Role> roleSet = new HashSet<>();
            roleSet.add(role);
            permissions.addAll(permissionRepository.findByRoles(roleSet));
        }

        return permissions.stream().map(permission -> new SimpleGrantedAuthority("ROLE_" + permission.getName()))
                .collect(Collectors.toList());
    }

}
