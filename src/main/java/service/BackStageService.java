package service;

import pojo.CollegeInfo;
import pojo.DevelopmentPath;
import pojo.JAAStatus;

import java.util.List;

public interface BackStageService {
    List<DevelopmentPath> getDevelopmentPath();

    void addDevelopmentPath();

    void deleteDevelopmentPath(int id);

    void updateDevelopmentPath(DevelopmentPath developmentPath);

    List<CollegeInfo> getCollegeInfo();

    void addCollegeInfo();

    void deleteCollegeInfo(int id);

    void updateCollegeInfo(CollegeInfo collegeInfo);

    JAAStatus getJAAStatus();

    void setJAAStatus(JAAStatus jaaStatus);
}
