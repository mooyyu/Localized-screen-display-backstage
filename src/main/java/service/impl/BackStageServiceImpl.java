package service.impl;

import dao.local.BackStageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.CollegeInfo;
import pojo.DevelopmentPath;
import pojo.JAAStatus;
import service.BackStageService;

import java.util.List;

@Service
public class BackStageServiceImpl implements BackStageService {
    private final BackStageDao backStageDao;
    @Autowired
    public BackStageServiceImpl(BackStageDao backStageDao) {
        this.backStageDao = backStageDao;
    }

    @Override
    public List<DevelopmentPath> getDevelopmentPath() {
        return backStageDao.getDevelopmentPath();
    }

    @Override
    public void addDevelopmentPath() {
        backStageDao.addDevelopmentPath();
    }

    @Override
    public void deleteDevelopmentPath(int id) {
        backStageDao.deleteDevelopmentPath(id);
    }

    @Override
    public void updateDevelopmentPath(DevelopmentPath developmentPath) {
        String year = developmentPath.getYear();
        String info = developmentPath.getInfo();
        if (info != null && year != null && year.length() == 4) {
            if (info.length() > 50) {
                developmentPath.setInfo(info.substring(0, 50));
            }
            backStageDao.updateDevelopmentPath(developmentPath);
        }
    }

    @Override
    public List<CollegeInfo> getCollegeInfo() {
        return backStageDao.getCollegeInfo();
    }

    @Override
    public void addCollegeInfo() {
        backStageDao.addCollegeInfo();
    }

    @Override
    public void deleteCollegeInfo(int id) {
        backStageDao.deleteCollegeInfo(id);
    }

    @Override
    public void updateCollegeInfo(CollegeInfo collegeInfo) {
        String title = collegeInfo.getTitle();
        String intro = collegeInfo.getIntro();
        if (title != null && intro != null) {
            if (title.length() > 10) {
                collegeInfo.setTitle(title.substring(0, 10));
            }
            if (intro.length() > 500) {
                collegeInfo.setIntro(intro.substring(0, 500));
            }
            backStageDao.updateCollegeInfo(collegeInfo);
        }
    }

    @Override
    public JAAStatus getJAAStatus() {
        return backStageDao.getJAAStatus();
    }

    @Override
    public void setJAAStatus(JAAStatus jaaStatus) {
        backStageDao.setJAAStatus(jaaStatus);
    }
}
