package com.example.service.impl;

import com.example.dto.request.NhanVienRequest;
import com.example.entity.*;
import com.example.model.ERole;
import com.example.reppsistory.NhanVienRepo;
import com.example.service.ChucVuService;
import com.example.service.NhanVienChuVuService;
import com.example.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    private NhanVienRepo nhanVienRepo;
    @Autowired
    private ChucVuService chucVuService;
    @Autowired
    private NhanVienChuVuService nhanVienChuVuService;
    @Autowired
    private PasswordEncoder encoder;
    @Override
    public Boolean addNhanVien(NhanVienRequest nhanVienRequest) {
        try {
            String ma = "NV" + new Random().nextInt(1000);
            NhanVien nhanVien = NhanVien.builder()
                    .ma(ma)
                    .hoTen(nhanVienRequest.getHoTen())
                    .mail(nhanVienRequest.getMail())
                    .passcode(encoder.encode(nhanVienRequest.getPasscode()))
                    .build();
            nhanVienRepo.save(nhanVien);
            NhanVien findNhanVien = nhanVienRepo.findByMa(ma);
            List<NhanVienChuVu> nhanVienChuVuList = new ArrayList<>();
            nhanVienRequest.getRoles().forEach(role->{
                switch (role){
                    case "admin" ->{
                        ChucVu chucVu = chucVuService.findByTen(ERole.ROLE_ADMIN);
                        nhanVienChuVuList.add(new NhanVienChuVu(
                                new IdNhanVienChuVu(findNhanVien,chucVu)));
                    }
                    case "moderator" ->{
                        ChucVu chucVu = chucVuService.findByTen(ERole.ROLE_MODERATOR);
                        nhanVienChuVuList.add(new NhanVienChuVu(
                                new IdNhanVienChuVu(findNhanVien,chucVu)));
                    }
                }
            });
            nhanVienChuVuService.saveForList(nhanVienChuVuList);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public NhanVien findByMa(String ma) {
        return null;
    }
}
