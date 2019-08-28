package service;

import pojo.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    void updateDataFromRaw();

    OverviewStatus getOverviewStatus();

    void setOverviewStatus(OverviewStatus overviewStatus);

    String checkLogin(LoginInfo loginInfo, HttpServletRequest request);

    String checkIsLogin(HttpServletRequest request);

    void getVCode(HttpServletRequest request, HttpServletResponse response);
}
