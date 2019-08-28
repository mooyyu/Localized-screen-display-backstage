package service.impl;

import dao.jmi.RawDataDao;
import dao.local.BackStageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.*;
import service.BackStageService;
import utils.Md5;
import utils.VCodeGenerator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class BackStageServiceImpl implements BackStageService {
    private final BackStageDao backStageDao;
    private final RawDataDao rawDataDao;
    @Autowired
    public BackStageServiceImpl(BackStageDao backStageDao, RawDataDao rawDataDao) {
        this.backStageDao = backStageDao;
        this.rawDataDao = rawDataDao;
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

    @Override
    public void updateDataFromRaw() {
        JAAStatus jaaStatus = backStageDao.getJAAStatus();
        backStageDao.deleteCollegeOverview();
        backStageDao.addCollegeOverview(rawDataDao.getRawCollegeOverview(jaaStatus));
        backStageDao.deleteCollegeTrend();
        backStageDao.addCollegeTrend(rawDataDao.getRawCollegeTrend(jaaStatus));
        backStageDao.deleteProfessionOverview();
        backStageDao.addProfessionOverview(rawDataDao.getRawProfessionOverview(jaaStatus));
        backStageDao.deleteStuSourceDistribution();
        backStageDao.addStuSourceDistribution(rawDataDao.getRawStuSourceDistribution(jaaStatus));
        backStageDao.deletePopularElective();
        backStageDao.addPopularElective(rawDataDao.getRawPopularElective(jaaStatus));
        backStageDao.deleteHanging();
        backStageDao.addHanging(rawDataDao.getRawHanging(jaaStatus));
        backStageDao.deleteBjHangingDistribution();
        backStageDao.addBjHangingDistribution(rawDataDao.getRawHangingDistribution(jaaStatus, "bjmc"));
        backStageDao.deleteZyHangingDistribution();
        backStageDao.addZyHangingDistribution(rawDataDao.getRawHangingDistribution(jaaStatus, "zymc"));
    }

    @Override
    public OverviewStatus getOverviewStatus() {
        return backStageDao.getOverviewStatus();
    }

    @Override
    public void setOverviewStatus(OverviewStatus overviewStatus) {
        backStageDao.setOverviewStatus(overviewStatus);
    }

    @Override
    public String checkLogin(LoginInfo loginInfo, HttpServletRequest request) {
        if (request.getSession().getAttribute("vcode") != null &&
            request.getSession().getAttribute("vcode").toString().equalsIgnoreCase((loginInfo.getVcode()))
        ) {
            loginInfo.setPassword(new Md5().createMD5(loginInfo.getPassword()));
            request.getSession().setAttribute("isLogin", true);
            return backStageDao.checkLogin(loginInfo) == 1 ? "success" : "error";
        } else {
            return "vcode_error";
        }
    }

    @Override
    public String checkIsLogin(HttpServletRequest request) {
        if (request.getSession().getAttribute("isLogin") == null) {
            return "no";
        } else {
            return request.getSession().getAttribute("isLogin").equals(true) ? "yes" : "no";
        }
    }

    @Override
    public void getVCode(HttpServletRequest request, HttpServletResponse response) {
        new VCodeGenerator().getVCode(request, response);
    }
}
