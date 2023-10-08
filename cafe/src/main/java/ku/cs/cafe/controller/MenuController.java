package ku.cs.cafe.controller;
// 6410406878
// Sarunpawat Phosoi
import ku.cs.cafe.entity.Menu;
import ku.cs.cafe.model.MenuRequest;
import ku.cs.cafe.sevice.CategoryService;
import ku.cs.cafe.sevice.MenuService;
import ku.cs.cafe.sevice.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/menus")
public class MenuController {
    @Autowired
    private MenuService menuService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public String getAllMenus(Model model) {
//        model.addAttribute("menus", menuService.getAllMenus());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "menu-all";
    }

    @GetMapping("/{id}")
    public String getOneMenu(@PathVariable UUID id, Model model) {
        Menu menu = menuService.getOneById(id);
        model.addAttribute("menu", menu);
        return "menu-view";
    }

    @GetMapping("/add")
    public String getMenuForm(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "menu-add";
    }

    @PostMapping("/add")
    public String createMenu(@ModelAttribute MenuRequest menu, Model model) {
        menuService.createMenu(menu);
        model.addAttribute("categories", categoryService.getAllCategories());
//        model.addAttribute("menus", menuService.getAllMenus());
        return "redirect:/menus";
    }


}
