package com.yzf.web.system.dept;


import com.github.pagehelper.PageInfo;
import com.yzf.domain.system.dept.Dept;
import com.yzf.service.system.dept.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dept")
public class DeptController {

        @Autowired
        private IDeptService iDeptService;

        @RequestMapping(path = "/tolist",method = {RequestMethod.GET,RequestMethod.POST})
        public String tolist(Model model, @RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "3") int pageSize,
                             @RequestParam(defaultValue = "1") String companyId){

            PageInfo<Dept> pb = iDeptService.findDept(currentPage,pageSize,companyId);

            model.addAttribute("pi",pb);
            return "system/dept/dept-list";
        }



}
