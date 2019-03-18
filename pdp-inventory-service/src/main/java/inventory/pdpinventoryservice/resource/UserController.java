package inventory.pdpinventoryservice.resource;



import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import inventory.pdpinventoryservice.model.InventoryResponse;
import inventory.pdpinventoryservice.model.User;
/**
 * This class is used for chat http://localhost:3015/
 * @author akhmohan
 *
 */
@Controller
public class UserController {


    @MessageMapping("/user")
    @SendTo("/inventory/user")
    public InventoryResponse getUser(User user) {
        return new InventoryResponse(user.getName());
    }
}
