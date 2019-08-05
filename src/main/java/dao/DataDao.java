package dao;

import org.apache.ibatis.annotations.Param;
import pojo.*;

import java.util.List;

public interface DataDao {
    CollegeOverview getCollegeOverview();

    List<CollegeTrend> getCollegeTrend();

    List<ProfessionOverview> getProfessionOverview();

    List<Hanging> getHanging();

    List<Hanging> getHangingDistribution(@Param("type") String type);

    List<PopularElective> getPopularElective();

    List<StuSourceDistribution> getStuSourceDistribution();

    List<DevelopmentPath> getDevelopmentPath();
}
