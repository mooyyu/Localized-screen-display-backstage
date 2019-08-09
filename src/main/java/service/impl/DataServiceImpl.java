package service.impl;

import dao.local.DataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.*;
import service.DataService;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataServiceImpl implements DataService {
    private final DataDao dataDao;
    @Autowired
    public DataServiceImpl(DataDao dataDao) {
        this.dataDao = dataDao;
    }

    @Override
    public CollegeOverview getCollegeOverview() {
        return dataDao.getCollegeOverview();
    }

    @Override
    public List<CollegeTrend> getCollegeTrend() {
        return dataDao.getCollegeTrend();
    }

    @Override
    public List<ProfessionOverview> getProfessionOverview() {
        return dataDao.getProfessionOverview();
    }

    @Override
    public List<Hanging> getHanging() {
        return dataDao.getHanging();
    }

    @Override
    public List<Hanging> getHangingDistribution(String type) {
        if (type.equals("bjmc")) {
            return dataDao.getBjHangingDistribution();
        } else if (type.equals("zymc")) {
            return dataDao.getZyHangingDistribution();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<PopularElective> getPopularElective() {
        return dataDao.getPopularElective();
    }

    @Override
    public List<StuSourceDistribution> getStuSourceDistribution() {
        return dataDao.getStuSourceDistribution();
    }

    @Override
    public List<DevelopmentPath> getDevelopmentPath() {
        return dataDao.getDevelopmentPath();
    }

    @Override
    public List<CollegeInfo> getCollegeInfo() {
        return dataDao.getCollegeInfo();
    }
}
