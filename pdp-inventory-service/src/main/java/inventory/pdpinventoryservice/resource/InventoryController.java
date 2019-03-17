package inventory.pdpinventoryservice.resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import inventory.pdpinventoryservice.model.InventoryDetails;
import inventory.pdpinventoryservice.model.InventoryResponse;


@RestController
@RequestMapping(value = "/inventory")
public class InventoryController {

	@Autowired
	SimpMessagingTemplate template;

	@RequestMapping(value = "/updateInventory", method = RequestMethod.POST)
	public void updateInventory(@RequestBody InventoryDetails inventoryDetails) {
		//some operations can be done here.........
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = null;
		String productId=inventoryDetails.getProductId();
		try {
			json = ow.writeValueAsString(inventoryDetails);
		} catch (JsonProcessingException e) {
			System.out.println(e);
		}
		if(StringUtils.isBlank(productId)) {
			productId="user";//this is used for chat
		}	
		System.out.println("/inventory/"+productId);
		
		
		System.out.println(""+template.getUserDestinationPrefix()+",,"+template.getDefaultDestination());
		template.convertAndSend("/inventory/"+productId, new InventoryResponse(json));
		
	}

}
