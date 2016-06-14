package cvut.fit.borrowsystem.web.API.RestEntity;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Jakub Tuček on 12.6.2016.
 */
@Document
public class BorrowPureData {

    private String itemId;

    private String userId;

    public BorrowPureData(String itemId, String userId) {
        this.itemId = itemId;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
}
