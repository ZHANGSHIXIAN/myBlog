package com.zsx.web;

import com.zsx.bean.Blog;
import com.zsx.bean.UserDto;
import com.zsx.service.BlogService;
import com.zsx.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/myblog")
public class BlogController {

    private final org.slf4j.Logger logger=LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BlogService blogService;

    @Autowired
    private UserService userService;




    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    @ResponseBody
    public Object doLogin(UserDto userDto){
        Map<String,String> result=new HashMap<String,String>();
        int i=userService.doLogin(userDto);
        if (i>0){
            result.put("status", "success");
        }else {
            result.put("status", "error");
        }

        return result;
    }





    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String blogList(@Param("currentPage") String currentPage, @Param("like") String like, Model model){
        Pattern pattern=Pattern.compile("[0-9]{1,9}");
        if (currentPage == null || !pattern.matcher(currentPage).matches()) {
            currentPage="1";
        }
        logger.debug("=======like=====", like);
        System.out.println("ccccccccccccccccccc"+like);
        //获取博客列表
        Map<String, Object> map = blogService.getBlogList(1001, 1,currentPage,like);
        model.addAttribute("list", map.get("list"));
        model.addAttribute("page", map.get("page"));
        model.addAttribute("like", like);

        return "home";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(Model model){
        return "login";
    }

    @RequestMapping(value = "/{blogId}/detail",method = RequestMethod.GET)
    public String blogList(@PathVariable("blogId") Long blogId, Model model){
        //获取博客
       Blog blog= blogService.getBlogById(blogId);
        model.addAttribute("blog", blog);

        return "detail";
    }

    @RequestMapping(value = "/write",method = RequestMethod.GET)
    public String writeBlog(@CookieValue(value = "username", required = false) String username){
        if (null!=username&&""!=username){
            return "write";
        }
        return "writeLogin";
    }


    @RequestMapping(value = "/submit",method = RequestMethod.POST)
    public int submitBlog(Blog blog){
        int result=blogService.insertBlog(blog);

        return result;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public Object deleteBlog(@Param("id") String id){
        System.out.println("======id==="+id);
        Map<String,String> result=new HashMap<String,String>();
        if (null!=id&&""!=id){
            int r=blogService.deleteBlog(id);
            if (r>0){
                result.put("status", "success");
            }else {
                result.put("status", "fault");
            }

        }else {
            result.put("status", "fault");
        }


        return result;
    }

}
