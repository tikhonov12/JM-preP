package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Model.Car;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    @GetMapping(value = "/cars")
    public String printCar(@RequestParam(value = "count", required = false) int count,//HttpServletRequest если нужен полный http запрос
                           Model model) {
        List<Car> cars = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        cars.add(new Car("BMW", "Black", "m5"));
        cars.add(new Car("Mercedes", "Blue", "GL550"));
        cars.add(new Car("Kia", "Red", "Optima"));
        cars.add(new Car("Ford", "White", "FocusST"));
        cars.add(new Car("Audi", "Green", "A8"));
        for (int i = 0; i < count; i++) {
            sb.append(cars.get(i).toString()+"\n");
        }
        model.addAttribute("message",sb);
        return "cars";
    }
}
