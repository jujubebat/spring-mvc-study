package kr.or.connect.mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //컨트롤러 클래스에는 반드시 붙여줘야 한다. 
public class PlusController {
  
  // GET 요청 처리 메서드
   @GetMapping(path="/plusform")
   public String plusform() {
     return "plusForm"; //plusFrom.jsp 뷰를 보여준다. WebMvcContextConfiguration 클래스에서 설정한대로 된다(WEB-INF/views/plusForm.jsp)
   }
   
   // POST 요청 처리 메서드. 값 두개를 받아서 결과값을 request scope에 넣어주고 plusResult 뷰를 보여준다. 
   // @RequestParam의 name은 http parameter의 name과 매핑된다. (html input 상자의 name과 매핑) required는 값이 필수인지 아닌지 설정하는 것
   @PostMapping(path = "/plus")
   public String plus(@RequestParam(name = "value1", required = true) int value1,
           @RequestParam(name = "value2", required = true) int value2, ModelMap modelMap) {
     
       int result = value1 + value2;

       // 스프링이 제공하는 modelmap 객체를 사용해 request scope에 변수를 넣어준다. 
       modelMap.addAttribute("value1", value1); 
       modelMap.addAttribute("value2", value2);
       modelMap.addAttribute("result", result);
       return "plusResult"; // views/plusResult.jsp 로 연결 ( WebMvcContextConfiguration 클래스의 viewResolver을 통해 WEB-INF/views/plusResult.jsp로 연결된다. )
   }
}
