package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/worldBig")
public class WorldBigController {

    @RequestMapping(value = "/list")
    public String toWorldIndex() {

        return "worldBig/worldList";
    }

    @RequestMapping(value = "/edit")
    public String edit() {
        return "worldBig/worldEdit";
    }

}
