package com.example.service;

import com.example.dto.request.NhanVienRequest;
import com.example.entity.NhanVien;

public interface NhanVienService {
    Boolean addNhanVien(NhanVienRequest nhanVienRequest);
    NhanVien findByMa(String ma);
}
