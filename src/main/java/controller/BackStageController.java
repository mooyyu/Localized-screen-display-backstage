package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pojo.CollegeInfo;
import pojo.DevelopmentPath;
import service.BackStageService;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping(value = "/backStage", method = {RequestMethod.GET}, produces = "application/json;charset=utf-8")
public class BackStageController {
    private final BackStageService backStageService;
    @Autowired
    public BackStageController(BackStageService backStageService) {
        this.backStageService = backStageService;
    }

    @RequestMapping(value = "getDevelopmentPath", method = {RequestMethod.GET})
    @ResponseBody
    public List<DevelopmentPath> getDevelopmentPath() {
        return backStageService.getDevelopmentPath();
    }

    @RequestMapping(value = "addDevelopmentPath", method = {RequestMethod.GET})
    @ResponseBody
    public void addDevelopmentPath() {
        backStageService.addDevelopmentPath();
    }

    @RequestMapping(value = "deleteDevelopmentPath", method = {RequestMethod.GET})
    @ResponseBody
    public void deleteDevelopmentPath(@RequestParam int id) {
        backStageService.deleteDevelopmentPath(id);
    }

    @RequestMapping(value = "updateDevelopmentPath", method = {RequestMethod.POST})
    @ResponseBody
    public void updateDevelopmentPath(@RequestBody DevelopmentPath developmentPath) {
        backStageService.updateDevelopmentPath(developmentPath);
    }

    @RequestMapping(value = "getCollegeInfo", method = {RequestMethod.GET})
    @ResponseBody
    public List<CollegeInfo> getCollegeInfo() {
        return backStageService.getCollegeInfo();
    }

    @RequestMapping(value = "addCollegeInfo", method = {RequestMethod.GET})
    @ResponseBody
    public void addCollegeInfo() {
        backStageService.addCollegeInfo();
    }

    @RequestMapping(value = "deleteCollegeInfo", method = {RequestMethod.GET})
    @ResponseBody
    public void deleteCollegeInfo(@RequestParam int id) {
        backStageService.deleteCollegeInfo(id);
    }

    @RequestMapping(value = "updateCollegeInfo", method = {RequestMethod.POST})
    @ResponseBody
    public void updateCollegeInfo(@RequestBody CollegeInfo collegeInfo) {
        backStageService.updateCollegeInfo(collegeInfo);
    }
}
