package kr.or.connect.mvcexam.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class GoodsController {
    @GetMapping("/goods/{id}") // {id} 형태로 path variable를 받겠다는뜻
    public String getGoodsById(@PathVariable(name="id") int id, // 애노테이션을 이용해 pathVariable을 가져온다.!
                               @RequestHeader(value="User-Agent", defaultValue="myBrowser") String userAgent, //애노테이션을 이용해 헤더 정보를 가져온다.
                              HttpServletRequest request, // 이렇게 HttpServletReques 서블릿을 사용할 수도 있다.
                              ModelMap model //ModelMap 객체를 사용해서 request scope에  값을 등록한다. 그 다음 goodsById.jsp 뷰에서 이 값을 화면에 보여준다. 
                              ) {
        
        String path = request.getServletPath();
        
        System.out.println("id : " + id);
        System.out.println("user_agent : " + userAgent);
        System.out.println("path : " + path);
        
        model.addAttribute("id", id);
        model.addAttribute("userAgent", userAgent);
        model.addAttribute("path", path);
        return "goodsById";
    }
}