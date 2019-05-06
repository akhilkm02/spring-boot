package inventory.pdpinventoryservice.resource;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import inventory.pdpinventoryservice.config.InventoryWebSocketConfig;
import inventory.pdpinventoryservice.model.InventoryDetails;
import inventory.pdpinventoryservice.model.InventoryResponse;

@RestController
@RequestMapping(value = "/inventory")
public class InventoryController {

	@Autowired
	 private SimpMessageSendingOperations template;

	@RequestMapping(value = "/updateInventory", method = RequestMethod.POST)
	public void updateInventory(@RequestBody InventoryDetails inventoryDetails) {
		// some operations can be done here.........
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = null;
		String productId = inventoryDetails.getProductId();
		try {
			json = ow.writeValueAsString(inventoryDetails);
		} catch (JsonProcessingException e) {
			System.out.println(e);
		}
		if (StringUtils.isBlank(productId)) {
			productId = "user";// this is used for chat
		}
		template.convertAndSend("/topic/" + productId, new InventoryResponse(json));

	}

	@RequestMapping(value = "/getUserView/{productId}", method = RequestMethod.GET)
	public String getUserView(@PathVariable("productId") String productId) {

		String message = countNumberOfViewers(InventoryWebSocketConfig.getPoductMap(), productId);
		template.convertAndSend("/topic/product." + productId, new InventoryResponse(message));
        return message;
	}

	private String countNumberOfViewers(Map<String, String> poductMap, String productId) {
		int[] numberOfViewers = { 0 };
		poductMap.forEach((key, value) -> {
			System.out.println("Item : " + key + " Count : " + value);
			if (productId.equals(value)) {
				numberOfViewers[0] = numberOfViewers[0] + 1;
			}
		});
		System.out.println("Total viewers for the product with product Id:"+productId+"is"+numberOfViewers[0]);
		return "There are "+numberOfViewers[0]+ " people currently viewing this item";
	}

}
