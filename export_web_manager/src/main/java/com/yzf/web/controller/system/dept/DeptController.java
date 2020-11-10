package com.yzf.web.controller.system.dept;




import com.github.pagehelper.PageInfo;
import com.yzf.domain.system.dept.Dept;
import com.yzf.service.system.dept.IDeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/system/dept")
public class DeptController {
       private static final Logger log = LoggerFactory.getLogger(DeptController.class);
        @Autowired
        private IDeptService DeptService;

        @RequestMapping(path = "/tolist",method = {RequestMethod.GET,RequestMethod.POST})
        public String tolist(Model model, @RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "3") int pageSize,
                             @RequestParam(defaultValue = "1") String companyId){

            PageInfo<Dept> pb = DeptService.findDept(currentPage,pageSize,companyId);

            model.addAttribute("pi",pb);
            return "system/dept/dept-list";
        }

         @RequestMapping(path = "/toUpdate",method = {RequestMethod.GET,RequestMethod.POST})
            public String toupdate(Model model,String deptId,@RequestParam(defaultValue = "1")String companyId){

            Dept dd = DeptService.findById(deptId);

             List<Dept> list = DeptService.findAll(companyId);
            log.info("dd="+dd);
            model.addAttribute("dd",dd);
            log.info("list"+list);
            model.addAttribute("list",list);
            return "system/dept/dept-update";
    }
        @RequestMapping(path = "/Update",method = {RequestMethod.GET,RequestMethod.POST})
        public String update(Dept dept){
            log.info("dept="+dept);
            DeptService.updateDept(dept);

        return "redirect:/system/dept/tolist.do";
}
}
