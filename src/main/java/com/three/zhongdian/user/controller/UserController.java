package com.three.zhongdian.user.controller;

import com.three.zhongdian.user.entity.User;
import com.three.zhongdian.user.mapper.UserMapper;
import com.three.zhongdian.user.service.UserService;
import com.three.zhongdian.util.PhoneUtil;
import com.three.zhongdian.util.Upload;
import com.three.zhongdian.util.ValidateCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 2017/8/5.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @InitBinder
    public void initBinder(HttpServletRequest request,
                           ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));

    }

    @Autowired
    private UserService userService;
    @RequestMapping("tologin")
    @ResponseBody
    public String login(HttpSession session,User user){
        User loginUser = userService.login(user);
        if(loginUser!=null) {
            session.setAttribute("loginUser", loginUser);
            return "1";
        }
        return "0";
    }
    @RequestMapping("goToLogin")
    public String goToLogin(HttpSession session,User user){
        User loginUser = userService.login(user);
        if(loginUser!=null) {
            session.setAttribute("loginUser", loginUser);
            return "user";
        }
        return "closeLogin";
    }
    /*
        清除session的方法
         */
    @RequestMapping("index")
    public String index(){return "index";}
    @RequestMapping("clearSession")
    @ResponseBody
    public String clear(HttpSession session){
        System.out.println("开始清除");
        session.removeAttribute("loginUser");
        return "";
    }
    @RequestMapping("toValidateCode")
    @ResponseBody
    public String toValidateCode(HttpServletResponse response,HttpSession session)throws Exception{
        ValidateCode vCode = new ValidateCode(160,40,5,150);
        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");
        //禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        vCode.write(response.getOutputStream());
        System.out.println(vCode.getCode().toString());
        session.setAttribute("code",vCode.getCode().toString());
        return null;
    }
    /*
    发送手机验证码的方法
     */
    @RequestMapping("toPhone")
    @ResponseBody
    public String toPhone(HttpSession session,String phone){
        System.out.println("开始发送短信"+phone);
        Integer phoneCode = PhoneUtil.getSecurity(phone);
        System.out.println(phoneCode);
        session.setAttribute("phoneCode",phoneCode+"");
        return null;
    }
    /*
    ajax验证验证码是否输入正确
     */
    @RequestMapping("yzCode")
    @ResponseBody
    public String yzCode(String code,HttpSession session){
        String codel = (String)session.getAttribute("code");
        if(code.equalsIgnoreCase(codel)){
            System.out.println("验证成功");
            return "1";
        }
        System.out.println("验证失败");
        return "0";
    }
    /*ajax验证手机验证码是否输入正确*/
    @RequestMapping("yzPhoneCode")
    @ResponseBody
    public String yzPhoneCode(HttpSession session,String phoneCode){
        String yzphoneCode = (String)session.getAttribute("phoneCode");
        if(yzphoneCode.equals(phoneCode)){
            System.out.println("手机号验证成功");
            return "1";
        }
        System.out.println("手机号验证失败");
        return "0";
    }
    /*用户注册的方法*/
    @RequestMapping("saveUser")
    public String saveUser(User user, Model model){
     userService.saveUser(user);
        System.out.println("添加成功");
        model.addAttribute("user",user);
     return "success";
    }
    /*
    修改用户信息的方法
     */
    @RequestMapping("toUpdateUser")
    public String updateUser(User user,HttpSession session){
        System.out.println(user.getCity());
        userService.updateUser(user);
        session.setAttribute("loginUser", userService.findUserById(user.getId()));
        return "updateUser";
    }
    /*
    ajax修改头像
     */
    @RequestMapping("updateImgHead")
    @ResponseBody
    public String updateImgHead (HttpSession session,@RequestParam("file")MultipartFile file,HttpServletRequest request,User user) throws Exception {
        String headName = Upload.getUpload(request, file);
        user.setImgHead(headName);
        System.out.println(user.getImgHead()+"====================="+user.getId());
        session.setAttribute("loginUser", userService.findUserById(user.getId()));
        userService.updateImgHead(user);
        return user.getImgHead();
    }

}
