package com.example.controller;

import com.example.dto.request.KhachHangRequest;
import com.example.dto.request.LoginRequest;
import com.example.dto.request.NhanVienRequest;
import com.example.entity.NhanVienChuVu;
import com.example.model.User;
import com.example.reppsistory.NhanVienChuVuRepo;
import com.example.security.CusTomUserDetailService;
import com.example.security.CustomUserDetail;
import com.example.service.AuthenticationService;
import com.example.service.KhachHangService;
import com.example.service.NhanVienService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/auth")
public class AppController {
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private NhanVienService nhanVienService;

    @PostMapping("/add-khach-hang")
    public ResponseEntity<?> registerKhachHang(@RequestBody KhachHangRequest khachHangRequest){
        boolean result = khachHangService.saveKhachHang(khachHangRequest);
        return new ResponseEntity<>(result ? "Thành Công":"Thất bại",
                result ? HttpStatus.OK:HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/add-nhan-vien")
    public ResponseEntity<?> registerNhanVien(@RequestBody NhanVienRequest nhanVienRequest){
        boolean result = nhanVienService.addNhanVien(nhanVienRequest);
        return new ResponseEntity<>(result ? "Thành Công":"Thất bại",
                result ? HttpStatus.OK:HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        return new ResponseEntity<>(authenticationService.login(loginRequest),HttpStatus.OK);
    }
}
