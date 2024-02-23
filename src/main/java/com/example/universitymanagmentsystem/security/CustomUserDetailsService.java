package com.example.universitymanagmentsystem.security;

import com.example.universitymanagmentsystem.entity.Teacher;
import com.example.universitymanagmentsystem.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final TeacherRepository teacherRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Teacher teacher = teacherRepository.findTeacherByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return new User(teacher.getUsername(), teacher.getPassword(), mapRolesToAuthorities(teacher.getRole()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(String role) {
        return AuthorityUtils.createAuthorityList(role);
    }
}