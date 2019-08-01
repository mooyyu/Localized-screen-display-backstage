package service;

import pojo.*;

import java.util.List;

public interface DataService {
    CollegeOverview getCollegeOverview();

    List<CollegeTrend> getCollegeTrend();

    List<ProfessionOverview> getProfessionOverview();

    List<Hanging> getHanging();

    List<Hanging> getHangingDistribution(String type);

    List<PopularElective> getPopularElective();

    List<StuSourceDistribution> getStuSourceDistribution();
}
