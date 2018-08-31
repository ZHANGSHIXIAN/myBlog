package com.zsx.web;

import com.zsx.bean.Blog;
import com.zsx.bean.Result;
import com.zsx.bean.UserDto;
import com.zsx.service.BlogService;
import com.zsx.service.UserService;
import com.zsx.utils.ResultUtil;
import org.apache.ibatis.annotations.Param;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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


    /**
     * 跳转关于页面
     * @return
     */
    @GetMapping(value = "/about")
    public String about(){
        return "about";
    }


    /**
     * 执行登陆操作
     * @param userDto
     * @throws Exception
     */
    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    @ResponseBody
    public void doLogin(UserDto userDto)throws Exception{

        userService.doLogin(userDto);

    }


    /**
     * 获取博客列表
     * @param currentPage
     * @param like
     * @param model
     * @return
     */
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String blogList(@Param("currentPage") String currentPage, @Param("like") String like, Model model){
        Pattern pattern=Pattern.compile("[0-9]{1,9}");
        if (currentPage == null || !pattern.matcher(currentPage).matches()) {
            currentPage="1";
        }
        //获取博客列表
        Map<String, Object> map = blogService.getBlogList(1001, 1,currentPage,like);
        model.addAttribute("list", map.get("list"));
        model.addAttribute("page", map.get("page"));
        model.addAttribute("like", like);

        return "home";
    }


    /**
     * 跳转登陆页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(Model model){
        return "login";
    }

    /**
     * 通过id获取一篇博客
     * @param blogId
     * @param model
     * @return
     */
    @RequestMapping(value = "/{blogId}/detail",method = RequestMethod.GET)
    public String getBlog(@PathVariable("blogId") Long blogId, Model model){
        //获取博客
       Blog blog= blogService.getBlogById(blogId);
        model.addAttribute("blog", blog);

        return "detail";
    }


    /**
     * 跳转写博客页面
     * @param username
     * @return
     */
    @RequestMapping(value = "/write",method = RequestMethod.GET)
    public String writeBlog(@CookieValue(value = "username", required = false) String username){
        //没有登陆是不允许写博客的
        if (null!=username&&""!=username){
            return "write";
        }
        //跳转登陆页面
        return "writeLogin";
    }


    /**
     * 提交博客
     * @param blog
     * @throws Exception
     */
    @RequestMapping(value = "/submit",method = RequestMethod.POST)
    @ResponseBody
    public void submitBlog(Blog blog) throws Exception{
        blogService.insertBlog(blog);
    }

    /**
     * 删除博客
     * @param id
     * @throws Exception
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public void deleteBlog(@Param("id") String id) throws Exception{
            blogService.deleteBlog(id);
    }


}
