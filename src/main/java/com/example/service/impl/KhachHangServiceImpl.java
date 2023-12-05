package com.example.service.impl;

import com.example.dto.request.KhachHangRequest;
import com.example.entity.ChucVu;
import com.example.entity.IdNhanVienChuVu;
import com.example.entity.KhachHang;
import com.example.entity.NhanVienChuVu;
import com.example.model.ERole;
import com.example.reppsistory.KhachHangRepo;
import com.example.service.ChucVuService;
import com.example.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    private KhachHangRepo khachHangRepo;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public boolean saveKhachHang(KhachHangRequest khachHangRequest) {
        try{
            String ma = "KH" + new Random().nextInt(1000);
            KhachHang khachHang = KhachHang.builder()
                    .ma(ma)
                    .hoTen(khachHangRequest.getHoTen())
                    .mail(khachHangRequest.getMail())
                    .passcode(encoder.encode(khachHangRequest.getPasscode()))
                    .build();
            khachHangRepo.save(khachHang);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;

        }
    }
}
