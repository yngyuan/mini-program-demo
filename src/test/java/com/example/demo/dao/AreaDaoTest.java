package com.example.demo.dao;

import com.example.demo.entity.Area;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class AreaDaoTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    void queryArea() {
        List<Area> areaList = areaDao.queryArea();
        assertEquals(2, areaList.size());
    }

    @Test
    void queryAreaById() {
        Area area = areaDao.queryAreaById(1);
        assertEquals("EastSide", area.getAreaName());
    }

    @Test
    void insertArea() {
        Area area = new Area();
        area.setAreaName("SouthSide");
        area.setPriority(1);
        int effectedNum = areaDao.insertArea(area);
        assertEquals(1, effectedNum);
    }

    @Test
    void updateArea() {
        Area area = new Area();
        area.setAreaName("WestSide");
        area.setAreaId(4);
        area.setLastEditTime(new Date());
        int effectedNum = areaDao.updateArea(area);
        assertEquals(1, effectedNum);
    }

    @Test
    void deleteArea() {
        int effectedNum = areaDao.deleteArea(4);
        assertEquals(1, effectedNum);
    }
}