package sg.edu.nus.iss.practice2day12.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import jakarta.servlet.http.HttpServletRequest;
import sg.edu.nus.iss.practice2day12.model.Image;


@Controller
@RequestMapping
public class RandomNumController {
    
    // create Get request for the home page
    @GetMapping
    public String homePage(){
        return "home";
    }

    // create Get request for generating random numbers
    // serv = object
    @GetMapping(path = "/numbers")
    public String numbers(Model model, HttpServletRequest serv){

        // when user types in an input number, Http will receive the
        // input as a string that is stored in variable serv
        // we then need to store this in an int var called 'num'
        int Rnum = Integer.parseInt(serv.getParameter("Rnum"));
        int num = Integer.parseInt(serv.getParameter("num"));
        String yrName = serv.getParameter("yrName");

        if (Rnum < 1 || Rnum > 30){
            model.addAttribute("error", "wrong number la");
            return "home";
        } 
            Random r = new Random();
            List<Integer> numList = new ArrayList<>();
            List<Image> imgList = new ArrayList<>();

            //.collect converts your stream data into another data type
            // in this case, Collectors.toList() converts into a list
            // .box tapao the data into a stream object before collecting
            numList = r.ints(1, 31).distinct()
            .limit(Rnum).boxed().collect(Collectors.toList());


            for (int n : numList) {
                imgList.add(new Image(Integer.toString(n), "/images/" + Integer.toString(n) + ".png"));
            }


            model.addAttribute("rando", Rnum);

            // in this case, to display the images, just pass in the imgList
            // object because we will do a for loop in html 
            model.addAttribute("imgList",imgList);
        
        System.out.println(imgList.toString());
        System.out.println(imgList.size());
        System.out.println(Rnum);
        System.out.println(num);
        System.out.println(yrName);

        return "numbers";
    }
}
