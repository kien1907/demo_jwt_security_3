package com.example.reppsistory;

import com.example.entity.ChucVu;
import com.example.model.ERole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChucVuRepo extends JpaRepository<ChucVu,Integer> {
    ChucVu findByTen(ERole ten);
}
