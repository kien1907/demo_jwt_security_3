package com.example.reppsistory;

import com.example.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KhachHangRepo extends JpaRepository<KhachHang,Integer> {
}
