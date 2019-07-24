package dao;

import pojo.*;

import java.util.List;

public interface DataDao {
    CollegeOverview getCollegeOverview();

    List<CollegeTrend> getCollegeTrend();

    List<ProfessionOverview> getProfessionOverview();

    List<Hanging> getHanging();

    List<PopularElective> getPopularElective();
}
