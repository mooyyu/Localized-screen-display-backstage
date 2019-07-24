package service.impl;

import dao.DataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.*;
import service.DataService;

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
    public List<PopularElective> getPopularElective() {
        return dataDao.getPopularElective();
    }
}
