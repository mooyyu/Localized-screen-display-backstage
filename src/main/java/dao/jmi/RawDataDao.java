package dao.jmi;

import org.apache.ibatis.annotations.Param;
import pojo.*;

import java.util.List;

public interface RawDataDao {
    CollegeOverview getRawCollegeOverview(JAAStatus jaaStatus);

    List<CollegeTrend> getRawCollegeTrend(JAAStatus jaaStatus);

    List<ProfessionOverview> getRawProfessionOverview(JAAStatus jaaStatus);

    List<Hanging> getRawHanging(JAAStatus jaaStatus);

    List<Hanging> getRawHangingDistribution(@Param("jaaStatus") JAAStatus jaaStatus, @Param("type") String type);

    List<PopularElective> getRawPopularElective(JAAStatus jaaStatus);

    List<StuSourceDistribution> getRawStuSourceDistribution(JAAStatus jaaStatus);
}
