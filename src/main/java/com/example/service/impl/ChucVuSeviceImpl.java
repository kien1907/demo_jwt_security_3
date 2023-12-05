package com.example.service.impl;

import com.example.entity.ChucVu;
import com.example.model.ERole;
import com.example.reppsistory.ChucVuRepo;
import com.example.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChucVuSeviceImpl implements ChucVuService {

    @Autowired
    private ChucVuRepo chucVuRepo;

    @Override
    public ChucVu findByTen(ERole ten) {
        return chucVuRepo.findByTen(ten);
    }
}
