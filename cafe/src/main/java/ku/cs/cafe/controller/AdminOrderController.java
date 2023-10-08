package ku.cs.cafe.controller;
// 6410406878
// Sarunpawat Phosoi
import ku.cs.cafe.sevice.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

public class AdminOrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public String getAllOrders(Model model){
        model.addAttribute("orders", orderService.getAllOrders());
        return "order-all";
    }

    @GetMapping("/{orderId}")
    public String getAllOrders(@PathVariable UUID orderId, Model model) {
        model.addAttribute("order", orderService.getById(orderId));
        return "order-view";
    }

    @PostMapping("/{orderId}/finish")
    public String finishOrder(@PathVariable UUID orderId, Model model) {
        orderService.finishOrder(orderId);
        return "redirect:/admin/orders";
    }


}

