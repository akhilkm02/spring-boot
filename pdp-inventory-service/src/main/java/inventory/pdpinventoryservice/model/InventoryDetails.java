package inventory.pdpinventoryservice.model;
/**
 * Pojo for inventory details
 * @author akhmohan
 *
 */
public class InventoryDetails {

	private String message;
	private String availableStockCount;
	private String additionalMessage;
	private String productId;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAvailableStockCount() {
		return availableStockCount;
	}
	public void setAvailableStockCount(String availableStockCount) {
		this.availableStockCount = availableStockCount;
	}
	public String getAdditionalMessage() {
		return additionalMessage;
	}
	public void setAdditionalMessage(String additionalMessage) {
		this.additionalMessage = additionalMessage;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
}
