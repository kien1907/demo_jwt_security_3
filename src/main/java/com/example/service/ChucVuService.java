package com.example.service;

import com.example.entity.ChucVu;
import com.example.model.ERole;

public interface ChucVuService {
    ChucVu findByTen(ERole ten);
}
