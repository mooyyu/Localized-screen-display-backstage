package dao.local;

import org.apache.ibatis.annotations.Param;
import pojo.CollegeInfo;
import pojo.DevelopmentPath;
import pojo.JAAStatus;

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
}
