package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.dao.CarDaoImp;
import web.models.Car;
import web.service.CarServiceImp;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    private final CarServiceImp carServiceImp = new CarServiceImp();


    @GetMapping("/cars")
    public String printCars(HttpServletRequest request, ModelMap model) {
        String param = request.getParameter("count");
        if (param == null) {
            model.addAttribute("carsList", carServiceImp.index());
        } else {
            model.addAttribute("carsList", carServiceImp.getCars(Integer.parseInt(param)));
        }
        return "cars";
    }

}
