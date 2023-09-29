package com.quruiqi.myadmin.monitor.repository;

import com.quruiqi.myadmin.monitor.domain.Logging;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @Author Lenovo
 * @Date 2023/9/29 10:04
 **/
@Repository
public interface LoggingRepository extends JpaRepository<Logging,Long>, JpaSpecificationExecutor {

    /**
     * 获取一个时间段的IP记录
     * @param date1
     * @param date2
     * @return
     */
    @Query(value = "select count(*) FROM (select * FROM log where createTime between ?1 and ?2 GROUP BY requestIp) as s",nativeQuery = true)
    Long findIp(String date1, String date2);
}
