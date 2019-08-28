package dao.local;

import org.apache.ibatis.annotations.Param;
import pojo.*;

import java.util.List;

public interface BackStageDao {
    List<DevelopmentPath> getDevelopmentPath();

    void addDevelopmentPath();

    void deleteDevelopmentPath(@Param("id") int id);

    void updateDevelopmentPath(DevelopmentPath developmentPath);

    List<CollegeInfo> getCollegeInfo();

    void addCollegeInfo();

    void deleteCollegeInfo(@Param("id") int id);

    void updateCollegeInfo(CollegeInfo collegeInfo);

    JAAStatus getJAAStatus();

    void setJAAStatus(JAAStatus jaaStatus);

    void deleteCollegeOverview();

    void deleteCollegeTrend();

    void deleteProfessionOverview();

    void deleteHanging();

    void deleteZyHangingDistribution();

    void deleteBjHangingDistribution();

    void deletePopularElective();

    void deleteStuSourceDistribution();

    void addCollegeOverview(CollegeOverview collegeOverview);

    void addCollegeTrend(List<CollegeTrend> list);

    void addProfessionOverview(List<ProfessionOverview> list);

    void addHanging(List<Hanging> list);

    void addZyHangingDistribution(List<Hanging> list);

    void addBjHangingDistribution(List<Hanging> list);

    void addPopularElective(List<PopularElective> list);

    void addStuSourceDistribution(List<StuSourceDistribution> list);

    OverviewStatus getOverviewStatus();

    void setOverviewStatus(OverviewStatus overviewStatus);

    int checkLogin(LoginInfo loginInfo);
}
