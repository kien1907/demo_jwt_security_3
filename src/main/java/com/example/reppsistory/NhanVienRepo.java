package com.example.reppsistory;

import com.example.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NhanVienRepo extends JpaRepository<NhanVien,Integer> {
    NhanVien findByMa(String ma);
}
