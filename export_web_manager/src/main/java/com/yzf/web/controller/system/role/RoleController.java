package com.yzf.web.controller.system.role;

import com.github.pagehelper.PageInfo;
import com.yzf.domain.result.Result;
import com.yzf.domain.system.role.Role;
import com.yzf.service.system.role.IRoleService;
import com.yzf.web.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/system/role")
public class RoleController extends BaseController {
    private static  final Logger l = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    IRoleService iRoleService;
    @RequestMapping(path="/toList",method ={ RequestMethod.GET, RequestMethod.POST})
    public String toList(@RequestParam(defaultValue = "1") int curr, @RequestParam(defaultValue = "3")int pageSize){
        //调查询分页列表的方法
        PageInfo<Role> pi = iRoleService.findByPage(curr, pageSize, getLoginCompanyId());
        //将pi添加到页面
        request.setAttribute("pi",pi);
        return "system/role/role-list";
    }
    @RequestMapping(path="/toAdd",method ={ RequestMethod.GET, RequestMethod.POST})
    public String toAdd(){
        return "system/role/role-add";
    }
    @RequestMapping(path="/add",method ={ RequestMethod.GET, RequestMethod.POST})
    public String add(Role role){//接收页面提交过来的表单
        l.info("add role="+role);
        role.setCompanyId(getLoginCompanyId());
        role.setCompanyName(getLoginCompanyName());
        iRoleService.saveRole(role);
        return "redirect:/system/role/toList.do";
    }
    //${path}/system/role/toUpdate.do?roleId=${o.roleId}
    @RequestMapping(path="/toUpdate",method ={ RequestMethod.GET, RequestMethod.POST})
    public String toUpdate(String roleId){//需要使用参数接收提交的 roleId
        Role role =  iRoleService.findById(roleId);
        l.info("toUpdate role="+role);

        //回显到页面
        request.setAttribute("role",role);
        return "system/role/role-update";
    }

    //action="${path}/system/role/update.do"
    @RequestMapping(path="/update",method ={ RequestMethod.GET, RequestMethod.POST})
    public String update(Role role){//需要接收编辑页面提交的表单数据
        l.info("update role="+role);
        //更新
        //重新设置companyId companyName
        role.setCompanyId(getLoginCompanyId());
        role.setCompanyName(getLoginCompanyName());

        iRoleService.updateRole(role);
        return "redirect:/system/role/toList.do";
    }

    //${path}/system/role/delete.do?roleId='+id;
    //{code:200,msg:'删除成功',data:null}
    @RequestMapping(path="/delete",method ={ RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    Object delete(String roleId){//参数接收页面js提交过来的roleId
        try {
            iRoleService.deleteRole(roleId);
            //成功
            return Result.init(200,"删除成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            //失败
            return Result.init(-200,"删除失败",null);
        }
    }

    @RequestMapping(path="/toRoleModule",method ={ RequestMethod.GET, RequestMethod.POST})
    public String toRoleModule(){
        return "system/role/role-module";
    }
}