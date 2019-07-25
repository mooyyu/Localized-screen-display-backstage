package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.StuInfo;
import pojo.TeaInfo;

import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping(value = "/info", method = {RequestMethod.GET}, produces = "application/json;charset=utf-8")
public class ExcellentInfoController {

    @RequestMapping("excellentStu")
    @ResponseBody
    public List<StuInfo> getStuInfo() {
        List<StuInfo> list = new ArrayList<StuInfo>();
        for (int i = 0; i < 10; i++) {
            list.add(new StuInfo());
            list.get(i).setTitle(list.get(i).getTitle() + i);
        }
        return list;
    }

    @RequestMapping("excellentTea")
    @ResponseBody
    public List<TeaInfo> getTeaInfo() {
        List<TeaInfo> list = new ArrayList<TeaInfo>();
        for (int i = 0; i < 10; i++) {
            list.add(new TeaInfo());
            list.get(i).setName(list.get(i).getName() + i);
        }
        return list;
    }
}
