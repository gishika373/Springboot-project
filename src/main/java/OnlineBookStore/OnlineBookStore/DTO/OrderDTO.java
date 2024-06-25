package OnlineBookStore.OnlineBookStore.DTO;

import lombok.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class OrderDTO {
    private Long orderId;
    private Date date;
    private Date expectedDelivery;
    private String paymentType;
}
