package dao.local;

import org.apache.ibatis.annotations.Param;
import pojo.*;

import java.util.List;

public interface DataDao {
    CollegeOverview getCollegeOverview();

    List<CollegeTrend> getCollegeTrend();

    List<ProfessionOverview> getProfessionOverview();

    List<Hanging> getHanging();

    List<Hanging> getZyHangingDistribution();

    List<Hanging> getBjHangingDistribution();

    List<PopularElective> getPopularElective();

    List<StuSourceDistribution> getStuSourceDistribution();

    List<DevelopmentPath> getDevelopmentPath();

    List<CollegeInfo> getCollegeInfo();
}
