package inventory.pdpinventoryservice.model;

public class InventoryResponse {
    String content;
    InventoryDetails inventoryDetails;

    public InventoryResponse() {
    }

    public String getContent() {
        return content;
    }

    public InventoryResponse(String content) {
        this.content = content;
    }
    
    public InventoryResponse(InventoryDetails inventoryDetails) {
        this.inventoryDetails = inventoryDetails;
    }

	public InventoryDetails getInventoryDetails() {
		return inventoryDetails;
	}

	public void setInventoryDetails(InventoryDetails inventoryDetails) {
		this.inventoryDetails = inventoryDetails;
	}
}
