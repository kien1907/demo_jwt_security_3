package com.example.reppsistory;

import com.example.entity.IdNhanVienChuVu;
import com.example.entity.NhanVienChuVu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NhanVienChuVuRepo extends JpaRepository<NhanVienChuVu, IdNhanVienChuVu> {
}
