package com.yzf.web.controller.company;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yzf.domain.company.Company;
import com.yzf.service.company.ICompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController {
        private static final Logger log = LoggerFactory.getLogger(CompanyController.class);

        @Autowired
        private ICompanyService iCompanyService;

        @RequestMapping(path = "/ms" ,method = {RequestMethod.GET,RequestMethod.POST})
        public String companyUI( Model model,Integer currentPage,Integer pageSize){
            if(currentPage==null){
                currentPage=1;
            }
            if (pageSize==null){
                pageSize=3;
            }
            PageInfo<Company> list = iCompanyService.findPage(currentPage,pageSize);
//
            model.addAttribute("pi",list);
            log.info(list+"");

            return "company/company-list";
        }

        @RequestMapping(path = "/date",method = RequestMethod.GET)
        public void testDate(Date date){
            log.info("date= "+date);
        }

        @RequestMapping(path = "/toAdd",method = RequestMethod.GET)
        public String toAdd(){
            return "company/company-add";
        }

        @RequestMapping(path = "/add",method = RequestMethod.POST)
        public String add(Company company){

            iCompanyService.saveCompany(company);

            return "redirect:/company/ms.do";
        }
        @RequestMapping(path = "/delete",method = RequestMethod.GET)
        public String delete(String id){
            iCompanyService.deleteById(id);
            return "redirect:/company/ms.do";
        }

        @RequestMapping(path = "/toUpdate",method = RequestMethod.GET)
        public String toUpdate(Model model,String id){

            Company company = iCompanyService.findById(id);

            model.addAttribute("company",company);

            return "company/company-update";
        }

        @RequestMapping(path = "/update",method = RequestMethod.POST)
        public String update(Company company){

            iCompanyService.updateCompany(company);

            return "redirect:/company/ms.do";
        }

}
