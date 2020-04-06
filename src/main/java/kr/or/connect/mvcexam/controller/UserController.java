package kr.or.connect.mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import kr.or.connect.mvcexam.dto.User;


@Controller // 컨트롤러 어노테이션 
public class UserController {
  
    // "/userform" URL에 대해 userform.jsp 뷰를 보여준다. 
    @RequestMapping(path="/userform", method=RequestMethod.GET) //@GetMapping 어노테이션으로도 할 수 있음.
    public String userform() {
        return "userform"; 
    }
    
    // "/regist" URL에 대한 요청처리. post로 받은 user 데이터를 user dto에 매핑한다음 콘솔에 출력
    @RequestMapping(path="/regist", method=RequestMethod.POST)
    public String regist(@ModelAttribute User user) { // @ModelAttribute 을 dto앞에 붙여주면 스프링이 pos 데이터를 보고 알아서 값을 넣고 객체를 만들어 넘겨줌

        System.out.println("사용자가 입력한 user 정보입니다. 해당 정보를 이용하는 코드가 와야합니다.");
        System.out.println(user);
        return "regist";
    }
}