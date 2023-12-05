package com.example.service;

import com.example.entity.IdNhanVienChuVu;
import com.example.entity.NhanVienChuVu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NhanVienChuVuService{
    List<NhanVienChuVu> getAll();
    void saveForList(List<NhanVienChuVu> list);
}
