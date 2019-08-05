package controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pojo.*;
import service.DataService;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping(value = "/data", method = {RequestMethod.GET}, produces = "application/json;charset=utf-8")
public class ChartDataController {
    private final DataService dataService;
    @Autowired
    public ChartDataController(DataService dataService) {
        this.dataService = dataService;
    }

    @RequestMapping(value = "collegeOverview", method = {RequestMethod.GET})
    @ResponseBody
    public CollegeOverview getCollegeOverview() {
        return dataService.getCollegeOverview();
    }

    @RequestMapping(value = "collegeTrend", method = {RequestMethod.GET})
    @ResponseBody
    public List<CollegeTrend> getCollegeTrend() {
        return dataService.getCollegeTrend();
    }

    @RequestMapping(value = "professionOverview", method = {RequestMethod.GET})
    @ResponseBody
    public List<ProfessionOverview> getProfessionOverview() {
        return dataService.getProfessionOverview();
    }

    @RequestMapping(value = "popularElective", method = {RequestMethod.GET})
    @ResponseBody
    public List<PopularElective> getPopularElective() {
        return dataService.getPopularElective();
    }

    @RequestMapping(value = "hangingDistribution", method = {RequestMethod.GET})
    @ResponseBody
    public List<Hanging> getHangingDistribution(@RequestParam String type) {
        return dataService.getHangingDistribution(type);
    }

    @RequestMapping(value = "hanging", method = {RequestMethod.GET})
    @ResponseBody
    public List<Hanging> getHanging() {
        return dataService.getHanging();
    }

    @RequestMapping(value = "stuSourceDistribution")
    @ResponseBody
    public List<StuSourceDistribution> getStuSourceDistribution() {
        return dataService.getStuSourceDistribution();
    }

    @RequestMapping(value = "developmentPath", method = {RequestMethod.GET})
    @ResponseBody
    public List<DevelopmentPath> getDevelopmentPath() {
        return dataService.getDevelopmentPath();
    }
}
