package com.example.security;

import com.example.model.User;
import com.example.service.NhanVienChuVuService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CusTomUserDetailService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Autowired
    private NhanVienChuVuService nhanVienChuVuService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByMail(username);
        List<GrantedAuthority> authorityList = new ArrayList<>();
        switch (user.getLoai()){
            case "NhanVien" ->{
                authorityList = nhanVienChuVuService
                        .getAll().stream().map(role ->
                                new SimpleGrantedAuthority(
                                        role.getIdNhanVienChuVu()
                                                .getChucVu().getTen().name())
                        ).collect(Collectors.toList());
            }
            case "KhachHang" ->{
                SimpleGrantedAuthority simpleGrantedAuthority =
                        new SimpleGrantedAuthority("ROLE_USER");
                authorityList.add(simpleGrantedAuthority);
            }
        }
        try {
            return CustomUserDetail.builder()
                    .ma(user.getMa())
                    .hoTen(user.getHoTen())
                    .mail(user.getMail())
                    .passcode(user.getPasscode())
                    .authorities(authorityList)
                            .build();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
