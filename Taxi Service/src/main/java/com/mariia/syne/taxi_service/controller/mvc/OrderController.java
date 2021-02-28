package com.mariia.syne.taxi_service.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ui/orders")
public class OrderController {


    @GetMapping("/list")
    public String showOrdersList(){

        return "order/list";
    }

    @GetMapping("/read/{order_id}")
    public String showOrdersRead(@PathVariable String order_id, Model model){

        //Topic topic = topicService.getTopic(topic_id);
        //model.addAttribute("topic",topic);

        model.addAttribute("order_id",order_id);

        return "order/read";
    }

    @GetMapping("/create")
    public String showOrdersCreate(){

        return "order/create";
    }

//    @GetMapping("/create/{order_auto_id}")
//    public String showOrdersCreate(@PathVariable String order_auto_id, Model model){
//
//        model.addAttribute("order_auto_id",order_auto_id);
//
//        return "order/create";
//    }

    @GetMapping("/update/{order_id}")
    public String showOrdersUpdate(@PathVariable String order_id, Model model){

        model.addAttribute("order_id",order_id);

        return "order/update";
    }
}
