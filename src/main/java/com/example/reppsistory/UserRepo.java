package com.example.reppsistory;

import com.example.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends JpaRepository<User,String> {
    @Query(value = "SELECT *\n" +
            "FROM\n" +
            "(\n" +
            "   SELECT ma, ho_ten , mail,passcode, 'NhanVien' as loai\n" +
            "   FROM nhan_vien\n" +
            "   UNION\n" +
            "   SELECT ma, ho_ten, mail,passcode, 'KhachHang' as loai\n" +
            "   FROM khach_hang\n" +
            ") AS merged_data\n" +
            "WHERE mail = :mail",nativeQuery = true)
    User findByMail(@Param("mail")String mail);
    @Query(value = "select ma,ho_ten,mail,passcode,'NhanVien' as loai from nhan_vien\n" +
            " union \n" +
            " select ma,ho_ten,mail,passcode,'KhachHang' as loai  from khach_hang",nativeQuery = true)
    List<User> getAll();
}
