package com.quruiqi.myadmin.monitor.service.impl;

import com.quruiqi.myadmin.common.utils.RequestHolder;
import com.quruiqi.myadmin.common.utils.TimeUtil;
import com.quruiqi.myadmin.monitor.domain.Visits;
import com.quruiqi.myadmin.monitor.repository.LoggingRepository;
import com.quruiqi.myadmin.monitor.repository.VisitsRepository;
import com.quruiqi.myadmin.monitor.service.VisitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author Lenovo
 * @Date 2023/9/29 10:07
 **/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class VisitsServiceImpl implements VisitsService {

    @Autowired
    private VisitsRepository visitsRepository;

    @Autowired
    private LoggingRepository loggingRepository;

    @Override
    public void save(HttpServletRequest request) {
        LocalDate localDate = LocalDate.now();
        Visits visits = visitsRepository.findByDate(localDate.toString());
        if(visits != null){
            visits.setPvCounts(visits.getPvCounts()+1);
            long ipCounts = loggingRepository.findIp(localDate.toString(), localDate.plusDays(1).toString());
            visits.setIpCounts(ipCounts);
        }else {
            visits = new Visits();
            visits.setWeekDay(TimeUtil.getWeekDay());
            visits.setPvCounts(1L);
            visits.setIpCounts(1L);
            visits.setDate(localDate.toString());
        }
        visitsRepository.save(visits);
    }

    @Override
    public Object get() {
        Map map = new HashMap();
        LocalDate localDate = LocalDate.now();
        Visits visits = visitsRepository.findByDate(localDate.toString());
        if(visits == null){
            save(RequestHolder.getHttpServletRequest());
        }
        List<Visits> list = visitsRepository.findAllVisits(localDate.minusDays(6).toString(),localDate.plusDays(1).toString());

        long recentVisits = 0, recentIp = 0;
        for (Visits data : list) {
            recentVisits += data.getPvCounts();
            recentIp += data.getIpCounts();
        }
        map.put("newVisits",visits.getPvCounts());
        map.put("newIp",visits.getIpCounts());
        map.put("recentVisits",recentVisits);
        map.put("recentIp",recentIp);
        return map;
    }

    @Override
    public Object getChartData() {
        Map map = new HashMap();
        LocalDate localDate = LocalDate.now();
        List<Visits> list = visitsRepository.findAllVisits(localDate.minusDays(6).toString(),localDate.plusDays(1).toString());
        map.put("weekDays",list.stream().map(Visits::getWeekDay).collect(Collectors.toList()));
        map.put("visitsData",list.stream().map(Visits::getPvCounts).collect(Collectors.toList()));
        map.put("ipData",list.stream().map(Visits::getIpCounts).collect(Collectors.toList()));
        return map;
    }
}
