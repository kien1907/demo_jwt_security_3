package com.example.service.impl;

import com.example.entity.NhanVienChuVu;
import com.example.reppsistory.NhanVienChuVuRepo;
import com.example.service.NhanVienChuVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienChuVuServiceImpl implements NhanVienChuVuService {
    @Autowired
    private NhanVienChuVuRepo nhanVienChuVuRepo;
    @Override
    public List<NhanVienChuVu> getAll() {
        return nhanVienChuVuRepo.findAll();
    }

    @Override
    public void saveForList(List<NhanVienChuVu> list) {
        nhanVienChuVuRepo.saveAll(list);
    }
}
