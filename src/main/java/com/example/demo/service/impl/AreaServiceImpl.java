package com.example.demo.service.impl;

import com.example.demo.dao.AreaDao;
import com.example.demo.entity.Area;
import com.example.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;
    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

    @Override
    public Area getAreaById(int areaId) {
        return areaDao.queryAreaById(areaId);
    }

    @Transactional
    @Override
    public boolean addArea(Area area) {
        if(area.getAreaName()!=null && !"".equals(area.getAreaName())){
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try{
                int effectedNum = areaDao.insertArea(area);
                if(effectedNum>0) {
                    return true;
                } else {
                    throw new RuntimeException("insert area info failed");
                }
            } catch (Exception e){
                throw new RuntimeException("insert area info failed:"+ e.getMessage());
            }
        } else {
            throw new RuntimeException("area name cannot be empty.");
        }
    }

    @Override
    public boolean modifyArea(Area area) {
        if(area.getAreaId() != null && area.getAreaId()>0){
            area.setLastEditTime(new Date());
            try{
                int effectedNum = areaDao.updateArea(area);
                if(effectedNum>0) {
                    return true;
                } else {
                    throw new RuntimeException("update area info failed");
                }
            } catch (Exception e){
                throw new RuntimeException("update area info failed:"+e.toString());
            }
        } else {
            throw new RuntimeException("area id cannot be empty");
        }
    }

    @Override
    public boolean deleteArea(int areaId) {
        if(areaId>0){
            try{
                int effectedNum = areaDao.deleteArea(areaId);
                if(effectedNum>0) {
                    return true;
                } else {
                    throw new RuntimeException("delete area info failed");
                }
            } catch (Exception e){
                throw new RuntimeException("delete area info failed:"+e.toString());
            }
        } else {
            throw new RuntimeException("area id cannot be empty");
        }
    }
}
