package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.*;
import service.DataService;

import java.util.List;

@Controller
@CrossOrigin("http://localhost:8080")
@RequestMapping(value = "/data", method = {RequestMethod.GET}, produces = "application/json;charset=utf-8")
public class OverviewChartDataController {
    private final DataService dataService;
    @Autowired
    public OverviewChartDataController(DataService dataService) {
        this.dataService = dataService;
    }

    @RequestMapping(value = "/", method = {RequestMethod.GET})
    @ResponseBody
    public String PrintHelloWorld() {
        return "hello, world.";
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

    @RequestMapping(value = "hanging", method = {RequestMethod.GET})
    @ResponseBody
    public List<Hanging> getHanging() {
        return dataService.getHanging();
    }
}
