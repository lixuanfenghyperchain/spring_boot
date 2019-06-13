package com.hyperchain.dao;

import com.hyperchain.base.WMap;
import com.hyperchain.vo.Girl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl, Integer> {

    List<Girl> findGirlByAge(Integer ages);

    @Query(value = "select * from girl where age=?1 ", nativeQuery = true)
    List<WMap> findGirlById(Integer ages);

}
