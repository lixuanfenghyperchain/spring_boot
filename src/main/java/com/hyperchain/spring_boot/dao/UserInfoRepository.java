package com.hyperchain.spring_boot.dao;

import com.hyperchain.spring_boot.entitiy.UserInfo;
import com.hyperchain.spring_boot.entitiy.ViewInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    @Query(value = "SELECT new com.hyperchain.spring_boot.entitiy.ViewInfo(u, a) FROM UserInfo u, Address a WHERE u.addressId = a.addressId  ")
    public List<ViewInfo> findViewInfo();

}
