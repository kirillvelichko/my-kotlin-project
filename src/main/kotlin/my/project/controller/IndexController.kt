package my.project.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class IndexController {

    @RequestMapping(value = ["/"])
    fun index(model: Model): String {
        model.addAttribute("projectName", "my-kotlin-project")
        return "index"
    }
}